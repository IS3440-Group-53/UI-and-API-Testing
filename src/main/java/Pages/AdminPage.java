package Pages;

import org.openqa.selenium.By;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {
    WebDriver driver;
    WebDriverWait wait;
    By admin_button = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]");

    By pageHeader = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]");
    public AdminPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void adminButtonClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(admin_button)).click();}

    public void isDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
        String headerText = driver.findElement(pageHeader).getText();
        assert headerText.equals("Admin") : "Expected header to be 'Admin', but found: " + headerText;

    }

    public void adminMenuClick() {
    }
}
