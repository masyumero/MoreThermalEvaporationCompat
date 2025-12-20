package io.github.masyumero.morethermalevaporationcompat.evolved.common.registries;

import fr.iglee42.evolvedmekanism.tiers.EMBaseTier;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.item.block.ItemBlockMekanismTier;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock.*;
import mekanism.api.tier.BaseTier;
import mekanism.common.block.interfaces.IHasDescription;
import mekanism.common.block.prefab.BlockBasicMultiblock;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import mekanism.common.resource.BlockResourceInfo;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class MoreThermalEvaporationCompatBlocks {

    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(MoreThermalEvaporationCompat.MODID);

    // Overclocked
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityOverclockedThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityOverclockedThermalEvaporationBlock>>> OVERCLOCKED_THERMAL_EVAPORATION_BLOCK = registerEvolvedBlock("overclocked_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.OVERCLOCKED_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), EMBaseTier.OVERCLOCKED);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityOverclockedThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityOverclockedThermalEvaporationValve>>> OVERCLOCKED_THERMAL_EVAPORATION_VALVE = registerEvolvedBlock("overclocked_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.OVERCLOCKED_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), EMBaseTier.OVERCLOCKED);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityOverclockedThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityOverclockedThermalEvaporationController>>> OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER = registerEvolvedBlock("overclocked_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), EMBaseTier.OVERCLOCKED);
    // Quantum
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityQuantumThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityQuantumThermalEvaporationBlock>>> QUANTUM_THERMAL_EVAPORATION_BLOCK = registerEvolvedBlock("quantum_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.QUANTUM_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), EMBaseTier.QUANTUM);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityQuantumThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityQuantumThermalEvaporationValve>>> QUANTUM_THERMAL_EVAPORATION_VALVE = registerEvolvedBlock("quantum_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.QUANTUM_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), EMBaseTier.QUANTUM);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityQuantumThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityQuantumThermalEvaporationController>>> QUANTUM_THERMAL_EVAPORATION_CONTROLLER = registerEvolvedBlock("quantum_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.QUANTUM_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), EMBaseTier.QUANTUM);
    // Dense
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityDenseThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityDenseThermalEvaporationBlock>>> DENSE_THERMAL_EVAPORATION_BLOCK = registerEvolvedBlock("dense_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.DENSE_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), EMBaseTier.DENSE);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityDenseThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityDenseThermalEvaporationValve>>> DENSE_THERMAL_EVAPORATION_VALVE = registerEvolvedBlock("dense_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.DENSE_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), EMBaseTier.DENSE);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityDenseThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityDenseThermalEvaporationController>>> DENSE_THERMAL_EVAPORATION_CONTROLLER = registerEvolvedBlock("dense_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.DENSE_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), EMBaseTier.DENSE);
    // Multiversal
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityMultiversalThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityMultiversalThermalEvaporationBlock>>> MULTIVERSAL_THERMAL_EVAPORATION_BLOCK = registerEvolvedBlock("multiversal_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.MULTIVERSAL_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), EMBaseTier.MULTIVERSAL);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityMultiversalThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityMultiversalThermalEvaporationValve>>> MULTIVERSAL_THERMAL_EVAPORATION_VALVE = registerEvolvedBlock("multiversal_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.MULTIVERSAL_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), EMBaseTier.MULTIVERSAL);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityMultiversalThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityMultiversalThermalEvaporationController>>> MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER = registerEvolvedBlock("multiversal_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), EMBaseTier.MULTIVERSAL);

    private MoreThermalEvaporationCompatBlocks() {
    }

    private static <BLOCK extends Block & IHasDescription> BlockRegistryObject<BLOCK, ItemBlockMekanismTier<BLOCK>> registerEvolvedBlock(
            String name,
            Supplier<? extends BLOCK> blockSupplier,
            BaseTier tier) {

        return BLOCKS.registerDefaultProperties(name, blockSupplier, (block, props) -> new ItemBlockMekanismTier<>(block, props, tier));
    }
}
