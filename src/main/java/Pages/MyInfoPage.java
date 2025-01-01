package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfoPage {
     WebDriver driver;
    WebDriverWait wait;
    By myInfo_button = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[6]/a[1]/span[1]");

    By pageHeader = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    public MyInfoPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void myInfoButtonClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myInfo_button)).click();}

    public void isDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
        String headerText = driver.findElement(pageHeader).getText();
        assert headerText.equals("My Info") : "Expected header to be 'My Info', but found: " + headerText;

    }

}
