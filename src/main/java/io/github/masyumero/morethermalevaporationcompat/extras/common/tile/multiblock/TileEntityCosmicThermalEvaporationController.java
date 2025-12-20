package io.github.masyumero.morethermalevaporationcompat.extras.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.extras.common.content.evaporation.CosmicThermalEvaporationMultiblockData;
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
    public boolean canBeMaster() {
        return true;
    }
}