package io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.evolved.common.content.evaporation.DenseThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityDenseThermalEvaporationController extends TileEntityDenseThermalEvaporationBlock {

    public TileEntityDenseThermalEvaporationController(BlockPos pos, BlockState state) {
        super(MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_CONTROLLER, pos, state);
        delaySupplier = NO_DELAY;
    }

    @Override
    protected boolean onUpdateServer(DenseThermalEvaporationMultiblockData multiblock) {
        boolean needsPacket = super.onUpdateServer(multiblock);
        setActive(multiblock.isFormed());
        return needsPacket;
    }

    @Override
    public boolean canBeMaster() {
        return true;
    }
}