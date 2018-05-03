package com.ddd.extendReports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots2 {
    public static String takeScreenshot2(WebDriver driver, String fileName) throws IOException {
        fileName = fileName+".png";
        String directory = "D:\\Java\\Reports\\screenshots\\";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory+fileName));
        String destination = directory + fileName;
        return destination;
    }
}
