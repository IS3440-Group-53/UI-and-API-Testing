package com.example.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PerformancePage {
    private WebDriver driver;

    // Existing locators
    private By searchButtonLocator = By.xpath("//button[text()='Search']");
    // New locator for the Reset button
    private By resetButtonLocator = By.xpath("//button[text()='Reset']");

    public PerformancePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchButtonDisplayed() {
        return driver.findElement(searchButtonLocator).isDisplayed();
    }

    public boolean isResetButtonDisplayed() {
        return driver.findElement(resetButtonLocator).isDisplayed();
    }
}
