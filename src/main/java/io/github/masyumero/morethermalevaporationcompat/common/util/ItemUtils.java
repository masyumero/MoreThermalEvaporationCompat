package io.github.masyumero.morethermalevaporationcompat.common.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("removal")
public class ItemUtils {

    public static Item getItem(ResourceLocation resourceLocation) {
        return ForgeRegistries.ITEMS.getValue(resourceLocation);
    }

    public static Item getItem(String id) {
        String resourceId = id;
        if (id.contains("{") && id.endsWith("}")) {
            resourceId = id.substring(0, id.indexOf("{"));
        }

        return getItem(new ResourceLocation(resourceId));
    }
}
