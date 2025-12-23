package io.github.masyumero.morethermalevaporationcompat.common.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import mekanism.common.config.IMekanismConfig;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.config.ConfigFileTypeHandler;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;
import java.util.function.Function;

public class MTECompatModConfig extends ModConfig {

    private static final MTECompatConfigFileTypeHandler MTECompat_TOML = new MTECompatConfigFileTypeHandler();

    private final IMekanismConfig mekanismMTECompatConfig;

    public MTECompatModConfig(ModContainer container, IMekanismConfig config) {
        super(config.getConfigType(), config.getConfigSpec(), container, MoreThermalEvaporationCompat.MOD_NAME + "/" + config.getFileName() + ".toml");
        this.mekanismMTECompatConfig = config;
    }

    @Override
    public ConfigFileTypeHandler getHandler() {
        return MTECompat_TOML;
    }

    public void clearCache(ModConfigEvent event) {
        mekanismMTECompatConfig.clearCache(event instanceof ModConfigEvent.Unloading);
    }

    private static class MTECompatConfigFileTypeHandler extends ConfigFileTypeHandler {

        private static Path getPath(Path configBasePath) {
            //Intercept server config path reading for Mekanism configs and reroute it to the normal config directory
            if (configBasePath.endsWith("serverconfig")) {
                return FMLPaths.CONFIGDIR.get();
            }
            return configBasePath;
        }

        @Override
        public Function<ModConfig, CommentedFileConfig> reader(Path configBasePath) {
            return super.reader(getPath(configBasePath));
        }

        @Override
        public void unload(Path configBasePath, ModConfig config) {
            super.unload(getPath(configBasePath), config);
        }
    }
}
