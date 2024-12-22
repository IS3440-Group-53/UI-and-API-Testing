package com.example.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PerformancePage {
    private WebDriver driver;

    private By searchButtonLocator = By.xpath("//button[text()='Search']");

    public PerformancePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchButtonPresent() {
        WebElement searchButton = driver.findElement(searchButtonLocator);
        return searchButton.isDisplayed();
    }
}
