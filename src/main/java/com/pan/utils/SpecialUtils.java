package com.pan.utils;

import static com.pan.utils.CommonUtils.click;

import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.Iterator;
import java.util.Set;

public class SpecialUtils {
    public static void enterCityName(String textBoxId, String placeName) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        String script = "return document.getElementById(\""+textBoxId+"\").value;";
        String text = (String) js.executeScript(script);

        while (!text.equalsIgnoreCase(placeName)) {
            DriverManager.getDriver().findElement(By.id(textBoxId)).sendKeys(Keys.DOWN);
            text = (String) js.executeScript(script);
        }
        DriverManager.getDriver().findElement(By.id(textBoxId)).sendKeys(Keys.ENTER);
    }

    public static void selectDate(String date) {
        int count = 0;
        while (!DriverManager.getDriver().findElement(By.cssSelector(".ui-datepicker-header .ui-datepicker-title")).getText().contains(date.substring(3,date.length()))) {
           click(DriverManager.getDriver().findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")), "Selected Month");
        }
        int rowCount = DriverManager.getDriver().findElements(By.xpath("//table/tbody/tr")).size();
        int columnCount = DriverManager.getDriver().findElements(By.xpath("//table/tbody/tr[1]/td")).size();
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <= columnCount; j++) {
                if ((DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + j + "]"))).getText()
                        .contains(date.split(" ")[0])) {
                    count++;
                    click(DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + j + "]")), "Selected Date");
                    break;
                }
            }
            if (count == 1) {
                break;
            }
        }
    }

    public static void switchToChildWindow() {
        String mainWindow = DriverManager.getDriver().getWindowHandle();

        Set<String> multipleWindow = DriverManager.getDriver().getWindowHandles();
        Iterator<String> itr = multipleWindow.iterator();

        while (itr.hasNext()) {
            String childWindow = itr.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)) {
                DriverManager.getDriver().switchTo().window(childWindow);
            }
        }
    }
}
