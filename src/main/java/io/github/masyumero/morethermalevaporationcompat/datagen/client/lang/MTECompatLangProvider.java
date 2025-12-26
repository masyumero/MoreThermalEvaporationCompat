package io.github.masyumero.morethermalevaporationcompat.datagen.client.lang;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompatLang;
import mekanism.api.providers.IBlockProvider;
import net.minecraft.data.PackOutput;

import static io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks.*;

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
        addExtraTiered(ABSOLUTE_THERMAL_EVAPORATION_BLOCK, SUPREME_THERMAL_EVAPORATION_BLOCK, COSMIC_THERMAL_EVAPORATION_BLOCK, INFINITE_THERMAL_EVAPORATION_BLOCK, "Thermal Evaporation Block");
        addExtraTiered(ABSOLUTE_THERMAL_EVAPORATION_VALVE, SUPREME_THERMAL_EVAPORATION_VALVE, COSMIC_THERMAL_EVAPORATION_VALVE, INFINITE_THERMAL_EVAPORATION_VALVE, "Thermal Evaporation Valve");
        addExtraTiered(ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER, SUPREME_THERMAL_EVAPORATION_CONTROLLER, COSMIC_THERMAL_EVAPORATION_CONTROLLER, INFINITE_THERMAL_EVAPORATION_CONTROLLER, "Thermal Evaporation Controller");
        addEvolvedTiered(OVERCLOCKED_THERMAL_EVAPORATION_BLOCK, QUANTUM_THERMAL_EVAPORATION_BLOCK, DENSE_THERMAL_EVAPORATION_BLOCK, MULTIVERSAL_THERMAL_EVAPORATION_BLOCK, "Thermal Evaporation Block");
        addEvolvedTiered(OVERCLOCKED_THERMAL_EVAPORATION_VALVE, QUANTUM_THERMAL_EVAPORATION_VALVE, DENSE_THERMAL_EVAPORATION_VALVE, MULTIVERSAL_THERMAL_EVAPORATION_VALVE, "Thermal Evaporation Valve");
        addEvolvedTiered(OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER, QUANTUM_THERMAL_EVAPORATION_CONTROLLER, DENSE_THERMAL_EVAPORATION_CONTROLLER, MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER, "Thermal Evaporation Controller");
    }

    private void addMisc() {
        add(MoreThermalEvaporationCompatLang.CREATIVE_TAB, "More Thermal Evaporation Compat");
        add(MoreThermalEvaporationCompatLang.ABSOLUTEEVAPORATION, "Absolute Thermal Evaporation");
    }

    private void addExtraTiered(IBlockProvider absolute, IBlockProvider supreme, IBlockProvider cosmic, IBlockProvider infinite, String name) {
        add(absolute, "Absolute " + name);
        add(supreme, "Supreme " + name);
        add(cosmic, "Cosmic " + name);
        add(infinite, "Infinite " + name);
    }

    private void addEvolvedTiered(IBlockProvider absolute, IBlockProvider supreme, IBlockProvider cosmic, IBlockProvider infinite, String name) {
        add(absolute, "Overclocked " + name);
        add(supreme, "Quantum " + name);
        add(cosmic, "Dense " + name);
        add(infinite, "Multiversal " + name);
    }
}
