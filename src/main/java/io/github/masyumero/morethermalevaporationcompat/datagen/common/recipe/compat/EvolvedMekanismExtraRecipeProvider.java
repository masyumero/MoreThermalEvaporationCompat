package io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.compat;

import com.jerry.mekanism_extras.common.registry.ExtraItem;
import fr.iglee42.evolvedmekanism.registries.EMItems;
import io.github.masyumero.emextras.common.registry.EMExtrasItem;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.builder.ExtendedShapedRecipeBuilder;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.impl.MTECompatRecipeProvider;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.pattern.Pattern;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.pattern.RecipePattern;
import mekanism.api.annotations.NothingNullByDefault;
import morethermalevaporation.common.registries.MoreThermalEvaporationBlocks;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

@NothingNullByDefault
public class EvolvedMekanismExtraRecipeProvider extends CompatRecipeProvider{

    private static final RecipePattern BLOCK_PATTERN = RecipePattern.createPattern(
            RecipePattern.TripleLine.of(Pattern.ALLOY, Pattern.CONSTANT, Pattern.ALLOY1),
            RecipePattern.TripleLine.of(Pattern.CONSTANT, Pattern.CIRCUIT, Pattern.CONSTANT),
            RecipePattern.TripleLine.of(Pattern.ALLOY1, Pattern.CONSTANT, Pattern.ALLOY));

    public EvolvedMekanismExtraRecipeProvider(String modid) {
        super(modid);
    }

    @Override
    protected void registerRecipes(Consumer<FinishedRecipe> consumer, String basePath) {
        basePath = basePath + "thermal_evaporation/";
        tieredBlock(consumer, basePath);
        tieredController(consumer, basePath);
        tieredValve(consumer, basePath);
    }

    private static void tieredBlock(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.ABSOLUTE_OVERCLOCKED), 4).pattern(BLOCK_PATTERN).key(Pattern.ALLOY, ExtraItem.RADIANCE_ALLOY).key(Pattern.ALLOY1, EMItems.HYPERCHARGED_ALLOY).key(Pattern.CIRCUIT, EMExtrasItem.ABSOLUTE_OVERCLOCKED_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_BLOCK).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute_overclocked/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.SUPREME_QUANTUM), 4).pattern(BLOCK_PATTERN).key(Pattern.ALLOY, ExtraItem.THERMONUCLEAR_ALLOY).key(Pattern.ALLOY1, EMItems.SUBATOMIC_ALLOY).key(Pattern.CIRCUIT, EMExtrasItem.SUPREME_QUANTUM_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.ABSOLUTE_OVERCLOCKED)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme_quantum/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.COSMIC_DENSE), 4).pattern(BLOCK_PATTERN).key(Pattern.ALLOY, ExtraItem.SHINING_ALLOY).key(Pattern.ALLOY1, EMItems.SINGULAR_ALLOY).key(Pattern.CIRCUIT, EMExtrasItem.COSMIC_DENSE_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.SUPREME_QUANTUM)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic_dense/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.INFINITE_MULTIVERSAL), 4).pattern(BLOCK_PATTERN).key(Pattern.ALLOY, ExtraItem.SPECTRUM_ALLOY).key(Pattern.ALLOY1, EMItems.EXOVERSAL_ALLOY).key(Pattern.CIRCUIT, EMExtrasItem.INFINITE_MULTIVERSAL_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.COSMIC_DENSE)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite_multiversal/block"));
    }

    private static void tieredController(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.ABSOLUTE_OVERCLOCKED)).controllerPattern().key(Pattern.CIRCUIT, EMExtrasItem.ABSOLUTE_OVERCLOCKED_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_CONTROLLER).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.ABSOLUTE_OVERCLOCKED)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute_overclocked/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.SUPREME_QUANTUM)).controllerPattern().key(Pattern.CIRCUIT, EMExtrasItem.SUPREME_QUANTUM_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.ABSOLUTE_OVERCLOCKED)).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.SUPREME_QUANTUM)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme_quantum/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.COSMIC_DENSE)).controllerPattern().key(Pattern.CIRCUIT, EMExtrasItem.COSMIC_DENSE_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.SUPREME_QUANTUM)).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.COSMIC_DENSE)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic_dense/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.INFINITE_MULTIVERSAL)).controllerPattern().key(Pattern.CIRCUIT, EMExtrasItem.INFINITE_MULTIVERSAL_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.COSMIC_DENSE)).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.INFINITE_MULTIVERSAL)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite_multiversal/controller"));
    }

    private static void tieredValve(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.ABSOLUTE_OVERCLOCKED)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.ABSOLUTE_OVERCLOCKED)).key(Pattern.OTHER, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_VALVE).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute_overclocked/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.SUPREME_QUANTUM)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.SUPREME_QUANTUM)).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.ABSOLUTE_OVERCLOCKED)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme_quantum/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.COSMIC_DENSE)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.COSMIC_DENSE)).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.SUPREME_QUANTUM)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic_dense/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.INFINITE_MULTIVERSAL)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.INFINITE_MULTIVERSAL)).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.COSMIC_DENSE)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite_multiversal/valve"));
    }
}
