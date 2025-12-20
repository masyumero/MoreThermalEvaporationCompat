package io.github.masyumero.morethermalevaporationcompat.extras.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.extras.common.content.evaporation.SupremeThermalEvaporationMultiblockData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntitySupremeThermalEvaporationController extends TileEntitySupremeThermalEvaporationBlock{

    public TileEntitySupremeThermalEvaporationController(BlockPos pos, BlockState state) {
        super(MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_CONTROLLER, pos, state);
        delaySupplier = NO_DELAY;
    }

    @Override
    protected boolean onUpdateServer(SupremeThermalEvaporationMultiblockData multiblock) {
        boolean needsPacket = super.onUpdateServer(multiblock);
        setActive(multiblock.isFormed());
        return needsPacket;
    }

    @Override
    public boolean canBeMaster() {
        return true;
    }
}