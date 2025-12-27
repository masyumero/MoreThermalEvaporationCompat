package io.github.masyumero.morethermalevaporationcompat.common.content.blocktype;

import io.github.masyumero.morethermalevaporationcompat.common.block.attribute.MTECompatAttributeTier;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.api.text.ILangEntry;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.base.TileEntityMekanism;

import java.util.function.Supplier;

public class MTECompatBlockTypeTile<TILE extends TileEntityMekanism> extends BlockTypeTile<TILE> {

    public MTECompatBlockTypeTile(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description, TETier tier) {
        super(tileEntityRegistrar, description);
        add(new MTECompatAttributeTier<>(tier));
    }

    public static class MTECompatBlockTileBuilder<BLOCK extends MTECompatBlockTypeTile<TILE>, TILE extends TileEntityMekanism, T extends MTECompatBlockTileBuilder<BLOCK, TILE, T>>
            extends BlockTileBuilder<BLOCK, TILE, T> {

        protected MTECompatBlockTileBuilder(BLOCK holder) {
            super(holder);
        }

        public static <TILE extends TileEntityMekanism> MTECompatBlockTileBuilder<MTECompatBlockTypeTile<TILE>, TILE, ?> createBlock(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description, TETier tier) {
            return new MTECompatBlockTileBuilder<>(new MTECompatBlockTypeTile<>(tileEntityRegistrar, description, tier));
        }
    }
}