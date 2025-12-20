package io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.evolved.common.content.evaporation.QuantumThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.registries.MoreThermalEvaporationCompatBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityQuantumThermalEvaporationController extends TileEntityQuantumThermalEvaporationBlock {

    public TileEntityQuantumThermalEvaporationController(BlockPos pos, BlockState state) {
        super(MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_CONTROLLER, pos, state);
        delaySupplier = NO_DELAY;
    }

    @Override
    protected boolean onUpdateServer(QuantumThermalEvaporationMultiblockData multiblock) {
        boolean needsPacket = super.onUpdateServer(multiblock);
        setActive(multiblock.isFormed());
        return needsPacket;
    }

    @Override
    public boolean canBeMaster() {
        return true;
    }
}