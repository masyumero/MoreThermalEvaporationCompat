package io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock;

import fr.iglee42.evolvedmekanism.registries.EMUpgrades;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.content.evaporation.OverclockedThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import mekanism.api.Upgrade;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityOverclockedThermalEvaporationController extends TileEntityOverclockedThermalEvaporationBlock {

    public TileEntityOverclockedThermalEvaporationController(BlockPos pos, BlockState state) {
        super(MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER, pos, state);
        delaySupplier = NO_DELAY;
    }

    @Override
    protected boolean onUpdateServer(OverclockedThermalEvaporationMultiblockData multiblock) {
        boolean needsPacket = super.onUpdateServer(multiblock);
        setActive(multiblock.isFormed());
        return needsPacket;
    }

    @Override
    public void recalculateUpgrades(Upgrade upgrade) {
        super.recalculateUpgrades(upgrade);
        if (upgrade == EMUpgrades.SOLAR_UPGRADE) {
            int upgradeCount = upgradeComponent.getUpgrades(upgrade);
            getMultiblock().mteCompat$setUpgradeCount(upgradeCount);
        }
    }

    @Override
    public boolean canBeMaster() {
        return true;
    }
}