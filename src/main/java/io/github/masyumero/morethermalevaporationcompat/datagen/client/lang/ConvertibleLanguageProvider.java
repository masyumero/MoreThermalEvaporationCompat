package io.github.masyumero.morethermalevaporationcompat.datagen.client.lang;

import java.util.List;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public abstract class ConvertibleLanguageProvider extends LanguageProvider {

    public ConvertibleLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    public abstract void convert(String key, List<FormatSplitter.Component> splitEnglish);

    @Override
    protected void addTranslations() {
    }
}
