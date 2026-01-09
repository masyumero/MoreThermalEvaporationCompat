package io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.impl;

import io.github.masyumero.morethermalevaporationcompat.MoreThermalEvaporationCompat;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.BaseRecipeProvider;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.ISubRecipeProvider;
import io.github.masyumero.morethermalevaporationcompat.datagen.common.recipe.compat.*;
import mekanism.api.annotations.NothingNullByDefault;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

@NothingNullByDefault
public class MTECompatRecipeProvider extends BaseRecipeProvider {

    public static final char GLASS_CHAR = 'G';

    private final List<ISubRecipeProvider> compatProviders = new ArrayList<>();
    private final Set<String> disabledCompats = new HashSet<>();

    public MTECompatRecipeProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, existingFileHelper, MoreThermalEvaporationCompat.MODID);

        checkCompat("mekanism_extras", MekanismExtrasRecipeProvider::new);
        checkCompat("evolvedmekanism", EvolvedMekanismRecipeProvider::new);
        checkCompat("astral_mekanism", AstralMekanismRecipeProvider::new);
        checkCompat("emextras", EvolvedMekanismExtraRecipeProvider::new);
        checkCompat("compactmekanismmachines", CompactRecipeProvider::new);
    }

    private void checkCompat(String modid, Function<String, ISubRecipeProvider> providerCreator) {
        if (ModList.get().isLoaded(modid)) {
            compatProviders.add(providerCreator.apply(modid));
        } else {
            disabledCompats.add(modid);
        }
    }

    public Set<String> getDisabledCompats() {
        return Collections.unmodifiableSet(disabledCompats);
    }

    @Override
    protected void addRecipes(Consumer<FinishedRecipe> consumer) {
        compatProviders.forEach(compatProvider -> compatProvider.addRecipes(consumer));
    }
}
