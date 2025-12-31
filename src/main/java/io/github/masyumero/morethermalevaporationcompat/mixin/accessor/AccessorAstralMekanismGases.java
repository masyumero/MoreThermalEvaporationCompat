package io.github.masyumero.morethermalevaporationcompat.mixin.accessor;

import astral_mekanism.registries.AstralMekanismGases;
import mekanism.api.chemical.gas.Gas;
import mekanism.common.registration.impl.GasRegistryObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = AstralMekanismGases.class, remap = false)
public interface AccessorAstralMekanismGases {

    @Accessor("ASTRAL_ETHER")
    static GasRegistryObject<Gas> getAstralEther() {
        throw new AssertionError();
    }
}
