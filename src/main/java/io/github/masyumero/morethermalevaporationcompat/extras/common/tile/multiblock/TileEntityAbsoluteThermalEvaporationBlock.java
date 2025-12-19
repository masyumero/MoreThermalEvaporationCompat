package io.github.masyumero.morethermalevaporationcompat.extras.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.extras.common.content.evaporation.AbsoluteThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatBlocks;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.lib.multiblock.MultiblockManager;
import mekanism.common.tile.prefab.TileEntityMultiblock;
import mekanism.common.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityAbsoluteThermalEvaporationBlock extends TileEntityMultiblock<AbsoluteThermalEvaporationMultiblockData> {

    public TileEntityAbsoluteThermalEvaporationBlock(BlockPos pos, BlockState state) {
        this(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_BLOCK, pos, state);
    }

    public TileEntityAbsoluteThermalEvaporationBlock(IBlockProvider provider, BlockPos pos, BlockState state) {
        super(provider, pos, state);
    }

    @Override
    public void onNeighborChange(Block block, BlockPos neighborPos) {
        super.onNeighborChange(block, neighborPos);
        if (!isRemote() && WorldUtils.sideDifference(worldPosition, neighborPos) == Direction.DOWN) {
            AbsoluteThermalEvaporationMultiblockData multiblock = getMultiblock();
            if (multiblock.isFormed()) {
                multiblock.updateSolarSpot(getLevel(), neighborPos);
            }
        }
    }

    @Override
    public AbsoluteThermalEvaporationMultiblockData createMultiblock() {
        return new AbsoluteThermalEvaporationMultiblockData(this);
    }

    @Override
    public MultiblockManager<AbsoluteThermalEvaporationMultiblockData> getManager() {
        return MoreThermalEvaporationCompat.AbsoluteThermalEvaporationManager;
    }

    @Override
    public boolean canBeMaster() {
        return false;
    }
}