package com.pan.tests;

import com.pan.annotation.FrameworkAnnotation;
import com.pan.driver.DriverManager;
import com.pan.enums.AuthorType;
import com.pan.enums.CategoryType;
import com.pan.enums.PropertyType;
import com.pan.utils.JsonUtils;
import com.pan.utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GoogleTest extends BaseTest {

    @FrameworkAnnotation(author = AuthorType.GOOGLE, category = CategoryType.STRIKERS)
    @Test
    void googleLoginTest(Map<String, String> map) {
        //DriverManager.getDriver().get(PropertyUtils.getValue(PropertyType.Google_URL));
        DriverManager.getDriver().get(JsonUtils.getValue(PropertyType.Google_URL));
        String expectedTitle = "Google";
        Assert.assertEquals(DriverManager.getDriver().getTitle(), expectedTitle);
    }

    @FrameworkAnnotation(author = AuthorType.GOOGLE, category = CategoryType.STRIKERS)
    @Test
    void googleTextEnterTest(Map<String, String> map) {
        DriverManager.getDriver().get(PropertyUtils.getValue(PropertyType.Google_URL));
       // DriverManager.getDriver().get(JsonUtils.getValue(PropertyType.Google_URL));
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();
        Assert.assertTrue(title.contains("Google Search"));
        Assert.assertTrue(Objects.nonNull(title));
        Assert.assertTrue(title.length()>10);
        Assert.assertTrue(title.length()<100);

        List<WebElement> list = DriverManager.getDriver().findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
        Assert.assertTrue(list.size()>0);
        list.stream().filter(e -> e.getText().equalsIgnoreCase("Automation")).findFirst().get().click();
    }
}
