package com.pan.utils;

import com.pan.constants.FrameworkConstants;
import com.pan.enums.PropertyType;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class JsonUtils {

    private JsonUtils() {
        /* No operation */
    }

    private static Map<String, String> map = new HashMap<>();

    static {
        try(FileReader fileReader = new FileReader(FrameworkConstants.JSON_PATH)) {
            map = new ObjectMapper().readValue(fileReader, HashMap.class);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(PropertyType key) {
        return map.get(key.getValue());
    }
}
