package io.github.masyumero.morethermalevaporationcompat.common.tile.multiblock;

import fr.iglee42.evolvedmekanism.registries.EMUpgrades;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.api.Upgrade;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityTieredThermalEvaporationController extends TileEntityTieredThermalEvaporationBlock {

    public TileEntityTieredThermalEvaporationController(BlockPos pos, BlockState state, TETier tier) {
        super(tier.getControllerBlock(), pos, state);
        delaySupplier = NO_DELAY;
    }

    @Override
    protected boolean onUpdateServer(TieredThermalEvaporationMultiblockData multiblock) {
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