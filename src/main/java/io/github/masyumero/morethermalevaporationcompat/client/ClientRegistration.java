package io.github.masyumero.morethermalevaporationcompat.client;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.evolved.client.gui.*;
import io.github.masyumero.morethermalevaporationcompat.evolved.client.tileentity.*;
import io.github.masyumero.morethermalevaporationcompat.extras.client.gui.*;
import io.github.masyumero.morethermalevaporationcompat.extras.client.tileentity.*;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatContainerTypes;
import mekanism.client.ClientRegistrationUtil;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

import static io.github.masyumero.morethermalevaporationcompat.evolved.common.registries.MoreThermalEvaporationCompatTileEntityTypes.*;
import static io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatTileEntityTypes.*;

@Mod.EventBusSubscriber(modid = MoreThermalEvaporationCompat.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistration {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        if (MoreThermalEvaporationCompat.EvolvedLoaded) {
            event.registerBlockEntityRenderer(OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER.get(), RenderOverclockedThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(QUANTUM_THERMAL_EVAPORATION_CONTROLLER.get(), RenderQuantumThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(DENSE_THERMAL_EVAPORATION_CONTROLLER.get(), RenderDenseThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER.get(), RenderMultiversalThermalEvaporationPlant::new);
        }
        if (MoreThermalEvaporationCompat.ExtrasLoaded) {
            event.registerBlockEntityRenderer(ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER.get(), RenderAbsoluteThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(SUPREME_THERMAL_EVAPORATION_CONTROLLER.get(), RenderSupremeThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(COSMIC_THERMAL_EVAPORATION_CONTROLLER.get(), RenderCosmicThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(INFINITE_THERMAL_EVAPORATION_CONTROLLER.get(), RenderInfiniteThermalEvaporationPlant::new);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerContainers(RegisterEvent event) {
        event.register(Registries.MENU, helper -> {
            if (MoreThermalEvaporationCompat.EvolvedLoaded) {
                ClientRegistrationUtil.registerScreen(io.github.masyumero.morethermalevaporationcompat.evolved.common.registries.MoreThermalEvaporationCompatContainerTypes.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER, GuiOverclockedThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(io.github.masyumero.morethermalevaporationcompat.evolved.common.registries.MoreThermalEvaporationCompatContainerTypes.QUANTUM_THERMAL_EVAPORATION_CONTROLLER, GuiQuantumThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(io.github.masyumero.morethermalevaporationcompat.evolved.common.registries.MoreThermalEvaporationCompatContainerTypes.DENSE_THERMAL_EVAPORATION_CONTROLLER, GuiDenseThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(io.github.masyumero.morethermalevaporationcompat.evolved.common.registries.MoreThermalEvaporationCompatContainerTypes.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER, GuiMultiversalThermalEvaporationController::new);
            }
            if (MoreThermalEvaporationCompat.ExtrasLoaded) {
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, GuiAbsoluteThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.SUPREME_THERMAL_EVAPORATION_CONTROLLER, GuiSupremeThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.COSMIC_THERMAL_EVAPORATION_CONTROLLER, GuiCosmicThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.INFINITE_THERMAL_EVAPORATION_CONTROLLER, GuiInfiniteThermalEvaporationController::new);
            }
        });
    }
}