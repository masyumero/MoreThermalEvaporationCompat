package io.github.masyumero.morethermalevaporationcompat.common.config;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import mekanism.common.config.IMekanismConfig;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class MTECompatConfigHelper {
    private MTECompatConfigHelper() {
    }

    public static final Path CONFIG_DIR = FMLPaths.getOrCreateGameRelativePath(FMLPaths.CONFIGDIR.get().resolve(MoreThermalEvaporationCompat.MOD_NAME));

    public static void registerConfig(ModContainer modContainer, IMekanismConfig config) {
        MTECompatModConfig modConfig = new MTECompatModConfig(modContainer, config);
        if (config.addToContainer()) {
            modContainer.addConfig(modConfig);
        }
    }
}
