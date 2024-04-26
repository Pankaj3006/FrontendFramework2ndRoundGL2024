package com.pan.listeners;

import com.pan.constants.FrameworkConstants;
import com.pan.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {

        List<Map<String, String>> methods = ExcelUtils.provideData(FrameworkConstants.SHEET_NAME);
        List<IMethodInstance> finalList = new ArrayList<>();

        for(int i=0; i< list.size(); i++) {
            for( int j=0; j< methods.size(); j++) {
                if(list.get(i).getMethod().getMethodName().equalsIgnoreCase(methods.get(j).get("TestName"))) {
                    if(methods.get(j).get("execution").equalsIgnoreCase("Yes")) {
                        list.get(i).getMethod().setInvocationCount(Integer.parseInt(methods.get(j).get("count")));
                        finalList.add(list.get(i));
                    }

                }
            }
        }

        return finalList;
    }
}
