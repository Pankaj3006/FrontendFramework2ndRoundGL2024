package com.pan.utils;

import static com.pan.utils.WaitUtils.waitForVisibilityOfElement;

import com.pan.driver.DriverManager;
import com.pan.reports.ExtentLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public final class CommonUtils {

    private CommonUtils() {
        /* No operation */
    }

    public static void click(WebElement element, String elementName) {
        waitForVisibilityOfElement(element);
        element.click();
        ExtentLogger.info(elementName +" has been clicked successfully");
    }

    public static void clickWithJs(WebElement element, String elementName) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", element);
        ExtentLogger.info(elementName +" has been clicked successfully");
    }

    public static void enterText(WebElement element, String text, String elementName) {
        waitForVisibilityOfElement(element);
        element.sendKeys(text);
        ExtentLogger.info(text + " is successfully entered in "+ elementName);
    }

    public static boolean isDisplayed(WebElement element, String elementName) {
        waitForVisibilityOfElement(element);
        boolean isDisplayed = element.isDisplayed();
        ExtentLogger.info(elementName + " is successfully Displayed");
        return isDisplayed;
    }
}
