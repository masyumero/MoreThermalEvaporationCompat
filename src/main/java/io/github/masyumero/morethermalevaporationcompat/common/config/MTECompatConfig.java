package io.github.masyumero.morethermalevaporationcompat.common.config;

import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.util.MTECompatEnumUtils;
import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedBooleanValue;
import mekanism.common.config.value.CachedDoubleValue;
import mekanism.common.config.value.CachedIntValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import java.util.HashMap;
import java.util.Map;

public class MTECompatConfig extends BaseMekanismConfig {

    private final ForgeConfigSpec configSpec;

    public final Map<TETier, CachedIntValue> heightConfig = new HashMap<>();
    public final Map<TETier, CachedIntValue> outputTankCapacityConfig = new HashMap<>();
    public final Map<TETier, CachedIntValue> inputTankCapacityConfig = new HashMap<>();
    public final Map<TETier, CachedDoubleValue> maxMultiplierTempConfig = new HashMap<>();

    public final CachedBooleanValue upgradeable;

    public MTECompatConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("More Thermal Evaporation Compat Settings");
        builder.push("Common");
        upgradeable = CachedBooleanValue.wrap(this, builder
                .comment("Specifies whether Compact Thermal Evaporation can be upgraded using the Tier Installer.")
                .define("Upgradeable", false));
        builder.pop();

        builder.push("Tier");
        for (TETier tier : MTECompatEnumUtils.THERMAL_EVAPORATION_TIERS) {
            if (!tier.isCompactOnly()) {
                builder.push(tier.getSimpleName().formatted(tier.getLowerName().replace("_", "")));
                builder.comment("Settings for the %s Tier".formatted(tier.getSimpleName()));
                var outputTankCapacity = CachedIntValue.wrap(this, builder
                                .comment("Amount of output fluid (mB) that the %s Evaporation Plant can store.".formatted(tier.getSimpleName().replace("_", " ")))
                                .defineInRange("%sEvaporationOutputTankCapacity".formatted(tier.getLowerName().replace("_", "")), tier.getBaseOutputTankCapacity(), 1, Integer.MAX_VALUE));
                var inputTankCapacity = CachedIntValue.wrap(this, builder
                        .comment("Amount of fluid (mB) that each block of the %s Thermal Evaporation Plant contributes to the input tank capacity. Max = volume * fluidPerTank".formatted(tier.getSimpleName().replace("_", " ")))
                        .defineInRange("%sThermalEvaporationInputTankCapacity".formatted(tier.getLowerName().replace("_", "")), tier.getBaseInputTankCapacity(), 1, 29826161));
                var height = CachedIntValue.wrap(this, builder
                        .comment("Buildable Height (in blocks) for the %s Evaporation Plant.".formatted(tier.getSimpleName().replace("_", " ")))
                        .defineInRange("%sEvaporationPlantHeight".formatted(tier.getLowerName().replace("_", "")), 18, 18, tier.getBaseHeight()));
                var maxMultiplierTemp = CachedDoubleValue.wrap(this, builder.
                        comment("Maximum temperature capping the temperature multiplier for the %s Thermal Evaporation Plant.".formatted(tier.getSimpleName().replace("_", " ")))
                        .defineInRange("%sThermalEvaporationMultiplierTempCap".formatted(tier.getLowerName().replace("_", "")), tier.getBaseMaxMultiplierTemp(), 3000, 2147483646));
                outputTankCapacityConfig.put(tier, outputTankCapacity);
                inputTankCapacityConfig.put(tier, inputTankCapacity);
                heightConfig.put(tier, height);
                maxMultiplierTempConfig.put(tier, maxMultiplierTemp);
                builder.pop();
            }
        }
        builder.pop();
        this.configSpec = builder.build();
    }

    public int getHeight(TETier tier) {
        return heightConfig.get(tier).get();
    }

    public int getOutputTankCapacity(TETier tier) {
        return outputTankCapacityConfig.get(tier).get();
    }

    public int getInputTankCapacity(TETier tier) {
        return inputTankCapacityConfig.get(tier).get();
    }

    public double getMaxMultiplierTemp(TETier tier) {
        return maxMultiplierTempConfig.get(tier).get();
    }

    @Override
    public String getFileName() {
        return "config";
    }

    @Override
    public ForgeConfigSpec getConfigSpec() {
        return configSpec;
    }

    @Override
    public ModConfig.Type getConfigType() {
        return ModConfig.Type.COMMON;
    }

    @Override
    public boolean addToContainer() {
        return false;
    }
}
