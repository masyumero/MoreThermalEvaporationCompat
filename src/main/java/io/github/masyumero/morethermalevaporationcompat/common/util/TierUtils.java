package io.github.masyumero.morethermalevaporationcompat.common.util;

import com.jerry.mekanism_extras.api.tier.AdvancedTier;
import io.github.masyumero.emextras.api.tier.EMExtraTier;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.api.tier.BaseTier;

public class TierUtils {

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
