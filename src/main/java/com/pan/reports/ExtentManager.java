package com.pan.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager() {
        /* No Operation */
    }

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    static ExtentTest getExtTest() {
        return extTest.get();
    }

    static void setExtTest(ExtentTest test) {
        extTest.set(test);
    }

    static void unload() {
        extTest.remove();
    }
}
