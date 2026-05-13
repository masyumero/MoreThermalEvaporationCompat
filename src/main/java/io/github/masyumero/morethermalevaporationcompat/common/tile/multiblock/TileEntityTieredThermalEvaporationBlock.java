package io.github.masyumero.morethermalevaporationcompat.common.tile.multiblock;

import io.github.masyumero.morethermalevaporationcompat.common.block.attribute.MTECompatAttribute;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.api.Upgrade;
import mekanism.api.providers.IBlockProvider;
import mekanism.common.lib.multiblock.MultiblockManager;
import mekanism.common.tile.prefab.TileEntityMultiblock;
import mekanism.common.util.UpgradeUtils;
import mekanism.common.util.WorldUtils;
import morethermalevaporation.common.upgrade.MoreThermalEvaporationUpgrade;
import morethermalevaporation.common.util.MoreThermalEvaporationUpgradeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TileEntityTieredThermalEvaporationBlock extends TileEntityMultiblock<TieredThermalEvaporationMultiblockData> {

    protected TETier tier;
    private static final int DEFAULT_HEIGHT = 18;
    private int allowedHeight = DEFAULT_HEIGHT;

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
    public void recalculateUpgrades(Upgrade upgrade) {
        TieredThermalEvaporationMultiblockData multiblock = getMultiblock();

        if (upgrade == MoreThermalEvaporationUpgrade.STRUCTURE) {
            this.allowedHeight = this.tier.getHeight() + upgradeComponent.getUpgrades(MoreThermalEvaporationUpgrade.STRUCTURE);
            if (multiblock.height() > this.allowedHeight) {
                multiblock.setFormedForce(false);
            }
        }
    }

    @Override
    public TieredThermalEvaporationMultiblockData createMultiblock() {
        return new TieredThermalEvaporationMultiblockData(this, tier);
    }

    @Override
    public MultiblockManager<TieredThermalEvaporationMultiblockData> getManager() {
        return tier.getManager();
    }

    @NotNull
    @Override
    public List<Component> getInfo(@NotNull Upgrade upgrade) {
        List<Component> ret = UpgradeUtils.getMultScaledInfo(this, upgrade);
        return MoreThermalEvaporationUpgradeUtils.getMultScaledInfo(ret, this, upgrade);
    }

    @Override
    public boolean canBeMaster() {
        return false;
    }

    public TETier getTier() {
        return tier;
    }

    public int getAllowedHeight() {
        return this.allowedHeight;
    }
}