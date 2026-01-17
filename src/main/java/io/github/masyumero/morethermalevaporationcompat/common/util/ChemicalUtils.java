package io.github.masyumero.morethermalevaporationcompat.common.util;

import mekanism.api.MekanismAPI;
import mekanism.api.chemical.gas.Gas;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("removal")
public class ChemicalUtils {

    public static Gas getGas(ResourceLocation resourceLocation) {
        return MekanismAPI.gasRegistry().getValue(resourceLocation);
    }

    public static Gas getGas(String id) {
        String resourceId = id;
        if (id.contains("{") && id.endsWith("}")) {
            resourceId = id.substring(0, id.indexOf("{"));
        }

        return getGas(new ResourceLocation(resourceId));
    }
}
