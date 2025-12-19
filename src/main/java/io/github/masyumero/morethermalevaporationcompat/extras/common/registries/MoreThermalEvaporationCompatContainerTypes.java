package io.github.masyumero.morethermalevaporationcompat.extras.common.registries;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.extras.common.tile.multiblock.*;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.registration.impl.ContainerTypeDeferredRegister;
import mekanism.common.registration.impl.ContainerTypeRegistryObject;

public class MoreThermalEvaporationCompatContainerTypes {
    public static final ContainerTypeDeferredRegister CONTAINER_TYPES = new ContainerTypeDeferredRegister(MoreThermalEvaporationCompat.MODID);

    // Absolute
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityAbsoluteThermalEvaporationController>> ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER = CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, TileEntityAbsoluteThermalEvaporationController.class);

    // Supreme
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntitySupremeThermalEvaporationController>> SUPREME_THERMAL_EVAPORATION_CONTROLLER = CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_CONTROLLER, TileEntitySupremeThermalEvaporationController.class);

    // Cosmic
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityCosmicThermalEvaporationController>> COSMIC_THERMAL_EVAPORATION_CONTROLLER = CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_CONTROLLER, TileEntityCosmicThermalEvaporationController.class);

    // Infinite
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityInfiniteThermalEvaporationController>> INFINITE_THERMAL_EVAPORATION_CONTROLLER = CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_CONTROLLER, TileEntityInfiniteThermalEvaporationController.class);

    private MoreThermalEvaporationCompatContainerTypes() {

    }
}
