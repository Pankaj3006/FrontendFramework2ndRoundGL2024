package com.pan.listeners;

import com.pan.annotation.FrameworkAnnotation;
import com.pan.constants.FrameworkConstants;
import com.pan.reports.ExtentLogger;
import com.pan.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ISuiteListener, ITestListener {

    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
        if(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class) != null) {
            ExtentReport.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
            ExtentReport.assignCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
        }
    }

    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
    }

    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
        ExtentLogger.fail(result.getThrowable().toString());
    }

    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
    }
}
