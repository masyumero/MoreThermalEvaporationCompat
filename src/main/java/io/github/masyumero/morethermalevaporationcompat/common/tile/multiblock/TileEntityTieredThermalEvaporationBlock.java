package io.github.masyumero.morethermalevaporationcompat.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.common.block.attribute.MTECompatAttribute;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.lib.multiblock.MultiblockManager;
import mekanism.common.tile.prefab.TileEntityMultiblock;
import mekanism.common.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityTieredThermalEvaporationBlock extends TileEntityMultiblock<TieredThermalEvaporationMultiblockData> {

    protected TETier tier;

    public TileEntityTieredThermalEvaporationBlock(BlockPos pos, BlockState state, TETier tier) {
        this(tier.getCasingBlock(), pos, state);
    }

    public TileEntityTieredThermalEvaporationBlock(IBlockProvider provider, BlockPos pos, BlockState state) {
        super(provider, pos, state);
    }

    @Override
    public void onNeighborChange(Block block, BlockPos neighborPos) {
        super.onNeighborChange(block, neighborPos);
        if (!isRemote() && WorldUtils.sideDifference(worldPosition, neighborPos) == Direction.DOWN) {
            TieredThermalEvaporationMultiblockData multiblock = getMultiblock();
            if (multiblock.isFormed()) {
                multiblock.updateSolarSpot(getLevel(), neighborPos);
            }
        }
    }

    @Override
    protected void presetVariables() {
        super.presetVariables();
        tier = MTECompatAttribute.getTier(getBlockType());
    }

    @Override
    public TieredThermalEvaporationMultiblockData createMultiblock() {
        return new TieredThermalEvaporationMultiblockData(this, tier);
    }

    @Override
    public MultiblockManager<TieredThermalEvaporationMultiblockData> getManager() {
        return tier.getManager();
    }

    @Override
    public boolean canBeMaster() {
        return false;
    }

    public TETier getTier() {
        return tier;
    }
}