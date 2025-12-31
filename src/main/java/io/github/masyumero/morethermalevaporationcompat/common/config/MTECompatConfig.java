package io.github.masyumero.morethermalevaporationcompat.common.config;

import io.github.masyumero.morethermalevaporationcompat.api.tier.ITier;
import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedIntValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class MTECompatConfig extends BaseMekanismConfig {

    private final ForgeConfigSpec configSpec;
    public final CachedIntValue absoluteHeight;
    public final CachedIntValue supremeHeight;
    public final CachedIntValue cosmicHeight;
    public final CachedIntValue infiniteHeight;
    public final CachedIntValue overclockedHeight;
    public final CachedIntValue quantumHeight;
    public final CachedIntValue denseHeight;
    public final CachedIntValue multiversalHeight;
    public final CachedIntValue vibrationHeight;
    public final CachedIntValue resonanceHeight;
    public final CachedIntValue illusionHeight;
    public final CachedIntValue absoluteOutputTankCapacity;
    public final CachedIntValue supremeOutputTankCapacity;
    public final CachedIntValue cosmicOutputTankCapacity;
    public final CachedIntValue infiniteOutputTankCapacity;
    public final CachedIntValue overclockedOutputTankCapacity;
    public final CachedIntValue quantumOutputTankCapacity;
    public final CachedIntValue denseOutputTankCapacity;
    public final CachedIntValue multiversalOutputTankCapacity;
    public final CachedIntValue vibrationOutputTankCapacity;
    public final CachedIntValue resonanceOutputTankCapacity;
    public final CachedIntValue illusionOutputTankCapacity;

    public MTECompatConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("More Thermal Evaporation Compat Settings");
        builder.push("Tier");
        builder.push("Absolute");
        builder.comment("Settings for the Absolute Tier");

        absoluteOutputTankCapacity = CachedIntValue.wrap(this, builder
                .comment("Amount of output fluid (mB) that the Absolute Evaporation Plant can store.")
                .defineInRange("AbsoluteEvaporationOutputTankCapacity", 20480000, 1, Integer.MAX_VALUE));

        absoluteHeight = CachedIntValue.wrap(this, builder
                .comment("Buildable Height (in blocks) for the Absolute Evaporation Plant.")
                .defineInRange("AbsoluteEvaporationPlantHeight", 18, 18, 514));

        builder.pop();
        builder.push("Supreme");
        builder.comment("Settings for the Supreme Tier");
        supremeOutputTankCapacity = CachedIntValue.wrap(this, builder
                .comment("Amount of output fluid (mB) that the Supreme Evaporation Plant can store.")
                .defineInRange("SupremeEvaporationOutputTankCapacity", 40960000, 1, Integer.MAX_VALUE));

        supremeHeight = CachedIntValue.wrap(this, builder
                .comment("Buildable Height (in blocks) for the Supreme Evaporation Plant.")
                .defineInRange("SupremeEvaporationPlantHeight", 18, 18, 1026));

        builder.pop();
        builder.push("Cosmic");
        builder.comment("Settings for the Cosmic Tier");
        cosmicOutputTankCapacity = CachedIntValue.wrap(this, builder
                .comment("Amount of output fluid (mB) that the Cosmic Evaporation Plant can store.")
                .defineInRange("CosmicEvaporationOutputTankCapacity", 81920000, 1, Integer.MAX_VALUE));

        cosmicHeight = CachedIntValue.wrap(this, builder
                .comment("Buildable Height (in blocks) for the Cosmic Evaporation Plant.")
                .defineInRange("CosmicEvaporationPlantHeight", 18, 18, 2050));

        builder.pop();
        builder.push("Infinite");
        builder.comment("Settings for the Infinite Tier");
        infiniteOutputTankCapacity = CachedIntValue.wrap(this, builder
                .comment("Amount of output fluid (mB) that the Infinite Evaporation Plant can store.")
                .defineInRange("InfiniteEvaporationOutputTankCapacity", 163840000, 1, Integer.MAX_VALUE));

        infiniteHeight = CachedIntValue.wrap(this, builder
                .comment("Buildable Height (in blocks) for the Infinite Evaporation Plant.")
                .defineInRange("InfiniteEvaporationPlantHeight", 18, 18, 4098));

        builder.pop();
        builder.push("Overclocked");
        builder.comment("Settings for the Overclocked Tier");
        overclockedOutputTankCapacity = CachedIntValue.wrap(this, builder
                .comment("Amount of output fluid (mB) that the Overclocked Evaporation Plant can store.")
                .defineInRange("OverclockedEvaporationOutputTankCapacity", 20480000, 1, Integer.MAX_VALUE));

        overclockedHeight = CachedIntValue.wrap(this, builder
                .comment("Buildable Height (in blocks) for the Overclocked Evaporation Plant.")
                .defineInRange("OverclockedEvaporationPlantHeight", 18, 18, 514));

        builder.pop();
        builder.push("Quantum");
        builder.comment("Settings for the Quantum Tier");
        quantumOutputTankCapacity = CachedIntValue.wrap(this, builder
                .comment("Amount of output fluid (mB) that the Quantum Evaporation Plant can store.")
                .defineInRange("QuantumEvaporationOutputTankCapacity", 40960000, 1, Integer.MAX_VALUE));

        quantumHeight = CachedIntValue.wrap(this, builder
                .comment("Buildable Height (in blocks) for the Quantum Evaporation Plant.")
                .defineInRange("QuantumEvaporationPlantHeight", 18, 18, 1026));

        builder.pop();
        builder.push("Dense");
        builder.comment("Settings for the Dense Tier");
        denseOutputTankCapacity = CachedIntValue.wrap(this, builder
                .comment("Amount of output fluid (mB) that the Dense Evaporation Plant can store.")
                .defineInRange("DenseEvaporationOutputTankCapacity", 81920000, 1, Integer.MAX_VALUE));

        denseHeight = CachedIntValue.wrap(this, builder
                .comment("Buildable Height (in blocks) for the Dense Evaporation Plant.")
                .defineInRange("DenseEvaporationPlantHeight", 18, 18, 2050));

        builder.pop();
        builder.push("Multiversal");
        builder.comment("Settings for the Multiversal Tier");
        multiversalOutputTankCapacity = CachedIntValue.wrap(this, builder
                .comment("Amount of output fluid (mB) that the Multiversal Evaporation Plant can store.")
                .defineInRange("MultiversalEvaporationOutputTankCapacity", 163840000, 1, Integer.MAX_VALUE));

        multiversalHeight = CachedIntValue.wrap(this, builder
                .comment("Buildable Height (in blocks) for the Multiversal Evaporation Plant.")
                .defineInRange("MultiversalEvaporationPlantHeight", 18, 18, 4098));

        builder.pop();
        builder.push("Vibration");
        builder.comment("Settings for the Vibration Tier");
        vibrationOutputTankCapacity = CachedIntValue.wrap(this, builder
                .comment("Amount of output fluid (mB) that the Vibration Evaporation Plant can store.")
                .defineInRange("VibrationEvaporationOutputTankCapacity", 15360000, 1, Integer.MAX_VALUE));

        vibrationHeight = CachedIntValue.wrap(this, builder
                .comment("Buildable Height (in blocks) for the Vibration Evaporation Plant.")
                .defineInRange("VibrationEvaporationPlantHeight", 18, 18, 432));

        builder.pop();
        builder.push("Resonance");
        builder.comment("Settings for the Resonance Tier");
        resonanceOutputTankCapacity = CachedIntValue.wrap(this, builder
                .comment("Amount of output fluid (mB) that the Resonance Evaporation Plant can store.")
                .defineInRange("ResonanceEvaporationOutputTankCapacity", 30720000, 1, Integer.MAX_VALUE));

        resonanceHeight = CachedIntValue.wrap(this, builder
                .comment("Buildable Height (in blocks) for the Resonance Evaporation Plant.")
                .defineInRange("ResonanceEvaporationPlantHeight", 18, 18, 864));

        builder.pop();
        builder.push("Illusion");
        builder.comment("Settings for the Illusion Tier");
        illusionOutputTankCapacity = CachedIntValue.wrap(this, builder
                .comment("Amount of output fluid (mB) that the Illusion Evaporation Plant can store.")
                .defineInRange("IllusionEvaporationOutputTankCapacity", 327680000, 1, Integer.MAX_VALUE));

        illusionHeight = CachedIntValue.wrap(this, builder
                .comment("Buildable Height (in blocks) for the Illusion Evaporation Plant.")
                .defineInRange("IllusionEvaporationPlantHeight", 18, 18, 9216));

        builder.pop().pop();
        this.configSpec = builder.build();
    }

    public int getHeight(Object tiers) {
        if (tiers instanceof ITier tier) {
            return switch (tier.getSimpleName()) {
                case "Absolute" -> this.absoluteHeight.get();
                case "Supreme" -> this.supremeHeight.get();
                case "Cosmic" -> this.cosmicHeight.get();
                case "Infinite" -> this.infiniteHeight.get();
                case "Overclocked" -> this.overclockedHeight.get();
                case "Quantum" -> this.quantumHeight.get();
                case "Dense" -> this.denseHeight.get();
                case "Multiversal" -> this.multiversalHeight.get();
                case "Vibration" -> this.vibrationHeight.get();
                case "Resonance" -> this.resonanceHeight.get();
                case "Illusion" -> this.illusionHeight.get();
                default -> 18;
            };
        }
        return 18;
    }

    public int getTankCapacity(Object tiers) {
        if (tiers instanceof ITier tier) {
            return switch (tier.getSimpleName()) {
                case "Absolute" -> this.absoluteOutputTankCapacity.get();
                case "Supreme" -> this.supremeOutputTankCapacity.get();
                case "Cosmic" -> this.cosmicOutputTankCapacity.get();
                case "Infinite" -> this.infiniteOutputTankCapacity.get();
                case "Overclocked" -> this.overclockedOutputTankCapacity.get();
                case "Quantum" -> this.quantumOutputTankCapacity.get();
                case "Dense" -> this.denseOutputTankCapacity.get();
                case "Multiversal" -> this.multiversalOutputTankCapacity.get();
                case "Vibration" -> this.vibrationOutputTankCapacity.get();
                case "Resonance" -> this.resonanceOutputTankCapacity.get();
                case "Illusion" -> this.illusionOutputTankCapacity.get();
                default -> 20000;
            };
        }
        return 20000;
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
