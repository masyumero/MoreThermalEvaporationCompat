package io.github.masyumero.morethermalevaporationcompat.mixin;

import io.github.masyumero.morethermalevaporationcompat.common.util.UpgradeUtils;
import mekanism.api.Upgrade;
import morethermalevaporation.common.registries.MoreThermalEvaporationBlockTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Set;

@Mixin(value = MoreThermalEvaporationBlockTypes.class, remap = false)
public class MixinMoreThermalEvaporationBlockTypes {

    @ModifyArg(method = "createMoreThermalEvaporationController", at = @At(value = "INVOKE", target = "Lmekanism/common/content/blocktype/BlockTypeTile$BlockTileBuilder;withSupportedUpgrades(Ljava/util/Set;)Lmekanism/common/content/blocktype/BlockTypeTile$BlockTileBuilder;", ordinal = 0))
    private static Set<Upgrade> supportUpgradesModify(Set<Upgrade> upgrades) {
        return UpgradeUtils.addUpgrades(upgrades);
    }
}
