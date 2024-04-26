package com.pan.pages.orangeHRMPages;

import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrangeHRMHomePage {

    private final By link_paul = By.xpath("//p[@class='oxd-userdropdown-name']");
    private final By link_logout = By.xpath("//a[text()='Logout']");

    public WebElement getLinkPaul() {

        return DriverManager.getDriver().findElement(link_paul);
    }

    public WebElement getLogoutLink() {
        return DriverManager.getDriver().findElement(link_logout);
    }
}
