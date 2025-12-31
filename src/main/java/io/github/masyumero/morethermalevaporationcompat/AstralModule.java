package io.github.masyumero.morethermalevaporationcompat;

import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationValidator;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.common.lib.multiblock.MultiblockCache;
import mekanism.common.lib.multiblock.MultiblockManager;
import net.minecraftforge.fml.ModList;

public class AstralModule {

    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> VibrationThermalEvaporationManager = new MultiblockManager<>("VibrationThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.VIBRATION));
    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> ResonanceThermalEvaporationManager = new MultiblockManager<>("ResonanceThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.RESONANCE));
    public static final MultiblockManager<TieredThermalEvaporationMultiblockData> IllusionThermalEvaporationManager = new MultiblockManager<>("IllusionThermalEvaporation", MultiblockCache::new, () ->  new TieredThermalEvaporationValidator(TETier.ILLUSION));

    public static boolean AstralLoaded = ModList.get().isLoaded("astral_mekanism");
}
