package io.github.masyumero.morethermalevaporationcompat.common.registries;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.tile.multiblock.*;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.base.TileEntityMekanism;

public class MoreThermalEvaporationCompatTileEntityTypes {
    public static final TileEntityTypeDeferredRegister EVOLVED_TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(MoreThermalEvaporationCompat.MODID);
    public static final TileEntityTypeDeferredRegister EXTRAS_TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(MoreThermalEvaporationCompat.MODID);

    // Overclocked
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationBlock> OVERCLOCKED_THERMAL_EVAPORATION_BLOCK = EVOLVED_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_BLOCK, (pos, state) -> new TileEntityTieredThermalEvaporationBlock(pos, state, TETier.OVERCLOCKED), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationValve> OVERCLOCKED_THERMAL_EVAPORATION_VALVE = EVOLVED_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_VALVE, (pos, state) -> new TileEntityTieredThermalEvaporationValve(pos, state, TETier.OVERCLOCKED), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationController> OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER = EVOLVED_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER, (pos, state) -> new TileEntityTieredThermalEvaporationController(pos, state, TETier.OVERCLOCKED), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);

    // Quantum
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationBlock> QUANTUM_THERMAL_EVAPORATION_BLOCK = EVOLVED_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_BLOCK, (pos, state) -> new TileEntityTieredThermalEvaporationBlock(pos, state, TETier.QUANTUM), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationValve> QUANTUM_THERMAL_EVAPORATION_VALVE = EVOLVED_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_VALVE, (pos, state) -> new TileEntityTieredThermalEvaporationValve(pos, state, TETier.QUANTUM), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationController> QUANTUM_THERMAL_EVAPORATION_CONTROLLER = EVOLVED_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_CONTROLLER, (pos, state) -> new TileEntityTieredThermalEvaporationController(pos, state, TETier.QUANTUM), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);

    // Dense
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationBlock> DENSE_THERMAL_EVAPORATION_BLOCK = EVOLVED_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_BLOCK, (pos, state) -> new TileEntityTieredThermalEvaporationBlock(pos, state, TETier.DENSE), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationValve> DENSE_THERMAL_EVAPORATION_VALVE = EVOLVED_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_VALVE, (pos, state) -> new TileEntityTieredThermalEvaporationValve(pos, state, TETier.DENSE), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationController> DENSE_THERMAL_EVAPORATION_CONTROLLER = EVOLVED_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_CONTROLLER, (pos, state) -> new TileEntityTieredThermalEvaporationController(pos, state, TETier.DENSE), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);

    // Multiversal
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationBlock> MULTIVERSAL_THERMAL_EVAPORATION_BLOCK = EVOLVED_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_BLOCK, (pos, state) -> new TileEntityTieredThermalEvaporationBlock(pos, state, TETier.MULTIVERSAL), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationValve> MULTIVERSAL_THERMAL_EVAPORATION_VALVE = EVOLVED_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_VALVE, (pos, state) -> new TileEntityTieredThermalEvaporationValve(pos, state, TETier.MULTIVERSAL), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationController> MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER = EVOLVED_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER, (pos, state) -> new TileEntityTieredThermalEvaporationController(pos, state, TETier.MULTIVERSAL), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);

    // Absolute
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationBlock> ABSOLUTE_THERMAL_EVAPORATION_BLOCK = EXTRAS_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_BLOCK, (pos, state) -> new TileEntityTieredThermalEvaporationBlock(pos, state, TETier.ABSOLUTE), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationValve> ABSOLUTE_THERMAL_EVAPORATION_VALVE = EXTRAS_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_VALVE, (pos, state) -> new TileEntityTieredThermalEvaporationValve(pos, state, TETier.ABSOLUTE), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationController> ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER = EXTRAS_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, (pos, state) -> new TileEntityTieredThermalEvaporationController(pos, state, TETier.ABSOLUTE), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);

    // Supreme
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationBlock> SUPREME_THERMAL_EVAPORATION_BLOCK = EXTRAS_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_BLOCK, (pos, state) -> new TileEntityTieredThermalEvaporationBlock(pos, state, TETier.SUPREME), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationValve> SUPREME_THERMAL_EVAPORATION_VALVE = EXTRAS_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_VALVE, (pos, state) -> new TileEntityTieredThermalEvaporationValve(pos, state, TETier.SUPREME), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationController> SUPREME_THERMAL_EVAPORATION_CONTROLLER = EXTRAS_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_CONTROLLER, (pos, state) -> new TileEntityTieredThermalEvaporationController(pos, state, TETier.SUPREME), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);

    // Cosmic
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationBlock> COSMIC_THERMAL_EVAPORATION_BLOCK = EXTRAS_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_BLOCK, (pos, state) -> new TileEntityTieredThermalEvaporationBlock(pos, state, TETier.COSMIC), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationValve> COSMIC_THERMAL_EVAPORATION_VALVE = EXTRAS_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_VALVE, (pos, state) -> new TileEntityTieredThermalEvaporationValve(pos, state, TETier.COSMIC), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationController> COSMIC_THERMAL_EVAPORATION_CONTROLLER = EXTRAS_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_CONTROLLER, (pos, state) -> new TileEntityTieredThermalEvaporationController(pos, state, TETier.COSMIC), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);

    // Infinite
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationBlock> INFINITE_THERMAL_EVAPORATION_BLOCK = EXTRAS_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_BLOCK, (pos, state) -> new TileEntityTieredThermalEvaporationBlock(pos, state, TETier.INFINITE), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationValve> INFINITE_THERMAL_EVAPORATION_VALVE = EXTRAS_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_VALVE, (pos, state) -> new TileEntityTieredThermalEvaporationValve(pos, state, TETier.INFINITE), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationController> INFINITE_THERMAL_EVAPORATION_CONTROLLER = EXTRAS_TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_CONTROLLER, (pos, state) -> new TileEntityTieredThermalEvaporationController(pos, state, TETier.INFINITE), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
}

