package io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.compat;

import com.jerry.mekanism_extras.common.registry.ExtraItem;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.builder.ExtendedShapedRecipeBuilder;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.impl.MTECompatRecipeProvider;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.pattern.Pattern;
import mekanism.api.annotations.NothingNullByDefault;
import morethermalevaporation.common.registries.MoreThermalEvaporationBlocks;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

@NothingNullByDefault
public class MekanismExtrasRecipeProvider extends CompatRecipeProvider {

    public MekanismExtrasRecipeProvider(String modid) {
        super(modid);
    }

    @Override
    protected void registerRecipes(Consumer<FinishedRecipe> consumer, String basePath) {
        basePath = basePath + "thermal_evaporation/";
        TieredBlock(consumer, basePath);
        TieredController(consumer, basePath);
        TieredValve(consumer, basePath);
    }

    private static void TieredBlock(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.ABSOLUTE), 4).blockPattern().key(Pattern.ALLOY, ExtraItem.RADIANCE_ALLOY).key(Pattern.CIRCUIT, ExtraItem.ABSOLUTE_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_BLOCK).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.SUPREME), 4).blockPattern().key(Pattern.ALLOY, ExtraItem.THERMONUCLEAR_ALLOY).key(Pattern.CIRCUIT, ExtraItem.SUPREME_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.ABSOLUTE)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.COSMIC), 4).blockPattern().key(Pattern.ALLOY, ExtraItem.SHINING_ALLOY).key(Pattern.CIRCUIT, ExtraItem.COSMIC_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.SUPREME)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.INFINITE), 4).blockPattern().key(Pattern.ALLOY, ExtraItem.SPECTRUM_ALLOY).key(Pattern.CIRCUIT, ExtraItem.INFINITE_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.COSMIC)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite/block"));
    }

    private static void TieredController(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.ABSOLUTE)).controllerPattern().key(Pattern.CIRCUIT, ExtraItem.ABSOLUTE_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_CONTROLLER).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.ABSOLUTE)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.SUPREME)).controllerPattern().key(Pattern.CIRCUIT, ExtraItem.SUPREME_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.ABSOLUTE)).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.SUPREME)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.COSMIC)).controllerPattern().key(Pattern.CIRCUIT, ExtraItem.COSMIC_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.SUPREME)).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.COSMIC)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.INFINITE)).controllerPattern().key(Pattern.CIRCUIT, ExtraItem.INFINITE_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.COSMIC)).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.INFINITE)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite/controller"));
    }

    private static void TieredValve(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.ABSOLUTE)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.ABSOLUTE)).key(Pattern.OTHER, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_VALVE).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.SUPREME)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.SUPREME)).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.ABSOLUTE)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.COSMIC)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.COSMIC)).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.SUPREME)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.INFINITE)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.INFINITE)).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.COSMIC)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite/valve"));
    }
}
