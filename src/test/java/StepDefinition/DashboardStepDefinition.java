package StepDefinition;

import Pages.DashboardPage;
import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DashboardStepDefinition extends DriverManager {
    DashboardPage dashboardPage;

    @When("I am logged into the application")
    public void i_am_logged_into_the_application() {
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Failed to navigate to Dashboard after login.");
        System.out.println("Successfully logged into the Dashboard.");
    }

    @Then("I should see the Dashboard page")
    public void i_should_see_the_dashboard_page() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        System.out.println("drv="+driver);
        dashboardPage.isDisplayed();
        System.out.println("Dashboard page is displayed successfully.");
    }

    @Then("I should see all widgets on the Dashboard")
    public void i_should_see_all_widgets_on_the_dashboard() {
        dashboardPage = new DashboardPage(driver);
        boolean areWidgetsVisible = dashboardPage.verifyAllWidgets();
        Assert.assertTrue(areWidgetsVisible, "Not all widgets are visible on the Dashboard.");
        System.out.println("All widgets are displayed successfully on the Dashboard.");
    }

    @When("I click on the user profile menu")
    public void i_click_on_the_user_profile_menu() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserProfileMenu();
        System.out.println("User profile menu is opened successfully.");
    }

    @Then("I should see options like Logout and About")
    public void i_should_see_options_like_logout_and_about() {
        dashboardPage = new DashboardPage(driver);
        boolean areOptionsDisplayed = dashboardPage.verifyUserProfileOptions();
        Assert.assertTrue(areOptionsDisplayed, "User profile menu options are not displayed correctly.");
        System.out.println("User profile menu options are displayed successfully.");
    }
    @Then("I validate responsiveness of the Dashboard at various screen sizes")
    public void i_validate_responsiveness_of_the_dashboard_at_various_screen_sizes() {
        dashboardPage = new DashboardPage(driver);

        // Test for desktop resolution
        dashboardPage.resizeWindow(1920, 1080);
        boolean isDesktopResponsive = dashboardPage.isDashboardResponsive();
        Assert.assertTrue(isDesktopResponsive, "Dashboard is not responsive on desktop resolution.");

        // Test for tablet resolution
        dashboardPage.resizeWindow(768, 1024);
        boolean isTabletResponsive = dashboardPage.isDashboardResponsive();
        Assert.assertTrue(isTabletResponsive, "Dashboard is not responsive on tablet resolution.");

        // Test for mobile resolution
        dashboardPage.resizeWindow(375, 667);
        boolean isMobileResponsive = dashboardPage.isDashboardResponsive();
        Assert.assertTrue(isMobileResponsive, "Dashboard is not responsive on mobile resolution.");

        driver.manage().window().maximize();
        System.out.println("Window maximized after responsiveness testing.");
        System.out.println("Dashboard is responsive at all tested screen sizes.");
    }
    @When("I navigate to the Dashboard page and locate the Pending Leave Requests widget")
    public void i_navigate_to_the_dashboard_page_and_locate_the_pending_leave_requests_widget() {
        dashboardPage = new DashboardPage(driver);

        // Verify navigation to the Dashboard
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Failed to navigate to the Dashboard page.");
        System.out.println("Successfully navigated to the Dashboard page.");

        // Verify visibility of the Pending Leave Requests widget
        boolean isWidgetVisible = dashboardPage.isPendingLeaveRequestsWidgetVisible();
        Assert.assertTrue(isWidgetVisible, "Pending Leave Requests widget is not visible on the Dashboard.");
        System.out.println("Pending Leave Requests widget is visible on the Dashboard.");
    }

    @Then("I verify the Pending Leave Requests count matches the system data")
    public void i_verify_the_pending_leave_requests_count_matches_the_system_data() {
        dashboardPage = new DashboardPage(driver);

        // Get the count displayed on the widget
        int displayedCount = dashboardPage.getPendingLeaveRequestsCount();
        System.out.println("Displayed Pending Leave Requests count: " + displayedCount);

        // Mock system count (replace with actual system API or database call)
        int actualSystemCount = dashboardPage.getSystemPendingLeaveRequestsCount();
        System.out.println("Actual Pending Leave Requests count from the system: " + actualSystemCount);

        // Assertion to verify the counts match
        Assert.assertEquals(displayedCount, actualSystemCount, "Mismatch in Pending Leave Requests count.");
        System.out.println("Pending Leave Requests count matches the system data.");
    }
    @When("I type {string} into the search bar on the Dashboard")
    public void i_type_into_the_search_bar_on_the_dashboard(String query) {
        dashboardPage = new DashboardPage(driver);
        boolean isSearchBarVisible = dashboardPage.isSearchBarVisible();
        Assert.assertTrue(isSearchBarVisible, "Search bar is not visible on the Dashboard.");
        dashboardPage.enterSearchQuery(query);
        System.out.println("Typed query into the search bar: " + query);
    }

    @Then("I should see results relevant to {string}")
    public void i_should_see_results_relevant_to(String query) {
        dashboardPage = new DashboardPage(driver);
        boolean areResultsRelevant = dashboardPage.verifySearchResults(query);
        Assert.assertTrue(areResultsRelevant, "Search results are not relevant to the query: " + query);
        System.out.println("Search results are relevant to the query: " + query);
    }

    @Then("the Dashboard is restored to its default state after clearing the search bar")
    public void the_dashboard_is_restored_to_its_default_state_after_clearing_the_search_bar() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clearSearchField();
        boolean isDefaultRestored = dashboardPage.isDefaultDashboardRestored();
        Assert.assertTrue(isDefaultRestored, "The Dashboard is not restored to its default state after clearing the search bar.");
        System.out.println("Dashboard restored to its default state.");
    }
}