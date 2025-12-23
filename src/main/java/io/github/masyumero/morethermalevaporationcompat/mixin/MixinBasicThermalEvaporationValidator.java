package io.github.masyumero.morethermalevaporationcompat.mixin;

import io.github.masyumero.morethermalevaporationcompat.common.config.LoadConfig;
import mekanism.api.tier.BaseTier;
import morethermalevaporation.common.evaporation.BasicThermalEvaporationValidator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = BasicThermalEvaporationValidator.class, remap = false)
public class MixinBasicThermalEvaporationValidator {

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lmekanism/common/lib/math/voxel/VoxelCuboid;<init>(III)V", ordinal = 1), index = 1)
    private static int heightModify(int height) {
        return LoadConfig.MTE_COMPAT_CONFIG.getHeight(BaseTier.BASIC);
    }
}
