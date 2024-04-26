package com.pan.utils;

import com.pan.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProviderUtils {

    @DataProvider
    Object[][] getDataAsParameters() {

        XSSFSheet sheet = ExcelUtils.readExcel(FrameworkConstants.KSRTC_SHEET_NAME);
        int rowNumber = sheet.getLastRowNum();
        int colNumber = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowNumber][colNumber];

        for(int i=1; i<=rowNumber; i++) {
            for(int j=0; j<colNumber; j++) {
                data[i-1][j]= sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return data;
    }

    @DataProvider
    Object[] getDataAsHashmap() {

        XSSFSheet sheet = ExcelUtils.readExcel(FrameworkConstants.KSRTC_SHEET_NAME);
        int rowNumber = sheet.getLastRowNum();
        int colNumber = sheet.getRow(0).getLastCellNum();

        Object[] data = new Object[rowNumber];
        Map<String, String> map;

        for(int i=1; i<=rowNumber; i++) {
            map = new HashMap<>();
            for(int j=0; j<colNumber; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
                data[i-1]=map;
            }
        }
        return data;
    }


    @DataProvider
    Object[] getDataAsHashMapUsingOneSheet(Method m) {

        // This Data provider will pick data from One sheet named as 'CombineSheet'
        // used for providing Data and also control the execution using
        // MethodInterceptor listener and also used for Cross Browser Testing

        String testName = m.getName();

        List<Map<String, String>> list = ExcelUtils.provideData(FrameworkConstants.SHEET_NAME);

        List<Map<String, String>> finalList = new ArrayList<>();

        for(int i=0; i<list.size(); i++) {
            if(list.get(i).get("TestName").equalsIgnoreCase(testName)) {
                if(list.get(i).get("execution").equalsIgnoreCase("Yes")) {
                    finalList.add(list.get(i));
                }
            }
        }

        return finalList.toArray();

    }
}
