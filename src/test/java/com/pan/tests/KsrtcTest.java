package com.pan.tests;

import static com.pan.utils.WaitUtils.waitForVisibilityOfElement;
import static com.pan.utils.WaitUtils.unConditionalWait;
import static com.pan.utils.CommonUtils.click;
import static com.pan.utils.CommonUtils.clickWithJs;
import static com.pan.utils.CommonUtils.enterText;
import static com.pan.utils.SpecialUtils.enterCityName;
import static com.pan.utils.SpecialUtils.selectDate;

import com.pan.annotation.FrameworkAnnotation;
import com.pan.driver.DriverManager;
import com.pan.enums.AuthorType;
import com.pan.enums.CategoryType;
import com.pan.enums.PropertyType;
import com.pan.pages.ksrtcPages.BusDetailsPage;
import com.pan.pages.ksrtcPages.LoginPage;
import com.pan.utils.DataProviderUtils;
import com.pan.utils.PropertyUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class KsrtcTest extends BaseTest {

    @FrameworkAnnotation(author = AuthorType.KSRTC, category = CategoryType.INTEGRATIONS)
    @Test
    void getSeatCountTest(Map<String, String> map) {

        DriverManager.getDriver().get(PropertyUtils.getValue(PropertyType.KSRTC_URL));

        String fromPlace = "Mysore";
        String toPlace = "Bangalore";
        String dateOfJourney = "29 January 2024";

        LoginPage loginPage = new LoginPage();
        enterText(loginPage.getFromPlace(), fromPlace.substring(0,3), "fromPlace Box");
        enterCityName("fromPlaceName", fromPlace);

        enterText(loginPage.getToPlace(), toPlace.substring(0,3), "toPlace Box");
        unConditionalWait(2000);
        enterCityName("toPlaceName", toPlace);
        click(loginPage.getJourneyDate(), "Journey Date");
        selectDate(dateOfJourney);
        clickWithJs(loginPage.getSearchButton(), "Search Button");

        BusDetailsPage busDetailsPage = new BusDetailsPage();

        waitForVisibilityOfElement(busDetailsPage.getHeaderDetails());

        List<WebElement> elements = busDetailsPage.getSeatCount();
        System.out.println("Total numbers of buses between " + fromPlace + " and " + toPlace + " are: " + elements.size());

        int totalSeats=0;
        for(WebElement ele:elements)
        {
            int NoOfSeats = Integer.parseInt(ele.getText().split(" ")[0]);
            totalSeats = totalSeats + NoOfSeats;
        }
        System.out.println("Total numbers of seats between " + fromPlace + " and " + toPlace + " are: " + totalSeats);
    }

//    @FrameworkAnnotation(author = "Ksrtc", category = {"Integrations", "Strikers"})
//    @Test(dataProvider = "getDataAsParameters", dataProviderClass = DataProviderUtils.class)
//    void dataProviderTest(String origin, String destination, String travelDate) {
//
//        DriverManager.getDriver().get(PropertyUtils.getValue(PropertyType.KSRTC_URL));
//
//        String fromPlace = origin;
//        String toPlace = destination;
//        String dateOfJourney = travelDate;
//
//        LoginPage loginPage = new LoginPage();
//        enterText(loginPage.getFromPlace(), fromPlace.substring(0,3), "fromPlace Box");
//        enterCityName("fromPlaceName", fromPlace);
//
//        enterText(loginPage.getToPlace(), toPlace.substring(0,3), "toPlace Box");
//        unConditionalWait(2000);
//        enterCityName("toPlaceName", toPlace);
//        click(loginPage.getJourneyDate(), "Journey Date");
//        selectDate(dateOfJourney);
//        clickWithJs(loginPage.getSearchButton(), "Search Button");
//
//        BusDetailsPage busDetailsPage = new BusDetailsPage();
//
//        waitForVisibilityOfElement(busDetailsPage.getHeaderDetails());
//
//        List<WebElement> elements = busDetailsPage.getSeatCount();
//        System.out.println("Total numbers of buses between " + fromPlace + " and " + toPlace + " are: " + elements.size());
//
//        int totalSeats=0;
//        for(WebElement ele:elements)
//        {
//            int NoOfSeats = Integer.parseInt(ele.getText().split(" ")[0]);
//            totalSeats = totalSeats + NoOfSeats;
//        }
//        System.out.println("Total numbers of seats between " + fromPlace + " and " + toPlace + " are: " + totalSeats);
//    }

    @FrameworkAnnotation(author = AuthorType.KSRTC, category = {CategoryType.INTEGRATIONS, CategoryType.STRIKERS})
    @Test
    void dataProviderTestUsingHashMap(Map<String, String> map) {

        DriverManager.getDriver().get(PropertyUtils.getValue(PropertyType.KSRTC_URL));

        String fromPlace = map.get("Origin");
        String toPlace = map.get("Destination");
        String dateOfJourney = map.get("TravelDate");

        LoginPage loginPage = new LoginPage();
        enterText(loginPage.getFromPlace(), fromPlace.substring(0,3), "fromPlace Box");
        enterCityName("fromPlaceName", fromPlace);

        enterText(loginPage.getToPlace(), toPlace.substring(0,3), "toPlace Box");
        unConditionalWait(2000);
        enterCityName("toPlaceName", toPlace);
        click(loginPage.getJourneyDate(), "Journey Date");
        selectDate(dateOfJourney);
        clickWithJs(loginPage.getSearchButton(), "Search Button");

        BusDetailsPage busDetailsPage = new BusDetailsPage();

        waitForVisibilityOfElement(busDetailsPage.getHeaderDetails());

        List<WebElement> elements = busDetailsPage.getSeatCount();
        System.out.println("Total numbers of buses between " + fromPlace + " and " + toPlace + " are: " + elements.size());

        int totalSeats=0;
        for(WebElement ele:elements)
        {
            int NoOfSeats = Integer.parseInt(ele.getText().split(" ")[0]);
            totalSeats = totalSeats + NoOfSeats;
        }
        System.out.println("Total numbers of seats between " + fromPlace + " and " + toPlace + " are: " + totalSeats);
    }
}
