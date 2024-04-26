package com.pan.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pan.enums.AuthorType;
import com.pan.enums.CategoryType;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport() {
        /* No Operation */
    }

    private static ExtentReports extentReports;

    public static void initReports() {
        if(Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("index.html");
            extentReports.attachReporter(extentSparkReporter);

            extentSparkReporter.config().setTheme(Theme.STANDARD);
            extentSparkReporter.config().setDocumentTitle("Test Automation Report");
            extentSparkReporter.config().setReportName("Pankaj Gupta");
        }
    }

    public static void flushReports() {
        if(Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File("index.html").toURI());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testCaseName) {
        ExtentManager.setExtTest(extentReports.createTest(testCaseName));
    }

    public static void assignAuthor(AuthorType[] authors) {
        for(AuthorType author: authors) {
            ExtentManager.getExtTest().assignAuthor(author.getValue());
        }
    }

    public static void assignCategory(CategoryType[] categories) {
        for(CategoryType category: categories) {
            ExtentManager.getExtTest().assignCategory(category.getValue());
        }
    }
}
