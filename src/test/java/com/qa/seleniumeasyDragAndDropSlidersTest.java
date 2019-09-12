package com.qa;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class seleniumeasyDragAndDropSlidersTest {
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
    public void sliderTest() throws InterruptedException {

        ExtentReports extent = new ExtentReports("C:\\Users\\admin\\Desktop\\testResult\\screenshot\\automationreport.html", true);
        ExtentTest test;

        test = extent.startTest("Slider Test");

        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");

        test.log(LogStatus.INFO, "Browser started");

        WebElement slider1 = driver.findElementByXPath("//*[@id=\"slider1\"]/div/input");

        Actions action = new Actions(driver);
        Thread.sleep(2000);

        action.moveToElement(slider1).dragAndDropBy(slider1, 10, 0).perform();
        Thread.sleep(2000);

        WebElement output = driver.findElementById("range");
        String value = output.getText();
        System.out.println(value);

        if(value.equals("53")){
            System.out.println(value);
            test.log(LogStatus.PASS, "verify Title of the page");
        } else {
            System.out.println("failure");
            test.log(LogStatus.FAIL, "verify Title of the page");
        }
        extent.endTest(test);
        extent.flush();
    }
}
