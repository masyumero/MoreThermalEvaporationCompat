package io.github.masyumero.morethermalevaporationcompat.client.gui;

import io.github.masyumero.morethermalevaporationcompat.common.tile.TileEntityTieredCompactThermalEvaporation;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.client.gui.GuiConfigurableTile;
import mekanism.client.gui.element.GuiDownArrow;
import mekanism.client.gui.element.GuiInnerScreen;
import mekanism.client.gui.element.bar.GuiBar;
import mekanism.client.gui.element.bar.GuiHorizontalRateBar;
import mekanism.client.gui.element.gauge.GaugeType;
import mekanism.client.gui.element.gauge.GuiFluidGauge;
import mekanism.client.gui.element.tab.GuiHeatTab;
import mekanism.client.gui.element.tab.GuiWarningTab;
import mekanism.common.MekanismLang;
import mekanism.common.content.evaporation.EvaporationMultiblockData;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.inventory.warning.IWarningTracker;
import mekanism.common.inventory.warning.WarningTracker;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.UnitDisplayUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;

public class GuiTieredCompactThermalEvaporation extends GuiConfigurableTile<TileEntityTieredCompactThermalEvaporation, MekanismTileContainer<TileEntityTieredCompactThermalEvaporation>> {

    public GuiTieredCompactThermalEvaporation(MekanismTileContainer<TileEntityTieredCompactThermalEvaporation> container, Inventory inv, Component title) {
        super(container, inv, title);
        inventoryLabelY += 2;
        titleLabelY = 4;
        dynamicSlots = true;
    }

    @Override
    protected void addGuiElements() {
        super.addGuiElements();
        addRenderableWidget(new GuiInnerScreen(this, 48, 19, 80, 40, () ->
                List.of(MekanismLang.MULTIBLOCK_FORMED.translate(), MekanismLang.EVAPORATION_HEIGHT.translate(18),
                        MekanismLang.TEMPERATURE.translate(MekanismUtils.getTemperatureDisplay(tile.getTemperature(), UnitDisplayUtils.TemperatureUnit.KELVIN, true)),
                        MekanismLang.FLUID_PRODUCTION.translate(Math.round(tile.lastGain * 100D) / 100D))).spacing(1));
        addRenderableWidget(new GuiDownArrow(this, 32, 39));
        addRenderableWidget(new GuiDownArrow(this, 136, 39));
        addRenderableWidget(new GuiHorizontalRateBar(this, new GuiBar.IBarInfoHandler() {
            @Override
            public Component getTooltip() {
                return MekanismUtils.getTemperatureDisplay(tile.getTemperature(), UnitDisplayUtils.TemperatureUnit.KELVIN, true);
            }

            @Override
            public double getLevel() {
                return Math.min(1, tile.getTemperature() / EvaporationMultiblockData.MAX_MULTIPLIER_TEMP);
            }
        }, 48, 63))
                //Note: We just apply this warning to the bar as we don't have an arrow or anything here
                .warning(WarningTracker.WarningType.INPUT_DOESNT_PRODUCE_OUTPUT, getWarningCheck(CachedRecipe.OperationTracker.RecipeError.INPUT_DOESNT_PRODUCE_OUTPUT));
        addRenderableWidget(new GuiFluidGauge(() -> tile.inputTank, () -> tile.getFluidTanks(null), GaugeType.STANDARD, this, 6, 13))
                .warning(WarningTracker.WarningType.NO_MATCHING_RECIPE, getWarningCheck(CachedRecipe.OperationTracker.RecipeError.NOT_ENOUGH_INPUT));
        addRenderableWidget(new GuiFluidGauge(() -> tile.outputTank, () -> tile.getFluidTanks(null), GaugeType.STANDARD, this, 152, 13))
                .warning(WarningTracker.WarningType.NO_SPACE_IN_OUTPUT, getWarningCheck(CachedRecipe.OperationTracker.RecipeError.NOT_ENOUGH_OUTPUT_SPACE));
        addRenderableWidget(new GuiHeatTab(this, () -> {
            Component environment = MekanismUtils.getTemperatureDisplay(tile.lastEnvironmentLoss, UnitDisplayUtils.TemperatureUnit.KELVIN, false);
            return Collections.singletonList(MekanismLang.DISSIPATED_RATE.translate(environment));
        }));
    }

    private BooleanSupplier getWarningCheck(CachedRecipe.OperationTracker.RecipeError error) {
        return () -> tile.hasWarning(error);
    }

    @Override
    protected void addWarningTab(IWarningTracker warningTracker) {
        //Put warning tab where the energy tab is as we don't have energy
        addRenderableWidget(new GuiWarningTab(this, warningTracker, 137));
    }

    @Override
    protected void drawForegroundText(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {
        renderTitleText(guiGraphics);
        drawString(guiGraphics, playerInventoryTitle, inventoryLabelX, inventoryLabelY, titleTextColor());
        super.drawForegroundText(guiGraphics, mouseX, mouseY);
    }
}