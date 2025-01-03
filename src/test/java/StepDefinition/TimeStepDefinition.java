
package StepDefinition;

import Pages.TimePage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;

public class TimeStepDefinition {
    private final WebDriver driver;
    private final TimePage timePage;

    public TimeStepDefinition() {
        this.driver = DriverManager.getDriver();
        this.timePage = new TimePage(driver);
    }

    @When("I navigate to Time tab")
    public void navigateToTimeTab() {
        timePage.clickTime();
    }

    @When("I click on Timesheets dropdown")
    public void clickTimesheetsDropdown() {
        timePage.clickTimesheetsDropdown();
    }

    @When("I select My Timesheet option")
    public void selectMyTimesheetOption() {
        timePage.selectMyTimesheetOption();
    }

    @When("I click the previous button {string} times")
    public void clickPreviousButton(String times) {
        timePage.clickPreviousButton(Integer.parseInt(times));
    }

    @When("I click Create Timesheet button")
    public void clickCreateTimesheet() {
        timePage.clickCreateTimesheet();
    }

    @When("I click Submit button")
    public void clickSubmitButton() {
        timePage.clickSubmit();
    }

    @When("I edit the timesheet")
    public void editTimesheet() {
        timePage.editTimesheet();
    }

    @When("I proceed to Project Info")
    public void proceedToProjectInfo() {
        timePage.clickProjectInfo();
    }

    @When("I select Customers option")
    public void selectCustomersOption() {
        timePage.selectCustomers();
    }

    @When("I create new customer with details:")
    public void createNewCustomerWithDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> customerData = data.get(0);
        timePage.createCustomer(customerData.get("name"), customerData.get("description"));
    }

    @When("I click the edit button for first customer")
    public void clickEditButtonForFirstCustomer() {
        timePage.editFirstCustomer();
    }

    @When("I attempt to create customer without name")
    public void attemptCreateCustomerWithoutName() {
        timePage.createCustomer("", "Test Description");
    }

    @When("I clear the description field")
    public void clearDescriptionField() {
        // This is handled in editFirstCustomer method
    }

    @When("I save the customer changes")
    public void saveCustomerChanges() {
        // This is handled in editFirstCustomer method
    }

    @After
    public void cleanup(Scenario scenario) {
        try {
            // Add delay of 3 seconds before closing the browser
            System.out.println("Waiting for 3 seconds before closing browser...");
            Thread.sleep(3000); // 3 second delay

        } catch (Exception e) {
            System.out.println("Failed to take screenshot or wait: " + e.getMessage());
        } finally {
            // Close the browser
            if (driver != null) {
                try {
                    System.out.println("Closing browser for scenario: " + scenario.getName());
//                    driver.quit();
                } catch (Exception e) {
                    System.out.println("Failed to close browser: " + e.getMessage());
                }
            }
        }
    }
}