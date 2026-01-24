package io.github.masyumero.morethermalevaporationcompat.common.util;

import dev.lapis256.mekanism_empowered.common.init.MekEmpUpgrades;
import fr.iglee42.evolvedmekanism.registries.EMUpgrades;
import io.github.masyumero.morethermalevaporationcompat.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import mekanism.api.Upgrade;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UpgradeUtils {

    public static Set<Upgrade> addUpgrades(Set<Upgrade> original) {
        if (EvolvedModule.EvolvedLoaded) {
            original.add(EMUpgrades.SOLAR_UPGRADE);
        }
        return original;
    }

    public static Set<Upgrade> getUpgrades() {
        if (EvolvedModule.EvolvedLoaded) {
            return Set.of(Upgrade.ANCHOR, EMUpgrades.SOLAR_UPGRADE);
        }
        return Set.of(Upgrade.ANCHOR);
    }

    public static Set<Upgrade> getCompactUpgrades() {
        var upgrade = new HashSet<>(getUpgrades());
        upgrade.addAll(EnumSet.of(Upgrade.ENERGY, Upgrade.SPEED, Upgrade.MUFFLING));
        if (MoreThermalEvaporationCompat.MEK_EMP_LOADED) {
            upgrade.addAll(List.of(MekEmpUpgrades.INSTANCE.getMACHINE_UPGRADES()));
        }
        return upgrade;
    }

    public static boolean isSolarUpgrade(Upgrade upgrade) {
        if (EvolvedModule.EvolvedLoaded) {
            return upgrade == EMUpgrades.SOLAR_UPGRADE;
        }
        return false;
    }
}
