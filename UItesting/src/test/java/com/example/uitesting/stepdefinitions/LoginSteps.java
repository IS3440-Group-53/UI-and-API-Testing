package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver;

    @Given("Open the application")
    public void open_the_application() {

        //driver = new ChromeDriver();
        driver = new EdgeDriver();
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
        driver.close();
    }
}
