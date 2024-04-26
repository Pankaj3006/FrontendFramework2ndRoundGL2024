package com.pan.dataprovider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pan.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataProviderWithJson {

    @Test(dataProvider = "ReadDataFromJSON")
    void test(HashMap<String, Object> map) {
        for(Map.Entry<String, Object> m : map.entrySet())
        {
            System.out.println(m.getKey() + " : " +m.getValue());
        }
    }

    @DataProvider(name="ReadDataFromJSON")
    Object[] getData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.JSON_PATH);
        // LinkedHasMap has been used in place of Hashmap just to ensure the insertion Order of keys
        //LinkedHashMap<String, Object> map = new ObjectMapper().readValue(fileInputStream, new TypeReference<LinkedHashMap<String, Object>>() {});
        LinkedHashMap<String, Object> map = new ObjectMapper().readValue(fileInputStream, LinkedHashMap.class);
        return new Object[] {map};
    }
}
