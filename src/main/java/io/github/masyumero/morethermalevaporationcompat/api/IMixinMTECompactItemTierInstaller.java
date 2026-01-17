package io.github.masyumero.morethermalevaporationcompat.api;

import io.github.masyumero.morethermalevaporationcompat.common.block.attribute.MTECompatAttribute;
import io.github.masyumero.morethermalevaporationcompat.common.block.attribute.MTECompatAttributeUpgradeable;
import io.github.masyumero.morethermalevaporationcompat.common.config.LoadConfig;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.common.Mekanism;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.tile.interfaces.ITierUpgradable;
import mekanism.common.tile.interfaces.ITileDirectional;
import mekanism.common.upgrade.IUpgradeData;
import mekanism.common.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public interface IMixinMTECompactItemTierInstaller {

    TETier mteCompat$getFromTier();

    TETier mteCompat$getToTier();

    default InteractionResult mteCompat$useOn(UseOnContext ctx, Block block, BlockState state, BlockPos pos, Level world, Player player) {
        if (!LoadConfig.MTE_COMPAT_CONFIG.upgradeable.get()) {
            return InteractionResult.PASS;
        }
        MTECompatAttributeUpgradeable upgradeableBlock = Attribute.get(block, MTECompatAttributeUpgradeable.class);
        if (upgradeableBlock != null) {
            TETier baseTier = MTECompatAttribute.getTier(block);
            if (baseTier == mteCompat$getFromTier() && baseTier != mteCompat$getToTier()) {
                BlockState upgradeState = upgradeableBlock.upgradeResult(state, mteCompat$getToTier());
                if (state == upgradeState) {
                    return InteractionResult.PASS;
                }
                BlockEntity tile = WorldUtils.getTileEntity(world, pos);
                if (tile instanceof ITierUpgradable tierUpgradable) {
                    if (tile instanceof TileEntityMekanism tileMek && !tileMek.playersUsing.isEmpty()) {
                        return InteractionResult.FAIL;
                    }
                    IUpgradeData upgradeData = tierUpgradable.getUpgradeData();
                    if (upgradeData == null) {
                        if (tierUpgradable.canBeUpgraded()) {
                            Mekanism.logger.warn("Got no upgrade data for block {} at position: {} in {} but it said it would be able to provide some.", block, pos, world);
                            return InteractionResult.FAIL;
                        }
                    } else {
                        world.setBlockAndUpdate(pos, upgradeState);
                        // TODO: Make it so it doesn't have to be a TileEntityMekanism?
                        TileEntityMekanism upgradedTile = WorldUtils.getTileEntity(TileEntityMekanism.class, world, pos);
                        if (upgradedTile == null) {
                            Mekanism.logger.warn("Error upgrading block at position: {} in {}.", pos, world);
                            return InteractionResult.FAIL;
                        } else {
                            if (tile instanceof ITileDirectional directional && directional.isDirectional()) {
                                upgradedTile.setFacing(directional.getDirection());
                            }
                            upgradedTile.parseUpgradeData(upgradeData);
                            upgradedTile.sendUpdatePacket();
                            upgradedTile.setChanged();
                            if (!player.isCreative()) {
                                ctx.getItemInHand().shrink(1);
                            }
                            return InteractionResult.sidedSuccess(world.isClientSide);
                        }
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }
}
