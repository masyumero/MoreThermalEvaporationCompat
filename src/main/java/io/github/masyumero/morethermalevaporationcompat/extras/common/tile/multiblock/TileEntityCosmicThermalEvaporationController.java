package io.github.masyumero.morethermalevaporationcompat.extras.common.tile.multiblock;

import fr.iglee42.evolvedmekanism.registries.EMUpgrades;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.extras.common.content.evaporation.CosmicThermalEvaporationMultiblockData;
import mekanism.api.Upgrade;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityCosmicThermalEvaporationController extends TileEntityCosmicThermalEvaporationBlock{

    public TileEntityCosmicThermalEvaporationController(BlockPos pos, BlockState state) {
        super(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_CONTROLLER, pos, state);
        delaySupplier = NO_DELAY;
    }

    @Override
    protected boolean onUpdateServer(CosmicThermalEvaporationMultiblockData multiblock) {
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