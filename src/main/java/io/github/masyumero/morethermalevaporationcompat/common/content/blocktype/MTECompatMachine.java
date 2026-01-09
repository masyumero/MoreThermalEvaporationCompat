package io.github.masyumero.morethermalevaporationcompat.common.content.blocktype;

import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.api.text.ILangEntry;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.base.TileEntityMekanism;

import java.util.function.Supplier;

public class MTECompatMachine<TILE extends TileEntityMekanism> extends MTECompatBlockTypeTile<TILE>  {

    public MTECompatMachine(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description, TETier tier) {
        super(tileEntityRegistrar, description, tier);
    }

    public static class MTECompatMachineBuilder<MACHINE extends MTECompatMachine<TILE>, TILE extends TileEntityMekanism, T extends MTECompatMachine.MTECompatMachineBuilder<MACHINE, TILE, T>> extends MTECompatBlockTypeTile.MTECompatBlockTileBuilder<MACHINE, TILE, T> {

        protected MTECompatMachineBuilder(MACHINE holder) {
            super(holder);
        }

        public static <TILE extends TileEntityMekanism> MTECompatMachine.MTECompatMachineBuilder<MTECompatMachine<TILE>, TILE, ?> createMachine(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description, TETier tier) {
            return new MTECompatMachine.MTECompatMachineBuilder<>(new MTECompatMachine<>(tileEntityRegistrar, description, tier));
        }
    }
}
