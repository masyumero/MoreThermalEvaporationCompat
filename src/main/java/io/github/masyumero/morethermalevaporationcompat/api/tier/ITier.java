package io.github.masyumero.morethermalevaporationcompat.api.tier;

import java.util.Locale;

public interface ITier {

    String getSimpleName();

    default String getLowerName() {
        return getSimpleName().toLowerCase(Locale.ROOT);
    }
}
