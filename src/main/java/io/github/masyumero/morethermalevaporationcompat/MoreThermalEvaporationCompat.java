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
            BuildCommand.register("absolute_evaporation", MoreThermalEvaporationCompatLang.ABSOLUTE_EVAPORATION, new Builders.EvaporationBuilder(TETier.ABSOLUTE));
            BuildCommand.register("supreme_evaporation", MoreThermalEvaporationCompatLang.SUPREME_EVAPORATION, new Builders.EvaporationBuilder(TETier.SUPREME));
            BuildCommand.register("cosmic_evaporation", MoreThermalEvaporationCompatLang.COSMIC_EVAPORATION, new Builders.EvaporationBuilder(TETier.COSMIC));
            BuildCommand.register("infinite_evaporation", MoreThermalEvaporationCompatLang.INFINITE_EVAPORATION, new Builders.EvaporationBuilder(TETier.INFINITE));
        }
        if (EvolvedModule.EvolvedLoaded) {
            BuildCommand.register("overclocked_evaporation", MoreThermalEvaporationCompatLang.OVERCLOCKED_EVAPORATION, new Builders.EvaporationBuilder(TETier.OVERCLOCKED));
            BuildCommand.register("quantum_evaporation", MoreThermalEvaporationCompatLang.QUANTUM_EVAPORATION, new Builders.EvaporationBuilder(TETier.QUANTUM));
            BuildCommand.register("dense_evaporation", MoreThermalEvaporationCompatLang.DENSE_EVAPORATION, new Builders.EvaporationBuilder(TETier.DENSE));
            BuildCommand.register("multiversal_evaporation", MoreThermalEvaporationCompatLang.MULTIVERSAL_EVAPORATION, new Builders.EvaporationBuilder(TETier.MULTIVERSAL));
        }
        event.getDispatcher().register(CommandMek.register());
    }
}
