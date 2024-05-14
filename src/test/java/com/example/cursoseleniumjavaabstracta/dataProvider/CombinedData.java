package com.example.cursoseleniumjavaabstracta.dataProvider;

import org.testng.annotations.DataProvider;


public class CombinedData {

    @DataProvider(name = "combinedData")
    public static Object[][] getCombinedData() {
        return new Object[][]{
                {"USD", "$", "MacBook", "$602.00"},
                {"EUR", "€", "iPhone", "96.66€"},
                {"USD", "$", "Canon EOS 5D", "$98.00"}
        };
    }
}