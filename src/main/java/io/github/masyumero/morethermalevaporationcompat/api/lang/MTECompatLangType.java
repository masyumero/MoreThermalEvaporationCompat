package io.github.masyumero.morethermalevaporationcompat.api.lang;

public enum MTECompatLangType {
    TITLE("Title"),
    DESC_BLOCK("Block"),
    DESC_VALVE("Valve"),
    DESC_CONTROLLER("Controller");

    private final String name;

    MTECompatLangType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
