package io.github.masyumero.morethermalevaporationcompat.common.registries;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatBlockTypeTile;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatMultiPartType;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.util.UpgradeUtils;
import mekanism.common.MekanismLang;
import mekanism.common.block.attribute.AttributeStateFacing;
import mekanism.common.block.attribute.Attributes;

public class MoreThermalEvaporationCompatBlockTypes {

    private static final Table<TETier, MTECompatMultiPartType, MTECompatBlockTypeTile<?>> BLOCKTYPE_TABLE = HashBasedTable.create();

    static {
        for (TETier tier : TETier.values()) {
            if (tier.isModLoaded()) {
                BLOCKTYPE_TABLE.put(tier, MTECompatMultiPartType.BLOCK, MTECompatBlockTypeTile.MTECompatBlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.getBlockTileEntityType(tier), MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_BLOCK, tier).with(new Attributes.AttributeCustomResistance(9)).externalMultiblock().build());
                BLOCKTYPE_TABLE.put(tier, MTECompatMultiPartType.VALVE, MTECompatBlockTypeTile.MTECompatBlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.getValveTileEntityType(tier), MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_VALVE, tier).with(Attributes.COMPARATOR, new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport(tier.getSimpleName() + "ThermalEvaporationValve").build());
                BLOCKTYPE_TABLE.put(tier, MTECompatMultiPartType.CONTROLLER, MTECompatBlockTypeTile.MTECompatBlockTileBuilder.createBlock(() -> MoreThermalEvaporationCompatTileEntityTypes.getControllerTileEntityType(tier), MekanismLang.DESCRIPTION_THERMAL_EVAPORATION_CONTROLLER, tier).withGui(() -> MoreThermalEvaporationCompatContainerTypes.getContainerType(tier), MekanismLang.EVAPORATION_PLANT).withSupportedUpgrades(UpgradeUtils.getUpgrades()).with(Attributes.INVENTORY, Attributes.ACTIVE, new AttributeStateFacing(), new Attributes.AttributeCustomResistance(9)).externalMultiblock().withComputerSupport(tier.getSimpleName() + "ThermalEvaporationController").build());
            }
        }
    }

    private MoreThermalEvaporationCompatBlockTypes() {
    }

    public static MTECompatBlockTypeTile<?> getBlockType(TETier tier, MTECompatMultiPartType type) {
        return BLOCKTYPE_TABLE.get(tier, type);
    }
}
