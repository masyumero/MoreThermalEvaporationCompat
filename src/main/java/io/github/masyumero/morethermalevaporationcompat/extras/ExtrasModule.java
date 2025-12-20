package io.github.masyumero.morethermalevaporationcompat.extras;

import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatContainerTypes;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatTileEntityTypes;
import io.github.masyumero.morethermalevaporationcompat.extras.common.content.evaporation.*;
import mekanism.common.lib.multiblock.MultiblockCache;
import mekanism.common.lib.multiblock.MultiblockManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;

public class ExtrasModule {

    public static final MultiblockManager<AbsoluteThermalEvaporationMultiblockData> AbsoluteThermalEvaporationManager = new MultiblockManager<>("AbsoluteThermalEvaporation", MultiblockCache::new, AbsoluteThermalEvaporationValidator::new);
    public static final MultiblockManager<SupremeThermalEvaporationMultiblockData> SupremeThermalEvaporationManager = new MultiblockManager<>("SupremeThermalEvaporation", MultiblockCache::new, SupremeThermalEvaporationValidator::new);
    public static final MultiblockManager<CosmicThermalEvaporationMultiblockData> CosmicThermalEvaporationManager = new MultiblockManager<>("CosmicThermalEvaporation", MultiblockCache::new, CosmicThermalEvaporationValidator::new);
    public static final MultiblockManager<InfiniteThermalEvaporationMultiblockData> InfiniteThermalEvaporationManager = new MultiblockManager<>("InfiniteThermalEvaporation", MultiblockCache::new, InfiniteThermalEvaporationValidator::new);

    public static boolean ExtrasLoaded = ModList.get().isLoaded("mekanism_extras");

    public static void init(IEventBus modEventBus) {
        MoreThermalEvaporationCompatBlocks.EXTRAS_BLOCKS.register(modEventBus);
        MoreThermalEvaporationCompatTileEntityTypes.EXTRAS_TILE_ENTITY_TYPES.register(modEventBus);
        MoreThermalEvaporationCompatContainerTypes.EXTRAS_CONTAINER_TYPES.register(modEventBus);
    }
}
