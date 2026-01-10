package io.github.masyumero.morethermalevaporationcompat.common.util;

import fr.iglee42.evolvedmekanism.registries.EMUpgrades;
import mekanism.api.Upgrade;
import net.minecraftforge.fml.ModList;

import java.util.EnumSet;

public class UpgradeUtils {

    public static EnumSet<Upgrade> getUpgrades() {
        if (ModList.get().isLoaded("mekanism_extras") && ModList.get().isLoaded("evolvedmekanism")) {
            return EnumSet.of(Upgrade.ANCHOR, EMUpgrades.SOLAR_UPGRADE);
        } else if (ModList.get().isLoaded("mekanism_extras")) {
            return EnumSet.of(Upgrade.ANCHOR);
        } else if (ModList.get().isLoaded("evolvedmekanism")) {
            return EnumSet.of(Upgrade.ANCHOR, EMUpgrades.SOLAR_UPGRADE);
        }
        return EnumSet.of(Upgrade.ANCHOR);
    }

    public static EnumSet<Upgrade> getCompactUpgrades() {
        var upgrade = getUpgrades().clone();
        upgrade.addAll(EnumSet.of(Upgrade.ENERGY, Upgrade.SPEED, Upgrade.MUFFLING));
        return upgrade;
    }
}
