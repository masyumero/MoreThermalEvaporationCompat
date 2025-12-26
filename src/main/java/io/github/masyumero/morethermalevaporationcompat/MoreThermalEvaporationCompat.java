package io.github.masyumero.morethermalevaporationcompat;

import com.mojang.logging.LogUtils;
import io.github.masyumero.morethermalevaporationcompat.common.command.builders.Builders;
import io.github.masyumero.morethermalevaporationcompat.common.config.LoadConfig;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatCreativeTabs;
import io.github.masyumero.morethermalevaporationcompat.evolved.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.extras.ExtrasModule;
import mekanism.common.command.CommandMek;
import mekanism.common.command.builders.BuildCommand;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
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
        if (ExtrasModule.ExtrasLoaded) {
            ExtrasModule.init(modEventBus);
        }
        if (EvolvedModule.EvolvedLoaded) {
            EvolvedModule.init(modEventBus);
        }
        MoreThermalEvaporationCompatCreativeTabs.register(modEventBus);
        MinecraftForge.EVENT_BUS.addListener(this::registerCommands);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void registerCommands(RegisterCommandsEvent event) {
        if (ModList.get().isLoaded("mekanism_extras")) {
            BuildCommand.register("absolute_evaporation", MoreThermalEvaporationCompatLang.ABSOLUTEEVAPORATION, new Builders.AbsoluteEvaporationBuilder());
        }
        event.getDispatcher().register(CommandMek.register());
    }
}
