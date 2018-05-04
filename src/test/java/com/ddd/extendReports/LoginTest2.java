package com.ddd.extendReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest2 {
    ExtentReports extentReports;
    ExtentTest extentTest;

    @BeforeClass
    public void setUP(){
        extentReports = ExtentFactory.getInstance();
        extentTest = extentReports.startTest("Thin is LoginTest2--> Vefification");

    }
    @Test
    public void testMethod(){
        extentTest.log(LogStatus.INFO, "This is LoginTest2 --> Test method starts.");
        extentTest.log(LogStatus.INFO, "This is LoginTest2 --> Test method continues.");
        extentTest.log(LogStatus.INFO, "This is LoginTest2 --> Test method ends.");

    }
    @AfterClass
    public void tearDown(){
        extentReports.endTest(extentTest);
        extentReports.flush();
    }

}
