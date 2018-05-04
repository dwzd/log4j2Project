package com.ddd.PageObject;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver = null;
    ExtentTest extentTest;

    public HomePage(WebDriver driver, ExtentTest extentTest){
        this.driver = driver;
        this.extentTest = extentTest;
    }

    public void enterUsernameText(String username){
        WebElement emailUser = driver.findElement(By.id("u"));
        emailUser.sendKeys(username);
        extentTest.log(LogStatus.INFO, "Here enter your username---");
    }
    public void enterPassword(String password){
        WebElement emailKey = driver.findElement(By.id("p"));
        emailKey.sendKeys(password);
        extentTest.log(LogStatus.INFO, "To enter password---");
    }
    public void clickButton(){
        driver.findElement(By.id("login_button")).click();
        extentTest.log(LogStatus.INFO, "To log in the email box---");
    }

    public void login(String userName, String pwd){
        enterUsernameText(userName);
        enterPassword(pwd);
        clickButton();
    }

    public boolean isWelcomeTextPresent(){
        WebElement welcomeText = null;
        try{
            welcomeText = driver.findElement(By.xpath("//span[@id='useraddr']"));
            if(welcomeText != null){
                return true;
            }
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }
}
