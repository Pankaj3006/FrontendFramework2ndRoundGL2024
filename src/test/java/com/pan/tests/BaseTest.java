package com.pan.tests;

import com.pan.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {

    @BeforeMethod
    void setUp(Object[] data) {
       // void setUp() {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map.get("browser"));
        //Driver.initDriver();
    }

    @AfterMethod
    void tearDown() {
        Driver.quitDriver();
    }
}
