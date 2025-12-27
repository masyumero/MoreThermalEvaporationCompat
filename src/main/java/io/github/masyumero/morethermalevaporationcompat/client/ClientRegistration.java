package io.github.masyumero.morethermalevaporationcompat.client;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.client.gui.GuiTieredThermalEvaporationController;
import io.github.masyumero.morethermalevaporationcompat.client.tileentity.RenderTieredThermalEvaporationPlant;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatContainerTypes;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatTileEntityTypes;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
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
        for (TETier tier : TETier.values()) {
            if (tier.isModLoaded()) {
                event.registerBlockEntityRenderer(MoreThermalEvaporationCompatTileEntityTypes.getControllerTileEntityType(tier).get(), RenderTieredThermalEvaporationPlant::new);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerContainers(RegisterEvent event) {
        event.register(Registries.MENU, helper -> {
            for (TETier tier : TETier.values()) {
                if (tier.isModLoaded()) {
                    ClientRegistrationUtil.registerScreen(MoreThermalEvaporationCompatContainerTypes.getContainerType(tier), GuiTieredThermalEvaporationController::new);
                }
            }
        });
    }
}