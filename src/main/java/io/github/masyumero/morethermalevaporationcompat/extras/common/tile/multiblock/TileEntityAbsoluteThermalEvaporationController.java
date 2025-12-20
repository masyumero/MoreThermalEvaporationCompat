package io.github.masyumero.morethermalevaporationcompat.extras.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.extras.common.content.evaporation.AbsoluteThermalEvaporationMultiblockData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityAbsoluteThermalEvaporationController extends TileEntityAbsoluteThermalEvaporationBlock{

    public TileEntityAbsoluteThermalEvaporationController(BlockPos pos, BlockState state) {
        super(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, pos, state);
        delaySupplier = NO_DELAY;
    }

    @Override
    protected boolean onUpdateServer(AbsoluteThermalEvaporationMultiblockData multiblock) {
        boolean needsPacket = super.onUpdateServer(multiblock);
        setActive(multiblock.isFormed());
        return needsPacket;
    }

    @Override
    public boolean canBeMaster() {
        return true;
    }
}