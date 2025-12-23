package io.github.masyumero.morethermalevaporationcompat.common.config;

import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;

public class LoadConfig {
    private LoadConfig() {
    }

    public static final MTECompatConfig MTE_COMPAT_CONFIG = new MTECompatConfig();

    @SuppressWarnings("removal")
    public static void registerConfig(ModLoadingContext modLoadingContext) {
        ModContainer modContainer = modLoadingContext.getActiveContainer();
        MTECompatConfigHelper.registerConfig(modContainer, MTE_COMPAT_CONFIG);
    }
}
