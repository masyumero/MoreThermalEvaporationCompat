package io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.compat;

import mekanism.api.annotations.NothingNullByDefault;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@NothingNullByDefault
public class CompactRecipeProvider extends CompatRecipeProvider {

    protected CompactRecipeProvider(String modid) {
        super(modid);
    }

    @Override
    protected void registerRecipes(Consumer<FinishedRecipe> consumer, String basePath) {
        basePath = basePath + "thermal_evaporation/";
    }
}
