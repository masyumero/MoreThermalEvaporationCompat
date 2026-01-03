package io.github.masyumero.morethermalevaporationcompat.datagen.client.lang;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.MTECompatLang;
import io.github.masyumero.morethermalevaporationcompat.api.lang.MTECompatLangType;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatMultiPartType;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import net.minecraft.data.PackOutput;

public class MTECompatLangProvider extends BaseLanguageProvider {

    public MTECompatLangProvider(PackOutput output) {
        super(output, MoreThermalEvaporationCompat.MODID);
    }

    @Override
    protected void addTranslations() {
        addBlocks();
        addMisc();
    }

    private void addBlocks() {
        for (TETier tier : TETier.values()) {
            for (MTECompatMultiPartType type : MTECompatMultiPartType.values()) {
                add(MoreThermalEvaporationCompatBlocks.getBlock(tier, type), tier.getSimpleName().replace("_", " ") + " Thermal Evaporation " + type.getName());
            }
        }
    }

    private void addMisc() {
        add(MTECompatLang.CREATIVE_TAB, "More Thermal Evaporation Compat");
        for (TETier tier : TETier.values()) {
            add(MTECompatLang.getLang(tier, MTECompatLangType.TITLE),           "%s Thermal Evaporation".formatted(tier.getSimpleName().replace("_", " ")));
            add(MTECompatLang.getLang(tier, MTECompatLangType.DESC_BLOCK),      "A copper-alloyed casing used in the structure of a %s Thermal Evaporation Plant, using its advanced material to conduct the great amounts of heat necessary for processing.".formatted(tier.getSimpleName().replace("_", " ")));
            add(MTECompatLang.getLang(tier, MTECompatLangType.DESC_VALVE),      "A valve that can be placed on a %s Thermal Evaporation Plant multiblock, allowing for fluids to be inserted and extracted via external piping.".formatted(tier.getSimpleName().replace("_", " ")));
            add(MTECompatLang.getLang(tier, MTECompatLangType.DESC_CONTROLLER), "The controller for a %s Thermal Evaporation Plant, acting as the master block of the structure. Only one of these should be placed on a multiblock.".formatted(tier.getSimpleName().replace("_", " ")));
        }
    }
}
