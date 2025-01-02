package StepDefinition;

import io.github.bonigarcia.wdm.WebDriverManager;
import Utilities.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import Pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinition extends DriverManager {
    LoginPage loginPage;

    //WebDriver driver;


    @Given("Open the application")
    public void open_the_application() {
//        WebDriverManager.chromedriver().setup();
//        loginPage = new LoginPage(DriverManager.getDriver());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Ensure this URL is correct

        loginPage = new LoginPage(driver); // Initialize LoginPage object
    }

    @When("Enter the valid username and password")
    public void enter_the_valid_username_and_password() {

        LoginPage loginpage = new LoginPage(driver);
        loginpage.TextInUsername("Admin");
        System.out.println("Entered Valid Username");
        loginpage.CodeInPassword("admin123");
        System.out.println("Entered Valid password");
        loginpage.LoginButtonClick();
        System.out.println("Clicked on login submit button");

      }
//    @Then("verify login should successfully done.")
//    public void verify_login_should_successfully_done() {
//        SoftAssert softAssert = new SoftAssert();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
//
//        try {
//
//            WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
//            ));
//
//            // Retrieve text and compare
//            String actualTitle = headerElement.getText();
//            String expectedTitle = "Dashboard";
//            softAssert.assertEquals(actualTitle, expectedTitle, "Login page title mismatch!");
//
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            softAssert.fail("Element not found: " + e.getMessage());
//        } catch (org.openqa.selenium.TimeoutException e) {
//            softAssert.fail("Element was not visible within the timeout: " + e.getMessage());
//        }
//
//        softAssert.assertAll();
//    }

//   @Then("Close the driver")
//   public void close(){
//       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//       driver.close();
//   }

}
