package io.github.masyumero.morethermalevaporationcompat.datagen.common.loot.table;

import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;

public class MTECompatBlockLootProvider extends BaseBlockLootTables {

    @Override
    protected void generate() {
        dropSelfWithContents(MoreThermalEvaporationCompatBlocks.BLOCKS.getAllBlocks());
    }
}
