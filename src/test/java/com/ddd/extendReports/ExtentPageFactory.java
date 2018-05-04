package com.ddd.extendReports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentPageFactory {
    public static ExtentReports getInstance(){
        ExtentReports extentReports;
        String path = "D:\\Java\\Reports\\PageObjectReport.html";
        extentReports = new ExtentReports(path, false);
        extentReports.addSystemInfo("Selenium Webdriver version: ", "3.11").addSystemInfo("Platform: ", "Windows 10");
        return extentReports;
    }
}
