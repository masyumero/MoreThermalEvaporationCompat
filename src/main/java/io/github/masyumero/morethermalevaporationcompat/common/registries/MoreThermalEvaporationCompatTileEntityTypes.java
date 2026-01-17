package io.github.masyumero.morethermalevaporationcompat.common.registries;

import io.github.masyumero.morethermalevaporationcompat.CompactModule;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.tile.TileEntityTieredCompactThermalEvaporation;
import io.github.masyumero.morethermalevaporationcompat.common.tile.multiblock.*;
import io.github.masyumero.morethermalevaporationcompat.common.util.MTECompatEnumUtils;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.base.TileEntityMekanism;

import java.util.HashMap;
import java.util.Map;

public class MoreThermalEvaporationCompatTileEntityTypes {
    public static final TileEntityTypeDeferredRegister TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(MoreThermalEvaporationCompat.MODID);

    private static final Map<TETier, TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationBlock>> BLOCKTILEENTITYTYPE_MAP = new HashMap<>();
    private static final Map<TETier, TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationValve>> VALVETILEENTITYTYPE_MAP = new HashMap<>();
    private static final Map<TETier, TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationController>> CONTROLLERTILEENTITYTYPE_MAP = new HashMap<>();
    private static final Map<TETier, TileEntityTypeRegistryObject<TileEntityTieredCompactThermalEvaporation>> COMPACTTILEENTITYTYPE_MAP = new HashMap<>();

    static {
        for (TETier tier : MTECompatEnumUtils.THERMAL_EVAPORATION_TIERS) {
            if (tier.isModLoaded()) {
                if (!tier.isCompactOnly()) {
                    BLOCKTILEENTITYTYPE_MAP.put(tier, TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.getCasingBlock(tier), (pos, state) -> new TileEntityTieredThermalEvaporationBlock(pos, state, tier), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient));
                    VALVETILEENTITYTYPE_MAP.put(tier, TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.getValveBlock(tier), (pos, state) -> new TileEntityTieredThermalEvaporationValve(pos, state, tier), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient));
                    CONTROLLERTILEENTITYTYPE_MAP.put(tier, TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.getControllerBlock(tier), (pos, state) -> new TileEntityTieredThermalEvaporationController(pos, state, tier), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient));
                }
                if (CompactModule.CompactLoaded) {
                    COMPACTTILEENTITYTYPE_MAP.put(tier, TILE_ENTITY_TYPES.register(MoreThermalEvaporationCompatBlocks.getCompactBlock(tier), (pos, state) -> new TileEntityTieredCompactThermalEvaporation(pos, state, tier), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient));
                }
            }
        }
    }

    public static TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationBlock> getBlockTileEntityType(TETier tier) {
        return BLOCKTILEENTITYTYPE_MAP.get(tier);
    }

    public static TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationValve> getValveTileEntityType(TETier tier) {
        return VALVETILEENTITYTYPE_MAP.get(tier);
    }

    public static TileEntityTypeRegistryObject<TileEntityTieredThermalEvaporationController> getControllerTileEntityType(TETier tier) {
        return CONTROLLERTILEENTITYTYPE_MAP.get(tier);
    }

    public static TileEntityTypeRegistryObject<TileEntityTieredCompactThermalEvaporation> getCompactTileEntityType(TETier tier) {
        return COMPACTTILEENTITYTYPE_MAP.get(tier);
    }
}

