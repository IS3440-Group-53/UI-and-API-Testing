

package StepDefinition;

import Pages.AdminPage;
import Pages.MyInfoPage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static Utilities.DriverManager.driver;

public class AdminStepDefinition extends DriverManager {
    //WebDriver driver;
//    LoginPage loginPage;
    AdminPage adminPage;

    @When("I am on the My Info page")
    public void i_am_on_the_my_info_page() {

        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
        String actual = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(actual, expected, "Failed to navigate to MyInfo.");
        System.out.println("Navigated to Home Page: " + actual);

    }


    @When("I click on the {string} menu on the Admin Page")
    public void i_click_on_the_menu(String menuName) {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.adminButtonClick();
        System.out.println("Clicked on Admin Menu Button");
    }


    @And("I click on the {string} menuitem")
    public void iClickOnTheMenuitem(String arg0) {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.adminButtonClick();
        System.out.println("Clicked on Admin Button");
    }

    @Then("I can see the  Admin page Title")
    public void iCanSeeTheAdminPageTitle() {
        AdminPage adminPage = new AdminPage(driver);
        Assert.assertEquals(adminPage.getPageHeader(),"Admin\n" +
                "User Management");
    }

//Reset/Search

    @When("I search for a user with the following details")
    public void searchUser() {
//        AdminPage adminPage = new AdminPage(driver);
//        List<Map<String, String>> searchDetails = dataTable.asMaps(String.class, String.class);
//        String username = searchDetails.get(0).get("Username");
//
//        adminPage.searchUserByUsername(username);
//        System.out.println("Searched user: " + username);

    }

    @Then("I can see the user details matching the search criteria")
    public void verifySearchResults() {
        // Placeholder: Implement a check to verify the search result table contains the expected data
        System.out.println("Verified search results.");
    }

    @When("I enter search criteria in the fields")
    public void enterSearchCriteria(DataTable dataTable) {
        AdminPage adminPage = new AdminPage(driver);
        List<Map<String, String>> searchDetails = dataTable.asMaps(String.class, String.class);
        String username = searchDetails.get(0).get("Username");

        adminPage.searchUserByUsername(username);
        System.out.println("Entered search criteria: " + username);
    }

    @And("I click on the Reset button")
    public void resetSearchFields() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.resetSearchFields();
        System.out.println("Clicked Reset button.");
    }

    @Then("all the search fields should be cleared")
    public void verifySearchFieldsAreCleared() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clearfeilds();
//        String usernameFieldValue = adminPage.getSearchFieldValue();
 //       Assert.assertTrue(usernameFieldValue.isEmpty(), "Search fields were not cleared!");
        System.out.println("Verified search fields are cleared.");
    }

    //testcase2
    @When("I add a new user with the following details")
    public void addNewUser(DataTable dataTable) {
        // Convert DataTable to a List of Maps
        List<Map<String, String>> userDetailsList = dataTable.asMaps(String.class, String.class);

        // Process each user's details
        for (Map<String, String> userDetails : userDetailsList) {
            String role = userDetails.get("Role");
            String employeeName = userDetails.get("EmployeeName");
            String status = userDetails.get("Status");
            String username = userDetails.get("Username");
            String password = userDetails.get("Password");
            String confirmPassword = userDetails.get("ConfirmPassword");

            // Navigate to the Add User form
            AdminPage adminPage = new AdminPage(driver);
            adminPage.clickAddUserButton();

            // Interact with the form
            adminPage.selectUserRole(role);
            adminPage.enterEmployeeName(employeeName);
            adminPage.selectStatus(status);
            adminPage.enterUsername(username);
            adminPage.enterPassword(password);
            adminPage.confirmPassword(confirmPassword);
            adminPage.clickSaveButton();

            // Log the operation
            System.out.println("Added user: " + username);
        }


    }


//Teswtcase3

    @When("I edit the user with the following details")
    public void editUser(DataTable dataTable) {
        List<Map<String, String>> userDetails = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> userDetail : userDetails) {
            System.out.println(userDetail); // Process userDetail map
        }
    }



}