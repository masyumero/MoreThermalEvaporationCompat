package io.github.masyumero.morethermalevaporationcompat;

import mekanism.api.text.ILangEntry;
import net.minecraft.Util;
import org.jetbrains.annotations.NotNull;

public enum MoreThermalEvaporationCompatLang implements ILangEntry {
    CREATIVE_TAB("creativetab.morethermalevaporationcompat.tab"),

    ABSOLUTE_EVAPORATION("evaporation", "absolute_thermal_evaporation"),
    SUPREME_EVAPORATION("evaporation", "supreme_thermal_evaporation"),
    COSMIC_EVAPORATION("evaporation", "cosmic_thermal_evaporation"),
    INFINITE_EVAPORATION("evaporation", "infinite_thermal_evaporation"),
    OVERCLOCKED_EVAPORATION("evaporation", "overclocked_thermal_evaporation"),
    QUANTUM_EVAPORATION("evaporation", "quantum_thermal_evaporation"),
    DENSE_EVAPORATION("evaporation", "dense_thermal_evaporation"),
    MULTIVERSAL_EVAPORATION("evaporation", "multiversal_thermal_evaporation");

    private final String key;

    MoreThermalEvaporationCompatLang(String key) {
        this.key = key;
    }

    MoreThermalEvaporationCompatLang(String type, String path) {
        this(Util.makeDescriptionId(type, MoreThermalEvaporationCompat.rl(path)));
    }

    @Override
    public @NotNull String getTranslationKey() {
        return key;
    }
}
