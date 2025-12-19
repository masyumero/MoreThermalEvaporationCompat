package io.github.masyumero.morethermalevaporationcompat.extras.common.registries;

import com.jerry.mekanism_extras.api.tier.AdvancedTier;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.extras.common.item.block.ItemBlockMekanismTier;
import io.github.masyumero.morethermalevaporationcompat.extras.common.tile.multiblock.*;
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

    // Absolute
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityAbsoluteThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityAbsoluteThermalEvaporationBlock>>> ABSOLUTE_THERMAL_EVAPORATION_BLOCK = registerExtraBlock("absolute_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.ABSOLUTE_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), AdvancedTier.ABSOLUTE);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityAbsoluteThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityAbsoluteThermalEvaporationValve>>> ABSOLUTE_THERMAL_EVAPORATION_VALVE = registerExtraBlock("absolute_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.ABSOLUTE_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), AdvancedTier.ABSOLUTE);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityAbsoluteThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityAbsoluteThermalEvaporationController>>> ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER = registerExtraBlock("absolute_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), AdvancedTier.ABSOLUTE);
    // Supreme
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntitySupremeThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntitySupremeThermalEvaporationBlock>>> SUPREME_THERMAL_EVAPORATION_BLOCK = registerExtraBlock("supreme_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.SUPREME_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), AdvancedTier.SUPREME);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntitySupremeThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntitySupremeThermalEvaporationValve>>> SUPREME_THERMAL_EVAPORATION_VALVE = registerExtraBlock("supreme_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.SUPREME_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), AdvancedTier.SUPREME);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntitySupremeThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntitySupremeThermalEvaporationController>>> SUPREME_THERMAL_EVAPORATION_CONTROLLER = registerExtraBlock("supreme_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.SUPREME_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), AdvancedTier.SUPREME);
    // Cosmic
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityCosmicThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityCosmicThermalEvaporationBlock>>> COSMIC_THERMAL_EVAPORATION_BLOCK = registerExtraBlock("cosmic_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.COSMIC_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), AdvancedTier.COSMIC);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityCosmicThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityCosmicThermalEvaporationValve>>> COSMIC_THERMAL_EVAPORATION_VALVE = registerExtraBlock("cosmic_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.COSMIC_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), AdvancedTier.COSMIC);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityCosmicThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityCosmicThermalEvaporationController>>> COSMIC_THERMAL_EVAPORATION_CONTROLLER = registerExtraBlock("cosmic_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.COSMIC_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), AdvancedTier.COSMIC);
    // Infinite
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityInfiniteThermalEvaporationBlock>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityInfiniteThermalEvaporationBlock>>> INFINITE_THERMAL_EVAPORATION_BLOCK = registerExtraBlock("infinite_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.INFINITE_THERMAL_EVAPORATION_BLOCK, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), AdvancedTier.INFINITE);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityInfiniteThermalEvaporationValve>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityInfiniteThermalEvaporationValve>>> INFINITE_THERMAL_EVAPORATION_VALVE = registerExtraBlock("infinite_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.INFINITE_THERMAL_EVAPORATION_VALVE, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), AdvancedTier.INFINITE);
    public static final BlockRegistryObject<BlockBasicMultiblock<TileEntityInfiniteThermalEvaporationController>, ItemBlockMekanismTier<BlockBasicMultiblock<TileEntityInfiniteThermalEvaporationController>>> INFINITE_THERMAL_EVAPORATION_CONTROLLER = registerExtraBlock("infinite_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.INFINITE_THERMAL_EVAPORATION_CONTROLLER, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), AdvancedTier.INFINITE);

    private MoreThermalEvaporationCompatBlocks() {
    }

    private static <BLOCK extends Block & IHasDescription> BlockRegistryObject<BLOCK, ItemBlockMekanismTier<BLOCK>> registerExtraBlock(
            String name,
            Supplier<? extends BLOCK> blockSupplier,
            AdvancedTier tier) {

        return BLOCKS.registerDefaultProperties(name, blockSupplier, (block, props) -> new ItemBlockMekanismTier<>(block, props, tier));
    }

    private static <BLOCK extends Block & IHasDescription> BlockRegistryObject<BLOCK, ItemBlockMekanismTier<BLOCK>> registerEvolvedBlock(
            String name,
            Supplier<? extends BLOCK> blockSupplier,
            BaseTier tier) {

        return BLOCKS.registerDefaultProperties(name, blockSupplier, (block, props) -> new ItemBlockMekanismTier<>(block, props, tier));
    }
}
