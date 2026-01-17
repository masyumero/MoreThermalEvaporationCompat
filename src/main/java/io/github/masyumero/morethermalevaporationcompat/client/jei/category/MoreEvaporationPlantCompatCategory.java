package io.github.masyumero.morethermalevaporationcompat.client.jei.category;

import giselle.jei_mekanism_multiblocks.client.TooltipHelper;
import giselle.jei_mekanism_multiblocks.client.gui.CheckBoxWidget;
import giselle.jei_mekanism_multiblocks.client.gui.IntSliderWidget;
import giselle.jei_mekanism_multiblocks.client.gui.IntSliderWithButtons;
import giselle.jei_mekanism_multiblocks.client.jei.MultiblockCategory;
import giselle.jei_mekanism_multiblocks.client.jei.MultiblockWidget;
import giselle.jei_mekanism_multiblocks.client.jei.ResultWidget;
import giselle.jei_mekanism_multiblocks.client.jei.category.ICostConsumer;
import giselle.jei_mekanism_multiblocks.common.JEI_MekanismMultiblocks;
import giselle.jei_mekanism_multiblocks.common.util.VolumeTextHelper;
import io.github.masyumero.morethermalevaporationcompat.MTECompatLang;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.api.lang.MTECompatLangType;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import mekanism.api.heat.HeatAPI;
import mekanism.common.config.MekanismConfig;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.UnitDisplayUtils.TemperatureUnit;
import mekanism.common.util.text.TextUtils;
import mekanism.generators.common.registries.GeneratorsBlocks;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class MoreEvaporationPlantCompatCategory extends MultiblockCategory<MoreEvaporationPlantCompatCategory.MoreEvaporationPlantCompatWidget> {
    private final TETier tier;

    public MoreEvaporationPlantCompatCategory(IGuiHelper helper, TETier tier, Class<? extends MoreEvaporationPlantCompatWidget> widgetClass) {
        super(helper, MoreThermalEvaporationCompat.rl(tier.ordinal() + "_" + tier.getLowerName() + "_evaporation_plant"), widgetClass, MTECompatLang.getLang(tier, MTECompatLangType.TITLE).translate(), MoreThermalEvaporationCompatBlocks.getControllerBlock(tier).getItemStack());
        this.tier = tier;
    }

    @Override
    protected void getRecipeCatalystItemStacks(Consumer<ItemStack> consumer) {
        super.getRecipeCatalystItemStacks(consumer);
        consumer.accept(MoreThermalEvaporationCompatBlocks.getCasingBlock(tier).getItemStack());
        consumer.accept(MoreThermalEvaporationCompatBlocks.getValveBlock(tier).getItemStack());
        consumer.accept(MoreThermalEvaporationCompatBlocks.getControllerBlock(tier).getItemStack());
        consumer.accept(MekanismBlocks.STRUCTURAL_GLASS.getItemStack());

        if (JEI_MekanismMultiblocks.MekanismGeneratorsLoaded) {
            consumer.accept(GeneratorsBlocks.ADVANCED_SOLAR_GENERATOR.getItemStack());
        }
    }

    public static abstract class MoreEvaporationPlantCompatWidget extends MultiblockWidget {
        protected CheckBoxWidget useAdvancedSolarGeneratorCheckBox;
        protected IntSliderWithButtons valvesWidget;

        public MoreEvaporationPlantCompatWidget() {
        }

        protected abstract TETier getTier();

        @Override
        public int getSideBlocks() {
            // 1 Controller
            // 4 Empty top inner
            return super.getSideBlocks() - 5;
        }

        @Override
        protected void collectOtherConfigs(Consumer<AbstractWidget> consumer) {
            super.collectOtherConfigs(consumer);

            if (JEI_MekanismMultiblocks.MekanismGeneratorsLoaded) {
                consumer.accept(this.useAdvancedSolarGeneratorCheckBox = new CheckBoxWidget(0, 0, 0, 0, Component.translatable("text.jei_mekanism_multiblocks.specs.use_things", GeneratorsBlocks.ADVANCED_SOLAR_GENERATOR.getItemStack().getHoverName()), true));
                this.useAdvancedSolarGeneratorCheckBox.addSelectedChangedHandler(this::onUseAdvancedSolarGeneratorChanged);
            } else {
                this.useAdvancedSolarGeneratorCheckBox = new CheckBoxWidget(0, 0, 0, 0, Component.empty(), false);
                this.useAdvancedSolarGeneratorCheckBox.addSelectedChangedHandler(this::onUseAdvancedSolarGeneratorChanged);
            }

            consumer.accept(this.valvesWidget = new IntSliderWithButtons(0, 0, 0, 0, "text.jei_mekanism_multiblocks.specs.valves", 0, 2, 0));
            this.valvesWidget.getSlider().addValueChangeHanlder(this::onValvesChanged);

            this.updateValveSliderLimit();
        }

        @Override
        public void load(CompoundTag tag) {
            super.load(tag);

            this.setUseAdvancedSolarGenerator(tag.getBoolean("UseAdvancedSolarGenerator"));
            this.setValveCount(tag.getInt("ValveCount"));
        }

        @Override
        public void save(CompoundTag tag) {
            super.save(tag);

            tag.putBoolean("UseAdvancedSolarGenerator", this.isUseAdvancedSolarGenerator());
            tag.putInt("ValveCount", this.getValveCount());
        }

        @Override
        protected void onDimensionChanged() {
            super.onDimensionChanged();

            this.updateValveSliderLimit();
        }

        public void updateValveSliderLimit() {
            IntSliderWidget valvesSlider = this.valvesWidget.getSlider();
            int minValves = valvesSlider.getMinValue();
            int valves = valvesSlider.getValue();
            valvesSlider.setMinValue(this.useAdvancedSolarGeneratorCheckBox.isSelected() ? 2 : 3);
            valvesSlider.setMaxValue(this.getSideBlocks());
            valvesSlider.setValue(valves + (valvesSlider.getMinValue() - minValves));
        }

        protected void onValvesChanged(int valves) {
            this.markNeedUpdate();
        }

        @Override
        protected void onUseGlassChanged(boolean useGlass) {
            super.onUseGlassChanged(useGlass);
        }

        protected void onUseAdvancedSolarGeneratorChanged(boolean useAdvancedSolarGenerator) {
            this.markNeedUpdate();

            this.updateValveSliderLimit();
        }

        @Override
        protected void collectCost(ICostConsumer consumer) {
            super.collectCost(consumer);
            TETier tier = getTier();

            int corners = this.getCornerBlocks();
            int sides = this.getSideBlocks();
            int valves = this.getValveCount();
            sides -= valves;

            int casing = 0;
            int glasses = 0;
            int advancedSolarGenerators = 0;

            if (this.isUseGlass()) {
                casing = corners;
                glasses = sides;

                if (this.isUseAdvancedSolarGenerator()) {
                    // Replace top corner to solar generator
                    casing -= 4;
                    advancedSolarGenerators += 4;
                } else {
                    // Replace top side to glass
                    casing -= 8;
                    glasses += 8;
                }

            } else {
                // Remove top vertices
                casing = corners + sides - 4;

                if (this.isUseAdvancedSolarGenerator()) {
                    advancedSolarGenerators += 4;
                }

            }

            consumer.accept(new ItemStack(MoreThermalEvaporationCompatBlocks.getControllerBlock(tier), 1));
            consumer.accept(new ItemStack(MoreThermalEvaporationCompatBlocks.getValveBlock(tier), valves));
            consumer.accept(new ItemStack(MoreThermalEvaporationCompatBlocks.getCasingBlock(tier), casing));
            consumer.accept(new ItemStack(this.getGlassBlock(), glasses));

            if (JEI_MekanismMultiblocks.MekanismGeneratorsLoaded) {
                consumer.accept(new ItemStack(GeneratorsBlocks.ADVANCED_SOLAR_GENERATOR, advancedSolarGenerators));
            }

        }

        @Override
        protected void collectResult(Consumer<AbstractWidget> consumer) {
            super.collectResult(consumer);
            TETier tier = getTier();

            long dimHeight = this.getDimensionHeight();
            long inputCapacity = dimHeight * 4 * MekanismConfig.general.evaporationFluidPerTank.get();
            long outputCapacity = tier.getOutputTankCapacity();
            double maxTemp = tier.getMaxMultiplierTemp();

            double maxSpeed = (maxTemp - HeatAPI.AMBIENT_TEMP) * MekanismConfig.general.evaporationTempMultiplier.get() * ((double) dimHeight / TieredThermalEvaporationMultiblockData.MAX_HEIGHT);
            ResultWidget speedWidget = new ResultWidget(Component.translatable("text.jei_mekanism_multiblocks.result.max_speed"), Component.literal("x" + TextUtils.format(maxSpeed)));
            speedWidget.setTooltip(TooltipHelper.createMessageOnly(Component.translatable("text.jei_mekanism_multiblocks.tooltip.when_temp_ge", MekanismUtils.getTemperatureDisplay(maxTemp, TemperatureUnit.KELVIN, false))));
            consumer.accept(speedWidget);
            consumer.accept(new ResultWidget(Component.translatable("text.jei_mekanism_multiblocks.result.input_tank"), VolumeTextHelper.formatMB(inputCapacity)));
            consumer.accept(new ResultWidget(Component.translatable("text.jei_mekanism_multiblocks.result.output_tank"), VolumeTextHelper.formatMB(outputCapacity)));
        }

        public int getValveCount() {
            return this.valvesWidget.getSlider().getValue();
        }

        public void setValveCount(int valveCount) {
            this.valvesWidget.getSlider().setValue(valveCount);
        }

        public boolean isUseAdvancedSolarGenerator() {
            return JEI_MekanismMultiblocks.MekanismGeneratorsLoaded && this.useAdvancedSolarGeneratorCheckBox.isSelected();
        }

        public void setUseAdvancedSolarGenerator(boolean useAdvancedSolarGenerator) {
            this.useAdvancedSolarGeneratorCheckBox.setSelected(useAdvancedSolarGenerator);
        }

        @Override
        public int getDimensionWidthMin() {
            return 4;
        }

        @Override
        public int getDimensionWidthMax() {
            return 4;
        }

        @Override
        public int getDimensionLengthMin() {
            return 4;
        }

        @Override
        public int getDimensionLengthMax() {
            return 4;
        }

        @Override
        public int getDimensionHeightMin() {
            return 3;
        }

        @Override
        public int getDimensionHeightMax() {
            TETier tier = getTier();
            return tier.getHeight();
        }

        @Override
        public Block getGlassBlock() {
            return MekanismBlocks.STRUCTURAL_GLASS.getBlock();
        }
    }

    public static class AbsoluteEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.ABSOLUTE;
        }
    }

    public static class SupremeEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.SUPREME;
        }
    }

    public static class CosmicEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.COSMIC;
        }
    }

    public static class InfiniteEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.INFINITE;
        }
    }

    public static class OverclockedEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.OVERCLOCKED;
        }
    }

    public static class QuantumEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.QUANTUM;
        }
    }

    public static class DenseEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.DENSE;
        }
    }

    public static class MultiversalEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.MULTIVERSAL;
        }
    }

    public static class VibrationEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.VIBRATION;
        }
    }

    public static class ResonanceEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.RESONANCE;
        }
    }

    public static class IllusionEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.ILLUSION;
        }
    }

    public static class AbsoluteOverclockedEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.ABSOLUTE_OVERCLOCKED;
        }
    }

    public static class SupremeQuantumEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.SUPREME_QUANTUM;
        }
    }

    public static class CosmicDenseEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.COSMIC_DENSE;
        }
    }

    public static class InfiniteMultiversalEvaporationPlantWidget extends MoreEvaporationPlantCompatWidget {

        @Override
        protected TETier getTier() {
            return TETier.INFINITE_MULTIVERSAL;
        }
    }
}
