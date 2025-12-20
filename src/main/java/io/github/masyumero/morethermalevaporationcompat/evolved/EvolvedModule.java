package io.github.masyumero.morethermalevaporationcompat.evolved;

import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatContainerTypes;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatTileEntityTypes;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.content.evaporation.*;
import mekanism.common.lib.multiblock.MultiblockCache;
import mekanism.common.lib.multiblock.MultiblockManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;

public class EvolvedModule {

    public static final MultiblockManager<OverclockedThermalEvaporationMultiblockData> OverclockedThermalEvaporationManager = new MultiblockManager<>("OverclockedThermalEvaporation", MultiblockCache::new, OverclockedThermalEvaporationValidator::new);
    public static final MultiblockManager<QuantumThermalEvaporationMultiblockData> QuantumThermalEvaporationManager = new MultiblockManager<>("QuantumThermalEvaporation", MultiblockCache::new, QuantumThermalEvaporationValidator::new);
    public static final MultiblockManager<DenseThermalEvaporationMultiblockData> DenseThermalEvaporationManager = new MultiblockManager<>("DenseThermalEvaporation", MultiblockCache::new, DenseThermalEvaporationValidator::new);
    public static final MultiblockManager<MultiversalThermalEvaporationMultiblockData> MultiversalThermalEvaporationManager = new MultiblockManager<>("MultiversalThermalEvaporation", MultiblockCache::new, MultiversalThermalEvaporationValidator::new);

    public static boolean EvolvedLoaded = ModList.get().isLoaded("evolvedmekanism");

    public static void init(IEventBus modEventBus) {
        MoreThermalEvaporationCompatBlocks.EVOLVED_BLOCKS.register(modEventBus);
        MoreThermalEvaporationCompatTileEntityTypes.EVOLVED_TILE_ENTITY_TYPES.register(modEventBus);
        MoreThermalEvaporationCompatContainerTypes.EVOLVED_CONTAINER_TYPES.register(modEventBus);
    }
}
