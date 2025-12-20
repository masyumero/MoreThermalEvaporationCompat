package io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.evolved.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.content.evaporation.QuantumThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.lib.multiblock.MultiblockManager;
import mekanism.common.tile.prefab.TileEntityMultiblock;
import mekanism.common.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityQuantumThermalEvaporationBlock extends TileEntityMultiblock<QuantumThermalEvaporationMultiblockData> {

    public TileEntityQuantumThermalEvaporationBlock(BlockPos pos, BlockState state) {
        this(MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_BLOCK, pos, state);
    }

    public TileEntityQuantumThermalEvaporationBlock(IBlockProvider provider, BlockPos pos, BlockState state) {
        super(provider, pos, state);
    }

    @Override
    public void onNeighborChange(Block block, BlockPos neighborPos) {
        super.onNeighborChange(block, neighborPos);
        if (!isRemote() && WorldUtils.sideDifference(worldPosition, neighborPos) == Direction.DOWN) {
            QuantumThermalEvaporationMultiblockData multiblock = getMultiblock();
            if (multiblock.isFormed()) {
                multiblock.updateSolarSpot(getLevel(), neighborPos);
            }
        }
    }

    @Override
    public QuantumThermalEvaporationMultiblockData createMultiblock() {
        return new QuantumThermalEvaporationMultiblockData(this);
    }

    @Override
    public MultiblockManager<QuantumThermalEvaporationMultiblockData> getManager() {
        return EvolvedModule.QuantumThermalEvaporationManager;
    }

    @Override
    public boolean canBeMaster() {
        return false;
    }
}