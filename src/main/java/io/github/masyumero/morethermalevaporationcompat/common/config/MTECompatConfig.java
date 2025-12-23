package io.github.masyumero.morethermalevaporationcompat.common.config;

import com.jerry.mekanism_extras.api.tier.AdvancedTier;
import mekanism.api.tier.BaseTier;
import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedBooleanValue;
import mekanism.common.config.value.CachedIntValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.config.ModConfig;

public class MTECompatConfig extends BaseMekanismConfig {

    private final ForgeConfigSpec configSpec;
    public final CachedBooleanValue heightAdjustment;
    public final CachedIntValue basicHeight;
    public final CachedIntValue advancedHeight;
    public final CachedIntValue eliteHeight;
    public final CachedIntValue ultimateHeight;
    public final CachedIntValue absoluteHeight;
    public final CachedIntValue supremeHeight;
    public final CachedIntValue cosmicHeight;
    public final CachedIntValue infiniteHeight;
    public final CachedIntValue overclockedHeight;
    public final CachedIntValue quantumHeight;
    public final CachedIntValue denseHeight;
    public final CachedIntValue multiversalHeight;

    public MTECompatConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("More Thermal Evaporation Compat Config");
        builder.push("Balance Adjustment");
        heightAdjustment = CachedBooleanValue.wrap(this, builder.comment("Reset the adjustments made in MoreThermalEvaporation-1.2 and raise the height limit.").define("maximumHeightAdjustment", true));
        builder.pop().push("Max Height");
        basicHeight = CachedIntValue.wrap(this, builder.comment("When Maximum Height Adjustment is false, the height limit will refer to these values. Vanilla: 18 Default: 34").define("basic", 34));
        advancedHeight = CachedIntValue.wrap(this, builder.comment("When Maximum Height Adjustment is false, the height limit will refer to these values. Vanilla: 18 Default: 66").define("advanced", 66));
        eliteHeight = CachedIntValue.wrap(this, builder.comment("When Maximum Height Adjustment is false, the height limit will refer to these values. Vanilla: 18 Default: 130").define("elite", 130));
        ultimateHeight = CachedIntValue.wrap(this, builder.comment("When Maximum Height Adjustment is false, the height limit will refer to these values. Vanilla: 18 Default: 258").define("ultimate", 258));
        absoluteHeight = CachedIntValue.wrap(this, builder.comment("When Maximum Height Adjustment is false, the height limit will refer to these values. Vanilla: 18 Default: 514").define("absolute", 514));
        supremeHeight = CachedIntValue.wrap(this, builder.comment("When Maximum Height Adjustment is false, the height limit will refer to these values. Vanilla: 18 Default: 1026").define("supreme", 1026));
        cosmicHeight = CachedIntValue.wrap(this, builder.comment("When Maximum Height Adjustment is false, the height limit will refer to these values. Vanilla: 18 Default: 2050").define("cosmic", 2050));
        infiniteHeight = CachedIntValue.wrap(this, builder.comment("When Maximum Height Adjustment is false, the height limit will refer to these values. Vanilla: 18 Default: 4098").define("infinite", 4098));
        overclockedHeight = CachedIntValue.wrap(this, builder.comment("When Maximum Height Adjustment is false, the height limit will refer to these values. Vanilla: 18 Default: 514").define("overclocked", 514));
        quantumHeight = CachedIntValue.wrap(this, builder.comment("When Maximum Height Adjustment is false, the height limit will refer to these values. Vanilla: 18 Default: 1026").define("quantum", 1026));
        denseHeight = CachedIntValue.wrap(this, builder.comment("When Maximum Height Adjustment is false, the height limit will refer to these values. Vanilla: 18 Default: 2050").define("dense", 2050));
        multiversalHeight = CachedIntValue.wrap(this, builder.comment("When Maximum Height Adjustment is false, the height limit will refer to these values. Vanilla: 18 Default: 4098").define("multiversal", 4098));
        this.configSpec = builder.build();
    }

    public int getHeight(Object tiers) {
        if (!heightAdjustment.get()) {
            if (tiers instanceof AdvancedTier tier) {
                return switch (tier) {
                    case ABSOLUTE -> this.absoluteHeight.get();
                    case SUPREME -> this.supremeHeight.get();
                    case COSMIC -> this.cosmicHeight.get();
                    case INFINITE -> this.infiniteHeight.get();
                };
            }
            if (tiers instanceof BaseTier tier) {
                if (ModList.get().isLoaded("evolvedmekanism")) {
                    return switch (tier.getSimpleName()) {
                        case "Basic" -> this.basicHeight.get();
                        case "Advanced" -> this.advancedHeight.get();
                        case "Elite" -> this.eliteHeight.get();
                        case "Ultimate" -> this.ultimateHeight.get();
                        case "Overclocked" -> this.overclockedHeight.get();
                        case "Quantum" -> this.quantumHeight.get();
                        case "Dense" -> this.denseHeight.get();
                        case "Multiversal" -> this.multiversalHeight.get();
                        case "Creative" -> 18;
                        default -> throw new IllegalStateException("Unexpected value: " + tier);
                    };
                } else {
                    return switch (tier) {
                        case BASIC -> this.basicHeight.get();
                        case ADVANCED -> this.advancedHeight.get();
                        case ELITE -> this.eliteHeight.get();
                        case ULTIMATE -> this.ultimateHeight.get();
                        case CREATIVE -> 18;
                    };
                }
            }
        }
        return 18;
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
        return ModConfig.Type.SERVER;
    }

    public boolean addToContainer() {
        return false;
    }
}
