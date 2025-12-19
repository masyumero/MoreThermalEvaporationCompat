package io.github.masyumero.morethermalevaporationcompat;

import com.mojang.logging.LogUtils;
import io.github.masyumero.morethermalevaporationcompat.extras.ExtrasModule;
import io.github.masyumero.morethermalevaporationcompat.extras.common.content.evaporation.*;
import mekanism.common.lib.multiblock.MultiblockCache;
import mekanism.common.lib.multiblock.MultiblockManager;
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

    public static final MultiblockManager<AbsoluteThermalEvaporationMultiblockData> AbsoluteThermalEvaporationManager = new MultiblockManager<>("AbsoluteThermalEvaporation", MultiblockCache::new, AbsoluteThermalEvaporationValidator::new);
    public static final MultiblockManager<SupremeThermalEvaporationMultiblockData> SupremeThermalEvaporationManager = new MultiblockManager<>("SupremeThermalEvaporation", MultiblockCache::new, SupremeThermalEvaporationValidator::new);
    public static final MultiblockManager<CosmicThermalEvaporationMultiblockData> CosmicThermalEvaporationManager = new MultiblockManager<>("CosmicThermalEvaporation", MultiblockCache::new, CosmicThermalEvaporationValidator::new);
    public static final MultiblockManager<InfiniteThermalEvaporationMultiblockData> InfiniteThermalEvaporationManager = new MultiblockManager<>("InfiniteThermalEvaporation", MultiblockCache::new, InfiniteThermalEvaporationValidator::new);

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
        MinecraftForge.EVENT_BUS.register(this);
    }
}
