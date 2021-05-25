package com.globant.bootcamp.model.enums;

public enum EggColor {
    RED("(D)"),
    WHITE("(O)");

    private final String label;

    EggColor(String o) {
        this.label = o;
    }

    public String getDraw() {
        return label;
    }


}
