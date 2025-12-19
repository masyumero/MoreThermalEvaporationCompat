package io.github.masyumero.morethermalevaporationcompat.datagen.common.loot;

import io.github.masyumero.morethermalevaporationcompat.datagen.common.loot.table.MTECompatBlockLootProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;

public class MTECompatLootProvider extends BaseLootProvider {

    public MTECompatLootProvider(PackOutput output) {
        super(output, List.of(
                new SubProviderEntry(MTECompatBlockLootProvider::new, LootContextParamSets.BLOCK)
        ));
    }
}
