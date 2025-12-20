package io.github.masyumero.morethermalevaporationcompat.extras.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.extras.ExtrasModule;
import io.github.masyumero.morethermalevaporationcompat.extras.common.content.evaporation.InfiniteThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatBlocks;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.lib.multiblock.MultiblockManager;
import mekanism.common.tile.prefab.TileEntityMultiblock;
import mekanism.common.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityInfiniteThermalEvaporationBlock extends TileEntityMultiblock<InfiniteThermalEvaporationMultiblockData> {

    public TileEntityInfiniteThermalEvaporationBlock(BlockPos pos, BlockState state) {
        this(MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_BLOCK, pos, state);
    }

    public TileEntityInfiniteThermalEvaporationBlock(IBlockProvider provider, BlockPos pos, BlockState state) {
        super(provider, pos, state);
    }

    @Override
    public void onNeighborChange(Block block, BlockPos neighborPos) {
        super.onNeighborChange(block, neighborPos);
        if (!isRemote() && WorldUtils.sideDifference(worldPosition, neighborPos) == Direction.DOWN) {
            InfiniteThermalEvaporationMultiblockData multiblock = getMultiblock();
            if (multiblock.isFormed()) {
                multiblock.updateSolarSpot(getLevel(), neighborPos);
            }
        }
    }

    @Override
    public InfiniteThermalEvaporationMultiblockData createMultiblock() {
        return new InfiniteThermalEvaporationMultiblockData(this);
    }

    @Override
    public MultiblockManager<InfiniteThermalEvaporationMultiblockData> getManager() {
        return ExtrasModule.InfiniteThermalEvaporationManager;
    }

    @Override
    public boolean canBeMaster() {
        return false;
    }
}