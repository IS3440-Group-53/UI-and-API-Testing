//
//package StepDefinition;
//
//import Pages.TimePage;
//import Utilities.DriverManager;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.cucumber.java.After;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import java.util.List;
//import java.util.Map;
//
//public class TimeStepDefinition {
//    private final WebDriver driver;
//    private final TimePage timePage;
//
//    public TimeStepDefinition() {
//        this.driver = DriverManager.getDriver();
//        this.timePage = new TimePage(driver);
//    }
//
//    @When("I navigate to Time tab")
//    public void navigateToTimeTab() {
//        timePage.clickTime();
//    }
//
//    @When("I click on Timesheets dropdown")
//    public void clickTimesheetsDropdown() {
//        timePage.clickTimesheetsDropdown();
//    }
//
//    @When("I select My Timesheet option")
//    public void selectMyTimesheetOption() {
//        timePage.selectMyTimesheetOption();
//    }
//
//    @When("I click the previous button {string} times")
//    public void clickPreviousButton(String times) {
//        timePage.clickPreviousButton(Integer.parseInt(times));
//    }
//
//    @When("I click Create Timesheet button")
//    public void clickCreateTimesheet() {
//        timePage.clickCreateTimesheet();
//    }
//
//    @When("I click Submit button")
//    public void clickSubmitButton() {
//        timePage.clickSubmit();
//    }
//
//    @When("I edit the timesheet")
//    public void editTimesheet() {
//        timePage.editTimesheet();
//    }
//
//    @When("I proceed to Project Info")
//    public void proceedToProjectInfo() {
//        timePage.clickProjectInfo();
//    }
//
//    @When("I select Customers option")
//    public void selectCustomersOption() {
//        timePage.selectCustomers();
//    }
//
//    @When("I create new customer with details:")
//    public void createNewCustomerWithDetails(DataTable dataTable) {
//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        Map<String, String> customerData = data.get(0);
//        timePage.createCustomer(customerData.get("name"), customerData.get("description"));
//    }
//
//    @When("I click the edit button for first customer")
//    public void clickEditButtonForFirstCustomer() {
//        timePage.editFirstCustomer();
//    }
//
//    @When("I attempt to create customer without name")
//    public void attemptCreateCustomerWithoutName() {
//        timePage.createCustomer("", "Test Description");
//    }
//
//    @When("I clear the description field")
//    public void clearDescriptionField() {
//        // This is handled in editFirstCustomer method
//    }
//
//    @When("I save the customer changes")
//    public void saveCustomerChanges() {
//        // This is handled in editFirstCustomer method
//    }
//
//    @After
//    public void cleanup(Scenario scenario) {
//        try {
//            // Add delay of 3 seconds before closing the browser
//            System.out.println("Waiting for 3 seconds before closing browser...");
//            Thread.sleep(3000); // 3 second delay
//
//        } catch (Exception e) {
//            System.out.println("Failed to take screenshot or wait: " + e.getMessage());
//        } finally {
//            // Close the browser
//            if (driver != null) {
//                try {
//                    System.out.println("Closing browser for scenario: " + scenario.getName());
//                    driver.quit();
//                } catch (Exception e) {
//                    System.out.println("Failed to close browser: " + e.getMessage());
//                }
//            }
//        }
//    }
//}
package StepDefinition;

import Pages.TimePage;

import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.SeverityLevel;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;


@Epic("Time Management")
@Feature("Timesheet and Customer Management")
public class TimeStepDefinition {
    private final WebDriver driver;
    private final TimePage timePage;

    public TimeStepDefinition() {
        this.driver = DriverManager.getDriver();
        this.timePage = new TimePage(driver);
    }

    @When("I navigate to Time tab")
    @Step("Navigating to Time tab")
    @Description("Click on Time tab in the navigation menu")
    @Severity(SeverityLevel.NORMAL)
    public void navigateToTimeTab() {
        timePage.clickTime();
    }

    @When("I click on Timesheets dropdown")
    @Step("Clicking Timesheets dropdown")
    @Description("Expand the Timesheets dropdown menu")
    @Severity(SeverityLevel.NORMAL)
    public void clickTimesheetsDropdown() {
        timePage.clickTimesheetsDropdown();
    }

    @When("I select My Timesheet option")
    @Step("Selecting My Timesheet option")
    @Description("Select My Timesheet from the dropdown menu")
    @Severity(SeverityLevel.NORMAL)
    public void selectMyTimesheetOption() {
        timePage.selectMyTimesheetOption();
    }

    @When("I click the previous button {string} times")
    @Step("Clicking previous button {0} times")
    @Description("Navigate to previous timesheet entries")
    @Severity(SeverityLevel.MINOR)
    public void clickPreviousButton(String times) {
        timePage.clickPreviousButton(Integer.parseInt(times));
    }

    @When("I click Create Timesheet button")
    @Step("Clicking Create Timesheet button")
    @Description("Create a new timesheet")
    @Severity(SeverityLevel.CRITICAL)
    public void clickCreateTimesheet() {
        timePage.clickCreateTimesheet();
    }

    @When("I click Submit button")
    @Step("Clicking Submit button")
    @Description("Submit the timesheet")
    @Severity(SeverityLevel.CRITICAL)
    public void clickSubmitButton() {
        timePage.clickSubmit();
    }

    @When("I edit the timesheet")
    @Step("Editing timesheet")
    @Description("Modify existing timesheet entries")
    @Severity(SeverityLevel.CRITICAL)
    public void editTimesheet() {
        timePage.editTimesheet();
    }

    @When("I proceed to Project Info")
    @Step("Navigating to Project Info")
    @Description("Access Project Information section")
    @Severity(SeverityLevel.NORMAL)
    public void proceedToProjectInfo() {
        timePage.clickProjectInfo();
    }

    @When("I select Customers option")
    @Step("Selecting Customers option")
    @Description("Navigate to Customers management section")
    @Severity(SeverityLevel.NORMAL)
    public void selectCustomersOption() {
        timePage.selectCustomers();
    }

    @When("I create new customer with details:")
    @Step("Creating new customer")
    @Description("Create a new customer with provided details")
    @Severity(SeverityLevel.CRITICAL)
    public void createNewCustomerWithDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> customerData = data.get(0);
        Allure.addAttachment("Customer Data", "application/json",
                String.format("{'name': '%s', 'description': '%s'}",
                        customerData.get("name"), customerData.get("description")));
        timePage.createCustomer(customerData.get("name"), customerData.get("description"));
    }

    @When("I click the edit button for first customer")
    @Step("Editing first customer")
    @Description("Edit details of the first customer in the list")
    @Severity(SeverityLevel.NORMAL)
    public void clickEditButtonForFirstCustomer() {
        timePage.editFirstCustomer();
    }

    @When("I attempt to create customer without name")
    @Step("Attempting to create customer without name")
    @Description("Negative test: Create customer with empty name field")
    @Severity(SeverityLevel.MINOR)
    public void attemptCreateCustomerWithoutName() {
        timePage.createCustomer("", "Test Description");
    }

    @When("I clear the description field")
    @Step("Clearing description field")
    @Description("Remove existing description from customer details")
    @Severity(SeverityLevel.MINOR)
    public void clearDescriptionField() {
        // This is handled in editFirstCustomer method
    }

    @When("I save the customer changes")
    @Step("Saving customer changes")
    @Description("Save modifications to customer details")
    @Severity(SeverityLevel.NORMAL)
    public void saveCustomerChanges() {
        // This is handled in editFirstCustomer method
    }

    @After
    public void cleanup(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                // Take screenshot if scenario fails
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Failed Scenario Screenshot",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        "png");
            }

            System.out.println("Waiting for 3 seconds before closing browser...");
            Thread.sleep(3000);

        } catch (Exception e) {
            Allure.addAttachment("Error Details", e.getMessage());
            System.out.println("Failed to take screenshot or wait: " + e.getMessage());
        } finally {
            if (driver != null) {
                try {
                    System.out.println("Closing browser for scenario: " + scenario.getName());
                    driver.quit();
                } catch (Exception e) {
                    Allure.addAttachment("Browser Closure Error", e.getMessage());
                    System.out.println("Failed to close browser: " + e.getMessage());
                }
            }
        }
    }
}

//    mvn allure:report
//    mvn allure:serve