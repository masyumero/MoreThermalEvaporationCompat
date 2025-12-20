package io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.compat;

import fr.iglee42.evolvedmekanism.registries.EMItems;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.builder.ExtendedShapedRecipeBuilder;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.impl.MTECompatRecipeProvider;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.pattern.Pattern;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.registries.MoreThermalEvaporationCompatBlocks;
import mekanism.api.annotations.NothingNullByDefault;
import morethermalevaporation.common.registries.MoreThermalEvaporationBlocks;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

@NothingNullByDefault
public class EvolvedMekanismRecipeProvider extends CompatRecipeProvider {
    
    public EvolvedMekanismRecipeProvider(String modid) {
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
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_BLOCK, 4).blockPattern().key(Pattern.ALLOY, EMItems.HYPERCHARGED_ALLOY).key(Pattern.CIRCUIT, EMItems.OVERCLOCKED_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_BLOCK).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_BLOCK, 4).blockPattern().key(Pattern.ALLOY, EMItems.SUBATOMIC_ALLOY).key(Pattern.CIRCUIT, EMItems.QUANTUM_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_BLOCK).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_BLOCK, 4).blockPattern().key(Pattern.ALLOY, EMItems.SINGULAR_ALLOY).key(Pattern.CIRCUIT, EMItems.DENSE_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_BLOCK).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_BLOCK, 4).blockPattern().key(Pattern.ALLOY, EMItems.EXOVERSAL_ALLOY).key(Pattern.CIRCUIT, EMItems.MULTIVERSAL_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_BLOCK).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite/block"));
    }

    private static void TieredController(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER).controllerPattern().key(Pattern.CIRCUIT, EMItems.OVERCLOCKED_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_CONTROLLER).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_BLOCK).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_CONTROLLER).controllerPattern().key(Pattern.CIRCUIT, EMItems.QUANTUM_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_CONTROLLER).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_BLOCK).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_CONTROLLER).controllerPattern().key(Pattern.CIRCUIT, EMItems.DENSE_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_CONTROLLER).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_BLOCK).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_CONTROLLER).controllerPattern().key(Pattern.CIRCUIT, EMItems.MULTIVERSAL_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_CONTROLLER).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_BLOCK).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite/controller"));
    }

    private static void TieredValve(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_VALVE).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_BLOCK).key(Pattern.OTHER, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_VALVE).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_VALVE).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_BLOCK).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.OVERCLOCKED_THERMAL_EVAPORATION_VALVE).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_VALVE).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_BLOCK).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.QUANTUM_THERMAL_EVAPORATION_VALVE).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_VALVE).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.MULTIVERSAL_THERMAL_EVAPORATION_BLOCK).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.DENSE_THERMAL_EVAPORATION_VALVE).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite/valve"));
    }
}
