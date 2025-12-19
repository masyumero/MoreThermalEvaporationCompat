package io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.compat;

import com.jerry.mekanism_extras.common.registry.ExtraItem;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.builder.ExtendedShapedRecipeBuilder;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.impl.MTECompatRecipeProvider;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.pattern.Pattern;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.pattern.RecipePattern;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.pattern.RecipePattern.TripleLine;
import io.github.masyumero.morethermalevaporationcompat.extras.common.registries.MoreThermalEvaporationCompatBlocks;
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

    private static final RecipePattern BLOCK_PATTERN = RecipePattern.createPattern(
            TripleLine.of(Pattern.ALLOY, Pattern.CONSTANT, Pattern.ALLOY),
            TripleLine.of(Pattern.CONSTANT, Pattern.CIRCUIT, Pattern.CONSTANT),
            TripleLine.of(Pattern.ALLOY, Pattern.CONSTANT, Pattern.ALLOY));

    private static final RecipePattern CONTROLLER_PATTERN = RecipePattern.createPattern(
            TripleLine.of(Pattern.CIRCUIT, MTECompatRecipeProvider.GLASS_CHAR, Pattern.CIRCUIT),
            TripleLine.of(Pattern.CONSTANT, Pattern.OTHER, Pattern.CONSTANT),
            TripleLine.of(Pattern.CONSTANT, Pattern.CONSTANT, Pattern.CONSTANT));

    private static final RecipePattern VALVE_PATTERN = RecipePattern.createPattern(
            TripleLine.of(Pattern.EMPTY, Pattern.CONSTANT, Pattern.EMPTY),
            TripleLine.of(Pattern.CONSTANT, Pattern.OTHER, Pattern.CONSTANT),
            TripleLine.of(Pattern.EMPTY, Pattern.CONSTANT, Pattern.EMPTY));

    @Override
    protected void registerRecipes(Consumer<FinishedRecipe> consumer, String basePath) {
        basePath = basePath + "thermal_evaporation/";
        TieredBlock(consumer, basePath);
        TieredController(consumer, basePath);
        TieredValve(consumer, basePath);
    }

    private static void TieredBlock(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_BLOCK, 4).pattern(BLOCK_PATTERN).key(Pattern.ALLOY, ExtraItem.RADIANCE_ALLOY).key(Pattern.CIRCUIT, ExtraItem.ABSOLUTE_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_BLOCK).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_BLOCK, 4).pattern(BLOCK_PATTERN).key(Pattern.ALLOY, ExtraItem.THERMONUCLEAR_ALLOY).key(Pattern.CIRCUIT, ExtraItem.SUPREME_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_BLOCK).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_BLOCK, 4).pattern(BLOCK_PATTERN).key(Pattern.ALLOY, ExtraItem.SHINING_ALLOY).key(Pattern.CIRCUIT, ExtraItem.COSMIC_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_BLOCK).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_BLOCK, 4).pattern(BLOCK_PATTERN).key(Pattern.ALLOY, ExtraItem.SPECTRUM_ALLOY).key(Pattern.CIRCUIT, ExtraItem.INFINITE_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_BLOCK).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite/block"));
    }

    private static void TieredController(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER).pattern(CONTROLLER_PATTERN).key(Pattern.CIRCUIT, ExtraItem.ABSOLUTE_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_CONTROLLER).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_BLOCK).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_CONTROLLER).pattern(CONTROLLER_PATTERN).key(Pattern.CIRCUIT, ExtraItem.SUPREME_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_BLOCK).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_CONTROLLER).pattern(CONTROLLER_PATTERN).key(Pattern.CIRCUIT, ExtraItem.COSMIC_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_CONTROLLER).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_BLOCK).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_CONTROLLER).pattern(CONTROLLER_PATTERN).key(Pattern.CIRCUIT, ExtraItem.INFINITE_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_CONTROLLER).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_BLOCK).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite/controller"));
    }

    private static void TieredValve(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_VALVE).pattern(VALVE_PATTERN).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_BLOCK).key(Pattern.OTHER, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_VALVE).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_VALVE).pattern(VALVE_PATTERN).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_BLOCK).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_VALVE).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_VALVE).pattern(VALVE_PATTERN).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_BLOCK).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.SUPREME_THERMAL_EVAPORATION_VALVE).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_VALVE).pattern(VALVE_PATTERN).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.INFINITE_THERMAL_EVAPORATION_BLOCK).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.COSMIC_THERMAL_EVAPORATION_VALVE).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite/valve"));
    }
}
