package io.github.masyumero.morethermalevaporationcompat.extras.common.registries;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompatLang;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MoreThermalEvaporationCompatCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreThermalEvaporationCompat.MODID);

    public static final RegistryObject<CreativeModeTab> TAB_MORE_THERMAL_EVAPORATION_COMPAT = CREATIVE_TABS.register("tab_more_thermal_evaporation_compat", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable(MoreThermalEvaporationCompatLang.CREATIVE_TAB.getTranslationKey()))
                    .icon(() -> new ItemStack(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_BLOCK.asItem()))
                    .displayItems((parameters, output) -> {
                        output.accept(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_BLOCK.getBlock());
                        output.accept(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_VALVE.getBlock());
                        output.accept(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER.getBlock());
                        output.accept(MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_BLOCK.getBlock());
                        output.accept(MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_VALVE.getBlock());
                        output.accept(MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_CONTROLLER.getBlock());
                        output.accept(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_BLOCK.getBlock());
                        output.accept(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_VALVE.getBlock());
                        output.accept(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_CONTROLLER.getBlock());
                        output.accept(MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_BLOCK.getBlock());
                        output.accept(MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_VALVE.getBlock());
                        output.accept(MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_CONTROLLER.getBlock());

                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}