package com.pan.enums;

public enum PropertyType {

    Google_URL("googleUrl"),
    KSRTC_URL("ksrtcUrl"),
    ORANGE_HRM_URL("orangeHrmUrl"),
    AMAZON_URL("amazonUrl"),
    RUNMODE("runmode");

    private String value;

    PropertyType(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
