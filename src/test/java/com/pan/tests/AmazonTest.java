package com.pan.tests;

import static com.pan.utils.CommonUtils.click;
import static com.pan.utils.CommonUtils.clickWithJs;
import static com.pan.utils.SpecialUtils.switchToChildWindow;

import com.pan.annotation.FrameworkAnnotation;
import com.pan.driver.DriverManager;
import com.pan.enums.AuthorType;
import com.pan.enums.PropertyType;
import com.pan.pages.amazonPages.HomePage;
import com.pan.utils.JsonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class AmazonTest extends BaseTest {

    @FrameworkAnnotation(author = AuthorType.AMAZON)
    @Test
    void checkForLaptopLinkTest(Map<String, String> map) {
        DriverManager.getDriver().get(JsonUtils.getValue(PropertyType.AMAZON_URL));

        HomePage homePage = new HomePage();

        click(homePage.getHamburgerMenu(), "Hamburger Menu");
        click(homePage.getMobileAndComputers(), "Mobile and Computers link");
        clickWithJs(homePage.getLaptops(), "Laptops Link");
        click(homePage.getAppleLaptop(), "Apple Laptop Link");
        click(homePage.getSortBy(), "Sort By link");
        click(homePage.getLowToHigh(), "Low to High");
        click(homePage.getFirstLaptop(), "First laptop On the page");
        switchToChildWindow();

        List<WebElement> listOfTables = DriverManager.getDriver().findElements(By.xpath("//tbody"));
        Assert.assertTrue(listOfTables.size()>0);
    }
}
