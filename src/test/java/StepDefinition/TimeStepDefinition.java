
package StepDefinition;

import Pages.TimePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class TimeStepDefinition {
    WebDriver driver = LoginStepDefinition.driver;
    TimePage timePage;

    @When("I navigate to Time tab")
    public void navigateToTimeTab() {
        timePage = new TimePage(driver);
        timePage.clickTimeTab();
    }

    @When("I click on Timesheets tab")
    public void clickTimesheetsTab() {
        timePage.clickTimesheetsTab();
    }

    @When("I select My Timesheets")
    public void selectMyTimesheets() {
        timePage.clickMyTimesheets();
    }

    @When("I edit the timesheet")
    public void editTimesheet() {
        timePage.clickEdit();
        timePage.enterTestInTypeField();
        timePage.clickSave();
    }

    @When("I proceed to Attendance")
    public void proceedToAttendance() {
        timePage.clickAttendanceDropdown();
        timePage.clickPunchInOut();
        timePage.enterNoteText();
        timePage.clickInOutButton();  // Updated to use new method
    }
}
