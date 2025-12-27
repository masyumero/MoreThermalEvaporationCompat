package io.github.masyumero.morethermalevaporationcompat;

import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationValidator;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.common.lib.multiblock.MultiblockCache;
import mekanism.common.lib.multiblock.MultiblockManager;
import net.minecraftforge.fml.ModList;

public class ExtrasModule {

    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> AbsoluteThermalEvaporationManager = new MultiblockManager<>("AbsoluteThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.ABSOLUTE));
    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> SupremeThermalEvaporationManager = new MultiblockManager<>("SupremeThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.SUPREME));
    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> CosmicThermalEvaporationManager = new MultiblockManager<>("CosmicThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.COSMIC));
    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> InfiniteThermalEvaporationManager = new MultiblockManager<>("InfiniteThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.INFINITE));

    public static boolean ExtrasLoaded = ModList.get().isLoaded("mekanism_extras");
}
