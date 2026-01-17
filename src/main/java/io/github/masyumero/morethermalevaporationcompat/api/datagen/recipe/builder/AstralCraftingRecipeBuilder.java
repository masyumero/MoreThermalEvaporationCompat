package io.github.masyumero.morethermalevaporationcompat.api.datagen.recipe.builder;

import astral_mekanism.AstralMekanismID;
import com.google.gson.JsonObject;
import io.github.masyumero.morethermalevaporationcompat.common.util.ChemicalUtils;
import io.github.masyumero.morethermalevaporationcompat.common.util.ItemUtils;
import mekanism.api.JsonConstants;
import mekanism.api.SerializerHelper;
import mekanism.api.datagen.recipe.MekanismRecipeBuilder;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import mekanism.api.recipes.ingredients.FluidStackIngredient;
import mekanism.api.recipes.ingredients.ItemStackIngredient;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

import static astral_mekanism.registries.AstralMekanismItems.ELASTIC_ALLOY;
import static astral_mekanism.registries.AstralMekanismItems.ILLUSION_CONTROL_CIRCUIT;
import static astral_mekanism.registries.AstralMekanismItems.SPACETIME_MODULATION_CORE;
import static astral_mekanism.registries.AstralMekanismItems.STARDUST_ALLOY;
import static com.jerry.mekanism_extras.common.registry.ExtraItem.SPECTRUM_ALLOY;
import static fr.iglee42.evolvedmekanism.registries.EMItems.EXOVERSAL_ALLOY;
import static io.github.masyumero.emextras.common.registry.EMExtrasItem.INFINITE_MULTIVERSAL_CONTROL_CIRCUIT;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AstralCraftingRecipeBuilder extends MekanismRecipeBuilder<AstralCraftingRecipeBuilder> {

    // 25スロット固定
    private static final int SLOT_COUNT = 25;
    private static final String[] INPUT_ITEM_KEYS = new String[] {
            "itemInputA1", "itemInputA2", "itemInputA3", "itemInputA4", "itemInputA5",
            "itemInputB1", "itemInputB2", "itemInputB3", "itemInputB4", "itemInputB5",
            "itemInputC1", "itemInputC2", "itemInputC3", "itemInputC4", "itemInputC5",
            "itemInputD1", "itemInputD2", "itemInputD3", "itemInputD4", "itemInputD5",
            "itemInputE1", "itemInputE2", "itemInputE3", "itemInputE4", "itemInputE5"
    };

    private final ItemStackIngredient[] inputItems;
    private final FluidStackIngredient inputFluid;
    private final ChemicalStackIngredient.GasStackIngredient inputGas;
    private final ItemStack output;

    protected AstralCraftingRecipeBuilder(ItemStackIngredient[] inputItems, FluidStackIngredient inputFluid, ChemicalStackIngredient.GasStackIngredient inputGas, ItemStack output) {
        super(AstralMekanismID.rl("astral_crafting"));
        this.inputItems = new ItemStackIngredient[SLOT_COUNT];
        for (int i = 0; i < SLOT_COUNT; i++) {
            this.inputItems[i] = inputItems[i % inputItems.length];
        }

        this.inputFluid = inputFluid;
        this.inputGas = inputGas;
        this.output = output;
    }

    public static AstralCraftingRecipeBuilder astralCrafting(ItemStackIngredient catalyst, ItemStack output) {
        return astralCrafting(new ItemStackIngredient[]{
                        IngredientCreatorAccess.item().from(ELASTIC_ALLOY, 64) , IngredientCreatorAccess.item().from(EXOVERSAL_ALLOY, 64),IngredientCreatorAccess.item().from(ItemUtils.getItem("ae2:singularity"), 64),IngredientCreatorAccess.item().from(EXOVERSAL_ALLOY, 64),IngredientCreatorAccess.item().from(ELASTIC_ALLOY, 64),
                        IngredientCreatorAccess.item().from(SPECTRUM_ALLOY, 64) , IngredientCreatorAccess.item().from(STARDUST_ALLOY),IngredientCreatorAccess.item().from(ILLUSION_CONTROL_CIRCUIT),IngredientCreatorAccess.item().from(STARDUST_ALLOY),IngredientCreatorAccess.item().from(SPECTRUM_ALLOY, 64),
                        IngredientCreatorAccess.item().from(INFINITE_MULTIVERSAL_CONTROL_CIRCUIT, 64) , IngredientCreatorAccess.item().from(SPACETIME_MODULATION_CORE),catalyst,IngredientCreatorAccess.item().from(SPACETIME_MODULATION_CORE),IngredientCreatorAccess.item().from(INFINITE_MULTIVERSAL_CONTROL_CIRCUIT, 64),
                        IngredientCreatorAccess.item().from(SPECTRUM_ALLOY, 64) , IngredientCreatorAccess.item().from(STARDUST_ALLOY),IngredientCreatorAccess.item().from(ILLUSION_CONTROL_CIRCUIT),IngredientCreatorAccess.item().from(STARDUST_ALLOY),IngredientCreatorAccess.item().from(SPECTRUM_ALLOY, 64),
                        IngredientCreatorAccess.item().from(ELASTIC_ALLOY, 64) , IngredientCreatorAccess.item().from(EXOVERSAL_ALLOY, 64),IngredientCreatorAccess.item().from(ItemUtils.getItem("ae2:singularity"), 64),IngredientCreatorAccess.item().from(EXOVERSAL_ALLOY, 64),IngredientCreatorAccess.item().from(ELASTIC_ALLOY, 64),
                },IngredientCreatorAccess.fluid().from(Fluids.LAVA, 10000),
                IngredientCreatorAccess.gas().from(ChemicalUtils.getGas("astral_mekanism:astral_ether"), 10000),
                output);
    }

    public static AstralCraftingRecipeBuilder astralCrafting(ItemStackIngredient[] inputItems, FluidStackIngredient inputFluid, ChemicalStackIngredient.GasStackIngredient inputGas, ItemStack output) {
        if (output.isEmpty()) {
            throw new IllegalArgumentException("This astral crafting recipe requires a non empty item output.");
        }
        return new AstralCraftingRecipeBuilder(inputItems, inputFluid, inputGas, output);
    }

    @Override
    protected MekanismRecipeBuilder<AstralCraftingRecipeBuilder>.RecipeResult getResult(ResourceLocation id) {
        return new AstralCraftingRecipeResult(id);
    }

    public void build(Consumer<FinishedRecipe> consumer) {
        build(consumer, output.getItem());
    }

    public class AstralCraftingRecipeResult extends RecipeResult {

        protected AstralCraftingRecipeResult(ResourceLocation id) {
            super(id);
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            for (int i = 0; i < SLOT_COUNT; i++) {
                json.add(INPUT_ITEM_KEYS[i], inputItems[i].serialize());
            }
            json.add(JsonConstants.FLUID_INPUT, inputFluid.serialize());
            json.add(JsonConstants.GAS_INPUT, inputGas.serialize());
            json.add(JsonConstants.OUTPUT, SerializerHelper.serializeItemStack(output));
        }
    }
}
