package io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.compat;

import fr.iglee42.evolvedmekanism.registries.EMItems;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.builder.ExtendedShapedRecipeBuilder;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.impl.MTECompatRecipeProvider;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.pattern.Pattern;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
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
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.OVERCLOCKED), 4).blockPattern().key(Pattern.ALLOY, EMItems.HYPERCHARGED_ALLOY).key(Pattern.CIRCUIT, EMItems.OVERCLOCKED_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_BLOCK).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.QUANTUM), 4).blockPattern().key(Pattern.ALLOY, EMItems.SUBATOMIC_ALLOY).key(Pattern.CIRCUIT, EMItems.QUANTUM_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.OVERCLOCKED)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.DENSE), 4).blockPattern().key(Pattern.ALLOY, EMItems.SINGULAR_ALLOY).key(Pattern.CIRCUIT, EMItems.DENSE_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.QUANTUM)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.MULTIVERSAL), 4).blockPattern().key(Pattern.ALLOY, EMItems.EXOVERSAL_ALLOY).key(Pattern.CIRCUIT, EMItems.MULTIVERSAL_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.DENSE)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite/block"));
    }

    private static void TieredController(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.OVERCLOCKED)).controllerPattern().key(Pattern.CIRCUIT, EMItems.OVERCLOCKED_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_CONTROLLER).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.OVERCLOCKED)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.QUANTUM)).controllerPattern().key(Pattern.CIRCUIT, EMItems.QUANTUM_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.OVERCLOCKED)).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.QUANTUM)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.DENSE)).controllerPattern().key(Pattern.CIRCUIT, EMItems.DENSE_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.QUANTUM)).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.DENSE)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.MULTIVERSAL)).controllerPattern().key(Pattern.CIRCUIT, EMItems.MULTIVERSAL_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.DENSE)).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.MULTIVERSAL)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite/controller"));
    }

    private static void TieredValve(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.OVERCLOCKED)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.OVERCLOCKED)).key(Pattern.OTHER, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_VALVE).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "absolute/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.QUANTUM)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.QUANTUM)).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.OVERCLOCKED)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "supreme/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.DENSE)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.DENSE)).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.QUANTUM)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "cosmic/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.MULTIVERSAL)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.MULTIVERSAL)).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.DENSE)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "infinite/valve"));
    }
}
