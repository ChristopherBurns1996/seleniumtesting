package com.qa;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReportsTest {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\seleniumtesting\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void reportTest(){
        ExtentReports extent = new ExtentReports("C:\\Users\\admin\\Desktop\\testResult\\screenshot\\automationreport.html", true);
        ExtentTest test;

        test = extent.startTest("Verify Application Title");
        test.log(LogStatus.INFO, "Browser started");
        test.log(LogStatus.PASS, "verify Title of the page");
        extent.endTest(test);
        extent.flush();
    }
}
