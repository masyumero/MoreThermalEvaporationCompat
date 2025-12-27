package io.github.masyumero.morethermalevaporationcompat;

import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationValidator;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.common.lib.multiblock.MultiblockCache;
import mekanism.common.lib.multiblock.MultiblockManager;
import net.minecraftforge.fml.ModList;

public class EvolvedModule {

    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> OverclockedThermalEvaporationManager = new MultiblockManager<>("OverclockedThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.OVERCLOCKED));
    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> QuantumThermalEvaporationManager = new MultiblockManager<>("QuantumThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.QUANTUM));
    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> DenseThermalEvaporationManager = new MultiblockManager<>("DenseThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.DENSE));
    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> MultiversalThermalEvaporationManager = new MultiblockManager<>("MultiversalThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.MULTIVERSAL));

    public static boolean EvolvedLoaded = ModList.get().isLoaded("evolvedmekanism");
}
