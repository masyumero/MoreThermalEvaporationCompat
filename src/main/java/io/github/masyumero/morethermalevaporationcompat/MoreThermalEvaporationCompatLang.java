package io.github.masyumero.morethermalevaporationcompat;

import mekanism.api.text.IHasTranslationKey;
import org.jetbrains.annotations.NotNull;

public enum MoreThermalEvaporationCompatLang implements IHasTranslationKey {
    CREATIVE_TAB("creativetab.morethermalevaporationcompat.tab");

    private final String key;

    MoreThermalEvaporationCompatLang(String key) {
        this.key = key;
    }

    @Override
    public @NotNull String getTranslationKey() {
        return key;
    }
}
