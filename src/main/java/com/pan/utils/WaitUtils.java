package com.pan.utils;

import com.pan.constants.FrameworkConstants;
import com.pan.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitUtils {

    private WaitUtils() {
        /* No operation */
    }

    public static void waitForVisibilityOfElement(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.TIME_TO_VISIBLE));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickabilityOfElement(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.TIME_TO_CLICKABLE));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void unConditionalWait(long duration)
    {
        try{
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
