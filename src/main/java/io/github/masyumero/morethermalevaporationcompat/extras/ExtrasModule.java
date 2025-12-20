package io.github.masyumero.morethermalevaporationcompat.extras;

import io.github.masyumero.morethermalevaporationcompat.extras.common.content.evaporation.*;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatContainerTypes;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatCreativeTabs;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatTileEntityTypes;
import mekanism.common.lib.multiblock.MultiblockCache;
import mekanism.common.lib.multiblock.MultiblockManager;
import net.minecraftforge.eventbus.api.IEventBus;

public class ExtrasModule {

    public static final MultiblockManager<AbsoluteThermalEvaporationMultiblockData> AbsoluteThermalEvaporationManager = new MultiblockManager<>("AbsoluteThermalEvaporation", MultiblockCache::new, AbsoluteThermalEvaporationValidator::new);
    public static final MultiblockManager<SupremeThermalEvaporationMultiblockData> SupremeThermalEvaporationManager = new MultiblockManager<>("SupremeThermalEvaporation", MultiblockCache::new, SupremeThermalEvaporationValidator::new);
    public static final MultiblockManager<CosmicThermalEvaporationMultiblockData> CosmicThermalEvaporationManager = new MultiblockManager<>("CosmicThermalEvaporation", MultiblockCache::new, CosmicThermalEvaporationValidator::new);
    public static final MultiblockManager<InfiniteThermalEvaporationMultiblockData> InfiniteThermalEvaporationManager = new MultiblockManager<>("InfiniteThermalEvaporation", MultiblockCache::new, InfiniteThermalEvaporationValidator::new);

    public static void init(IEventBus modEventBus) {
        MoreThermalEvaporationCompatBlocks.BLOCKS.register(modEventBus);
        MoreThermalEvaporationCompatTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        MoreThermalEvaporationCompatContainerTypes.CONTAINER_TYPES.register(modEventBus);
        MoreThermalEvaporationCompatCreativeTabs.register(modEventBus);
    }
}
