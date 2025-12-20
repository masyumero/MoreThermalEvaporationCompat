package io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.evolved.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.content.evaporation.MultiversalThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.lib.multiblock.MultiblockManager;
import mekanism.common.tile.prefab.TileEntityMultiblock;
import mekanism.common.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityMultiversalThermalEvaporationBlock extends TileEntityMultiblock<MultiversalThermalEvaporationMultiblockData> {

    public TileEntityMultiversalThermalEvaporationBlock(BlockPos pos, BlockState state) {
        this(MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_BLOCK, pos, state);
    }

    public TileEntityMultiversalThermalEvaporationBlock(IBlockProvider provider, BlockPos pos, BlockState state) {
        super(provider, pos, state);
    }

    @Override
    public void onNeighborChange(Block block, BlockPos neighborPos) {
        super.onNeighborChange(block, neighborPos);
        if (!isRemote() && WorldUtils.sideDifference(worldPosition, neighborPos) == Direction.DOWN) {
            MultiversalThermalEvaporationMultiblockData multiblock = getMultiblock();
            if (multiblock.isFormed()) {
                multiblock.updateSolarSpot(getLevel(), neighborPos);
            }
        }
    }

    @Override
    public MultiversalThermalEvaporationMultiblockData createMultiblock() {
        return new MultiversalThermalEvaporationMultiblockData(this);
    }

    @Override
    public MultiblockManager<MultiversalThermalEvaporationMultiblockData> getManager() {
        return EvolvedModule.MultiversalThermalEvaporationManager;
    }

    @Override
    public boolean canBeMaster() {
        return false;
    }
}