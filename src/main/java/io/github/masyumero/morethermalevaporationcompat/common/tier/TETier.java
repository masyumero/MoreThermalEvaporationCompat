package io.github.masyumero.morethermalevaporationcompat.common.tier;

import io.github.masyumero.morethermalevaporationcompat.*;
import io.github.masyumero.morethermalevaporationcompat.common.config.LoadConfig;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatMultiPartType;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlockTypes;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import mekanism.api.SupportsColorMap;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.tier.BaseTier;
import mekanism.common.content.blocktype.BlockType;
import mekanism.common.lib.multiblock.MultiblockManager;
import morethermalevaporation.common.registries.MoreThermalEvaporationBlocks;
import morethermalevaporation.common.tier.MoreThermalEvaporationTier;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

public enum TETier implements SupportsColorMap {
    BASIC("Basic", BaseTier.BASIC, MoreThermalEvaporationTier.BASIC),
    ADVANCED("Advanced", BaseTier.ADVANCED, MoreThermalEvaporationTier.ADVANCED),
    ELITE("Elite", BaseTier.ELITE, MoreThermalEvaporationTier.ELITE),
    ULTIMATE("Ultimate", BaseTier.ULTIMATE, MoreThermalEvaporationTier.ULTIMATE),
    CREATIVE("Creative", BaseTier.CREATIVE, MoreThermalEvaporationTier.CREATIVE),
    ABSOLUTE("Absolute", new int[]{95, 255, 184}, MapColor.COLOR_YELLOW, ExtrasModule.ExtrasLoaded, 514, 20480000, 64000, 96_000, ExtrasModule.AbsoluteThermalEvaporationManager),
    SUPREME("Supreme", new int[]{255, 128, 106}, MapColor.COLOR_RED, ExtrasModule.ExtrasLoaded, 1026, 40960000, 64000, 192_000, ExtrasModule.SupremeThermalEvaporationManager),
    COSMIC("Cosmic", new int[]{75, 248, 255}, MapColor.COLOR_PINK, ExtrasModule.ExtrasLoaded, 2050, 81920000, 64000, 384_000, ExtrasModule.CosmicThermalEvaporationManager),
    INFINITE("Infinite", new int[]{247, 135, 255}, MapColor.COLOR_BLUE, ExtrasModule.ExtrasLoaded, 4098, 163840000, 64000, 768_000, ExtrasModule.InfiniteThermalEvaporationManager),
    OVERCLOCKED("Overclocked", new int[]{0, 221, 0}, MapColor.COLOR_LIGHT_GREEN, EvolvedModule.EvolvedLoaded, 514, 20480000, 64000, 96_000, EvolvedModule.OverclockedThermalEvaporationManager),
    QUANTUM("Quantum", new int[]{252, 158, 250}, MapColor.COLOR_PURPLE, EvolvedModule.EvolvedLoaded, 1026, 40960000, 64000, 192_000, EvolvedModule.QuantumThermalEvaporationManager),
    DENSE("Dense", new int[]{253, 245, 95}, MapColor.GOLD, EvolvedModule.EvolvedLoaded, 2050, 81920000, 64000, 384_000, EvolvedModule.DenseThermalEvaporationManager),
    MULTIVERSAL("Multiversal", new int[]{90, 87, 90}, MapColor.COLOR_BLACK, EvolvedModule.EvolvedLoaded, 4098, 163840000, 64000, 768_000, EvolvedModule.MultiversalThermalEvaporationManager),
    VIBRATION("Vibration", new int[]{255, 255, 85}, MapColor.TERRACOTTA_PURPLE , AstralModule.AstralLoaded, 432, 15360000, 64000, 72_000, AstralModule.VibrationThermalEvaporationManager),
    RESONANCE("Resonance", new int[]{85, 255, 255}, MapColor.COLOR_PURPLE , AstralModule.AstralLoaded, 864, 30720000, 64000, 144_000, AstralModule.ResonanceThermalEvaporationManager),
    ILLUSION("Illusion", new int[]{255, 85, 255}, MapColor.COLOR_YELLOW , AstralModule.AstralLoaded, 9216, 327680000, 64000, 1_536_000, AstralModule.IllusionThermalEvaporationManager),
    ABSOLUTE_OVERCLOCKED("Absolute_Overclocked", new int[]{95, 255, 184}, MapColor.COLOR_LIGHT_GREEN, EMExtrasModule.EMExtraLoaded, 864, 30720000, 64000, 144_000, EMExtrasModule.AbsoluteOverclockedThermalEvaporationManager),
    SUPREME_QUANTUM("Supreme_Quantum", new int[]{255, 128, 106}, MapColor.TERRACOTTA_PINK, EMExtrasModule.EMExtraLoaded, 1728, 61440000, 64000, 288_000, EMExtrasModule.SupremeQuantumThermalEvaporationManager),
    COSMIC_DENSE("Cosmic_Dense", new int[]{75, 248, 255}, MapColor.DIAMOND, EMExtrasModule.EMExtraLoaded, 3456, 122880000, 64000, 576_000, EMExtrasModule.CosmicDenseThermalEvaporationManager),
    INFINITE_MULTIVERSAL("Infinite_Multiversal", new int[]{247, 135, 255}, MapColor.COLOR_MAGENTA, EMExtrasModule.EMExtraLoaded, 6912, 245760000, 64000, 1_152_000, EMExtrasModule.InfiniteMultiversalThermalEvaporationManager),
    ;

    private final String name;
    private TextColor textColor;
    private final MapColor mapColor;
    private final boolean modLoaded;
    private final boolean compactOnly;
    private final int baseHeight;
    private final int baseOutputTankCapacity;
    private final int baseInputTankCapacity;
    private final double baseMaxMultiplierTemp;
    private int[] rgbCode;
    private MoreThermalEvaporationTier mteTier;
    private final MultiblockManager<TieredThermalEvaporationMultiblockData> manager;

    TETier(String name, int[] rgbCode, MapColor mapColor, boolean modLoaded, int baseHeight, int baseOutputTankCapacity, int baseInputTankCapacity, int baseMaxMultiplierTemp, MultiblockManager<TieredThermalEvaporationMultiblockData> manager) {
        this.name = name;
        this.mapColor = mapColor;
        this.modLoaded = modLoaded;
        this.baseHeight = baseHeight;
        this.baseOutputTankCapacity = baseOutputTankCapacity;
        this.baseInputTankCapacity = baseInputTankCapacity;
        this.manager = manager;
        this.baseMaxMultiplierTemp = baseMaxMultiplierTemp;
        compactOnly = false;
        setColorFromAtlas(rgbCode);
    }

    TETier(String name, BaseTier tier, MoreThermalEvaporationTier mteTier) {
        this.name = name;
        this.mapColor = tier.getMapColor();
        this.modLoaded = CompactModule.CompactLoaded;
        this.manager = null;
        this.compactOnly = true;
        this.textColor = tier.getColor();
        this.mteTier = mteTier;
        this.baseMaxMultiplierTemp = mteTier.getMultiplierTemp();
        this.baseHeight = mteTier.getHeight();
        this.baseInputTankCapacity = mteTier.getInputTankCapacity();
        this.baseOutputTankCapacity = mteTier.getOutputTankCapacity();
    }

    public int getBaseHeight() {
        return baseHeight;
    }

    public int getHeight() {
        if (compactOnly) {
            return mteTier.getHeight();
        }
        return LoadConfig.MTE_COMPAT_CONFIG.getHeight(this);
    }

    public int getBaseOutputTankCapacity() {
        return baseOutputTankCapacity;
    }

    public int getOutputTankCapacity() {
        if (compactOnly) {
            return mteTier.getOutputTankCapacity();
        }
        return LoadConfig.MTE_COMPAT_CONFIG.getOutputTankCapacity(this);
    }

    public int getBaseInputTankCapacity() {
        return baseInputTankCapacity;
    }

    public int getInputTankCapacity() {
        if (compactOnly) {
            return mteTier.getInputTankCapacity();
        }
        return LoadConfig.MTE_COMPAT_CONFIG.getInputTankCapacity(this);
    }

    public double getBaseMaxMultiplierTemp() {
        return baseMaxMultiplierTemp;
    }

    public double getMaxMultiplierTemp() {
        if (compactOnly) {
            return mteTier.getMultiplierTemp();
        }
        return LoadConfig.MTE_COMPAT_CONFIG.getMaxMultiplierTemp(this);
    }

    public String getLowerName() {
        return this.getSimpleName().toLowerCase(Locale.ROOT);
    }

    public IBlockProvider getCasingBlock() {
        if (compactOnly) {
            return MoreThermalEvaporationBlocks.getBlock(mteTier);
        }
        return MoreThermalEvaporationCompatBlocks.getCasingBlock(this);
    }

    public IBlockProvider getValveBlock() {
        if (compactOnly) {
            return MoreThermalEvaporationBlocks.getValve(mteTier);
        }
        return MoreThermalEvaporationCompatBlocks.getValveBlock(this);
    }

    public IBlockProvider getControllerBlock() {
        if (compactOnly) {
            return MoreThermalEvaporationBlocks.getController(mteTier);
        }
        return MoreThermalEvaporationCompatBlocks.getControllerBlock(this);
    }

    public IBlockProvider getCompactBlock() {
        return MoreThermalEvaporationCompatBlocks.getCompactBlock(this);
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

    public BlockType getCompactBlockType() {
        return MoreThermalEvaporationCompatBlockTypes.getCompactBlockType(this);
    }

    public MultiblockManager<TieredThermalEvaporationMultiblockData> getManager() {
        return manager;
    }

    public String getSimpleName() {
        return name;
    }

    public MapColor getMapColor() {
        return mapColor;
    }

    public boolean isModLoaded() {
        return modLoaded;
    }

    @Override
    public int[] getRgbCode() {
        return rgbCode;
    }

    @Override
    public void setColorFromAtlas(int[] color) {
        this.rgbCode = color;
        this.textColor = TextColor.fromRgb(rgbCode[0] << 16 | rgbCode[1] << 8 | rgbCode[2]);
    }

    public TextColor getColor() {
        return textColor;
    }

    public boolean isCompactOnly() {
        return compactOnly;
    }
}
