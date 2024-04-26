package com.pan.constants;

public final class FrameworkConstants {

    private FrameworkConstants() {
        /* No Operation */
    }

    private static final String RESOURCE_PATH = System.getProperty("user.dir");
    public static final String PROPERTIES_PATH = RESOURCE_PATH + "/src/test/resources/config.properties";
    public static final String JSON_PATH = RESOURCE_PATH + "/src/test/resources/config.json";
    public static final String EXCEL_PATH = RESOURCE_PATH + "/src/test/resources/TestData.xlsx";
    public static final String SHEET_NAME = "CombineData";
    public static final String KSRTC_SHEET_NAME = "KsrtcData";
    public static final Integer TIME_TO_VISIBLE = 10;
    public static final Integer TIME_TO_CLICKABLE = 10;


}
