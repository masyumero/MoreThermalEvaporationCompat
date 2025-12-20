package io.github.masyumero.morethermalevaporationcompat.evolved.common.registries;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock.TileEntityOverclockedThermalEvaporationController;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock.TileEntityDenseThermalEvaporationController;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock.TileEntityMultiversalThermalEvaporationController;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock.TileEntityQuantumThermalEvaporationController;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.registration.impl.ContainerTypeDeferredRegister;
import mekanism.common.registration.impl.ContainerTypeRegistryObject;

public class MoreThermalEvaporationCompatContainerTypes {
    public static final ContainerTypeDeferredRegister CONTAINER_TYPES = new ContainerTypeDeferredRegister(MoreThermalEvaporationCompat.MODID);

    // Overclocked
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityOverclockedThermalEvaporationController>> OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER = CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER, TileEntityOverclockedThermalEvaporationController.class);

    // Quantum
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityQuantumThermalEvaporationController>> QUANTUM_THERMAL_EVAPORATION_CONTROLLER = CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_CONTROLLER, TileEntityQuantumThermalEvaporationController.class);

    // Dense
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityDenseThermalEvaporationController>> DENSE_THERMAL_EVAPORATION_CONTROLLER = CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_CONTROLLER, TileEntityDenseThermalEvaporationController.class);

    // Multiversal
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityMultiversalThermalEvaporationController>> MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER = CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER, TileEntityMultiversalThermalEvaporationController.class);

    private MoreThermalEvaporationCompatContainerTypes() {

    }
}
