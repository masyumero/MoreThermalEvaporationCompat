package io.github.masyumero.morethermalevaporationcompat;

import com.mojang.logging.LogUtils;
import io.github.masyumero.morethermalevaporationcompat.common.command.builders.Builders;
import io.github.masyumero.morethermalevaporationcompat.common.config.LoadConfig;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatContainerTypes;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatCreativeTabs;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatTileEntityTypes;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.common.command.CommandMek;
import mekanism.common.command.builders.BuildCommand;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoreThermalEvaporationCompat.MODID)
public class MoreThermalEvaporationCompat {

    public static final String MODID = "morethermalevaporationcompat";
    public static final String MOD_NAME = "MoreThermalEvaporationCompat";
    public static final Logger LOGGER = LogUtils.getLogger();

    @SuppressWarnings("removal")
    public static ResourceLocation rl(String id) {
        return new ResourceLocation(MODID, id);
    }

    @SuppressWarnings("removal")
    public MoreThermalEvaporationCompat() {
        LoadConfig.registerConfig(ModLoadingContext.get());
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MoreThermalEvaporationCompatBlocks.BLOCKS.register(modEventBus);
        MoreThermalEvaporationCompatTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        MoreThermalEvaporationCompatContainerTypes.CONTAINER_TYPES.register(modEventBus);
        MoreThermalEvaporationCompatCreativeTabs.register(modEventBus);
        MinecraftForge.EVENT_BUS.addListener(this::registerCommands);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void registerCommands(RegisterCommandsEvent event) {
        if (ExtrasModule.ExtrasLoaded) {
            BuildCommand.register("evaporation_absolute", MTECompatLang.ABSOLUTE_EVAPORATION, new Builders.EvaporationBuilder(TETier.ABSOLUTE));
            BuildCommand.register("evaporation_supreme", MTECompatLang.SUPREME_EVAPORATION, new Builders.EvaporationBuilder(TETier.SUPREME));
            BuildCommand.register("evaporation_cosmic", MTECompatLang.COSMIC_EVAPORATION, new Builders.EvaporationBuilder(TETier.COSMIC));
            BuildCommand.register("evaporation_infinite", MTECompatLang.INFINITE_EVAPORATION, new Builders.EvaporationBuilder(TETier.INFINITE));
        }
        if (EvolvedModule.EvolvedLoaded) {
            BuildCommand.register("evaporation_overclocked", MTECompatLang.OVERCLOCKED_EVAPORATION, new Builders.EvaporationBuilder(TETier.OVERCLOCKED));
            BuildCommand.register("evaporation_quantum", MTECompatLang.QUANTUM_EVAPORATION, new Builders.EvaporationBuilder(TETier.QUANTUM));
            BuildCommand.register("evaporation_dense", MTECompatLang.DENSE_EVAPORATION, new Builders.EvaporationBuilder(TETier.DENSE));
            BuildCommand.register("evaporation_multiversal", MTECompatLang.MULTIVERSAL_EVAPORATION, new Builders.EvaporationBuilder(TETier.MULTIVERSAL));
        }
        if (AstralModule.AstralLoaded) {
            BuildCommand.register("evaporation_vibration", MTECompatLang.VIBRATION_EVAPORATION, new Builders.EvaporationBuilder(TETier.VIBRATION));
            BuildCommand.register("evaporation_resonance", MTECompatLang.RESONANCE_EVAPORATION, new Builders.EvaporationBuilder(TETier.RESONANCE));
            BuildCommand.register("evaporation_illusion", MTECompatLang.ILLUSION_EVAPORATION, new Builders.EvaporationBuilder(TETier.ILLUSION));
        }
        if (EMExtrasModule.EMExtraLoaded) {
            BuildCommand.register("evaporation_absolute_overclocked", MTECompatLang.ABSOLUTE_OVERCLOCKED_EVAPORATION, new Builders.EvaporationBuilder(TETier.ABSOLUTE_OVERCLOCKED));
            BuildCommand.register("evaporation_supreme_quantum", MTECompatLang.SUPREME_QUANTUM_EVAPORATION, new Builders.EvaporationBuilder(TETier.SUPREME_QUANTUM));
            BuildCommand.register("evaporation_cosmic_dense", MTECompatLang.COSMIC_DENSE_EVAPORATION, new Builders.EvaporationBuilder(TETier.COSMIC_DENSE));
            BuildCommand.register("evaporation_infinite_multiversal", MTECompatLang.INFINITE_MULTIVERSAL_EVAPORATION, new Builders.EvaporationBuilder(TETier.INFINITE_MULTIVERSAL));
        }
        event.getDispatcher().register(CommandMek.register());
    }
}
