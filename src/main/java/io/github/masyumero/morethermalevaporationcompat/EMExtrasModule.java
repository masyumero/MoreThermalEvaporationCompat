package io.github.masyumero.morethermalevaporationcompat;

import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationValidator;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.common.lib.multiblock.MultiblockCache;
import mekanism.common.lib.multiblock.MultiblockManager;
import net.minecraftforge.fml.ModList;

public class EMExtrasModule {

    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> AbsoluteOverclockedThermalEvaporationManager = new MultiblockManager<>("AbsoluteOverclockedThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.ABSOLUTE_OVERCLOCKED));
    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> SupremeQuantumThermalEvaporationManager = new MultiblockManager<>("SupremeQuantumThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.SUPREME_QUANTUM));
    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> CosmicDenseThermalEvaporationManager = new MultiblockManager<>("CosmicDenseThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.COSMIC_DENSE));
    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> InfiniteMultiversalThermalEvaporationManager = new MultiblockManager<>("InfiniteMultiversalThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.INFINITE_MULTIVERSAL));

    public static boolean EMExtraLoaded = ModList.get().isLoaded("emextras");
}
