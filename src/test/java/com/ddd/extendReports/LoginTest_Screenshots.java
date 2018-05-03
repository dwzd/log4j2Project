package com.ddd.extendReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest_Screenshots {
    private WebDriver driver;
    private String baseUrl;
    ExtentReports extentReports;
    ExtentTest extentTest;

    @BeforeClass
    public void setUp(){
        baseUrl = "https://mail.qq.com";
        extentReports = new ExtentReports("D:\\Java\\Reports\\logintest.html");
        extentTest = extentReports.startTest("Watching if the login is successfully!");

        driver = new ChromeDriver();
        extentTest.log(LogStatus.INFO, "Started the browser---");
        driver.manage().window().maximize();
        extentTest.log(LogStatus.INFO, "Browser maximized---");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1_loginTest() throws InterruptedException {
        driver.get(baseUrl);
        extentTest.log(LogStatus.INFO, "To input url---");
        driver.switchTo().frame("login_frame");
        Thread.sleep(10);
        WebElement emailUser = driver.findElement(By.id("u"));
        emailUser.sendKeys("3087942612");
        extentTest.log(LogStatus.INFO, "To input username---");
        WebElement emailKey = driver.findElement(By.id("p"));
        emailKey.sendKeys("conans888");
        extentTest.log(LogStatus.INFO, "To input password---");
        driver.findElement(By.id("login_button")).click();
        extentTest.log(LogStatus.INFO, "To log in the email box---");

        Thread.sleep(3000);
        WebElement welcomeText = null;
        try{
            welcomeText = driver.findElement(By.xpath("//span[@id='useraddr']"));
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(welcomeText.getText(), "3087942612@qq.com");
        extentTest.log(LogStatus.PASS, "Checking if login is successfully!!!");
    }
    @AfterMethod
    public void tearDown(ITestResult testResult) throws InterruptedException, IOException {
        
        if (testResult.getStatus() == ITestResult.FAILURE){
            String path = Screenshots2.takeScreenshot2(driver, testResult.getName());
            String imagepath = extentTest.addScreenCapture(path);
            extentTest.log(LogStatus.FAIL, "The login is failed!!!", imagepath);
        }
        Thread.sleep(3000);
        driver.quit();
        extentReports.endTest(extentTest);
        extentReports.flush();
    }

}
