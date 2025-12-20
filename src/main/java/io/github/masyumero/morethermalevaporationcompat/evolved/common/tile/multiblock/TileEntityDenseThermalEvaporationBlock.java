package io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.evolved.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.content.evaporation.DenseThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.registries.MoreThermalEvaporationCompatBlocks;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.lib.multiblock.MultiblockManager;
import mekanism.common.tile.prefab.TileEntityMultiblock;
import mekanism.common.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityDenseThermalEvaporationBlock extends TileEntityMultiblock<DenseThermalEvaporationMultiblockData> {

    public TileEntityDenseThermalEvaporationBlock(BlockPos pos, BlockState state) {
        this(MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_BLOCK, pos, state);
    }

    public TileEntityDenseThermalEvaporationBlock(IBlockProvider provider, BlockPos pos, BlockState state) {
        super(provider, pos, state);
    }

    @Override
    public void onNeighborChange(Block block, BlockPos neighborPos) {
        super.onNeighborChange(block, neighborPos);
        if (!isRemote() && WorldUtils.sideDifference(worldPosition, neighborPos) == Direction.DOWN) {
            DenseThermalEvaporationMultiblockData multiblock = getMultiblock();
            if (multiblock.isFormed()) {
                multiblock.updateSolarSpot(getLevel(), neighborPos);
            }
        }
    }

    @Override
    public DenseThermalEvaporationMultiblockData createMultiblock() {
        return new DenseThermalEvaporationMultiblockData(this);
    }

    @Override
    public MultiblockManager<DenseThermalEvaporationMultiblockData> getManager() {
        return EvolvedModule.DenseThermalEvaporationManager;
    }

    @Override
    public boolean canBeMaster() {
        return false;
    }
}