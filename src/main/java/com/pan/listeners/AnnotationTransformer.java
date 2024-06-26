package com.pan.listeners;

import com.pan.utils.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryFailedTests.class);
        annotation.setDataProviderClass(DataProviderUtils.class);
        annotation.setDataProvider("getDataAsHashMapUsingOneSheet");
    }


}
