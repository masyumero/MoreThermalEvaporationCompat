package io.github.masyumero.morethermalevaporationcompat.mixin;

import fr.iglee42.evolvedmekanism.registries.EMUpgrades;
import io.github.masyumero.morethermalevaporationcompat.api.IThermalEvaporationMultiblockData;
import mekanism.api.Upgrade;
import morethermalevaporation.tile.multiblock.TileEntityEliteThermalEvaporationBlock;
import morethermalevaporation.tile.multiblock.TileEntityEliteThermalEvaporationController;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = TileEntityEliteThermalEvaporationController.class, remap = false)
public abstract class MixinTileEntityEliteThermalEvaporationController extends TileEntityEliteThermalEvaporationBlock {

    public MixinTileEntityEliteThermalEvaporationController(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public void recalculateUpgrades(Upgrade upgrade) {
        super.recalculateUpgrades(upgrade);
        if (upgrade == EMUpgrades.SOLAR_UPGRADE) {
            int upgradeCount = upgradeComponent.getUpgrades(upgrade);
            ((IThermalEvaporationMultiblockData)getMultiblock()).mteCompat$setUpgradeCount(upgradeCount);
        }
    }
}
