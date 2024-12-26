package UItesting.src.main.test.java.com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLoginTest {

    private WebDriver driver;
    private final String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private final String username = "Admin"; // Default demo username
    private final String password = "admin123"; // Default demo password

    @BeforeClass
    public void setUp() {
        // Set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testLogin() {
        System.out.println("Running login test...");
        // Locate the username, password, and login button elements
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.tagName("button"));

        // Perform login actions
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Add assertions to confirm successful login
        WebElement dashboardHeader = driver.findElement(By.tagName("h6")); // Dashboard header element
        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard is not displayed after login.");
        Assert.assertEquals(dashboardHeader.getText(), "Dashboard", "Dashboard header text does not match.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
