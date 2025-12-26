package io.github.masyumero.morethermalevaporationcompat.mixin.tier;

import com.jerry.mekanism_extras.api.tier.AdvancedTier;
import io.github.masyumero.morethermalevaporationcompat.api.tier.ITier;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = AdvancedTier.class, remap = false)
public abstract class MixinAdvancedTier implements ITier {
}
