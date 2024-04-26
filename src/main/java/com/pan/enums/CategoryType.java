package com.pan.enums;

public enum CategoryType {

    INTEGRATIONS("Integrations"),
    STRIKERS("Strikers");

    private String value;

    CategoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
