package com.example.uitesting.stepdefinitions;

import com.example.uitesting.pages.PerformancePage;
import com.example.uitesting.utilities.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SearchButtonSteps {
    private PerformancePage performancePage;

    @Given("I navigate to the performance review search page")
    public void navigateToPerformanceReviewSearchPage() {
        DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/performance/searchEvaluatePerformanceReview");
        performancePage = new PerformancePage(DriverManager.getDriver());
    }

    @Then("I verify the Search button is available")
    public void verifySearchButtonIsAvailable() {
        Assert.assertTrue(performancePage.isSearchButtonPresent(), "Search button is not available on the page.");
    }
}
