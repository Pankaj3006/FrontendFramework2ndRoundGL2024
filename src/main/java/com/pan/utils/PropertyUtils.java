package com.pan.utils;

import com.pan.constants.FrameworkConstants;
import com.pan.enums.PropertyType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils() {
        /* No operation */
    }

    private static Properties properties = new Properties();

    private static final Map<String, String> map = new HashMap<>();

    static {
        try(FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.PROPERTIES_PATH)) {
            properties.load(fileInputStream);
            properties.forEach((k,v)-> map.put(String.valueOf(k), String.valueOf(v)));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(PropertyType key) {
        return map.get(key.getValue());
    }
}
