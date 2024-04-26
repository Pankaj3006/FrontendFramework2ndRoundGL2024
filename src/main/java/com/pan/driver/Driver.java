package com.pan.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Driver {

    private Driver() {
        /* No operation */
    }

    private static WebDriver driver;
    public static void initDriver(String browser) {
        if(Objects.isNull(DriverManager.getDriver())) {
            try {
                driver = DriverFactory.getDriver(browser);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
