package io.github.masyumero.morethermalevaporationcompat.evolved;

import io.github.masyumero.morethermalevaporationcompat.evolved.common.content.evaporation.*;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.registries.*;
import mekanism.common.lib.multiblock.MultiblockCache;
import mekanism.common.lib.multiblock.MultiblockManager;
import net.minecraftforge.eventbus.api.IEventBus;

public class EvolvedModule {

    public static final MultiblockManager<OverclockedThermalEvaporationMultiblockData> OverclockedThermalEvaporationManager = new MultiblockManager<>("OverclockedThermalEvaporation", MultiblockCache::new, OverclockedThermalEvaporationValidator::new);
    public static final MultiblockManager<QuantumThermalEvaporationMultiblockData> QuantumThermalEvaporationManager = new MultiblockManager<>("QuantumThermalEvaporation", MultiblockCache::new, QuantumThermalEvaporationValidator::new);
    public static final MultiblockManager<DenseThermalEvaporationMultiblockData> DenseThermalEvaporationManager = new MultiblockManager<>("DenseThermalEvaporation", MultiblockCache::new, DenseThermalEvaporationValidator::new);
    public static final MultiblockManager<MultiversalThermalEvaporationMultiblockData> MultiversalThermalEvaporationManager = new MultiblockManager<>("MultiversalThermalEvaporation", MultiblockCache::new, MultiversalThermalEvaporationValidator::new);

    public static void init(IEventBus modEventBus) {
        MoreThermalEvaporationCompatBlocks.BLOCKS.register(modEventBus);
        MoreThermalEvaporationCompatTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        MoreThermalEvaporationCompatContainerTypes.CONTAINER_TYPES.register(modEventBus);
    }
}
