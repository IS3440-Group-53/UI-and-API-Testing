package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class LoginSteps {

    WebDriver driver;

//    @Given("Open the application")
//    public void open_the_application() {
//
//        driver = new ChromeDriver();
////        driver = new EdgeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com");
//        driver.manage().window().maximize();
//    }

    @Given("Open the application")
    public void open_the_application() {
        // Set the path to the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\Acadamic Notes\\Lvl 4 Sem 1\\IS 3440 ITQA\\chromedriver-win64\\chromedriver.exe");

        // Set Brave browser options
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"); // Update with your Brave path

        // Initialize ChromeDriver with Brave binary
        driver = new ChromeDriver(options);

        // Open the application
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();
    }
    @When("Enter the valid username and password")
    public void enter_the_valid_username_and_password() {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Locate the username field
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys("Admin");

            // Locate the password field
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("admin123");

            // Locate and click the submit button
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            submitButton.click();
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
            e.printStackTrace();
        }

    }
    @Then("verify login should successfully done.")
    public void verify_login_should_successfully_done() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"OrangeHRM","Login page title mismatch!");
        softAssert.assertAll();
        //driver.close();
    }

    @Then("Verify key elements on the dashboard")
    public void verify_dashboard_elements() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

            // Verify Dashboard title
            WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header is not displayed!");

            // Verify the presence of the first widget (e.g., Quick Launch)
            WebElement quickLaunchWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("widgetId"))); // Replace with actual ID
            softAssert.assertTrue(quickLaunchWidget.isDisplayed(), "Quick Launch widget is not displayed!");

            // Verify the presence of a menu item (e.g., "Leave")
            WebElement leaveMenuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Leave']")));
            softAssert.assertTrue(leaveMenuItem.isDisplayed(), "Leave menu item is not displayed!");

            softAssert.assertAll();
        } catch (Exception e) {
            System.out.println("Error while verifying dashboard elements: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }
    @Then("Verify Employee Distribution by Subunit widget is interactive")
    public void verify_employee_distribution_widget() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Verify that the widget is visible
            WebElement widget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Employee Distribution by Subunit']")));
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(widget.isDisplayed(), "Employee Distribution by Subunit widget is not displayed!");

            // Verify that the chart inside the widget is visible
            WebElement chart = driver.findElement(By.xpath("//canvas[contains(@class, 'chart-canvas')]"));
            softAssert.assertTrue(chart.isDisplayed(), "Chart inside the Employee Distribution widget is not displayed!");

            // Verify interactivity: Check if tooltip appears when hovering over the chart
            Actions actions = new Actions(driver);
            actions.moveToElement(chart, 50, 50).perform(); // Move to a point on the chart

            WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'tooltip')]")));
            softAssert.assertTrue(tooltip.isDisplayed(), "Tooltip is not displayed on hovering over the chart!");

            softAssert.assertAll();
        } catch (Exception e) {
            System.out.println("Error while verifying Employee Distribution by Subunit widget: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }

}
