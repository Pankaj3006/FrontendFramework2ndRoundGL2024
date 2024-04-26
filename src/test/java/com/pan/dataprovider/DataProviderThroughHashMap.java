package com.pan.dataprovider;

import com.pan.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataProviderThroughHashMap {

    @Test(dataProvider = "ReadDataFromExcel")
    void test(Map<String, String> map) {
        map.entrySet().forEach(e -> System.out.print(e.getValue() + " : "));
        System.out.println();
    }

    @DataProvider(name = "ReadDataFromExcel")
    Object[] getData() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.EXCEL_PATH);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("Testing Data");

        int rowNum = xssfSheet.getLastRowNum();
        int colNum = xssfSheet.getRow(0).getLastCellNum();

        Object[] data = new Object[rowNum];
        Map<String, String> map;

        for(int i=1; i<=rowNum; i++)
        {
            // LinkedHasMap has been used in place of Hashmap just to ensure the insertion Order of Keys (Same as Rows order in Excel)
            map = new LinkedHashMap<>();
            for (int j=0; j<colNum; j++)
            {
                String key = xssfSheet.getRow(0).getCell(j).getStringCellValue();
                String value = xssfSheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
                data[i-1] = map;
            }
        }

        return data;

    }
}
