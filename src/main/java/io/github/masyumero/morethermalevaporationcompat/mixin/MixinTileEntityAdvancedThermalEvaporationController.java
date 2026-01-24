package io.github.masyumero.morethermalevaporationcompat.mixin;

import io.github.masyumero.morethermalevaporationcompat.api.IThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.util.UpgradeUtils;
import mekanism.api.Upgrade;
import morethermalevaporation.common.tier.MoreThermalEvaporationTier;
import morethermalevaporation.common.tile.multiblock.TileEntityMoreThermalEvaporationBlock;
import morethermalevaporation.common.tile.multiblock.TileEntityMoreThermalEvaporationController;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = TileEntityMoreThermalEvaporationController.class, remap = false)
public abstract class MixinTileEntityAdvancedThermalEvaporationController extends TileEntityMoreThermalEvaporationBlock {

    public MixinTileEntityAdvancedThermalEvaporationController(MoreThermalEvaporationTier tier, BlockPos pos, BlockState state) {
        super(tier, pos, state);
    }

    @Override
    public void recalculateUpgrades(Upgrade upgrade) {
        super.recalculateUpgrades(upgrade);
        if (UpgradeUtils.isSolarUpgrade(upgrade)) {
            int upgradeCount = upgradeComponent.getUpgrades(upgrade);
            ((IThermalEvaporationMultiblockData) getMultiblock()).mteCompat$setUpgradeCount(upgradeCount);
        }
    }
}
