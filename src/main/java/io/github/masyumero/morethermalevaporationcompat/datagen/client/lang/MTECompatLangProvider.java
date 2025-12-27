package io.github.masyumero.morethermalevaporationcompat.datagen.client.lang;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompatLang;
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
                add(MoreThermalEvaporationCompatBlocks.getBlock(tier, type), tier.getSimpleName() + " Thermal Evaporation " + type.getName());
            }
        }
    }

    private void addMisc() {
        add(MoreThermalEvaporationCompatLang.CREATIVE_TAB, "More Thermal Evaporation Compat");
        add(MoreThermalEvaporationCompatLang.ABSOLUTE_EVAPORATION, "Absolute Thermal Evaporation");
        add(MoreThermalEvaporationCompatLang.SUPREME_EVAPORATION, "Supreme Thermal Evaporation");
        add(MoreThermalEvaporationCompatLang.COSMIC_EVAPORATION, "Cosmic Thermal Evaporation");
        add(MoreThermalEvaporationCompatLang.INFINITE_EVAPORATION, "Infinite Thermal Evaporation");
        add(MoreThermalEvaporationCompatLang.OVERCLOCKED_EVAPORATION, "Overclocked Thermal Evaporation");
        add(MoreThermalEvaporationCompatLang.QUANTUM_EVAPORATION, "Quantum Thermal Evaporation");
        add(MoreThermalEvaporationCompatLang.DENSE_EVAPORATION, "Dense Thermal Evaporation");
        add(MoreThermalEvaporationCompatLang.MULTIVERSAL_EVAPORATION, "Multiversal Thermal Evaporation");
    }
}
