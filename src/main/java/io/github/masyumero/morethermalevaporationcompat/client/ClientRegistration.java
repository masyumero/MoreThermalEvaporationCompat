package io.github.masyumero.morethermalevaporationcompat.client;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatContainerTypes;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatTileEntityTypes;
import io.github.masyumero.morethermalevaporationcompat.evolved.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.evolved.client.gui.*;
import io.github.masyumero.morethermalevaporationcompat.evolved.client.tileentity.*;
import io.github.masyumero.morethermalevaporationcompat.extras.ExtrasModule;
import io.github.masyumero.morethermalevaporationcompat.extras.client.gui.*;
import io.github.masyumero.morethermalevaporationcompat.extras.client.tileentity.*;
import mekanism.client.ClientRegistrationUtil;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = MoreThermalEvaporationCompat.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistration {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        if (EvolvedModule.EvolvedLoaded) {
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER.get(), RenderOverclockedThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.QUANTUM_THERMAL_EVAPORATION_CONTROLLER.get(), RenderQuantumThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.DENSE_THERMAL_EVAPORATION_CONTROLLER.get(), RenderDenseThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER.get(), RenderMultiversalThermalEvaporationPlant::new);
        }
        if (ExtrasModule.ExtrasLoaded) {
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER.get(), RenderAbsoluteThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.SUPREME_THERMAL_EVAPORATION_CONTROLLER.get(), RenderSupremeThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.COSMIC_THERMAL_EVAPORATION_CONTROLLER.get(), RenderCosmicThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.INFINITE_THERMAL_EVAPORATION_CONTROLLER.get(), RenderInfiniteThermalEvaporationPlant::new);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerContainers(RegisterEvent event) {
        event.register(Registries.MENU, helper -> {
            if (EvolvedModule.EvolvedLoaded) {
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER, GuiOverclockedThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.QUANTUM_THERMAL_EVAPORATION_CONTROLLER, GuiQuantumThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.DENSE_THERMAL_EVAPORATION_CONTROLLER, GuiDenseThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER, GuiMultiversalThermalEvaporationController::new);
            }
            if (ExtrasModule.ExtrasLoaded) {
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, GuiAbsoluteThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.SUPREME_THERMAL_EVAPORATION_CONTROLLER, GuiSupremeThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.COSMIC_THERMAL_EVAPORATION_CONTROLLER, GuiCosmicThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.INFINITE_THERMAL_EVAPORATION_CONTROLLER, GuiInfiniteThermalEvaporationController::new);
            }
        });
    }
}