package io.github.masyumero.morethermalevaporationcompat.mixin;

import com.jerry.mekanism_extras.common.block.attribute.ExtraAttributeUpgradeable;
import io.github.masyumero.emextras.common.block.attribute.EMExtraAttributeUpgradeable;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.api.text.ILangEntry;
import mekanism.common.block.attribute.AttributeUpgradeable;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.base.TileEntityMekanism;
import morethermalevaporation.common.content.blocktype.MoreThermalEvaporationMachine;
import morethermalevaporation.common.tier.MoreThermalEvaporationTier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(value = MoreThermalEvaporationMachine.class, remap = false)
public class MixinMoreThermalEvaporationMachine<TILE extends TileEntityMekanism> extends BlockTypeTile<TILE> {

    public MixinMoreThermalEvaporationMachine(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description) {
        super(tileEntityRegistrar, description);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void ultimateToOverclockedUpgradeInject(Supplier tileEntityRegistrar, ILangEntry description, MoreThermalEvaporationTier tier, CallbackInfo ci) {
        if (tier == MoreThermalEvaporationTier.ULTIMATE) {
            add(new AttributeUpgradeable(() -> MoreThermalEvaporationCompatBlocks.getCompactBlock(TETier.OVERCLOCKED)));
        }
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void ultimateToAbsoluteUpgradeInject(Supplier tileEntityRegistrar, ILangEntry description, MoreThermalEvaporationTier tier, CallbackInfo ci) {
        if (tier == MoreThermalEvaporationTier.ULTIMATE) {
            add(new ExtraAttributeUpgradeable(() -> MoreThermalEvaporationCompatBlocks.getCompactBlock(TETier.ABSOLUTE)));
        }
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void ultimateToAbsoluteOverclockedUpgradeInject(Supplier tileEntityRegistrar, ILangEntry description, MoreThermalEvaporationTier tier, CallbackInfo ci) {
        if (tier == MoreThermalEvaporationTier.ULTIMATE) {
            add(new EMExtraAttributeUpgradeable(() -> MoreThermalEvaporationCompatBlocks.getCompactBlock(TETier.ABSOLUTE_OVERCLOCKED)));
        }
    }
}
