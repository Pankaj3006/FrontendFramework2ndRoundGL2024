package com.pan.driver;

import com.pan.enums.PropertyType;
import com.pan.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {

    private DriverFactory() {
        /* No Operation */
    }

    private static  WebDriver driver;

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        //String browser = "chrome";
        String runMode = PropertyUtils.getValue(PropertyType.RUNMODE);

        if(browser.equalsIgnoreCase("chrome")) {
            if(runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            }
            else {
                driver = new ChromeDriver();
            }
        }
        else {
            if(runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName("firefox");
                driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), cap);
            }
            else {
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}
