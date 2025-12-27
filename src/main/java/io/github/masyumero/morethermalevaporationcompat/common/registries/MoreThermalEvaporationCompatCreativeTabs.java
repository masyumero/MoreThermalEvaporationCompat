package io.github.masyumero.morethermalevaporationcompat.common.registries;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompatLang;
import io.github.masyumero.morethermalevaporationcompat.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.ExtrasModule;
import mekanism.common.registries.MekanismBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks.*;

public class MoreThermalEvaporationCompatCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreThermalEvaporationCompat.MODID);

    public static final RegistryObject<CreativeModeTab> TAB_MORE_THERMAL_EVAPORATION_COMPAT = CREATIVE_TABS.register("tab_more_thermal_evaporation_compat", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable(MoreThermalEvaporationCompatLang.CREATIVE_TAB.getTranslationKey()))
                    .icon(() -> {
                        if (ExtrasModule.ExtrasLoaded) {
                            return ABSOLUTE_THERMAL_EVAPORATION_BLOCK.getItemStack();
                        } else if (EvolvedModule.EvolvedLoaded) {
                            return OVERCLOCKED_THERMAL_EVAPORATION_BLOCK.getItemStack();
                        }
                        return MekanismBlocks.THERMAL_EVAPORATION_BLOCK.getItemStack();
                    } )
                    .displayItems((parameters, output) -> {
                        if (EvolvedModule.EvolvedLoaded) {
                            output.accept(OVERCLOCKED_THERMAL_EVAPORATION_BLOCK.getBlock());
                            output.accept(OVERCLOCKED_THERMAL_EVAPORATION_VALVE.getBlock());
                            output.accept(OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER.getBlock());
                            output.accept(QUANTUM_THERMAL_EVAPORATION_BLOCK.getBlock());
                            output.accept(QUANTUM_THERMAL_EVAPORATION_VALVE.getBlock());
                            output.accept(QUANTUM_THERMAL_EVAPORATION_CONTROLLER.getBlock());
                            output.accept(DENSE_THERMAL_EVAPORATION_BLOCK.getBlock());
                            output.accept(DENSE_THERMAL_EVAPORATION_VALVE.getBlock());
                            output.accept(DENSE_THERMAL_EVAPORATION_CONTROLLER.getBlock());
                            output.accept(MULTIVERSAL_THERMAL_EVAPORATION_BLOCK.getBlock());
                            output.accept(MULTIVERSAL_THERMAL_EVAPORATION_VALVE.getBlock());
                            output.accept(MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER.getBlock());
                        }
                        if (ExtrasModule.ExtrasLoaded) {
                            output.accept(ABSOLUTE_THERMAL_EVAPORATION_BLOCK.getBlock());
                            output.accept(ABSOLUTE_THERMAL_EVAPORATION_VALVE.getBlock());
                            output.accept(ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER.getBlock());
                            output.accept(SUPREME_THERMAL_EVAPORATION_BLOCK.getBlock());
                            output.accept(SUPREME_THERMAL_EVAPORATION_VALVE.getBlock());
                            output.accept(SUPREME_THERMAL_EVAPORATION_CONTROLLER.getBlock());
                            output.accept(COSMIC_THERMAL_EVAPORATION_BLOCK.getBlock());
                            output.accept(COSMIC_THERMAL_EVAPORATION_VALVE.getBlock());
                            output.accept(COSMIC_THERMAL_EVAPORATION_CONTROLLER.getBlock());
                            output.accept(INFINITE_THERMAL_EVAPORATION_BLOCK.getBlock());
                            output.accept(INFINITE_THERMAL_EVAPORATION_VALVE.getBlock());
                            output.accept(INFINITE_THERMAL_EVAPORATION_CONTROLLER.getBlock());
                        }
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}