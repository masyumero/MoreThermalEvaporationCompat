package io.github.masyumero.morethermalevaporationcompat;

import io.github.masyumero.morethermalevaporationcompat.api.lang.MTECompatLangType;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.api.text.ILangEntry;
import net.minecraft.Util;
import org.jetbrains.annotations.NotNull;

public enum MTECompatLang implements ILangEntry {
    CREATIVE_TAB("creativetab", "tab"),

    ABSOLUTE_EVAPORATION("evaporation", "absolute_thermal_evaporation", TETier.ABSOLUTE, MTECompatLangType.TITLE),
    DESCRIPTION_ABSOLUTE_EVAPORATION_BLOCK("description", "absolute_thermal_evaporation_block", TETier.ABSOLUTE, MTECompatLangType.DESC_BLOCK),
    DESCRIPTION_ABSOLUTE_EVAPORATION_VALVE("description", "absolute_thermal_evaporation_valve", TETier.ABSOLUTE, MTECompatLangType.DESC_VALVE),
    DESCRIPTION_ABSOLUTE_EVAPORATION_CONTROLLER("description", "absolute_thermal_evaporation_controller", TETier.ABSOLUTE, MTECompatLangType.DESC_CONTROLLER),

    SUPREME_EVAPORATION("evaporation", "supreme_thermal_evaporation", TETier.SUPREME, MTECompatLangType.TITLE),
    DESCRIPTION_SUPREME_EVAPORATION_BLOCK("description", "supreme_thermal_evaporation_block", TETier.SUPREME, MTECompatLangType.DESC_BLOCK),
    DESCRIPTION_SUPREME_EVAPORATION_VALVE("description", "supreme_thermal_evaporation_valve", TETier.SUPREME, MTECompatLangType.DESC_VALVE),
    DESCRIPTION_SUPREME_EVAPORATION_CONTROLLER("description", "supreme_thermal_evaporation_controller", TETier.SUPREME, MTECompatLangType.DESC_CONTROLLER),

    COSMIC_EVAPORATION("evaporation", "cosmic_thermal_evaporation", TETier.COSMIC, MTECompatLangType.TITLE),
    DESCRIPTION_COSMIC_EVAPORATION_BLOCK("description", "cosmic_thermal_evaporation_block", TETier.COSMIC, MTECompatLangType.DESC_BLOCK),
    DESCRIPTION_COSMIC_EVAPORATION_VALVE("description", "cosmic_thermal_evaporation_valve", TETier.COSMIC, MTECompatLangType.DESC_VALVE),
    DESCRIPTION_COSMIC_EVAPORATION_CONTROLLER("description", "cosmic_thermal_evaporation_controller", TETier.COSMIC, MTECompatLangType.DESC_CONTROLLER),

    INFINITE_EVAPORATION("evaporation", "infinite_thermal_evaporation", TETier.INFINITE, MTECompatLangType.TITLE),
    DESCRIPTION_INFINITE_EVAPORATION_BLOCK("description", "infinite_thermal_evaporation_block", TETier.INFINITE, MTECompatLangType.DESC_BLOCK),
    DESCRIPTION_INFINITE_EVAPORATION_VALVE("description", "infinite_thermal_evaporation_valve", TETier.INFINITE, MTECompatLangType.DESC_VALVE),
    DESCRIPTION_INFINITE_EVAPORATION_CONTROLLER("description", "infinite_thermal_evaporation_controller", TETier.INFINITE, MTECompatLangType.DESC_CONTROLLER),

    OVERCLOCKED_EVAPORATION("evaporation", "overclocked_thermal_evaporation", TETier.OVERCLOCKED, MTECompatLangType.TITLE),
    DESCRIPTION_OVERCLOCKED_EVAPORATION_BLOCK("description", "overclocked_thermal_evaporation_block", TETier.OVERCLOCKED, MTECompatLangType.DESC_BLOCK),
    DESCRIPTION_OVERCLOCKED_EVAPORATION_VALVE("description", "overclocked_thermal_evaporation_valve", TETier.OVERCLOCKED, MTECompatLangType.DESC_VALVE),
    DESCRIPTION_OVERCLOCKED_EVAPORATION_CONTROLLER("description", "overclocked_thermal_evaporation_controller", TETier.OVERCLOCKED, MTECompatLangType.DESC_CONTROLLER),

    QUANTUM_EVAPORATION("evaporation", "quantum_thermal_evaporation", TETier.QUANTUM, MTECompatLangType.TITLE),
    DESCRIPTION_QUANTUM_EVAPORATION_BLOCK("description", "quantum_thermal_evaporation_block", TETier.QUANTUM, MTECompatLangType.DESC_BLOCK),
    DESCRIPTION_QUANTUM_EVAPORATION_VALVE("description", "quantum_thermal_evaporation_valve", TETier.QUANTUM, MTECompatLangType.DESC_VALVE),
    DESCRIPTION_QUANTUM_EVAPORATION_CONTROLLER("description", "quantum_thermal_evaporation_controller", TETier.QUANTUM, MTECompatLangType.DESC_CONTROLLER),

    DENSE_EVAPORATION("evaporation", "dense_thermal_evaporation", TETier.DENSE, MTECompatLangType.TITLE),
    DESCRIPTION_DENSE_EVAPORATION_BLOCK("description", "dense_thermal_evaporation_block", TETier.DENSE, MTECompatLangType.DESC_BLOCK),
    DESCRIPTION_DENSE_EVAPORATION_VALVE("description", "dense_thermal_evaporation_valve", TETier.DENSE, MTECompatLangType.DESC_VALVE),
    DESCRIPTION_DENSE_EVAPORATION_CONTROLLER("description", "dense_thermal_evaporation_controller", TETier.DENSE, MTECompatLangType.DESC_CONTROLLER),

    MULTIVERSAL_EVAPORATION("evaporation", "multiversal_thermal_evaporation", TETier.MULTIVERSAL, MTECompatLangType.TITLE),
    DESCRIPTION_MULTIVERSAL_EVAPORATION_BLOCK("description", "multiversal_thermal_evaporation_block", TETier.MULTIVERSAL, MTECompatLangType.DESC_BLOCK),
    DESCRIPTION_MULTIVERSAL_EVAPORATION_VALVE("description", "multiversal_thermal_evaporation_valve", TETier.MULTIVERSAL, MTECompatLangType.DESC_VALVE),
    DESCRIPTION_MULTIVERSAL_EVAPORATION_CONTROLLER("description", "multiversal_thermal_evaporation_controller",TETier.MULTIVERSAL, MTECompatLangType.DESC_CONTROLLER)
    ;

    private final String key;
    private final TETier tier;
    private final MTECompatLangType langType;

    MTECompatLang(String key) {
        this.key = key;
        this.tier = null;
        this.langType = null;
    }

    MTECompatLang(String key, TETier tier, MTECompatLangType langType) {
        this.key = key;
        this.tier = tier;
        this.langType = langType;
    }

    MTECompatLang(String type, String path) {
        this(Util.makeDescriptionId(type, MoreThermalEvaporationCompat.rl(path)));
    }

    MTECompatLang(String type, String path, TETier tier, MTECompatLangType langType) {
        this(Util.makeDescriptionId(type, MoreThermalEvaporationCompat.rl(path)), tier, langType);
    }

    public static ILangEntry getLang(TETier tier, MTECompatLangType type) {
        for (MTECompatLang lang : MTECompatLang.values()) {
            if (lang.getTier() == null || lang.getLangType() == null) {
                continue;
            }
            if (lang.getTier().equals(tier) && lang.getLangType().equals(type)) {
                return lang;
            }
        }
        return null;
    }

    private TETier getTier() {
        return tier;
    }

    private MTECompatLangType getLangType() {
        return langType;
    }

    @Override
    public @NotNull String getTranslationKey() {
        return key;
    }
}
