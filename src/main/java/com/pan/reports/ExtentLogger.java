package com.pan.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.pan.utils.ScreenshotUtils;

public final class ExtentLogger {

    private ExtentLogger() {
        /* No Operation */
    }

    public static void pass(String message) {
        ExtentManager.getExtTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtTest().fail(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtTest().skip(message);
    }

    public static void info(String message) {
        ExtentManager.getExtTest().info(message);
    }

    public static void fail(String message, boolean screenShotNeeded) {
        if(screenShotNeeded) {
            ExtentManager.getExtTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.captureScreenshots()).build());
        }
        else {
            fail(message);
        }
    }
}
