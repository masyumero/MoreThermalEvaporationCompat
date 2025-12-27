package io.github.masyumero.morethermalevaporationcompat.common.block.attribute;

import io.github.masyumero.morethermalevaporationcompat.api.tier.ITier;
import mekanism.common.MekanismLang;
import mekanism.common.content.blocktype.BlockType;

import java.util.HashMap;
import java.util.Map;

public record MTECompatAttributeTier<TIER extends ITier>(TIER tier) implements MTECompatAttribute{

    private static final Map<ITier, BlockType> typeCache = new HashMap<>();

    public static <T extends ITier> BlockType getPassthroughType(T tier) {
        return typeCache.computeIfAbsent(tier, t -> BlockType.BlockTypeBuilder.createBlock(MekanismLang.EMPTY).with(new MTECompatAttribute[] { new MTECompatAttributeTier<>(t) }).build());
    }
}
