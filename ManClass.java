package com.crystal;

public enum ManClass {
    FIGHTER("Fighter"),
    MAGICIAN("Magician");

    private String className;

    ManClass(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
