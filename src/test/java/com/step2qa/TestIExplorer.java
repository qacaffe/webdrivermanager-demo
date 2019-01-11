package com.step2qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Rahul R on 1/11/2019
 * @version 1.0.1
 */
public class TestIExplorer {

    private WebDriver driver;

    @BeforeTest
    public void setup() {

        WebDriverManager.iedriver().setup();
        WebDriverManager.iedriver().arch32().setup();
        driver = new InternetExplorerDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com");

    }

    @Test
    public void openStep2QA() throws InterruptedException {

        driver.findElement(By.name("q")).sendKeys("Step2QA");

        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        WebElement link = driver.findElement(By.xpath("//*[contains(text(),'Elevate Quality Engineering')]"));

        link.click();

        Thread.sleep(5000);

        Assert.assertEquals(driver.getTitle(), "Step2QA – Elevate Quality Engineering", "Failed to open the clicked site.");

    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
