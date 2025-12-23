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

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lmekanism/common/content/blocktype/BlockTypeTile$BlockTileBuilder;withSupportedUpgrades(Ljava/util/Set;)Lmekanism/common/content/blocktype/BlockTypeTile$BlockTileBuilder;", ordinal = 0))
    private static Set<Upgrade> supportUpgradesModify_0(Set<Upgrade> upgrades) {
        return UpgradeUtils.getUpgrades();
    }

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lmekanism/common/content/blocktype/BlockTypeTile$BlockTileBuilder;withSupportedUpgrades(Ljava/util/Set;)Lmekanism/common/content/blocktype/BlockTypeTile$BlockTileBuilder;", ordinal = 1))
    private static Set<Upgrade> supportUpgradesModify_1(Set<Upgrade> upgrades) {
        return UpgradeUtils.getUpgrades();
    }

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lmekanism/common/content/blocktype/BlockTypeTile$BlockTileBuilder;withSupportedUpgrades(Ljava/util/Set;)Lmekanism/common/content/blocktype/BlockTypeTile$BlockTileBuilder;", ordinal = 2))
    private static Set<Upgrade> supportUpgradesModify_2(Set<Upgrade> upgrades) {
        return UpgradeUtils.getUpgrades();
    }

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lmekanism/common/content/blocktype/BlockTypeTile$BlockTileBuilder;withSupportedUpgrades(Ljava/util/Set;)Lmekanism/common/content/blocktype/BlockTypeTile$BlockTileBuilder;", ordinal = 3))
    private static Set<Upgrade> supportUpgradesModify_3(Set<Upgrade> upgrades) {
        return UpgradeUtils.getUpgrades();
    }
}
