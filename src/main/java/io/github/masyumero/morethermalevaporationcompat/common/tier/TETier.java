package io.github.masyumero.morethermalevaporationcompat.common.tier;

import com.jerry.mekanism_extras.api.tier.AdvancedTier;
import fr.iglee42.evolvedmekanism.tiers.EMBaseTier;
import io.github.masyumero.morethermalevaporationcompat.api.tier.ITier;
import io.github.masyumero.morethermalevaporationcompat.common.config.LoadConfig;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import mekanism.api.providers.IBlockProvider;

public enum TETier {
    ABSOLUTE("Absolute", AdvancedTier.ABSOLUTE),
    SUPREME("Supreme", AdvancedTier.SUPREME),
    COSMIC("Cosmic", AdvancedTier.COSMIC),
    INFINITE("Infinite", AdvancedTier.INFINITE),
    OVERCLOCKED("Overclocked", EMBaseTier.OVERCLOCKED),
    QUANTUM("Quantum", EMBaseTier.QUANTUM),
    DENSE("Dense", EMBaseTier.DENSE),
    MULTIVERSAL("Multiversal", EMBaseTier.MULTIVERSAL);

    private final String name;
    private final Object originalTier;

    TETier(String name, Object originalTier) {
        this.name = name;
        this.originalTier = originalTier;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return LoadConfig.MTE_COMPAT_CONFIG.getHeight(originalTier);
    }

    public int getOutputTankCapacity() {
        return LoadConfig.MTE_COMPAT_CONFIG.getTankCapacity(originalTier);
    }

    public Object getOriginalTier() {
        return originalTier;
    }

    public IBlockProvider getCasingBlock() {
        if (!(originalTier instanceof ITier tier)) {
            throw new IllegalStateException("Unexpected value: " + originalTier.getClass().getSimpleName());
        }
        return switch (tier.getSimpleName()) {
            case "Absolute" ->      MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_BLOCK;
            case "Supreme" ->       MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_BLOCK;
            case "Cosmic" ->        MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_BLOCK;
            case "Infinite" ->      MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_BLOCK;
            case "Overclocked" ->   MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_BLOCK;
            case "Quantum" ->       MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_BLOCK;
            case "Dense" ->         MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_BLOCK;
            case "Multiversal" ->   MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_BLOCK;
            default -> throw new IllegalStateException("Unexpected value: " + tier.getSimpleName());
        };
    }

    public IBlockProvider getValveBlock() {
        if (!(originalTier instanceof ITier tier)) {
            throw new IllegalStateException("Unexpected value: " + originalTier.getClass().getSimpleName());
        }
        return switch (tier.getSimpleName()) {
            case "Absolute" ->      MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_VALVE;
            case "Supreme" ->       MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_VALVE;
            case "Cosmic" ->        MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_VALVE;
            case "Infinite" ->      MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_VALVE;
            case "Overclocked" ->   MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_VALVE;
            case "Quantum" ->       MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_VALVE;
            case "Dense" ->         MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_VALVE;
            case "Multiversal" ->   MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_VALVE;
            default -> throw new IllegalStateException("Unexpected value: " + tier.getSimpleName());
        };
    }

    public IBlockProvider getControllerBlock() {
        if (!(originalTier instanceof ITier tier)) {
            throw new IllegalStateException("Unexpected value: " + originalTier.getClass().getSimpleName());
        }
        return switch (tier.getSimpleName()) {
            case "Absolute" ->      MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER;
            case "Supreme" ->       MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_CONTROLLER;
            case "Cosmic" ->        MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_CONTROLLER;
            case "Infinite" ->      MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_CONTROLLER;
            case "Overclocked" ->   MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER;
            case "Quantum" ->       MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_CONTROLLER;
            case "Dense" ->         MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_CONTROLLER;
            case "Multiversal" ->   MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER;
            default -> throw new IllegalStateException("Unexpected value: " + tier.getSimpleName());
        };
    }
}
