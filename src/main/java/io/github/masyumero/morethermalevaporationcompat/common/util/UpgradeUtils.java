package io.github.masyumero.morethermalevaporationcompat.common.util;

import astral_mekanism.enums.AMEUpgrade;
import dev.lapis256.mekanism_empowered.api.MekEmpUpgrade;
import fr.iglee42.evolvedmekanism.registries.EMUpgrades;
import io.github.masyumero.morethermalevaporationcompat.AstralModule;
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
        var upgrade = new HashSet<>(Set.of(Upgrade.ANCHOR));
        if (EvolvedModule.EvolvedLoaded) {
            upgrade.add(EMUpgrades.SOLAR_UPGRADE);
        }
        if (AstralModule.AstralLoaded) {
            upgrade.add(AMEUpgrade.WATER_SUPPLY.getValue());
        }
        return upgrade;
    }

    public static Set<Upgrade> getCompactUpgrades() {
        var upgrade = new HashSet<>(getUpgrades());
        upgrade.addAll(EnumSet.of(Upgrade.MUFFLING));
        if (MoreThermalEvaporationCompat.MEK_EMP_LOADED) {
            upgrade.addAll(List.of(MekEmpUpgrade.getIO_CAPACITY(),
                    MekEmpUpgrade.getAUTO_INSERTER(),
                    MekEmpUpgrade.getFAST_ITEM_INSERT(),
                    MekEmpUpgrade.getFAST_ITEM_EJECT()
            ));
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
