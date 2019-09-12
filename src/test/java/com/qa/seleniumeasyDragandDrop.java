package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class seleniumeasyDragandDrop {
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
    public void mouseMoveTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
        Thread.sleep(1000);

        Actions action = new Actions(driver);

        WebElement drag1 = driver.findElementByXPath("//*[@id=\"todrag\"]/span[1]");
        WebElement dropbox = driver.findElementById("mydropzone");
        action.moveToElement(drag1).dragAndDrop(drag1, dropbox).perform();
        action.moveByOffset(100, 200).perform();
        Thread.sleep(1000);
    }
}
