package io.github.masyumero.morethermalevaporationcompat.common.content.blocktype;

import java.util.Locale;

public enum MTECompatMultiPartType {
    BLOCK("Block"),
    VALVE("Valve"),
    CONTROLLER("Controller");

    private final String name;

    MTECompatMultiPartType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLowerName() {
        return this.getName().toLowerCase(Locale.ROOT);
    }
}
