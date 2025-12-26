package io.github.masyumero.morethermalevaporationcompat.datagen.common.registries;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class MTECompatDatapackRegistryProvider extends BaseDatapackRegistryProvider {

    public MTECompatDatapackRegistryProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, MoreThermalEvaporationCompat.MODID);
    }

    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder();
}
