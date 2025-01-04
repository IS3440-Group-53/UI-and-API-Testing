package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class DriverManager {
    public static WebDriver driver;
    private static final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeSuite
    public static WebDriver setUpSuite() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-software-rasterizer");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(url);
            System.out.println("Opened Chrome browser and navigated to URL: " + url);
        }
        return null;
    }
    public static WebDriver getDriver() {
        if (driver == null) {


            throw new IllegalStateException("Driver has not been initialized. Call setUpSuite first.");
        }
        return driver;
    }
//    public static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//            System.out.println("Driver has been closed.");
//        }
//    }
}
