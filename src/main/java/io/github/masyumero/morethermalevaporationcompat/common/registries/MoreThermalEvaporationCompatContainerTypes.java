package io.github.masyumero.morethermalevaporationcompat.common.registries;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.tile.multiblock.TileEntityTieredThermalEvaporationController;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.registration.impl.ContainerTypeDeferredRegister;
import mekanism.common.registration.impl.ContainerTypeRegistryObject;

public class MoreThermalEvaporationCompatContainerTypes {
    public static final ContainerTypeDeferredRegister EVOLVED_CONTAINER_TYPES = new ContainerTypeDeferredRegister(MoreThermalEvaporationCompat.MODID);
    public static final ContainerTypeDeferredRegister EXTRAS_CONTAINER_TYPES = new ContainerTypeDeferredRegister(MoreThermalEvaporationCompat.MODID);

    // Overclocked
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityTieredThermalEvaporationController>> OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER = EVOLVED_CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER, TileEntityTieredThermalEvaporationController.class);

    // Quantum
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityTieredThermalEvaporationController>> QUANTUM_THERMAL_EVAPORATION_CONTROLLER = EVOLVED_CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_CONTROLLER, TileEntityTieredThermalEvaporationController.class);

    // Dense
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityTieredThermalEvaporationController>> DENSE_THERMAL_EVAPORATION_CONTROLLER = EVOLVED_CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_CONTROLLER, TileEntityTieredThermalEvaporationController.class);

    // Multiversal
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityTieredThermalEvaporationController>> MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER = EVOLVED_CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER, TileEntityTieredThermalEvaporationController.class);

    // Absolute
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityTieredThermalEvaporationController>> ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER = EXTRAS_CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, TileEntityTieredThermalEvaporationController.class);

    // Supreme
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityTieredThermalEvaporationController>> SUPREME_THERMAL_EVAPORATION_CONTROLLER = EXTRAS_CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_CONTROLLER, TileEntityTieredThermalEvaporationController.class);

    // Cosmic
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityTieredThermalEvaporationController>> COSMIC_THERMAL_EVAPORATION_CONTROLLER = EXTRAS_CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_CONTROLLER, TileEntityTieredThermalEvaporationController.class);

    // Infinite
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityTieredThermalEvaporationController>> INFINITE_THERMAL_EVAPORATION_CONTROLLER = EXTRAS_CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_CONTROLLER, TileEntityTieredThermalEvaporationController.class);

    private MoreThermalEvaporationCompatContainerTypes() {

    }
}
