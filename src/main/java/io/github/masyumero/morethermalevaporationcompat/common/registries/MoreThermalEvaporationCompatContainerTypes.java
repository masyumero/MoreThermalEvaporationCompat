package io.github.masyumero.morethermalevaporationcompat.common.registries;

import io.github.masyumero.morethermalevaporationcompat.CompactModule;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.tile.TileEntityTieredCompactThermalEvaporation;
import io.github.masyumero.morethermalevaporationcompat.common.tile.multiblock.TileEntityTieredThermalEvaporationController;
import io.github.masyumero.morethermalevaporationcompat.common.util.MTECompatEnumUtils;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.registration.impl.ContainerTypeDeferredRegister;
import mekanism.common.registration.impl.ContainerTypeRegistryObject;

import java.util.HashMap;
import java.util.Map;

public class MoreThermalEvaporationCompatContainerTypes {
    public static final ContainerTypeDeferredRegister CONTAINER_TYPES = new ContainerTypeDeferredRegister(MoreThermalEvaporationCompat.MODID);

    private static final Map<TETier, ContainerTypeRegistryObject<MekanismTileContainer<TileEntityTieredThermalEvaporationController>>> CONTAINERTYPE_MAP = new HashMap<>();
    private static final Map<TETier, ContainerTypeRegistryObject<MekanismTileContainer<TileEntityTieredCompactThermalEvaporation>>> COMPACT_CONTAINERTYPE_MAP = new HashMap<>();

    static {
        for (TETier tier : MTECompatEnumUtils.THERMAL_EVAPORATION_TIERS) {
            if (tier.isModLoaded()) {
                if (!tier.isCompactOnly()) {
                    CONTAINERTYPE_MAP.put(tier, CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.getControllerBlock(tier), TileEntityTieredThermalEvaporationController.class));
                }
                if (CompactModule.CompactLoaded) {
                    COMPACT_CONTAINERTYPE_MAP.put(tier, CONTAINER_TYPES.register(MoreThermalEvaporationCompatBlocks.getCompactBlock(tier), TileEntityTieredCompactThermalEvaporation.class));
                }
            }
        }
    }

    private MoreThermalEvaporationCompatContainerTypes() {
    }

    public static ContainerTypeRegistryObject<MekanismTileContainer<TileEntityTieredThermalEvaporationController>> getContainerType(TETier tier) {
        return CONTAINERTYPE_MAP.get(tier);
    }

    public static ContainerTypeRegistryObject<MekanismTileContainer<TileEntityTieredCompactThermalEvaporation>> getCompactContainerType(TETier tier) {
        return COMPACT_CONTAINERTYPE_MAP.get(tier);
    }
}
