package io.github.masyumero.morethermalevaporationcompat.common.registries;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.MTECompatLang;
import io.github.masyumero.morethermalevaporationcompat.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.ExtrasModule;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatMultiPartType;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.common.registries.MekanismBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MoreThermalEvaporationCompatCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreThermalEvaporationCompat.MODID);

    public static final RegistryObject<CreativeModeTab> TAB_MORE_THERMAL_EVAPORATION_COMPAT = CREATIVE_TABS.register("tab_more_thermal_evaporation_compat", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable(MTECompatLang.CREATIVE_TAB.getTranslationKey()))
                    .icon(() -> {
                        if (ExtrasModule.ExtrasLoaded) {
                            return MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.ABSOLUTE).getItemStack();
                        } else if (EvolvedModule.EvolvedLoaded) {
                            return MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.OVERCLOCKED).getItemStack();
                        }
                        return MekanismBlocks.THERMAL_EVAPORATION_BLOCK.getItemStack();
                    } )
                    .displayItems((parameters, output) -> {
                        for (TETier tier : TETier.values()) {
                            for (MTECompatMultiPartType type : MTECompatMultiPartType.values()) {
                                output.accept(MoreThermalEvaporationCompatBlocks.getBlock(tier, type));
                            }
                        }
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}