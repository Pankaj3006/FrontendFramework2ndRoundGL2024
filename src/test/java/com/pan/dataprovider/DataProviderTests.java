package com.pan.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTests {

    @Test(dataProvider="getData1")
    void test1(Employee employee)
    {
        System.out.println("***************** Test1 ******************");
        System.out.println(employee.getId() + " : " + employee.getName());
    }

    @DataProvider
    public Object[] getData1() {

        return new Employee[] {new Employee(12, "Pankaj"), new Employee(14, "Divyank")};
    }

    @Test(dataProvider="getData2")
    void test2(Employee employee)
    {
        System.out.println("**************** Test2 ******************");
        System.out.println(employee.getId() + " : " + employee.getName());
    }

    @DataProvider
    public Object[][] getData2() {

        return new Employee[][] {
                {new Employee(12, "Pankaj")},
                {new Employee(14, "Divyank")}
        };
    }

    @Test(dataProvider="getData3")
    void test3(String str)
    {
        System.out.println("**************** Test3 ******************");
        System.out.println(str);
    }

    @DataProvider
    public Object[] getData3() {

        return new String[] {"Pankaj", "Divyank"};
    }

    @Test(dataProvider="getData4")
    void test4(String str)
    {
        System.out.println("**************** Test4 ******************");
        System.out.println(str);
    }

    @DataProvider
    public Object[][] getData4() {

        return new String[][] {
                {"Pankaj"},
                {"Divyank"}
        };
    }

    @Test(dataProvider="getData5")
    void test5(String str1, String str2)
    {
        System.out.println("**************** Test5 ******************");
        System.out.println(str1);
        System.out.println(str2);
    }

    @DataProvider
    public Object[][] getData5() {

        return new String[][] {
                {"Pankaj", "Gunjan"},
                {"Divyank", "Radha"}
        };
    }

    @Test(dataProvider="getData6")
    void test6(Employee employee1, Employee employee2)
    {
        System.out.println("**************** Test6 ******************");
        System.out.println(employee1.getId() + " : " + employee1.getName());
        System.out.println(employee2.getId() + " : " + employee2.getName());
    }

    @DataProvider
    public Object[][] getData6() {

        return new Employee[][] {
                {new Employee(12, "Pankaj"), new Employee(13, "Rani")},
                {new Employee(14, "Divyank"), new Employee(15, "Radha")}
        };
    }
}
