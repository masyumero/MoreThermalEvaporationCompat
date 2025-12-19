package io.github.masyumero.morethermalevaporationcompat.extras.client;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.extras.client.gui.*;
import io.github.masyumero.morethermalevaporationcompat.extras.client.tileentity.*;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatContainerTypes;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatTileEntityTypes;
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
        event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER.get(), RenderAbsoluteThermalEvaporationPlant::new);
        event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.SUPREME_THERMAL_EVAPORATION_CONTROLLER.get(), RenderSupremeThermalEvaporationPlant::new);
        event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.COSMIC_THERMAL_EVAPORATION_CONTROLLER.get(), RenderCosmicThermalEvaporationPlant::new);
        event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.INFINITE_THERMAL_EVAPORATION_CONTROLLER.get(), RenderInfiniteThermalEvaporationPlant::new);
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerContainers(RegisterEvent event) {
        event.register(Registries.MENU, helper -> {
            ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, GuiAbsoluteThermalEvaporationController::new);
            ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.SUPREME_THERMAL_EVAPORATION_CONTROLLER, GuiSupremeThermalEvaporationController::new);
            ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.COSMIC_THERMAL_EVAPORATION_CONTROLLER, GuiCosmicThermalEvaporationController::new);
            ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.INFINITE_THERMAL_EVAPORATION_CONTROLLER, GuiInfiniteThermalEvaporationController::new);
        });
    }
}