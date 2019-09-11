package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class seleniumeasyP2 {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\seleniumtesting\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void checkboxTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(1000);

        WebElement checkb = driver.findElementById("isAgeSelected");
        checkb.click();
        Thread.sleep(1000);

        WebElement output = driver.findElementById("txtAge");
        Thread.sleep(1000);

        assertEquals(output.getText(), "Success - Check box is checked");
    }

    @Test
    public void multiCBAllBoxesTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(1000);

        WebElement cb1 = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label");
        WebElement cb2 = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label");
        WebElement cb3 = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label");
        WebElement cb4 = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label");

        cb1.click();
        cb2.click();
        cb3.click();
        cb4.click();
        Thread.sleep(1000);

        WebElement btn = driver.findElementById("check1");

        assertEquals(btn.getAttribute("value"), "Uncheck All");

    }

}