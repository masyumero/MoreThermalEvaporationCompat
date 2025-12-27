package io.github.masyumero.morethermalevaporationcompat.common.tier;

import com.jerry.mekanism_extras.api.tier.AdvancedTier;
import fr.iglee42.evolvedmekanism.tiers.EMBaseTier;
import io.github.masyumero.morethermalevaporationcompat.api.tier.ITier;
import io.github.masyumero.morethermalevaporationcompat.common.config.LoadConfig;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlockTypes;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.ExtrasModule;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.content.blocktype.BlockType;
import mekanism.common.lib.multiblock.MultiblockManager;
import net.minecraft.network.chat.TextColor;

public enum TETier implements ITier {
    ABSOLUTE("Absolute", AdvancedTier.ABSOLUTE, ExtrasModule.AbsoluteThermalEvaporationManager),
    SUPREME("Supreme", AdvancedTier.SUPREME, ExtrasModule.SupremeThermalEvaporationManager),
    COSMIC("Cosmic", AdvancedTier.COSMIC, ExtrasModule.CosmicThermalEvaporationManager),
    INFINITE("Infinite", AdvancedTier.INFINITE, ExtrasModule.InfiniteThermalEvaporationManager),
    OVERCLOCKED("Overclocked", EMBaseTier.OVERCLOCKED, EvolvedModule.OverclockedThermalEvaporationManager),
    QUANTUM("Quantum", EMBaseTier.QUANTUM, EvolvedModule.QuantumThermalEvaporationManager),
    DENSE("Dense", EMBaseTier.DENSE, EvolvedModule.DenseThermalEvaporationManager),
    MULTIVERSAL("Multiversal", EMBaseTier.MULTIVERSAL, EvolvedModule.MultiversalThermalEvaporationManager)
    ;

    private final String name;
    private final Object originalTier;
    private final MultiblockManager<TieredThermalEvaporationMultiblockData> manager;

    TETier(String name, Object originalTier, MultiblockManager<TieredThermalEvaporationMultiblockData> manager) {
        this.name = name;
        this.originalTier = originalTier;
        this.manager = manager;
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

    public double getMaxMultiplierTemp() {
        if (!(originalTier instanceof ITier tier)) {
            throw new IllegalStateException("Unexpected value: " + originalTier.getClass().getSimpleName());
        }
        return switch (tier.getSimpleName()) {
            case "Absolute", "Overclocked" -> 96_000;
            case "Supreme", "Quantum" -> 192_000;
            case "Cosmic", "Dense" -> 384_000;
            case "Infinite", "Multiversal" -> 768_000;
            default -> throw new IllegalStateException("Unexpected value: " + tier.getSimpleName());
        };
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

    public BlockType getCasingBlockType() {
        if (!(originalTier instanceof ITier tier)) {
            throw new IllegalStateException("Unexpected value: " + originalTier.getClass().getSimpleName());
        }
        return switch (tier.getSimpleName()) {
            case "Absolute" ->      MoreThermalEvaporationCompatBlockTypes.ABSOLUTE_THERMAL_EVAPORATION_BLOCK;
            case "Supreme" ->       MoreThermalEvaporationCompatBlockTypes.SUPREME_THERMAL_EVAPORATION_BLOCK;
            case "Cosmic" ->        MoreThermalEvaporationCompatBlockTypes.COSMIC_THERMAL_EVAPORATION_BLOCK;
            case "Infinite" ->      MoreThermalEvaporationCompatBlockTypes.INFINITE_THERMAL_EVAPORATION_BLOCK;
            case "Overclocked" ->   MoreThermalEvaporationCompatBlockTypes.OVERCLOCKED_THERMAL_EVAPORATION_BLOCK;
            case "Quantum" ->       MoreThermalEvaporationCompatBlockTypes.QUANTUM_THERMAL_EVAPORATION_BLOCK;
            case "Dense" ->         MoreThermalEvaporationCompatBlockTypes.DENSE_THERMAL_EVAPORATION_BLOCK;
            case "Multiversal" ->   MoreThermalEvaporationCompatBlockTypes.MULTIVERSAL_THERMAL_EVAPORATION_BLOCK;
            default -> throw new IllegalStateException("Unexpected value: " + tier.getSimpleName());
        };
    }

    public BlockType getValveBlockType() {
        if (!(originalTier instanceof ITier tier)) {
            throw new IllegalStateException("Unexpected value: " + originalTier.getClass().getSimpleName());
        }
        return switch (tier.getSimpleName()) {
            case "Absolute" ->      MoreThermalEvaporationCompatBlockTypes.ABSOLUTE_THERMAL_EVAPORATION_VALVE;
            case "Supreme" ->       MoreThermalEvaporationCompatBlockTypes.SUPREME_THERMAL_EVAPORATION_VALVE;
            case "Cosmic" ->        MoreThermalEvaporationCompatBlockTypes.COSMIC_THERMAL_EVAPORATION_VALVE;
            case "Infinite" ->      MoreThermalEvaporationCompatBlockTypes.INFINITE_THERMAL_EVAPORATION_VALVE;
            case "Overclocked" ->   MoreThermalEvaporationCompatBlockTypes.OVERCLOCKED_THERMAL_EVAPORATION_VALVE;
            case "Quantum" ->       MoreThermalEvaporationCompatBlockTypes.QUANTUM_THERMAL_EVAPORATION_VALVE;
            case "Dense" ->         MoreThermalEvaporationCompatBlockTypes.DENSE_THERMAL_EVAPORATION_VALVE;
            case "Multiversal" ->   MoreThermalEvaporationCompatBlockTypes.MULTIVERSAL_THERMAL_EVAPORATION_VALVE;
            default -> throw new IllegalStateException("Unexpected value: " + tier.getSimpleName());
        };
    }

    public BlockType getControllerBlockType() {
        if (!(originalTier instanceof ITier tier)) {
            throw new IllegalStateException("Unexpected value: " + originalTier.getClass().getSimpleName());
        }
        return switch (tier.getSimpleName()) {
            case "Absolute" ->      MoreThermalEvaporationCompatBlockTypes.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER;
            case "Supreme" ->       MoreThermalEvaporationCompatBlockTypes.SUPREME_THERMAL_EVAPORATION_CONTROLLER;
            case "Cosmic" ->        MoreThermalEvaporationCompatBlockTypes.COSMIC_THERMAL_EVAPORATION_CONTROLLER;
            case "Infinite" ->      MoreThermalEvaporationCompatBlockTypes.INFINITE_THERMAL_EVAPORATION_CONTROLLER;
            case "Overclocked" ->   MoreThermalEvaporationCompatBlockTypes.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER;
            case "Quantum" ->       MoreThermalEvaporationCompatBlockTypes.QUANTUM_THERMAL_EVAPORATION_CONTROLLER;
            case "Dense" ->         MoreThermalEvaporationCompatBlockTypes.DENSE_THERMAL_EVAPORATION_CONTROLLER;
            case "Multiversal" ->   MoreThermalEvaporationCompatBlockTypes.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER;
            default -> throw new IllegalStateException("Unexpected value: " + tier.getSimpleName());
        };
    }

    public MultiblockManager<TieredThermalEvaporationMultiblockData> getManager() {
        return manager;
    }

    @Override
    public String getSimpleName() {
        return name;
    }

    @Override
    public TextColor getColor() {
        return null;
    }
}
