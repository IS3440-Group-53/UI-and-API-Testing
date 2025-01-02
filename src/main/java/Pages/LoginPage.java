package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By username = By.xpath("//input[@placeholder='Username']");
    By password = By.xpath("//input[@placeholder='Password']");
    By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void TextInUsername(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).isDisplayed();
        driver.findElement(username).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(username).sendKeys(text);
    }

    public void CodeInPassword(String text) {
        driver.findElement(password).sendKeys(text);
    }

    public void LoginButtonClick() {
        driver.findElement(loginButton).sendKeys(Keys.RETURN);
    }

    public void login(String usernameText, String passwordText) {
        TextInUsername(usernameText);
        CodeInPassword(passwordText);
        LoginButtonClick();
    }
}


