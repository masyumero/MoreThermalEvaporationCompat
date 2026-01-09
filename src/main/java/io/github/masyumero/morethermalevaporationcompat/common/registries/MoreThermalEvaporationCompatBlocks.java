package io.github.masyumero.morethermalevaporationcompat.common.registries;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import io.github.masyumero.morethermalevaporationcompat.CompactModule;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatMultiPartType;
import io.github.masyumero.morethermalevaporationcompat.common.item.block.ItemBlockMekanismTier;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.common.block.interfaces.IHasDescription;
import mekanism.common.block.prefab.BlockBasicMultiblock;
import mekanism.common.block.prefab.BlockTile;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MoreThermalEvaporationCompatBlocks {

    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(MoreThermalEvaporationCompat.MODID);

    private static final Table<TETier, MTECompatMultiPartType, BlockRegistryObject<BlockBasicMultiblock<?>, ItemBlockMekanismTier<BlockBasicMultiblock<?>>>> BLOCK_TABLE = HashBasedTable.create();
    private static final Map<TETier, BlockRegistryObject<BlockTile.BlockTileModel<?, ?>, ItemBlockMekanismTier<BlockTile.BlockTileModel<?, ?>>>> COMPACT_BLOCK_TABLE = new HashMap<>();

    static {
        for (TETier tier : TETier.values()) {
            if (tier.isModLoaded()) {
                if (!tier.isCompactOnly()) {
                    BLOCK_TABLE.put(tier, MTECompatMultiPartType.BLOCK, MoreThermalEvaporationCompatBlocks.registerBlock(tier.getLowerName() + "_thermal_evaporation_block", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.getBlockType(tier, MTECompatMultiPartType.BLOCK), properties -> properties.mapColor(tier.getMapColor())), tier));
                    BLOCK_TABLE.put(tier, MTECompatMultiPartType.VALVE, MoreThermalEvaporationCompatBlocks.registerBlock(tier.getLowerName() + "_thermal_evaporation_valve", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.getBlockType(tier, MTECompatMultiPartType.VALVE), properties -> properties.mapColor(tier.getMapColor())), tier));
                    BLOCK_TABLE.put(tier, MTECompatMultiPartType.CONTROLLER, MoreThermalEvaporationCompatBlocks.registerBlock(tier.getLowerName() + "_thermal_evaporation_controller", () -> new BlockBasicMultiblock<>(MoreThermalEvaporationCompatBlockTypes.getBlockType(tier, MTECompatMultiPartType.CONTROLLER), properties -> properties.mapColor(tier.getMapColor())), tier));
                }
                if (CompactModule.CompactLoaded) {
                    COMPACT_BLOCK_TABLE.put(tier, MoreThermalEvaporationCompatBlocks.registerBlock(tier.getLowerName() + "_compact_thermal_evaporation_controller", () -> new BlockTile.BlockTileModel<>(MoreThermalEvaporationCompatBlockTypes.getCompactBlockType(tier), properties -> properties.mapColor(tier.getMapColor())), tier));
                }
            }
        }
    }

    private MoreThermalEvaporationCompatBlocks() {
    }

    private static <BLOCK extends Block & IHasDescription> BlockRegistryObject<BLOCK, ItemBlockMekanismTier<BLOCK>> registerBlock(
            String name,
            Supplier<? extends BLOCK> blockSupplier,
            TETier tier) {

        return BLOCKS.registerDefaultProperties(name, blockSupplier, (block, props) -> new ItemBlockMekanismTier<>(block, props, tier));
    }

    public static BlockRegistryObject<BlockBasicMultiblock<?>, ItemBlockMekanismTier<BlockBasicMultiblock<?>>> getCasingBlock(TETier tier) {
        return getBlock(tier, MTECompatMultiPartType.BLOCK);
    }

    public static BlockRegistryObject<BlockBasicMultiblock<?>, ItemBlockMekanismTier<BlockBasicMultiblock<?>>> getValveBlock(TETier tier) {
        return getBlock(tier, MTECompatMultiPartType.VALVE);
    }

    public static BlockRegistryObject<BlockBasicMultiblock<?>, ItemBlockMekanismTier<BlockBasicMultiblock<?>>> getControllerBlock(TETier tier) {
        return getBlock(tier, MTECompatMultiPartType.CONTROLLER);
    }

    public static BlockRegistryObject<BlockBasicMultiblock<?>, ItemBlockMekanismTier<BlockBasicMultiblock<?>>> getBlock(TETier tier, MTECompatMultiPartType type) {
        return BLOCK_TABLE.get(tier, type);
    }

    public static BlockRegistryObject<BlockTile.BlockTileModel<?,?>, ItemBlockMekanismTier<BlockTile.BlockTileModel<?,?>>> getCompactBlock(TETier tier) {
        return COMPACT_BLOCK_TABLE.get(tier);
    }
}
