package io.github.masyumero.morethermalevaporationcompat.datagen.common.tag;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import mekanism.api.providers.IBlockProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MTECompatTagProvider extends BaseTagProvider {

    public MTECompatTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MoreThermalEvaporationCompat.MODID, existingFileHelper);
    }

    @Override
    protected List<IBlockProvider> getAllBlocks() {
        List<IBlockProvider> allBlocks = new ArrayList<>();
        allBlocks.addAll(MoreThermalEvaporationCompatBlocks.EVOLVED_BLOCKS.getAllBlocks());
        allBlocks.addAll(MoreThermalEvaporationCompatBlocks.EXTRAS_BLOCKS.getAllBlocks());
        return allBlocks;
    }

    @Override
    protected void registerTags(HolderLookup.Provider registries) {
        for (IBlockProvider block : getAllBlocks()) {
            addToHarvestTag(BlockTags.MINEABLE_WITH_PICKAXE, block);
        }
    }
}
