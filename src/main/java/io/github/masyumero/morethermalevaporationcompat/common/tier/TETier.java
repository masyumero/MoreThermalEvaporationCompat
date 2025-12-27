package io.github.masyumero.morethermalevaporationcompat.common.tier;

import com.jerry.mekanism_extras.api.tier.AdvancedTier;
import fr.iglee42.evolvedmekanism.tiers.EMBaseTier;
import io.github.masyumero.morethermalevaporationcompat.api.tier.ITier;
import io.github.masyumero.morethermalevaporationcompat.common.config.LoadConfig;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatMultiPartType;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlockTypes;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.ExtrasModule;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.content.blocktype.BlockType;
import mekanism.common.lib.multiblock.MultiblockManager;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

public enum TETier implements ITier {
    ABSOLUTE("Absolute", AdvancedTier.ABSOLUTE, MapColor.COLOR_YELLOW, ExtrasModule.ExtrasLoaded, ExtrasModule.AbsoluteThermalEvaporationManager),
    SUPREME("Supreme", AdvancedTier.SUPREME, MapColor.COLOR_RED, ExtrasModule.ExtrasLoaded, ExtrasModule.SupremeThermalEvaporationManager),
    COSMIC("Cosmic", AdvancedTier.COSMIC, MapColor.COLOR_PINK, ExtrasModule.ExtrasLoaded, ExtrasModule.CosmicThermalEvaporationManager),
    INFINITE("Infinite", AdvancedTier.INFINITE, MapColor.COLOR_BLUE, ExtrasModule.ExtrasLoaded, ExtrasModule.InfiniteThermalEvaporationManager),
    OVERCLOCKED("Overclocked", EMBaseTier.OVERCLOCKED, MapColor.COLOR_GREEN, EvolvedModule.EvolvedLoaded, EvolvedModule.OverclockedThermalEvaporationManager),
    QUANTUM("Quantum", EMBaseTier.QUANTUM, MapColor.COLOR_PURPLE, EvolvedModule.EvolvedLoaded, EvolvedModule.QuantumThermalEvaporationManager),
    DENSE("Dense", EMBaseTier.DENSE, MapColor.TERRACOTTA_YELLOW, EvolvedModule.EvolvedLoaded, EvolvedModule.DenseThermalEvaporationManager),
    MULTIVERSAL("Multiversal", EMBaseTier.MULTIVERSAL, MapColor.COLOR_BLACK, EvolvedModule.EvolvedLoaded, EvolvedModule.MultiversalThermalEvaporationManager)
    ;

    private final String name;
    private final Object originalTier;
    private final MapColor mapColor;
    private final boolean modLoaded;
    private final MultiblockManager<TieredThermalEvaporationMultiblockData> manager;

    TETier(String name, Object originalTier, MapColor mapColor, boolean modLoaded, MultiblockManager<TieredThermalEvaporationMultiblockData> manager) {
        this.name = name;
        this.originalTier = originalTier;
        this.mapColor = mapColor;
        this.modLoaded = modLoaded;
        this.manager = manager;
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

    public String getLowerName() {
        return this.getSimpleName().toLowerCase(Locale.ROOT);
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
        return MoreThermalEvaporationCompatBlocks.getCasingBlock(this);
    }

    public IBlockProvider getValveBlock() {
        return MoreThermalEvaporationCompatBlocks.getValveBlock(this);
    }

    public IBlockProvider getControllerBlock() {
        return MoreThermalEvaporationCompatBlocks.getControllerBlock(this);
    }

    public BlockType getCasingBlockType() {
        return MoreThermalEvaporationCompatBlockTypes.getBlockType(this, MTECompatMultiPartType.BLOCK);
    }

    public BlockType getValveBlockType() {
        return MoreThermalEvaporationCompatBlockTypes.getBlockType(this, MTECompatMultiPartType.VALVE);
    }

    public BlockType getControllerBlockType() {
        return MoreThermalEvaporationCompatBlockTypes.getBlockType(this, MTECompatMultiPartType.CONTROLLER);
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

    public MapColor getMapColor() {
        return mapColor;
    }

    public boolean isModLoaded() {
        return modLoaded;
    }
}
