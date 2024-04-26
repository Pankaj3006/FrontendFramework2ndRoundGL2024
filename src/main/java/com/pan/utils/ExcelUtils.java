package com.pan.utils;

import com.pan.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {

    private ExcelUtils() {
        /* No Operation */
    }

    public static XSSFSheet readExcel(String sheetName) {

        XSSFWorkbook xssfWorkbook;
        try(FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.EXCEL_PATH)) {
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return xssfWorkbook.getSheet(sheetName);
    }

    public static List<Map<String, String>> provideData(String sheetName) {

        XSSFSheet sheet = readExcel(sheetName);
        int rowNumber = sheet.getLastRowNum();
        int colNumber = sheet.getRow(0).getLastCellNum();

        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;

        for(int i=1; i<=rowNumber; i++) {
            map= new HashMap<>();
            for(int j=0; j<colNumber; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
            }
            list.add(map);
        }

        return list;
    }
}
