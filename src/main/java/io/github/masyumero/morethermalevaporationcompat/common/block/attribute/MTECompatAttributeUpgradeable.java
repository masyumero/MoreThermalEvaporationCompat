package io.github.masyumero.morethermalevaporationcompat.common.block.attribute;

import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.common.block.states.BlockStateHelper;
import mekanism.common.registration.impl.BlockRegistryObject;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MTECompatAttributeUpgradeable implements MTECompatAttribute {
    private final Supplier<BlockRegistryObject<?, ?>> upgradeBlock;

    public MTECompatAttributeUpgradeable(Supplier<BlockRegistryObject<?, ?>> upgradeBlock) {
        this.upgradeBlock = upgradeBlock;
    }

    public BlockState upgradeResult(BlockState current, TETier tier) {
        return BlockStateHelper.copyStateData(current, MoreThermalEvaporationCompatBlocks.getCompactBlock(tier));
    }

    public BlockState upgradeResult(BlockState current) {
        return BlockStateHelper.copyStateData(current, upgradeBlock.get());
    }
}
