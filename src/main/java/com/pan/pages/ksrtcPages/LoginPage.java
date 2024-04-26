package com.pan.pages.ksrtcPages;

import com.pan.driver.Driver;
import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final By fromPlace = By.id("fromPlaceName");
    private final By toPlace = By.id("toPlaceName");
    private final By journeyDate = By.id("txtJourneyDate");
    private final By searchButton = By.xpath("//*[@id='bookingsForm']/div[1]/div/div[2]/div[3]/button");

    public WebElement getFromPlace() {
        return DriverManager.getDriver().findElement(fromPlace);
    }

    public WebElement getToPlace() {
        return DriverManager.getDriver().findElement(toPlace);
    }

    public WebElement getJourneyDate() {
        return DriverManager.getDriver().findElement(journeyDate);
    }

    public WebElement getSearchButton() {
        return DriverManager.getDriver().findElement(searchButton);
    }
}
