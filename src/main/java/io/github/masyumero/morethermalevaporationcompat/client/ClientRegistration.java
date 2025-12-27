package io.github.masyumero.morethermalevaporationcompat.client;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.client.gui.GuiTieredThermalEvaporationController;
import io.github.masyumero.morethermalevaporationcompat.client.tileentity.RenderTieredThermalEvaporationPlant;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatContainerTypes;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatTileEntityTypes;
import io.github.masyumero.morethermalevaporationcompat.EvolvedModule;
import io.github.masyumero.morethermalevaporationcompat.ExtrasModule;
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
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER.get(), RenderTieredThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.QUANTUM_THERMAL_EVAPORATION_CONTROLLER.get(), RenderTieredThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.DENSE_THERMAL_EVAPORATION_CONTROLLER.get(), RenderTieredThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER.get(), RenderTieredThermalEvaporationPlant::new);
        }
        if (ExtrasModule.ExtrasLoaded) {
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER.get(), RenderTieredThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.SUPREME_THERMAL_EVAPORATION_CONTROLLER.get(), RenderTieredThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.COSMIC_THERMAL_EVAPORATION_CONTROLLER.get(), RenderTieredThermalEvaporationPlant::new);
            event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.INFINITE_THERMAL_EVAPORATION_CONTROLLER.get(), RenderTieredThermalEvaporationPlant::new);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerContainers(RegisterEvent event) {
        event.register(Registries.MENU, helper -> {
            if (EvolvedModule.EvolvedLoaded) {
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER, GuiTieredThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.QUANTUM_THERMAL_EVAPORATION_CONTROLLER, GuiTieredThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.DENSE_THERMAL_EVAPORATION_CONTROLLER, GuiTieredThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER, GuiTieredThermalEvaporationController::new);
            }
            if (ExtrasModule.ExtrasLoaded) {
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, GuiTieredThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.SUPREME_THERMAL_EVAPORATION_CONTROLLER, GuiTieredThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.COSMIC_THERMAL_EVAPORATION_CONTROLLER, GuiTieredThermalEvaporationController::new);
                ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.INFINITE_THERMAL_EVAPORATION_CONTROLLER, GuiTieredThermalEvaporationController::new);
            }
        });
    }
}