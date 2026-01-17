package io.github.masyumero.morethermalevaporationcompat.common.util;

import dev.lapis256.mekanism_empowered.common.init.MekEmpUpgrades;
import fr.iglee42.evolvedmekanism.registries.EMUpgrades;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import mekanism.api.Upgrade;
import net.minecraftforge.fml.ModList;

import java.util.EnumSet;
import java.util.List;

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
        if (MoreThermalEvaporationCompat.MEK_EMP_LOADED) {
            upgrade.addAll(List.of(MekEmpUpgrades.INSTANCE.getMACHINE_UPGRADES()));
        }
        return upgrade;
    }
}
