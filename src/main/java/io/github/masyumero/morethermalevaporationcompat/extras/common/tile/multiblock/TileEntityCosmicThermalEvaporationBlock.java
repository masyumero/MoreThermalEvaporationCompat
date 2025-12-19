package io.github.masyumero.morethermalevaporationcompat.extras.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.extras.common.content.evaporation.CosmicThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatBlocks;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.lib.multiblock.MultiblockManager;
import mekanism.common.tile.prefab.TileEntityMultiblock;
import mekanism.common.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityCosmicThermalEvaporationBlock extends TileEntityMultiblock<CosmicThermalEvaporationMultiblockData> {

    public TileEntityCosmicThermalEvaporationBlock(BlockPos pos, BlockState state) {
        this(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_BLOCK, pos, state);
    }

    public TileEntityCosmicThermalEvaporationBlock(IBlockProvider provider, BlockPos pos, BlockState state) {
        super(provider, pos, state);
    }

    @Override
    public void onNeighborChange(Block block, BlockPos neighborPos) {
        super.onNeighborChange(block, neighborPos);
        if (!isRemote() && WorldUtils.sideDifference(worldPosition, neighborPos) == Direction.DOWN) {
            CosmicThermalEvaporationMultiblockData multiblock = getMultiblock();
            if (multiblock.isFormed()) {
                multiblock.updateSolarSpot(getLevel(), neighborPos);
            }
        }
    }

    @Override
    public CosmicThermalEvaporationMultiblockData createMultiblock() {
        return new CosmicThermalEvaporationMultiblockData(this);
    }

    @Override
    public MultiblockManager<CosmicThermalEvaporationMultiblockData> getManager() {
        return MoreThermalEvaporationCompat.CosmicThermalEvaporationManager;
    }

    @Override
    public boolean canBeMaster() {
        return false;
    }
}