package io.github.masyumero.morethermalevaporationcompat;

import mekanism.api.text.ILangEntry;
import net.minecraft.Util;
import org.jetbrains.annotations.NotNull;

public enum MoreThermalEvaporationCompatLang implements ILangEntry {
    CREATIVE_TAB("creativetab.morethermalevaporationcompat.tab"),

    ABSOLUTEEVAPORATION("evaporation", "absolute_thermal_evaporation");

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
