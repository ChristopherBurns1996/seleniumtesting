package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class seleniumeasyP1 {
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
    public void input1() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(1000);

        WebElement input = driver.findElementById("user-message");
        input.sendKeys("testtext");

        WebElement inputButton = driver.findElementByXPath("//*[@id=\"get-input\"]/button");
        inputButton.click();
        Thread.sleep(1000);

        WebElement displayarea = driver.findElementById("display");
        Thread.sleep(1000);

        assertEquals("testtext", displayarea.getText());
    }

    @Test
    public void input2() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(1000);

        WebElement input1 = driver.findElementById("sum1");
        input1.sendKeys("1");

        WebElement input2 = driver.findElementById("sum2");
        input2.sendKeys("2");

        WebElement inputButton = driver.findElementByXPath("//*[@id=\"gettotal\"]/button");
        inputButton.click();
        Thread.sleep(1000);

        WebElement displayarea = driver.findElementById("displayvalue");
        Thread.sleep(1000);

        assertEquals("3", displayarea.getText());
    }
}
