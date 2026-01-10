package io.github.masyumero.morethermalevaporationcompat.mixin;

import io.github.masyumero.morethermalevaporationcompat.api.IThermalEvaporationMultiblockData;
import mekanism.common.capabilities.heat.VariableHeatCapacitor;
import mekanism.common.config.MekanismConfig;
import morethermalevaporation.common.content.evaporation.MoreThermalEvaporationMultiblockData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = MoreThermalEvaporationMultiblockData.class, remap = false)
public abstract class MixinAdvancedThermalEvaporationMultiblockData implements IThermalEvaporationMultiblockData {

    @Shadow
    abstract int getActiveSolars();

    @Shadow
    public VariableHeatCapacitor heatCapacitor;

    @Override
    public void mteCompat$setUpgradeCount(int count) {
        mteCompat$upgradeCount = count;
    }

    @Unique
    private int mteCompat$upgradeCount;

    @ModifyArg(method = "simulateEnvironment", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/heat/VariableHeatCapacitor;handleHeat(D)V", ordinal = 0))
    private double simulateEnvironmentModify(double par1) {
        double heatCapacity = heatCapacitor.getHeatCapacity();
        return getActiveSolars() * (mteCompat$upgradeCount + 1) * MekanismConfig.general.evaporationSolarMultiplier.get() * heatCapacity;
    }
}
