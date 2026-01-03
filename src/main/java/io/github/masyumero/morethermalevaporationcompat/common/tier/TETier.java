package io.github.masyumero.morethermalevaporationcompat.common.tier;

import com.jerry.mekanism_extras.api.tier.AdvancedTier;
import fr.iglee42.evolvedmekanism.tiers.EMBaseTier;
import io.github.masyumero.emextras.api.tier.EMExtraTier;
import io.github.masyumero.morethermalevaporationcompat.AstralModule;
import io.github.masyumero.morethermalevaporationcompat.EMExtrasModule;
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
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

public enum TETier implements ITier {
    ABSOLUTE("Absolute", AdvancedTier.ABSOLUTE.getColor(), MapColor.COLOR_YELLOW, ExtrasModule.ExtrasLoaded, ExtrasModule.AbsoluteThermalEvaporationManager),
    SUPREME("Supreme", AdvancedTier.SUPREME.getColor(), MapColor.COLOR_RED, ExtrasModule.ExtrasLoaded, ExtrasModule.SupremeThermalEvaporationManager),
    COSMIC("Cosmic", AdvancedTier.COSMIC.getColor(), MapColor.COLOR_PINK, ExtrasModule.ExtrasLoaded, ExtrasModule.CosmicThermalEvaporationManager),
    INFINITE("Infinite", AdvancedTier.INFINITE.getColor(), MapColor.COLOR_BLUE, ExtrasModule.ExtrasLoaded, ExtrasModule.InfiniteThermalEvaporationManager),
    OVERCLOCKED("Overclocked", EMBaseTier.OVERCLOCKED.getColor(), MapColor.COLOR_GREEN, EvolvedModule.EvolvedLoaded, EvolvedModule.OverclockedThermalEvaporationManager),
    QUANTUM("Quantum", EMBaseTier.QUANTUM.getColor(), MapColor.COLOR_PURPLE, EvolvedModule.EvolvedLoaded, EvolvedModule.QuantumThermalEvaporationManager),
    DENSE("Dense", EMBaseTier.DENSE.getColor(), MapColor.TERRACOTTA_YELLOW, EvolvedModule.EvolvedLoaded, EvolvedModule.DenseThermalEvaporationManager),
    MULTIVERSAL("Multiversal", EMBaseTier.MULTIVERSAL.getColor(), MapColor.COLOR_BLACK, EvolvedModule.EvolvedLoaded, EvolvedModule.MultiversalThermalEvaporationManager),
    VIBRATION("Vibration", ChatFormatting.YELLOW, MapColor.TERRACOTTA_PURPLE , AstralModule.AstralLoaded, AstralModule.VibrationThermalEvaporationManager),
    RESONANCE("Resonance", ChatFormatting.AQUA, MapColor.COLOR_PURPLE , AstralModule.AstralLoaded, AstralModule.ResonanceThermalEvaporationManager),
    ILLUSION("Illusion", ChatFormatting.LIGHT_PURPLE, MapColor.COLOR_YELLOW , AstralModule.AstralLoaded, AstralModule.IllusionThermalEvaporationManager),
    ABSOLUTE_OVERCLOCKED("Absolute_Overclocked", EMExtraTier.ABSOLUTE_OVERCLOCKED.getColor(), MapColor.COLOR_LIGHT_GREEN, EMExtrasModule.EMExtraLoaded, EMExtrasModule.AbsoluteOverclockedThermalEvaporationManager),
    SUPREME_QUANTUM("Supreme_Quantum", EMExtraTier.SUPREME_QUANTUM.getColor(), MapColor.TERRACOTTA_PINK, EMExtrasModule.EMExtraLoaded, EMExtrasModule.SupremeQuantumThermalEvaporationManager),
    COSMIC_DENSE("Cosmic_Dense", EMExtraTier.COSMIC_DENSE.getColor(), MapColor.DIAMOND, EMExtrasModule.EMExtraLoaded, EMExtrasModule.CosmicDenseThermalEvaporationManager),
    INFINITE_MULTIVERSAL("Infinite_Multiversal", EMExtraTier.INFINITE_MULTIVERSAL.getColor(), MapColor.COLOR_MAGENTA, EMExtrasModule.EMExtraLoaded, EMExtrasModule.InfiniteMultiversalThermalEvaporationManager),
    ;

    private final String name;
    private final TextColor textColor;
    private final MapColor mapColor;
    private final boolean modLoaded;
    private final MultiblockManager<TieredThermalEvaporationMultiblockData> manager;

    TETier(String name, TextColor textColor, MapColor mapColor, boolean modLoaded, MultiblockManager<TieredThermalEvaporationMultiblockData> manager) {
        this.name = name;
        this.textColor = textColor;
        this.mapColor = mapColor;
        this.modLoaded = modLoaded;
        this.manager = manager;
    }

    TETier(String name, ChatFormatting color, MapColor mapColor, boolean modLoaded, MultiblockManager<TieredThermalEvaporationMultiblockData> manager) {
        this(name, TextColor.fromRgb(color.getColor()), mapColor, modLoaded, manager);
    }

    public int getHeight() {
        return LoadConfig.MTE_COMPAT_CONFIG.getHeight(this);
    }

    public int getOutputTankCapacity() {
        return LoadConfig.MTE_COMPAT_CONFIG.getTankCapacity(this);
    }

    @Override
    public TextColor getColor() {
        return textColor;
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

    @Override
    public String getSimpleName() {
        return name;
    }

    public MapColor getMapColor() {
        return mapColor;
    }

    public boolean isModLoaded() {
        return modLoaded;
    }
}
