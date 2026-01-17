package io.github.masyumero.morethermalevaporationcompat.common.content.blocktype;

import io.github.masyumero.morethermalevaporationcompat.common.block.attribute.MTECompatAttributeUpgradeable;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.util.MTECompatEnumUtils;
import mekanism.api.Upgrade;
import mekanism.api.text.ILangEntry;
import mekanism.common.block.attribute.AttributeParticleFX;
import mekanism.common.block.attribute.AttributeStateFacing;
import mekanism.common.block.attribute.AttributeUpgradeSupport;
import mekanism.common.block.attribute.Attributes;
import mekanism.common.lib.math.Pos3D;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.base.TileEntityMekanism;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;

import java.util.EnumSet;
import java.util.function.Supplier;

public class MTECompatMachine<TILE extends TileEntityMekanism> extends MTECompatBlockTypeTile<TILE>  {

    public MTECompatMachine(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description, TETier tier) {
        super(tileEntityRegistrar, description, tier);
        add(new AttributeParticleFX()
                .add(ParticleTypes.SMOKE, rand -> new Pos3D(rand.nextFloat() * 0.6F - 0.3F, rand.nextFloat() * 6.0F / 16.0F, 0.52))
                .add(DustParticleOptions.REDSTONE, rand -> new Pos3D(rand.nextFloat() * 0.6F - 0.3F, rand.nextFloat() * 6.0F / 16.0F, 0.52)));
        add(Attributes.ACTIVE_LIGHT, new AttributeStateFacing(), Attributes.INVENTORY, Attributes.SECURITY, Attributes.REDSTONE, Attributes.COMPARATOR);
        add(new AttributeUpgradeSupport(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY, Upgrade.MUFFLING)));

        if (!(tier == TETier.INFINITE || tier == TETier.MULTIVERSAL || tier == TETier.ILLUSION || tier == TETier.INFINITE_MULTIVERSAL)) {
            add(new MTECompatAttributeUpgradeable(() -> MoreThermalEvaporationCompatBlocks.getCompactBlock(MTECompatEnumUtils.THERMAL_EVAPORATION_TIERS[tier.ordinal() + 1])));
        }
    }

    public static class MTECompatMachineBuilder<MACHINE extends MTECompatMachine<TILE>, TILE extends TileEntityMekanism, T extends MTECompatMachine.MTECompatMachineBuilder<MACHINE, TILE, T>> extends MTECompatBlockTypeTile.MTECompatBlockTileBuilder<MACHINE, TILE, T> {

        protected MTECompatMachineBuilder(MACHINE holder) {
            super(holder);
        }

        public static <TILE extends TileEntityMekanism> MTECompatMachine.MTECompatMachineBuilder<MTECompatMachine<TILE>, TILE, ?> createMachine(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description, TETier tier) {
            return new MTECompatMachine.MTECompatMachineBuilder<>(new MTECompatMachine<>(tileEntityRegistrar, description, tier));
        }
    }
}
