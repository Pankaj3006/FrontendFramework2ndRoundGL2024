package com.pan.dataprovider;

import com.pan.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderFromExcel {

    @Test(dataProvider = "ReadDataFromExcel")
    void test(String username, String password, String firstName, String lastname) {
        System.out.println(username + " : " + password + " : " + firstName + " : " + lastname);
    }

    @DataProvider(name = "ReadDataFromExcel")
    Object[][] getData() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.EXCEL_PATH);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("Testing Data");

        int rowNum = xssfSheet.getLastRowNum();
        int colNum = xssfSheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowNum][colNum];

        for(int i=1; i<=rowNum; i++)
        {
            for (int j=0; j<colNum; j++)
            {
                data[i-1][j] = xssfSheet.getRow(i).getCell(j).getStringCellValue();
            }
        }

        return data;

    }
}
