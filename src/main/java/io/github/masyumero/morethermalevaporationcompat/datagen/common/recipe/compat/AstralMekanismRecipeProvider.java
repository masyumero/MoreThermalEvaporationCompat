package io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.compat;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.api.datagen.recipe.builder.AstralCraftingRecipeBuilder;
import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatMultiPartType;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.util.ItemUtils;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.builder.ExtendedShapedRecipeBuilder;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.impl.MTECompatRecipeProvider;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.pattern.Pattern;
import io.github.masyumero.morethermalevaporationcompat.mixin.accessor.AccessorAstralMekanismGases;
import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.recipes.ingredients.ItemStackIngredient;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import morethermalevaporation.common.registries.MoreThermalEvaporationBlocks;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static astral_mekanism.registries.AstralMekanismItems.*;
import static com.jerry.mekanism_extras.common.registry.ExtraItem.SPECTRUM_ALLOY;
import static fr.iglee42.evolvedmekanism.registries.EMItems.EXOVERSAL_ALLOY;
import static io.github.masyumero.emextras.common.registry.EMExtrasItem.INFINITE_MULTIVERSAL_CONTROL_CIRCUIT;

@NothingNullByDefault
public class AstralMekanismRecipeProvider extends CompatRecipeProvider{

    public AstralMekanismRecipeProvider(String modid) {
        super(modid);
    }

    @Override
    protected void registerRecipes(Consumer<FinishedRecipe> consumer, String basePath) {
        basePath = basePath + "thermal_evaporation/";
        for (MTECompatMultiPartType type : MTECompatMultiPartType.values()) {
            AstralCraftingRecipeBuilder.astralCrafting(new ItemStackIngredient[]{
                    IngredientCreatorAccess.item().from(ELASTIC_ALLOY, 64) , IngredientCreatorAccess.item().from(EXOVERSAL_ALLOY, 64),IngredientCreatorAccess.item().from(ItemUtils.getItem("ae2:singularity"), 64),IngredientCreatorAccess.item().from(EXOVERSAL_ALLOY, 64),IngredientCreatorAccess.item().from(ELASTIC_ALLOY, 64),
                    IngredientCreatorAccess.item().from(SPECTRUM_ALLOY, 64) , IngredientCreatorAccess.item().from(STARDUST_ALLOY),IngredientCreatorAccess.item().from(ILLUSION_CONTROL_CIRCUIT),IngredientCreatorAccess.item().from(STARDUST_ALLOY),IngredientCreatorAccess.item().from(SPECTRUM_ALLOY, 64),
                    IngredientCreatorAccess.item().from(INFINITE_MULTIVERSAL_CONTROL_CIRCUIT, 64) , IngredientCreatorAccess.item().from(SPACETIME_MODULATION_CORE),IngredientCreatorAccess.item().from(MoreThermalEvaporationCompatBlocks.getBlock(TETier.RESONANCE, type)),IngredientCreatorAccess.item().from(SPACETIME_MODULATION_CORE),IngredientCreatorAccess.item().from(INFINITE_MULTIVERSAL_CONTROL_CIRCUIT, 64),
                    IngredientCreatorAccess.item().from(SPECTRUM_ALLOY, 64) , IngredientCreatorAccess.item().from(STARDUST_ALLOY),IngredientCreatorAccess.item().from(ILLUSION_CONTROL_CIRCUIT),IngredientCreatorAccess.item().from(STARDUST_ALLOY),IngredientCreatorAccess.item().from(SPECTRUM_ALLOY, 64),
                    IngredientCreatorAccess.item().from(ELASTIC_ALLOY, 64) , IngredientCreatorAccess.item().from(EXOVERSAL_ALLOY, 64),IngredientCreatorAccess.item().from(ItemUtils.getItem("ae2:singularity"), 64),IngredientCreatorAccess.item().from(EXOVERSAL_ALLOY, 64),IngredientCreatorAccess.item().from(ELASTIC_ALLOY, 64),
            },IngredientCreatorAccess.fluid().from(Fluids.LAVA, 10000),
                    IngredientCreatorAccess.gas().from(AccessorAstralMekanismGases.getAstralEther().get(), 10000),
                    new ItemStack(MoreThermalEvaporationCompatBlocks.getBlock(TETier.ILLUSION, type)))
                    .build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "illusion/" + type.getLowerName()));
        }
        tieredBlock(consumer, basePath);
        tieredController(consumer, basePath);
        tieredValve(consumer, basePath);
    }

    private static void tieredBlock(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.VIBRATION), 4).blockPattern().key(Pattern.ALLOY, ELASTIC_ALLOY).key(Pattern.CIRCUIT, VIBRATION_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_BLOCK).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "resonance/block"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.RESONANCE), 4).blockPattern().key(Pattern.ALLOY, CONVERGENT_ALLOY).key(Pattern.CIRCUIT, RESONANCE_CONTROL_CIRCUIT).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.VIBRATION)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "vibration/block"));
    }

    private static void tieredController(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.VIBRATION)).controllerPattern().key(Pattern.CIRCUIT, VIBRATION_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_CONTROLLER).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.VIBRATION)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "resonance/controller"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.RESONANCE)).controllerPattern().key(Pattern.CIRCUIT, RESONANCE_CONTROL_CIRCUIT).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getControllerBlock(TETier.VIBRATION)).key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.RESONANCE)).key(MTECompatRecipeProvider.GLASS_CHAR, Tags.Items.GLASS_PANES).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "vibration/controller"));
    }

    private static void tieredValve(Consumer<FinishedRecipe> consumer, String basePath) {
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.VIBRATION)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.VIBRATION)).key(Pattern.OTHER, MoreThermalEvaporationBlocks.ULTIMATE_THERMAL_EVAPORATION_VALVE).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "resonance/valve"));
        ExtendedShapedRecipeBuilder.shapedRecipe(MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.RESONANCE)).valvePattern().key(Pattern.CONSTANT, MoreThermalEvaporationCompatBlocks.getCasingBlock(TETier.RESONANCE)).key(Pattern.OTHER, MoreThermalEvaporationCompatBlocks.getValveBlock(TETier.VIBRATION)).build(consumer, MoreThermalEvaporationCompat.rl(basePath+ "vibration/valve"));
    }
}
