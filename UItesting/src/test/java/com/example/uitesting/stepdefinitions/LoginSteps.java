import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginSteps  {
    protected static WebDriver driver;
    WebDriverWait wait;
    String url ="https://opensource-demo.orangehrmlive.com";


    @Given("Open the application")
    public void open_the_application() {
//      System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe"); // Update the path if necessary
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

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

    }
    @Then("Close the driver")
    public void close(){
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.close();
    }

}
