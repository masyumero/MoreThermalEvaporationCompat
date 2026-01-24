package io.github.masyumero.morethermalevaporationcompat.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.util.UpgradeUtils;
import mekanism.api.Upgrade;
import mekanism.common.lib.chunkloading.IChunkLoader;
import mekanism.common.tile.component.TileComponentChunkLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collections;
import java.util.Set;

public class TileEntityTieredThermalEvaporationController extends TileEntityTieredThermalEvaporationBlock implements IChunkLoader {

    private final TileComponentChunkLoader<TileEntityTieredThermalEvaporationController> chunkLoaderComponent = new TileComponentChunkLoader<>(this);

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
        if (UpgradeUtils.isSolarUpgrade(upgrade)) {
            int upgradeCount = upgradeComponent.getUpgrades(upgrade);
            getMultiblock().mteCompat$setUpgradeCount(upgradeCount);
        }
    }


    @Override
    public boolean canBeMaster() {
        return true;
    }

    @Override
    public TileComponentChunkLoader<TileEntityTieredThermalEvaporationController> getChunkLoader() {
        return chunkLoaderComponent;
    }

    @Override
    public Set<ChunkPos> getChunkSet() {
        return Collections.singleton(new ChunkPos(getBlockPos()));
    }
}