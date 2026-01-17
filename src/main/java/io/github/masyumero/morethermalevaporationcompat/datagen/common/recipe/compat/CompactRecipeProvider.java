package io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.compat;

import astral_mekanism.registries.AstralMekanismItems;
import com.jerry.mekanism_extras.common.registry.ExtraItem;
import fr.iglee42.evolvedmekanism.registries.EMItems;
import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.api.datagen.recipe.builder.AstralCraftingRecipeBuilder;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.util.MTECompatEnumUtils;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.builder.ExtendedShapedRecipeBuilder;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.pattern.Pattern;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.pattern.RecipePattern;
import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import mekanism.common.tags.MekanismTags;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

@NothingNullByDefault
public class CompactRecipeProvider extends CompatRecipeProvider {

    private static final RecipePattern PATTERN = RecipePattern.createPattern(
            RecipePattern.TripleLine.of(Pattern.CONSTANT, Pattern.ALLOY, Pattern.CONSTANT),
            RecipePattern.TripleLine.of(Pattern.ALLOY, Pattern.PREVIOUS, Pattern.ALLOY),
            RecipePattern.TripleLine.of(Pattern.CONSTANT, Pattern.ALLOY, Pattern.CONSTANT)
    );

    private static final RecipePattern EMEXTRA_PATTERN = RecipePattern.createPattern(
            RecipePattern.TripleLine.of(Pattern.CONSTANT, Pattern.ALLOY1, Pattern.CONSTANT),
            RecipePattern.TripleLine.of(Pattern.ALLOY, Pattern.PREVIOUS, Pattern.ALLOY),
            RecipePattern.TripleLine.of(Pattern.CONSTANT, Pattern.ALLOY1, Pattern.CONSTANT)
    );

    public CompactRecipeProvider(String modid) {
        super(modid);
    }

    @Override
    protected void registerRecipes(Consumer<FinishedRecipe> consumer, String basePath) {
        basePath = basePath + "thermal_evaporation/";
        AstralCraftingRecipeBuilder.astralCrafting(
                        IngredientCreatorAccess.item().from(TETier.RESONANCE.getCompactBlock()),
                        new ItemStack(TETier.ILLUSION.getCompactBlock()))
                .build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "illusion/" + "compact"));
        tieredController(consumer, basePath);
    }

    private static void tieredController(Consumer<FinishedRecipe> consumer, String basePath) {
        for (TETier tier : MTECompatEnumUtils.THERMAL_EVAPORATION_TIERS) {
            switch (tier) {
                case BASIC -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, MekanismTags.Items.ALLOYS_BASIC).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case ADVANCED -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, MekanismTags.Items.ALLOYS_ADVANCED).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case ELITE ->  ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, MekanismTags.Items.ALLOYS_ELITE).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case ULTIMATE -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, MekanismTags.Items.ALLOYS_ULTIMATE).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case ABSOLUTE -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, ExtraItem.RADIANCE_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case SUPREME -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, ExtraItem.THERMONUCLEAR_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case COSMIC -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, ExtraItem.SHINING_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case INFINITE -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, ExtraItem.SPECTRUM_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case OVERCLOCKED -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, EMItems.HYPERCHARGED_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case QUANTUM -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, EMItems.SUBATOMIC_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case DENSE -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, EMItems.SINGULAR_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case MULTIVERSAL -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, EMItems.EXOVERSAL_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case VIBRATION -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, AstralMekanismItems.ELASTIC_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case RESONANCE -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, AstralMekanismItems.CONVERGENT_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case ABSOLUTE_OVERCLOCKED -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(EMEXTRA_PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, ExtraItem.RADIANCE_ALLOY).key(Pattern.ALLOY1, EMItems.HYPERCHARGED_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case SUPREME_QUANTUM -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(EMEXTRA_PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, ExtraItem.THERMONUCLEAR_ALLOY).key(Pattern.ALLOY1, EMItems.SUBATOMIC_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case COSMIC_DENSE -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(EMEXTRA_PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, ExtraItem.SHINING_ALLOY).key(Pattern.ALLOY1, EMItems.SINGULAR_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
                case INFINITE_MULTIVERSAL -> ExtendedShapedRecipeBuilder.shapedRecipe(tier.getCompactBlock()).pattern(EMEXTRA_PATTERN).key(Pattern.PREVIOUS, tier.getControllerBlock()).key(Pattern.ALLOY, ExtraItem.SPECTRUM_ALLOY).key(Pattern.ALLOY1, EMItems.EXOVERSAL_ALLOY).key(Pattern.CONSTANT, tier.getCasingBlock()).build(consumer, MoreThermalEvaporationCompat.rl(basePath + tier.getLowerName() + "/compact"));
            }
        }
    }
}
