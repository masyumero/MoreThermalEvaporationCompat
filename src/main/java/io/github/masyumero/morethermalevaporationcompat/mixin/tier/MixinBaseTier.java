package io.github.masyumero.morethermalevaporationcompat.mixin.tier;

import io.github.masyumero.morethermalevaporationcompat.api.tier.ITier;
import mekanism.api.tier.BaseTier;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = BaseTier.class, remap = false)
public abstract class MixinBaseTier implements ITier {
}
