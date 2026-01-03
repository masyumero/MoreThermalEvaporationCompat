package io.github.masyumero.morethermalevaporationcompat.common.tier;

import io.github.masyumero.morethermalevaporationcompat.AstralModule;
import io.github.masyumero.morethermalevaporationcompat.EMExtrasModule;
import io.github.masyumero.morethermalevaporationcompat.common.config.LoadConfig;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatMultiPartType;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlockTypes;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.ExtrasModule;
import mekanism.api.SupportsColorMap;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.content.blocktype.BlockType;
import mekanism.common.lib.multiblock.MultiblockManager;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

public enum TETier implements SupportsColorMap {
    ABSOLUTE("Absolute", new int[]{95, 255, 184}, MapColor.COLOR_YELLOW, ExtrasModule.ExtrasLoaded, ExtrasModule.AbsoluteThermalEvaporationManager),
    SUPREME("Supreme", new int[]{255, 128, 106}, MapColor.COLOR_RED, ExtrasModule.ExtrasLoaded, ExtrasModule.SupremeThermalEvaporationManager),
    COSMIC("Cosmic", new int[]{75, 248, 255}, MapColor.COLOR_PINK, ExtrasModule.ExtrasLoaded, ExtrasModule.CosmicThermalEvaporationManager),
    INFINITE("Infinite", new int[]{247, 135, 255}, MapColor.COLOR_BLUE, ExtrasModule.ExtrasLoaded, ExtrasModule.InfiniteThermalEvaporationManager),
    OVERCLOCKED("Overclocked", new int[]{0, 221, 0}, MapColor.COLOR_LIGHT_GREEN, EvolvedModule.EvolvedLoaded, EvolvedModule.OverclockedThermalEvaporationManager),
    QUANTUM("Quantum", new int[]{252, 158, 250}, MapColor.COLOR_PURPLE, EvolvedModule.EvolvedLoaded, EvolvedModule.QuantumThermalEvaporationManager),
    DENSE("Dense", new int[]{253, 245, 95}, MapColor.GOLD, EvolvedModule.EvolvedLoaded, EvolvedModule.DenseThermalEvaporationManager),
    MULTIVERSAL("Multiversal", new int[]{90, 87, 90}, MapColor.COLOR_BLACK, EvolvedModule.EvolvedLoaded, EvolvedModule.MultiversalThermalEvaporationManager),
    VIBRATION("Vibration", new int[]{255, 255, 85}, MapColor.TERRACOTTA_PURPLE , AstralModule.AstralLoaded, AstralModule.VibrationThermalEvaporationManager),
    RESONANCE("Resonance", new int[]{85, 255, 255}, MapColor.COLOR_PURPLE , AstralModule.AstralLoaded, AstralModule.ResonanceThermalEvaporationManager),
    ILLUSION("Illusion", new int[]{255, 85, 255}, MapColor.COLOR_YELLOW , AstralModule.AstralLoaded, AstralModule.IllusionThermalEvaporationManager),
    ABSOLUTE_OVERCLOCKED("Absolute_Overclocked", new int[]{95, 255, 184}, MapColor.COLOR_LIGHT_GREEN, EMExtrasModule.EMExtraLoaded, EMExtrasModule.AbsoluteOverclockedThermalEvaporationManager),
    SUPREME_QUANTUM("Supreme_Quantum", new int[]{255, 128, 106}, MapColor.TERRACOTTA_PINK, EMExtrasModule.EMExtraLoaded, EMExtrasModule.SupremeQuantumThermalEvaporationManager),
    COSMIC_DENSE("Cosmic_Dense", new int[]{75, 248, 255}, MapColor.DIAMOND, EMExtrasModule.EMExtraLoaded, EMExtrasModule.CosmicDenseThermalEvaporationManager),
    INFINITE_MULTIVERSAL("Infinite_Multiversal", new int[]{247, 135, 255}, MapColor.COLOR_MAGENTA, EMExtrasModule.EMExtraLoaded, EMExtrasModule.InfiniteMultiversalThermalEvaporationManager),
    ;

    private final String name;
    private TextColor textColor;
    private final MapColor mapColor;
    private final boolean modLoaded;
    private int[] rgbCode;
    private final MultiblockManager<TieredThermalEvaporationMultiblockData> manager;

    TETier(String name, int[] rgbCode, MapColor mapColor, boolean modLoaded, MultiblockManager<TieredThermalEvaporationMultiblockData> manager) {
        this.name = name;
        this.mapColor = mapColor;
        this.modLoaded = modLoaded;
        this.manager = manager;
        setColorFromAtlas(rgbCode);
    }

    public int getHeight() {
        return LoadConfig.MTE_COMPAT_CONFIG.getHeight(this);
    }

    public int getOutputTankCapacity() {
        return LoadConfig.MTE_COMPAT_CONFIG.getTankCapacity(this);
    }

    public String getLowerName() {
        return this.getSimpleName().toLowerCase(Locale.ROOT);
    }

    public double getMaxMultiplierTemp() {
        return switch (this.getSimpleName()) {
            case "Absolute", "Overclocked" -> 96_000; //32
            case "Supreme", "Quantum" -> 192_000; //64
            case "Cosmic", "Dense" -> 384_000; //128
            case "Infinite", "Multiversal" -> 768_000; //256
            case "Vibration" -> 72_000; //24
            case "Resonance" -> 144_000; //48
            case "Illusion" -> 1_536_000; //512
            case "Absolute_Overclocked" -> 144_000; //48
            case "Supreme_Quantum" -> 288_000; //96
            case "Cosmic_Dense" -> 576_000; //192
            case "Infinite_Multiversal" -> 1_152_000; //384
            default -> throw new IllegalStateException("Unexpected value: " + this.getSimpleName());
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
}
