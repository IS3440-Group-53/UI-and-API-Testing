package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;

public class LoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup WebDriver Manager to handle browser drivers
        WebDriverManager.chromedriver().setup();

        // ChromeOptions to handle any security restrictions (e.g., --remote-allow-origins)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize ChromeDriver
        driver = new ChromeDriver(options);

        // Navigate to the login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void testLogin() {
        // Find and interact with the login form
        driver.findElement(By.name("username")).sendKeys("Admin"); // Enter username
        driver.findElement(By.name("password")).sendKeys("admin123"); // Enter password
        driver.findElement(By.xpath("//button[@type='submit']")).click(); // Click login button

        // Wait for the next page to load (can be done with an explicit wait in real tests)
        try {
            Thread.sleep(2000); // Sleep for 2 seconds (avoid in production code, use WebDriverWait)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Validate the successful login by checking the URL or any element on the dashboard page
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl = driver.getCurrentUrl();

        // Assert that the URL matches expected URL after successful login
        Assert.assertEquals(actualUrl, expectedUrl, "Login failed! User is not redirected to the dashboard page.");
    }

    // Cleanup after test
    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
