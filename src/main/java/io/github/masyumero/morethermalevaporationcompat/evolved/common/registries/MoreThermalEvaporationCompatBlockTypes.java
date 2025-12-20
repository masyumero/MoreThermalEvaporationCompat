package io.github.masyumero.morethermalevaporationcompat.evolved.common.registries;

import io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock.*;
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
    // Overclocked
    public static final BlockTypeTile<TileEntityOverclockedThermalEvaporationBlock> OVERCLOCKED_THERMAL_EVAPORATION_BLOCK = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.OVERCLOCKED_THERMAL_EVAPORATION_BLOCK, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_BLOCK).with(new Attributes.AttributeCustomResistance(9)).externalMultiblock().build();
    public static final BlockTypeTile<TileEntityOverclockedThermalEvaporationValve> OVERCLOCKED_THERMAL_EVAPORATION_VALVE = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.OVERCLOCKED_THERMAL_EVAPORATION_VALVE, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_VALVE).with(Attributes.COMPARATOR, new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("OverclockedThermalEvaporationValve").build();
    public static final BlockTypeTile<TileEntityOverclockedThermalEvaporationController> OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_CONTROLLER).withGui(() -> MoreThermalEvaporationCompatContainerTypes.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.EVAPORATION_PLANT).with(Attributes.INVENTORY, Attributes.ACTIVE, new AttributeStateFacing(), new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("OverclockedThermalEvaporationController").build();

    // Quantum
    public static final BlockTypeTile<TileEntityQuantumThermalEvaporationBlock> QUANTUM_THERMAL_EVAPORATION_BLOCK = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.QUANTUM_THERMAL_EVAPORATION_BLOCK, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_BLOCK).with(new Attributes.AttributeCustomResistance(9)).externalMultiblock().build();
    public static final BlockTypeTile<TileEntityQuantumThermalEvaporationValve> QUANTUM_THERMAL_EVAPORATION_VALVE = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.QUANTUM_THERMAL_EVAPORATION_VALVE, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_VALVE).with(Attributes.COMPARATOR, new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("QuantumThermalEvaporationValve").build();
    public static final BlockTypeTile<TileEntityQuantumThermalEvaporationController> QUANTUM_THERMAL_EVAPORATION_CONTROLLER = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.QUANTUM_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_CONTROLLER).withGui(() -> MoreThermalEvaporationCompatContainerTypes.QUANTUM_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.EVAPORATION_PLANT).with(Attributes.INVENTORY, Attributes.ACTIVE, new AttributeStateFacing(), new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("QuantumThermalEvaporationController").build();

    // Dense
    public static final BlockTypeTile<TileEntityDenseThermalEvaporationBlock> DENSE_THERMAL_EVAPORATION_BLOCK = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.DENSE_THERMAL_EVAPORATION_BLOCK, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_BLOCK).with(new Attributes.AttributeCustomResistance(9)).externalMultiblock().build();
    public static final BlockTypeTile<TileEntityDenseThermalEvaporationValve> DENSE_THERMAL_EVAPORATION_VALVE = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.DENSE_THERMAL_EVAPORATION_VALVE, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_VALVE).with(Attributes.COMPARATOR, new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("DenseThermalEvaporationValve").build();
    public static final BlockTypeTile<TileEntityDenseThermalEvaporationController> DENSE_THERMAL_EVAPORATION_CONTROLLER = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.DENSE_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_CONTROLLER).withGui(() -> MoreThermalEvaporationCompatContainerTypes.DENSE_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.EVAPORATION_PLANT).with(Attributes.INVENTORY, Attributes.ACTIVE, new AttributeStateFacing(), new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("DenseThermalEvaporationController").build();

    // Multiversal
    public static final BlockTypeTile<TileEntityMultiversalThermalEvaporationBlock> MULTIVERSAL_THERMAL_EVAPORATION_BLOCK = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.MULTIVERSAL_THERMAL_EVAPORATION_BLOCK, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_BLOCK).with(new Attributes.AttributeCustomResistance(9)).externalMultiblock().build();
    public static final BlockTypeTile<TileEntityMultiversalThermalEvaporationValve> MULTIVERSAL_THERMAL_EVAPORATION_VALVE = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.MULTIVERSAL_THERMAL_EVAPORATION_VALVE, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_VALVE).with(Attributes.COMPARATOR, new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("MultiversalThermalEvaporationValve").build();
    public static final BlockTypeTile<TileEntityMultiversalThermalEvaporationController> MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER = BlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_CONTROLLER).withGui(() -> MoreThermalEvaporationCompatContainerTypes.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER, MekanismLang.EVAPORATION_PLANT).with(Attributes.INVENTORY, Attributes.ACTIVE, new AttributeStateFacing(), new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport("MultiversalThermalEvaporationController").build();

    private MoreThermalEvaporationCompatBlockTypes() {
    }

    public static <TILE extends TileEntityMekanism> BlockTypeTile<TILE> createTierBlock(InductionCellTier tier, Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description) {
        return BlockTileBuilder.createBlock(tileEntityRegistrar, description)
                .with(new AttributeTier<>(tier))
                .build();
    }
}
