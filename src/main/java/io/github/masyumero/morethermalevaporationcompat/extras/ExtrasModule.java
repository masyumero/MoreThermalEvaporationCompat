package io.github.masyumero.morethermalevaporationcompat.extras;

import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatContainerTypes;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatCreativeTabs;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatTileEntityTypes;
import net.minecraftforge.eventbus.api.IEventBus;

public class ExtrasModule {

    public static void init(IEventBus modEventBus) {
        MoreThermalEvaporationCompatBlocks.BLOCKS.register(modEventBus);
        MoreThermalEvaporationCompatTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        MoreThermalEvaporationCompatContainerTypes.CONTAINER_TYPES.register(modEventBus);
        MoreThermalEvaporationCompatCreativeTabs.register(modEventBus);
    }
}
