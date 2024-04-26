package com.pan.pages.orangeHRMPages;

import com.pan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrangeHRMLoginPage {

    private final By textbox_username = By.xpath("//input[@name='username']");
    private final By textbox_password = By.xpath("//input[@name='password']");
    private final By button_login = By.xpath("//button[@type='submit']");
    private final By img_logo = By.xpath("//img[@alt='company-branding']");

    public WebElement getUserName()
    {
        return DriverManager.getDriver().findElement(textbox_username);
    }

    public WebElement getPassword()
    {
        return DriverManager.getDriver().findElement(textbox_password);
    }

    public WebElement getLoginButton() {

        return DriverManager.getDriver().findElement(button_login);
    }

    public WebElement getImageLogo() {
        return DriverManager.getDriver().findElement(img_logo);
    }
}
