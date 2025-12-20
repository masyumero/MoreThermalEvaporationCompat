package io.github.masyumero.morethermalevaporationcompat;

import com.mojang.logging.LogUtils;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatCreativeTabs;
import io.github.masyumero.morethermalevaporationcompat.evolved.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.extras.ExtrasModule;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoreThermalEvaporationCompat.MODID)
public class MoreThermalEvaporationCompat {

    public static final String MODID = "morethermalevaporationcompat";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static boolean ExtrasLoaded = ModList.get().isLoaded("mekanism_extras");
    public static boolean EvolvedLoaded = ModList.get().isLoaded("evolvedmekanism");

    @SuppressWarnings("removal")
    public static ResourceLocation rl(String id) {
        return new ResourceLocation(MODID, id);
    }

    @SuppressWarnings("removal")
    public MoreThermalEvaporationCompat() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        if (ExtrasLoaded) {
            ExtrasModule.init(modEventBus);
        }
        if (EvolvedLoaded) {
            EvolvedModule.init(modEventBus);
        }
        MoreThermalEvaporationCompatCreativeTabs.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
