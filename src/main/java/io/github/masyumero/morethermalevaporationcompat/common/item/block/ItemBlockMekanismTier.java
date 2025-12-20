package io.github.masyumero.morethermalevaporationcompat.common.item.block;

import com.jerry.mekanism_extras.api.tier.AdvancedTier;
import mekanism.api.text.TextComponentUtil;
import mekanism.api.tier.BaseTier;
import mekanism.common.block.interfaces.IHasDescription;
import mekanism.common.item.block.ItemBlockTooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class ItemBlockMekanismTier<BLOCK extends Block & IHasDescription> extends ItemBlockTooltip<BLOCK> {

    private final int color;

    public ItemBlockMekanismTier(BLOCK block, Properties properties, int color) {
        super(block, properties);
        this.color = color;
    }

    public ItemBlockMekanismTier(BLOCK block, Properties properties, AdvancedTier tier) {
        this(block, properties, tier.getColor().getValue());
    }

    public ItemBlockMekanismTier(BLOCK block, Properties properties, BaseTier tier) {
        this(block, properties, tier.getColor().getValue());
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        return TextComponentUtil.color(super.getName(stack).copy(), color);
    }
}