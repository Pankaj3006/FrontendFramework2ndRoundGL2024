package com.pan.pages.ksrtcPages;

import com.pan.driver.Driver;
import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BusDetailsPage {

    private final By headerDetails = By.xpath("//html/body/header/nav/div/div/ul/li");
    private final By seatsCount = By.xpath("//div[@class='seats-count']/div/h4");

    public WebElement getHeaderDetails() {
        return DriverManager.getDriver().findElement(headerDetails);
    }

    public List<WebElement> getSeatCount() {
        return DriverManager.getDriver().findElements(seatsCount);
    }
}
