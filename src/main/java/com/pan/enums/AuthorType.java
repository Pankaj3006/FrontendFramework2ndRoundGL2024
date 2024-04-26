package com.pan.enums;

public enum AuthorType {

    GOOGLE("Google"),
    ORANGE_HRM("OrangeHRM"),
    AMAZON("Amazon"),
    KSRTC("Ksrtc");

    private  String value;
    AuthorType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
