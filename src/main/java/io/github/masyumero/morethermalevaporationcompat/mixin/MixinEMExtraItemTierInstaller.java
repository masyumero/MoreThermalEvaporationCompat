package io.github.masyumero.morethermalevaporationcompat.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import io.github.masyumero.emextras.api.tier.EMExtraTier;
import io.github.masyumero.emextras.common.item.EMExtraItemTierInstaller;
import io.github.masyumero.morethermalevaporationcompat.api.IMixinMTECompactItemTierInstaller;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.util.TierUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EMExtraItemTierInstaller.class, remap = false)
public abstract class MixinEMExtraItemTierInstaller implements IMixinMTECompactItemTierInstaller {

    @Unique
    @Mutable
    private @Final TETier mteCompat$fromTier;
    @Unique
    @Mutable
    private @Final TETier mteCompat$toTier;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void initInject(EMExtraTier fromTier, EMExtraTier toTier, Item.Properties properties, CallbackInfo ci) {
        if (fromTier == null) {
            this.mteCompat$fromTier = TETier.ULTIMATE;
        } else {
            this.mteCompat$fromTier = TierUtils.getTETier(fromTier);
        }
        this.mteCompat$toTier = TierUtils.getTETier(toTier);
    }

    @Inject(method = "useOn", at = @At(value = "TAIL"), remap = true, cancellable = true)
    private void useOnInject(
            UseOnContext context,
            CallbackInfoReturnable<InteractionResult> cir,
            @Local(name = "block") Block block,
            @Local(name = "state") BlockState state,
            @Local(name = "pos") BlockPos pos,
            @Local(name = "world") Level world,
            @Local(name = "player") Player player) {
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
}
