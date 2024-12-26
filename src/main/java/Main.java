import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Main {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver( ).setup( ) ;
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Anuradha\\OneDrive - University of Moratuwa\\Desktop\\Selenium\\geckodriver.exe");

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
}