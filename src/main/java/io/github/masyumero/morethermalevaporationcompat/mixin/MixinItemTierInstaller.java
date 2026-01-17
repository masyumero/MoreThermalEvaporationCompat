package io.github.masyumero.morethermalevaporationcompat.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import io.github.masyumero.morethermalevaporationcompat.api.IMixinMTECompactItemTierInstaller;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.util.TierUtils;
import mekanism.api.tier.BaseTier;
import mekanism.common.item.ItemTierInstaller;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ItemTierInstaller.class, remap = false)
public abstract class MixinItemTierInstaller implements IMixinMTECompactItemTierInstaller {

    @Shadow
    @Final
    private @Nullable BaseTier fromTier;
    @Shadow
    @Final
    private @NotNull BaseTier toTier;
    @Unique
    @Mutable
    private @Final TETier mteCompat$fromTier;
    @Unique
    @Mutable
    private @Final TETier mteCompat$toTier;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void initInject(BaseTier fromTier, BaseTier toTier, Item.Properties properties, CallbackInfo ci) {
        this.mteCompat$fromTier = TierUtils.getTETier(fromTier);
        this.mteCompat$toTier = TierUtils.getTETier(toTier);
    }

    @Inject(method = "useOn", at = @At(value = "TAIL"), remap = true, cancellable = true)
    private void useOnInject(
            UseOnContext context,
            CallbackInfoReturnable<InteractionResult> cir,
            @Local(name = "block")Block block,
            @Local(name = "state")BlockState state,
            @Local(name = "pos")BlockPos pos,
            @Local(name = "world")Level world,
            @Local(name = "player")Player player) {
        cir.setReturnValue(mteCompat$useOn(context, block, state, pos, world, player));
    }

    @Override
    public TETier mteCompat$getFromTier() {
        return mteCompat$fromTier;
    }

    @Override
    public TETier mteCompat$getToTier() {
        return mteCompat$toTier;
    }
//
//    @Override
//    public TETier mteCompat$getFromTier() {
//        return TierUtils.getBeforeTier(mteCompat$toTier);
//    }
//
//    @Override
//    public TETier mteCompat$getToTier() {
//        return TierUtils.getAfterTier(mteCompat$fromTier, mteCompat$toTier);
//    }
}
