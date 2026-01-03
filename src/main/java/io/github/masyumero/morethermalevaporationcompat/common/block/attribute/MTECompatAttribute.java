package io.github.masyumero.morethermalevaporationcompat.common.block.attribute;

import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.common.block.attribute.Attribute;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public interface MTECompatAttribute extends Attribute {

    @Nullable
    static TETier getTier(Block block) {
        MTECompatAttributeTier<?> attr = Attribute.get(block, MTECompatAttributeTier.class);
        return Objects.requireNonNull(attr).tier();
    }
}
