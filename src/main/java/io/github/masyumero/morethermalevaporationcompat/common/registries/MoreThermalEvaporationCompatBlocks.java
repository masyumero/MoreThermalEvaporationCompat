package io.github.masyumero.morethermalevaporationcompat.common.registries;

import com.jerry.mekanism_extras.api.tier.AdvancedTier;
import fr.iglee42.evolvedmekanism.tiers.EMBaseTier;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.item.block.ItemBlockMekanismTier;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock.*;
import io.github.masyumero.morethermalevaporationcompat.extras.common.tile.multiblock.*;
import mekanism.api.tier.BaseTier;
import mekanism.common.block.interfaces.IHasDescription;
import mekanism.common.block.prefab.BlockBasicMultiblock;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

public class MoreThermalEvaporationCompatBlocks {

    public static final BlockDeferredRegister EVOLVED_BLOCKS = new BlockDeferredRegister(MoreThermalEvaporationCompat.MODID);
    public static final BlockDeferredRegister EXTRAS_BLOCKS = new BlockDeferredRegister(MoreThermalEvaporationCompat.MODID);
    
    // Overclocked
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityOverclockedThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityOverclockedThermalEvaporationBlock>>> OVERCLOCKED_THERMAL_EVAPORATION_BLOCK = registerEvolvedBlock("overclocked_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.OVERCLOCKED_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(MapColor.COLOR_GREEN)), EMBaseTier.OVERCLOCKED);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityOverclockedThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityOverclockedThermalEvaporationValve>>> OVERCLOCKED_THERMAL_EVAPORATION_VALVE = registerEvolvedBlock("overclocked_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.OVERCLOCKED_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(MapColor.COLOR_GREEN)), EMBaseTier.OVERCLOCKED);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityOverclockedThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityOverclockedThermalEvaporationController>>> OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER = registerEvolvedBlock("overclocked_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(MapColor.COLOR_GREEN)), EMBaseTier.OVERCLOCKED);
    // Quantum
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityQuantumThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityQuantumThermalEvaporationBlock>>> QUANTUM_THERMAL_EVAPORATION_BLOCK = registerEvolvedBlock("quantum_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.QUANTUM_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(MapColor.COLOR_PURPLE)), EMBaseTier.QUANTUM);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityQuantumThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityQuantumThermalEvaporationValve>>> QUANTUM_THERMAL_EVAPORATION_VALVE = registerEvolvedBlock("quantum_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.QUANTUM_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(MapColor.COLOR_PURPLE)), EMBaseTier.QUANTUM);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityQuantumThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityQuantumThermalEvaporationController>>> QUANTUM_THERMAL_EVAPORATION_CONTROLLER = registerEvolvedBlock("quantum_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.QUANTUM_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(MapColor.COLOR_PURPLE)), EMBaseTier.QUANTUM);
    // Dense
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityDenseThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityDenseThermalEvaporationBlock>>> DENSE_THERMAL_EVAPORATION_BLOCK = registerEvolvedBlock("dense_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.DENSE_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(MapColor.TERRACOTTA_YELLOW)), EMBaseTier.DENSE);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityDenseThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityDenseThermalEvaporationValve>>> DENSE_THERMAL_EVAPORATION_VALVE = registerEvolvedBlock("dense_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.DENSE_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(MapColor.TERRACOTTA_YELLOW)), EMBaseTier.DENSE);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityDenseThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityDenseThermalEvaporationController>>> DENSE_THERMAL_EVAPORATION_CONTROLLER = registerEvolvedBlock("dense_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.DENSE_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(MapColor.TERRACOTTA_YELLOW)), EMBaseTier.DENSE);
    // Multiversal
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityMultiversalThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityMultiversalThermalEvaporationBlock>>> MULTIVERSAL_THERMAL_EVAPORATION_BLOCK = registerEvolvedBlock("multiversal_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.MULTIVERSAL_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(MapColor.COLOR_BLACK)), EMBaseTier.MULTIVERSAL);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityMultiversalThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityMultiversalThermalEvaporationValve>>> MULTIVERSAL_THERMAL_EVAPORATION_VALVE = registerEvolvedBlock("multiversal_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.MULTIVERSAL_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(MapColor.COLOR_BLACK)), EMBaseTier.MULTIVERSAL);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityMultiversalThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityMultiversalThermalEvaporationController>>> MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER = registerEvolvedBlock("multiversal_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(MapColor.COLOR_BLACK)), EMBaseTier.MULTIVERSAL);

    // Absolute
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityAbsoluteThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityAbsoluteThermalEvaporationBlock>>> ABSOLUTE_THERMAL_EVAPORATION_BLOCK = registerExtraBlock("absolute_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.ABSOLUTE_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(MapColor.COLOR_YELLOW)), AdvancedTier.ABSOLUTE);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityAbsoluteThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityAbsoluteThermalEvaporationValve>>> ABSOLUTE_THERMAL_EVAPORATION_VALVE = registerExtraBlock("absolute_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.ABSOLUTE_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(MapColor.COLOR_YELLOW)), AdvancedTier.ABSOLUTE);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityAbsoluteThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityAbsoluteThermalEvaporationController>>> ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER = registerExtraBlock("absolute_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(MapColor.COLOR_YELLOW)), AdvancedTier.ABSOLUTE);
    // Supreme
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntitySupremeThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntitySupremeThermalEvaporationBlock>>> SUPREME_THERMAL_EVAPORATION_BLOCK = registerExtraBlock("supreme_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.SUPREME_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(MapColor.COLOR_RED)), AdvancedTier.SUPREME);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntitySupremeThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntitySupremeThermalEvaporationValve>>> SUPREME_THERMAL_EVAPORATION_VALVE = registerExtraBlock("supreme_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.SUPREME_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(MapColor.COLOR_RED)), AdvancedTier.SUPREME);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntitySupremeThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntitySupremeThermalEvaporationController>>> SUPREME_THERMAL_EVAPORATION_CONTROLLER = registerExtraBlock("supreme_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.SUPREME_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(MapColor.COLOR_RED)), AdvancedTier.SUPREME);
    // Cosmic
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityCosmicThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityCosmicThermalEvaporationBlock>>> COSMIC_THERMAL_EVAPORATION_BLOCK = registerExtraBlock("cosmic_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.COSMIC_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(MapColor.COLOR_PINK)), AdvancedTier.COSMIC);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityCosmicThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityCosmicThermalEvaporationValve>>> COSMIC_THERMAL_EVAPORATION_VALVE = registerExtraBlock("cosmic_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.COSMIC_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(MapColor.COLOR_PINK)), AdvancedTier.COSMIC);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityCosmicThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityCosmicThermalEvaporationController>>> COSMIC_THERMAL_EVAPORATION_CONTROLLER = registerExtraBlock("cosmic_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.COSMIC_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(MapColor.COLOR_PINK)), AdvancedTier.COSMIC);
    // Infinite
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityInfiniteThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityInfiniteThermalEvaporationBlock>>> INFINITE_THERMAL_EVAPORATION_BLOCK = registerExtraBlock("infinite_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.INFINITE_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(MapColor.COLOR_BLUE)), AdvancedTier.INFINITE);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityInfiniteThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityInfiniteThermalEvaporationValve>>> INFINITE_THERMAL_EVAPORATION_VALVE = registerExtraBlock("infinite_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.INFINITE_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(MapColor.COLOR_BLUE)), AdvancedTier.INFINITE);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityInfiniteThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityInfiniteThermalEvaporationController>>> INFINITE_THERMAL_EVAPORATION_CONTROLLER = registerExtraBlock("infinite_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.INFINITE_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(MapColor.COLOR_BLUE)), AdvancedTier.INFINITE);
    
    private MoreThermalEvaporationCompatBlocks() {
    }

    private static <BLOCK extends Block & IHasDescription> BlockRegistryObject<BLOCK, ItemBlockMekanismTier<BLOCK>> registerEvolvedBlock(
            String name,
            Supplier<? extends BLOCK> blockSupplier,
            BaseTier tier) {

        return EVOLVED_BLOCKS.registerDefaultProperties(name, blockSupplier, (block, props) -> new ItemBlockMekanismTier<>(block, props, tier));
    }

    private static <BLOCK extends Block & IHasDescription> BlockRegistryObject<BLOCK, ItemBlockMekanismTier<BLOCK>> registerExtraBlock(
            String name,
            Supplier<? extends BLOCK> blockSupplier,
            AdvancedTier tier) {

        return EXTRAS_BLOCKS.registerDefaultProperties(name, blockSupplier, (block, props) -> new ItemBlockMekanismTier<>(block, props, tier));
    }
}
