package io.github.masyumero.morethermalevaporationcompat.common.util;

import com.jerry.mekanism_extras.api.tier.AdvancedTier;
import io.github.masyumero.emextras.api.tier.EMExtraTier;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.api.tier.BaseTier;

public class TierUtils {

    public static TETier getAfterTier(TETier tier, TETier toTier) {
        return switch (tier) {
            case BASIC -> TETier.ADVANCED;
            case ADVANCED -> TETier.ELITE;
            case ELITE -> TETier.ULTIMATE;
            case ULTIMATE -> toTier;
            case ABSOLUTE -> TETier.SUPREME;
            case SUPREME -> TETier.COSMIC;
            case COSMIC -> TETier.INFINITE;
            case INFINITE -> null;
            case OVERCLOCKED -> TETier.QUANTUM;
            case QUANTUM -> TETier.DENSE;
            case DENSE -> TETier.MULTIVERSAL;
            case MULTIVERSAL -> null;
            case VIBRATION -> TETier.RESONANCE;
            case RESONANCE -> TETier.ILLUSION;
            case ILLUSION -> null;
            case ABSOLUTE_OVERCLOCKED -> TETier.SUPREME_QUANTUM;
            case SUPREME_QUANTUM -> TETier.COSMIC_DENSE;
            case COSMIC_DENSE -> TETier.INFINITE_MULTIVERSAL;
            case INFINITE_MULTIVERSAL -> null;
        };
    }

    public static TETier getBeforeTier(TETier tier) {
        return switch (tier) {
            case BASIC -> null;
            case ADVANCED -> TETier.BASIC;
            case ELITE -> TETier.ADVANCED;
            case ULTIMATE -> TETier.ELITE;
            case ABSOLUTE -> TETier.ULTIMATE;
            case SUPREME -> TETier.ABSOLUTE;
            case COSMIC -> TETier.SUPREME;
            case INFINITE -> TETier.COSMIC;
            case OVERCLOCKED -> TETier.ULTIMATE;
            case QUANTUM -> TETier.OVERCLOCKED;
            case DENSE -> TETier.QUANTUM;
            case MULTIVERSAL -> TETier.DENSE;
            case VIBRATION -> TETier.ULTIMATE;
            case RESONANCE -> TETier.VIBRATION;
            case ILLUSION -> TETier.RESONANCE;
            case ABSOLUTE_OVERCLOCKED -> TETier.ULTIMATE;
            case SUPREME_QUANTUM -> TETier.ABSOLUTE_OVERCLOCKED;
            case COSMIC_DENSE -> TETier.SUPREME_QUANTUM;
            case INFINITE_MULTIVERSAL -> TETier.COSMIC_DENSE;
        };
    }

    public static TETier getTETier(Object tierObject) {
        if (tierObject instanceof BaseTier tier) {
            return getTETier(tier.getLowerName());
        } else if (tierObject instanceof AdvancedTier tier) {
            return getTETier(tier.getLowerName());
        } else if (tierObject instanceof EMExtraTier tier) {
            return getTETier(tier.getLowerName());
        } else {
            return TETier.BASIC;
        }
    }

    public static TETier getTETier(String tierName) {
        for (TETier tier : MTECompatEnumUtils.THERMAL_EVAPORATION_TIERS) {
            if (tier.getLowerName().equals(tierName)) {
                return tier;
            }
        }
        return TETier.BASIC;
    }
}
