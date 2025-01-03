
package StepDefinition;

import Pages.TimePage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

    @When("I click on Timesheets tab")
    public void clickTimesheetsTab() {
        timePage.clickTimesheets();
    }

    @When("I select My Timesheet option")
    public void selectMyTimesheetOption() {
        timePage.selectMyTimesheetOption();
    }

    @When("I select My Timesheets")
    public void selectMyTimesheets() {
        timePage.clickMyTimesheet();
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

    @Then("The new timesheet should be created")
    public void verifyTimesheetCreated() {
        // Add verification logic here if needed
    }

    @When("I edit the timesheet")
    public void editTimesheet() {
        timePage.clickEditButton();
        timePage.enterTypeFieldData();
        timePage.clickSaveButton();
    }

    @Then("The timesheet should be saved successfully")
    public void verifyTimesheetSaved() {
        // Add verification logic here
    }

    @When("I proceed to Project Info")
    public void proceedToProjectInfo() {
        timePage.clickProjectInfo();
        timePage.selectCustomers();
    }

    @When("I create new customer with details:")
    public void createNewCustomerWithDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> customerData = data.get(0);

        timePage.clickAddCustomer();
        timePage.enterCustomerDetails(
                customerData.get("name"),
                customerData.get("description")
        );
        timePage.saveCustomer();
    }

    @Then("The customer should be created successfully")
    public void verifyCustomerCreated() {
        // Add verification logic here
    }

    @When("I attempt to create customer without name")
    public void attemptCustomerCreateWithoutName() {
        timePage.clickAddCustomer();
        timePage.enterCustomerDetails("", "Test Description");
        timePage.saveCustomer();
    }

    @Then("I should see the required field validation message")
    public void verifyValidationMessage() {
        // Add verification logic here
    }
}