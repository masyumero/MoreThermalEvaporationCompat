package io.github.masyumero.morethermalevaporationcompat.datagen.common.loot.table;

import io.github.masyumero.morethermalevaporationcompat.evolved.common.registries.MoreThermalEvaporationCompatBlocks;

import static io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatBlocks.BLOCKS;

public class MTECompatBlockLootProvider extends BaseBlockLootTables {

    @Override
    protected void generate() {
        dropSelfWithContents(BLOCKS.getAllBlocks());
        dropSelfWithContents(MoreThermalEvaporationCompatBlocks.BLOCKS.getAllBlocks());
    }
}
