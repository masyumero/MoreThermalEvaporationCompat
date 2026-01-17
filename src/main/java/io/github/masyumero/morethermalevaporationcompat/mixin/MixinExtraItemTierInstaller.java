package io.github.masyumero.morethermalevaporationcompat.mixin;

import com.jerry.mekanism_extras.api.tier.AdvancedTier;
import com.jerry.mekanism_extras.common.item.ExtraItemTierInstaller;
import io.github.masyumero.morethermalevaporationcompat.api.IMixinMTECompactItemTierInstaller;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.util.TierUtils;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ExtraItemTierInstaller.class, remap = false)
public abstract class MixinExtraItemTierInstaller implements IMixinMTECompactItemTierInstaller {

    @Unique
    @Mutable
    private @Final TETier mteCompat$fromTier;
    @Unique
    @Mutable
    private @Final TETier mteCompat$toTier;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void initInject(AdvancedTier fromTier, AdvancedTier toTier, Item.Properties properties, CallbackInfo ci) {
        if (fromTier == null) {
            this.mteCompat$fromTier = TETier.ULTIMATE;
        } else {
            this.mteCompat$fromTier = TierUtils.getTETier(fromTier);
        }
        this.mteCompat$toTier = TierUtils.getTETier(toTier);
    }

    @Inject(method = "useOn", at = @At(value = "TAIL"), remap = true, cancellable = true)
    private void useOnInject(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        cir.setReturnValue(mteCompat$useOn(context));
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
