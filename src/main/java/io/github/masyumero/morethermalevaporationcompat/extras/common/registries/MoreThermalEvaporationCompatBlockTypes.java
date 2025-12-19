package io.github.masyumero.morethermalevaporationcompat.extras.common.registries;

import io.github.masyumero.morethermalevaporationcompat.extras.common.tile.multiblock.*;
import mekanism.api.text.ILangEntry;
import mekanism.common.MekanismLang;
import mekanism.common.block.attribute.AttributeStateFacing;
import mekanism.common.block.attribute.AttributeTier;
import mekanism.common.block.attribute.Attributes;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.content.blocktype.BlockTypeTile.BlockTileBuilder;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tier.InductionCellTier;
import mekanism.common.tile.base.TileEntityMekanism;

import java.util.function.Supplier;

public class MoreThermalEvaporationCompatBlockTypes {
    // Absolute
    public static final BlockTypeTile<TileEntityAbsoluteThermalEvaporationBlock> ABSOLUTE_THERMAL_EVAPORATION_BLOCK = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.ABSOLUTE_THERMAL_EVAPORATION_BLOCK, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_BLOCK).with(new Attributes.AttributeCustomResistance(9)).externalMultiblock().build();
    public static final BlockTypeTile<TileEntityAbsoluteThermalEvaporationValve> ABSOLUTE_THERMAL_EVAPORATION_VALVE = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.ABSOLUTE_THERMAL_EVAPORATION_VALVE, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_VALVE).with(Attributes.COMPARATOR, new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("AbsoluteThermalEvaporationValve").build();
    public static final BlockTypeTile<TileEntityAbsoluteThermalEvaporationController> ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_CONTROLLER).withGui(() -> MoreThermalEvaporationCompatContainerTypes.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.EVAPORATION_PLANT).with(Attributes.INVENTORY, Attributes.ACTIVE, new AttributeStateFacing(), new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("AbsoluteThermalEvaporationController").build();

    // Supreme
    public static final BlockTypeTile<TileEntitySupremeThermalEvaporationBlock> SUPREME_THERMAL_EVAPORATION_BLOCK = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.SUPREME_THERMAL_EVAPORATION_BLOCK, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_BLOCK).with(new Attributes.AttributeCustomResistance(9)).externalMultiblock().build();
    public static final BlockTypeTile<TileEntitySupremeThermalEvaporationValve> SUPREME_THERMAL_EVAPORATION_VALVE = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.SUPREME_THERMAL_EVAPORATION_VALVE, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_VALVE).with(Attributes.COMPARATOR, new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("SupremeThermalEvaporationValve").build();
    public static final BlockTypeTile<TileEntitySupremeThermalEvaporationController> SUPREME_THERMAL_EVAPORATION_CONTROLLER = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.SUPREME_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_CONTROLLER).withGui(() -> MoreThermalEvaporationCompatContainerTypes.SUPREME_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.EVAPORATION_PLANT).with(Attributes.INVENTORY, Attributes.ACTIVE, new AttributeStateFacing(), new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("SupremeThermalEvaporationController").build();

    // Cosmic
    public static final BlockTypeTile<TileEntityCosmicThermalEvaporationBlock> COSMIC_THERMAL_EVAPORATION_BLOCK = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.COSMIC_THERMAL_EVAPORATION_BLOCK, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_BLOCK).with(new Attributes.AttributeCustomResistance(9)).externalMultiblock().build();
    public static final BlockTypeTile<TileEntityCosmicThermalEvaporationValve> COSMIC_THERMAL_EVAPORATION_VALVE = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.COSMIC_THERMAL_EVAPORATION_VALVE, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_VALVE).with(Attributes.COMPARATOR, new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("CosmicThermalEvaporationValve").build();
    public static final BlockTypeTile<TileEntityCosmicThermalEvaporationController> COSMIC_THERMAL_EVAPORATION_CONTROLLER = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.COSMIC_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_CONTROLLER).withGui(() -> MoreThermalEvaporationCompatContainerTypes.COSMIC_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.EVAPORATION_PLANT).with(Attributes.INVENTORY, Attributes.ACTIVE, new AttributeStateFacing(), new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("CosmicThermalEvaporationController").build();

    // Infinite
    public static final BlockTypeTile<TileEntityInfiniteThermalEvaporationBlock> INFINITE_THERMAL_EVAPORATION_BLOCK = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.INFINITE_THERMAL_EVAPORATION_BLOCK, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_BLOCK).with(new Attributes.AttributeCustomResistance(9)).externalMultiblock().build();
    public static final BlockTypeTile<TileEntityInfiniteThermalEvaporationValve> INFINITE_THERMAL_EVAPORATION_VALVE = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.INFINITE_THERMAL_EVAPORATION_VALVE, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_VALVE).with(Attributes.COMPARATOR, new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("InfiniteThermalEvaporationValve").build();
    public static final BlockTypeTile<TileEntityInfiniteThermalEvaporationController> INFINITE_THERMAL_EVAPORATION_CONTROLLER = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.INFINITE_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_CONTROLLER).withGui(() -> MoreThermalEvaporationCompatContainerTypes.INFINITE_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.EVAPORATION_PLANT).with(Attributes.INVENTORY, Attributes.ACTIVE, new AttributeStateFacing(), new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("InfiniteThermalEvaporationController").build();

    private MoreThermalEvaporationCompatBlockTypes() {
    }

    public static <TILE extends TileEntityMekanism> BlockTypeTile<TILE> createTierBlock(InductionCellTier tier, Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description) {
        return BlockTileBuilder.createBlock(tileEntityRegistrar, description)
                .with(new AttributeTier<>(tier))
                .build();
    }
}
