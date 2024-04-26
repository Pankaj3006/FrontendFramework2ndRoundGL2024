package com.pan.tests;

import static com.pan.utils.CommonUtils.click;
import static com.pan.utils.CommonUtils.isDisplayed;
import static com.pan.utils.CommonUtils.enterText;

import com.pan.annotation.FrameworkAnnotation;
import com.pan.driver.DriverManager;
import com.pan.enums.AuthorType;
import com.pan.enums.CategoryType;
import com.pan.enums.PropertyType;
import com.pan.pages.orangeHRMPages.OrangeHRMHomePage;
import com.pan.pages.orangeHRMPages.OrangeHRMLoginPage;
import com.pan.utils.PropertyUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;


public class OrangeHRMTest extends BaseTest{

    @FrameworkAnnotation(author = AuthorType.ORANGE_HRM, category = CategoryType.STRIKERS)
    @Test
    void validateLogoTest(Map<String, String> map) {
        DriverManager.getDriver().get(PropertyUtils.getValue(PropertyType.ORANGE_HRM_URL));
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
        Assert.assertTrue(isDisplayed(orangeHRMLoginPage.getImageLogo(), "Logo Image"));
    }

    @FrameworkAnnotation(author = AuthorType.ORANGE_HRM, category = CategoryType.INTEGRATIONS)
    @Test
    void orangeHRMLoginTest(Map<String, String> map) {
        DriverManager.getDriver().get(PropertyUtils.getValue(PropertyType.ORANGE_HRM_URL));
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
        enterText(orangeHRMLoginPage.getUserName(),"admin", "UserName Box");
        enterText(orangeHRMLoginPage.getPassword(), "admin123", "Password Box");
        click(orangeHRMLoginPage.getLoginButton(), "Login Button");
        OrangeHRMHomePage orangeHRMHomePage = new OrangeHRMHomePage();
        click(orangeHRMHomePage.getLinkPaul(), "Paul Link");
        click(orangeHRMHomePage.getLogoutLink(), "Logout Link");
    }
}
