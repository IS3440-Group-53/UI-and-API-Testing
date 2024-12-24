package com.example.uitesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChromeDriverTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DINESHI\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize the ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchButtonPresence() {
        // Navigate to the page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/performance/searchEvaluatePerformanceReview");

        // Locate the Search button
        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));

        // Assert that the Search button is displayed
        Assert.assertTrue(searchButton.isDisplayed(), "Search button is not displayed!");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
