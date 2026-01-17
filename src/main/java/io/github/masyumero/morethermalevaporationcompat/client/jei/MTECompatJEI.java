package io.github.masyumero.morethermalevaporationcompat.client.jei;

import giselle.jei_mekanism_multiblocks.client.JEI_MekanismMultiblocks_Client;
import giselle.jei_mekanism_multiblocks.client.SavedData;
import giselle.jei_mekanism_multiblocks.client.jei.MultiblockCategory;
import giselle.jei_mekanism_multiblocks.client.jei.MultiblockWidget;
import giselle.jei_mekanism_multiblocks.common.JEI_MekanismMultiblocks;
import giselle.jei_mekanism_multiblocks.common.config.ClientConfig;
import giselle.jei_mekanism_multiblocks.common.config.JEI_MekanismMultiblocks_Config;
import io.github.masyumero.morethermalevaporationcompat.*;
import io.github.masyumero.morethermalevaporationcompat.client.jei.category.MoreEvaporationPlantCompatCategory;
import io.github.masyumero.morethermalevaporationcompat.common.util.MTECompatEnumUtils;
import mekanism.client.jei.CatalystRegistryHelper;
import mekanism.client.jei.MekanismJEIRecipeType;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Supplier;

import io.github.masyumero.morethermalevaporationcompat.common.content.blocktype.MTECompatMultiPartType;
import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@JeiPlugin
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class MTECompatJEI implements IModPlugin {

    private final List<MultiblockCategory<? extends MultiblockWidget>> categories = new ArrayList<>();

    @Override
    public ResourceLocation getPluginUid() {
        return MoreThermalEvaporationCompat.rl("jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registry) {
        for (TETier tier : MTECompatEnumUtils.THERMAL_EVAPORATION_TIERS) {
            for (MTECompatMultiPartType type : MTECompatMultiPartType.values()) {
                if (tier.isModLoaded() && !tier.isCompactOnly()) CatalystRegistryHelper.register(registry, MekanismJEIRecipeType.EVAPORATING, MoreThermalEvaporationCompatBlocks.getBlock(tier, type));
            }
            if (CompactModule.CompactLoaded) {
                CatalystRegistryHelper.register(registry, MekanismJEIRecipeType.EVAPORATING, MoreThermalEvaporationCompatBlocks.getCompactBlock(tier));
            }
        }

        for (MultiblockCategory<?> category : this.getCategories()) {
            category.registerRecipeCatalysts(registry);
        }
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        if (MoreThermalEvaporationCompat.JEI_MEK_LOADED) {
            ClientConfig config = JEI_MekanismMultiblocks_Config.CLIENT;
            IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
            this.categories.clear();
            if (ExtrasModule.ExtrasLoaded){
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.ABSOLUTE, MoreEvaporationPlantCompatCategory.AbsoluteEvaporationPlantWidget.class));
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.SUPREME, MoreEvaporationPlantCompatCategory.SupremeEvaporationPlantWidget.class));
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.COSMIC, MoreEvaporationPlantCompatCategory.CosmicEvaporationPlantWidget.class));
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.INFINITE, MoreEvaporationPlantCompatCategory.InfiniteEvaporationPlantWidget.class));
            }
            if (EvolvedModule.EvolvedLoaded){
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.OVERCLOCKED, MoreEvaporationPlantCompatCategory.OverclockedEvaporationPlantWidget.class));
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.QUANTUM, MoreEvaporationPlantCompatCategory.QuantumEvaporationPlantWidget.class));
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.DENSE, MoreEvaporationPlantCompatCategory.DenseEvaporationPlantWidget.class));
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.MULTIVERSAL, MoreEvaporationPlantCompatCategory.MultiversalEvaporationPlantWidget.class));
            }
            if (AstralModule.AstralLoaded){
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.VIBRATION, MoreEvaporationPlantCompatCategory.VibrationEvaporationPlantWidget.class));
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.RESONANCE, MoreEvaporationPlantCompatCategory.ResonanceEvaporationPlantWidget.class));
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.ILLUSION, MoreEvaporationPlantCompatCategory.IllusionEvaporationPlantWidget.class));
            }
            if (EMExtrasModule.EMExtraLoaded){
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.ABSOLUTE_OVERCLOCKED, MoreEvaporationPlantCompatCategory.AbsoluteOverclockedEvaporationPlantWidget.class));
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.SUPREME_QUANTUM, MoreEvaporationPlantCompatCategory.SupremeQuantumEvaporationPlantWidget.class));
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.COSMIC_DENSE, MoreEvaporationPlantCompatCategory.CosmicDenseEvaporationPlantWidget.class));
                this.addCategory(config.evaporationPlantVisible, () -> new MoreEvaporationPlantCompatCategory(guiHelper, TETier.INFINITE_MULTIVERSAL, MoreEvaporationPlantCompatCategory.InfiniteMultiversalEvaporationPlantWidget.class));
            }

            for (MultiblockCategory<?> category : this.getCategories()) {
                registration.addRecipeCategories(category);
            }
        }
    }

    private <CATEGOERY extends MultiblockCategory<?>> void addCategory(ForgeConfigSpec.BooleanValue config, Supplier<CATEGOERY> constructor) {
        if (config.get()) {
            this.categories.add(constructor.get());
        }
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        if (JEI_MekanismMultiblocks.EMILoaded) {
            return;
        }

        IModPlugin.super.registerRecipes(registration);

        for (MultiblockCategory<?> category : this.getCategories()) {
            @SuppressWarnings("unchecked")
            RecipeType<MultiblockWidget> recipeType = (RecipeType<MultiblockWidget>) category.getRecipeType();
            registration.addRecipes(recipeType, Arrays.asList(this.createWidget(category)));
        }
    }

    public <WIDGET extends MultiblockWidget> WIDGET createWidget(MultiblockCategory<WIDGET> category) {
        try {
            RecipeType<WIDGET> recipeType = category.getRecipeType();
            WIDGET widget = recipeType.getRecipeClass().getDeclaredConstructor().newInstance();

            if (SavedData.hasMultiblock(recipeType.getUid())) {
                widget.load(SavedData.getMultiblock(recipeType.getUid()));
            }

            widget.addChangedHandler(w -> this.onWidgetChanged(category, widget));
            return widget;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
                 InvocationTargetException | NoSuchMethodException | SecurityException e) {
            throw new RuntimeException("Category: " + category.getRecipeType(), e);
        }

    }

    private void onWidgetChanged(MultiblockCategory<?> category, MultiblockWidget widget) {
        CompoundTag tag = new CompoundTag();
        widget.save(tag);

        SavedData.setMultiblockData(category.getRecipeType().getUid(), tag);
        JEI_MekanismMultiblocks_Client.markNeedSave();
    }

    public List<MultiblockCategory<? extends MultiblockWidget>> getCategories() {
        return Collections.unmodifiableList(this.categories);
    }

}
