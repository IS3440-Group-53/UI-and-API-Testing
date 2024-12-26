import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TimeTab {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        // Create a wait object with 10 seconds timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to the website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Wait for username field and enter username
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")))
                .sendKeys("Admin");

        // Enter password
        driver.findElement(By.name("password")).sendKeys("admin123");

        // Click login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Go to Time tab
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Time']"))).click();

        // Wait for and click Time Sheets
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span"))).click();

        // Wait for and click Employee Time sheets
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li[2]/a"))).click();

        //click the view button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div/button"))).click();


//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div/div/div/div[2]/div/div/input"))).sendKeys("Ranga  Akunuri");
//
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/form/div[2]/button"))).click();

//        driver.close();
    }
}