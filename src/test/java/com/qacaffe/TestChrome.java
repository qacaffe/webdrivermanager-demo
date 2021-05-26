package com.qacaffe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Rahul R on 1/11/2021
 * @version 1.1.0
 */
public class TestChrome {

    private WebDriver driver;

    @BeforeTest
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com");

    }

    @Test
    public void openQACaffe_chrome() throws InterruptedException {

        driver.findElement(By.name("q")).sendKeys("QACaffe RahulR");

        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        driver.findElement(By.xpath("//h3[text()='QACaffe By RahulR']")).click();

        Thread.sleep(5000);

        Assert.assertEquals(driver.getTitle(), "QACaffe By RahulR",
                "Failed to open the clicked site.");

    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
