package io.github.masyumero.morethermalevaporationcompat.client.jei;

import io.github.masyumero.morethermalevaporationcompat.CompactModule;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatMultiPartType;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.client.jei.CatalystRegistryHelper;
import mekanism.client.jei.MekanismJEIRecipeType;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@JeiPlugin
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class MTECompatJEI implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return MoreThermalEvaporationCompat.rl("jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registry) {
        for (TETier tier : TETier.values()) {
            for (MTECompatMultiPartType type : MTECompatMultiPartType.values()) {
                if (tier.isModLoaded() && !tier.isCompactOnly()) CatalystRegistryHelper.register(registry, MekanismJEIRecipeType.EVAPORATING, MoreThermalEvaporationCompatBlocks.getBlock(tier, type));
            }
            if (CompactModule.CompactLoaded) {
                CatalystRegistryHelper.register(registry, MekanismJEIRecipeType.EVAPORATING, MoreThermalEvaporationCompatBlocks.getCompactBlock(tier));
            }
        }
    }
}
