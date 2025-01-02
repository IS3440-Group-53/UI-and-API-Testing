package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

//    By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    By dashboardHeader = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    Map<String, By> widgets = new HashMap<>();

    By userProfileMenu = By.xpath("//span[@class='oxd-userdropdown-tab']");
    By aboutOption = By.xpath("//a[normalize-space()='About']");
    By supportOption = By.xpath("//a[normalize-space()='Support']");
    By changePasswordOption = By.xpath("//a[normalize-space()='Change Password']");
    By logoutOption = By.xpath("//a[normalize-space()='Logout']");
    By quickLaunchWidget = By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='oxd-grid-3 orangehrm-dashboard-grid']/div[1]/div[1]");
    By employeeDistributionWidget = By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='oxd-grid-3 orangehrm-dashboard-grid']/div[1]/div[1]");
    By pendingLeaveRequestsWidget = By.xpath("//div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget emp-leave-chart']//div[@class='orangehrm-dashboard-widget-header']']]");
    By searchBar = By.xpath("//input[@placeholder='Search']");
    By searchResults = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul");
    By pendingLeaveRequestsCount = By.xpath("//h6[text()='Pending Leave Requests']/following-sibling::div");
    By defaultDashboardWidgets = By.xpath("//div[contains(@class, 'dashboard-widget')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void isDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
        String headerText = driver.findElement(dashboardHeader).getText();
        assert headerText.equals("Dashboard") : "Expected header to be 'Dashboard', but found: " + headerText;
    }

    public boolean verifyAllWidgets() {
        boolean allWidgetsVisible = true;
        for (Map.Entry<String, By> widget : widgets.entrySet()) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(widget.getValue()));
                System.out.println(widget.getKey() + " is visible.");
            } catch (Exception e) {
                System.out.println(widget.getKey() + " is NOT visible.");
                allWidgetsVisible = false;
            }
        }
        return allWidgetsVisible;
    }
    public void clickUserProfileMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileMenu)).click();
    }

    public boolean verifyUserProfileOptions() {
        try {
            WebElement about = wait.until(ExpectedConditions.visibilityOfElementLocated(aboutOption));
            WebElement support =  wait.until(ExpectedConditions.visibilityOfElementLocated(supportOption));
            WebElement changePassword = wait.until(ExpectedConditions.visibilityOfElementLocated(changePasswordOption));
            WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutOption));
            return logout.isDisplayed() && about.isDisplayed() && support.isDisplayed() && changePassword.isDisplayed();
        } catch (Exception e) {
            System.out.println("User profile menu options are not visible: " + e.getMessage());
            return false;
        }
    }
    public void resizeWindow(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
        System.out.println("Window resized to: " + width + "x" + height);
    }

    public boolean isDashboardResponsive() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(quickLaunchWidget));
            wait.until(ExpectedConditions.visibilityOfElementLocated(employeeDistributionWidget));
            wait.until(ExpectedConditions.visibilityOfElementLocated(pendingLeaveRequestsWidget));
            System.out.println("Dashboard elements are visible at the current resolution.");
            driver.manage().window().maximize();
            return true;
        } catch (Exception e) {
            System.out.println("Dashboard elements are not responsive: " + e.getMessage());
            driver.manage().window().maximize();
            return false;
        }
    }
    public boolean isSearchBarVisible() {
        try {
            WebElement searchBarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
            return searchBarElement.isDisplayed();
        } catch (Exception e) {
            System.out.println("Search bar is not visible: " + e.getMessage());
            return false;
        }
    }

    public void enterSearchQuery(String query) {
        WebElement searchBarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        searchBarElement.clear();
        searchBarElement.sendKeys(query);
        searchBarElement.sendKeys(Keys.ENTER);
        System.out.println("Query entered in the search bar: " + query);
    }

    public boolean verifySearchResults(String query) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
            List<WebElement> results = driver.findElements(searchResults);
            for (WebElement result : results) {
                String resultText = result.getText().toLowerCase();
                if (!resultText.contains(query.toLowerCase())) {
                    System.out.println("Irrelevant result found: " + resultText);
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error verifying search results: " + e.getMessage());
            return false;
        }
    }
    public void clearSearchField() {
        try {
            WebElement searchBarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
            searchBarElement.click(); // Focus on the search bar
            searchBarElement.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
            searchBarElement.sendKeys(Keys.BACK_SPACE); // Clear the text
            System.out.println("Search field cleared.");
        } catch (Exception e) {
            System.out.println("Error clearing search field: " + e.getMessage());
        }
    }


    public boolean isDefaultDashboardRestored() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(defaultDashboardWidgets));
            List<WebElement> widgets = driver.findElements(defaultDashboardWidgets);
            return widgets.size() > 0;
        } catch (Exception e) {
            System.out.println("Error verifying default dashboard state: " + e.getMessage());
            return false;
        }
    }
    public boolean isPendingLeaveRequestsWidgetVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(pendingLeaveRequestsWidget));
            return true;
        } catch (Exception e) {
            System.out.println("Error locating Pending Leave Requests widget: " + e.getMessage());
            return false;
        }
    }

    public int getPendingLeaveRequestsCount() {
        try {
            WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pendingLeaveRequestsCount));
            return Integer.parseInt(countElement.getText());
        } catch (Exception e) {
            System.out.println("Error fetching Pending Leave Requests count: " + e.getMessage());
            return -1;
        }
    }

    public int getSystemPendingLeaveRequestsCount() {
        return 1;
    }

}
