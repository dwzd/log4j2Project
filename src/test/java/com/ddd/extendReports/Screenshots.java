package com.ddd.extendReports;

//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class Screenshots {
    public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
        fileName = fileName+".png";
        String directory = "D:\\Java\\Reports\\screenshots";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory+fileName));
    }
}
