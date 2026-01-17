package io.github.masyumero.morethermalevaporationcompat.common.registries;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import io.github.masyumero.morethermalevaporationcompat.CompactModule;
import io.github.masyumero.morethermalevaporationcompat.MTECompatLang;
import io.github.masyumero.morethermalevaporationcompat.api.lang.MTECompatLangType;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatBlockTypeTile;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatMachine;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatMultiPartType;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.util.MTECompatEnumUtils;
import io.github.masyumero.morethermalevaporationcompat.common.util.UpgradeUtils;
import mekanism.common.block.attribute.AttributeCustomSelectionBox;
import mekanism.common.block.attribute.AttributeStateFacing;
import mekanism.common.block.attribute.Attributes;

import java.util.HashMap;
import java.util.Map;

public class MoreThermalEvaporationCompatBlockTypes {

    private static final Table<TETier, MTECompatMultiPartType, MTECompatBlockTypeTile<?>> BLOCKTYPE_TABLE = HashBasedTable.create();
    private static final Map<TETier, MTECompatBlockTypeTile<?>> COMPACT_BLOCKTYPE_TABLE = new HashMap<>();

    static {
        for (TETier tier : MTECompatEnumUtils.THERMAL_EVAPORATION_TIERS) {
            if (tier.isModLoaded()) {
                if (!tier.isCompactOnly()) {
                    BLOCKTYPE_TABLE.put(tier, MTECompatMultiPartType.BLOCK, MTECompatBlockTypeTile.MTECompatBlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.getBlockTileEntityType(tier), MTECompatLang.getLang(tier, MTECompatLangType.DESC_BLOCK), tier).with(new Attributes.AttributeCustomResistance(9)).externalMultiblock().build());
                    BLOCKTYPE_TABLE.put(tier, MTECompatMultiPartType.VALVE, MTECompatBlockTypeTile.MTECompatBlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.getValveTileEntityType(tier), MTECompatLang.getLang(tier, MTECompatLangType.DESC_VALVE), tier).with(Attributes.COMPARATOR, new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport(tier.getSimpleName() + "ThermalEvaporationValve").build());
                    BLOCKTYPE_TABLE.put(tier, MTECompatMultiPartType.CONTROLLER, MTECompatBlockTypeTile.MTECompatBlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.getControllerTileEntityType(tier), MTECompatLang.getLang(tier, MTECompatLangType.DESC_CONTROLLER), tier).withGui(() -> MoreThermalEvaporationCompatContainerTypes.getContainerType(tier), MTECompatLang.getLang(tier, MTECompatLangType.TITLE)).withSupportedUpgrades(UpgradeUtils.getUpgrades()).with(Attributes.INVENTORY, Attributes.ACTIVE, new AttributeStateFacing(), new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport(tier.getSimpleName() + "ThermalEvaporationController").build());
                }
                if (CompactModule.CompactLoaded) {
                    COMPACT_BLOCKTYPE_TABLE.put(tier, MTECompatMachine.MTECompatMachineBuilder.createMachine(() -> MoreThermalEvaporationCompatTileEntityTypes.getCompactTileEntityType(tier), MTECompatLang.getCompactLang(tier), tier).withGui(() -> MoreThermalEvaporationCompatContainerTypes.getCompactContainerType(tier)).withSupportedUpgrades(UpgradeUtils.getCompactUpgrades()).with(AttributeCustomSelectionBox.JSON).withComputerSupport("compactthermalevaporation").build());
                }
            }
        }
    }

    private MoreThermalEvaporationCompatBlockTypes() {
    }

    public static MTECompatBlockTypeTile<?> getBlockType(TETier tier, MTECompatMultiPartType type) {
        return BLOCKTYPE_TABLE.get(tier, type);
    }

    public static MTECompatBlockTypeTile<?> getCompactBlockType(TETier tier) {
        return COMPACT_BLOCKTYPE_TABLE.get(tier);
    }
}
