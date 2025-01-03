package StepDefinition;

import Pages.MyInfoPage;
import Pages.LoginPage;
import Utilities.DriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;



public class MyInfoStepDefinition extends DriverManager {
   //WebDriver driver;
//    LoginPage loginPage;
    MyInfoPage myinfopage;



    @When("I am on the Dashboard page")
    public void i_am_on_the_dashboard_page() {
//        loginPage = new LoginPage(DriverManager.driver);
//        WebDriver driver = setUpSuite();
//        System.out.println("driver = "+driver);
//        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
//        String actual = driver.getCurrentUrl();
//        Assert.assertEquals(actual, expected);
//        System.out.println("Navigated to Home Page: " + actual);
        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actual = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(actual, expected, "Failed to navigate to Dashboard.");
        System.out.println("Navigated to Home Page: " + actual);

    }

    @When("I click on the {string} menu")
    public void i_click_on_the_menu(String menuName) {
        MyInfoPage myinfopage = new MyInfoPage(driver);
        myinfopage.myInfoButtonClick();
        System.out.println("Clicked on MyInfo Button");
    }

    @Then("I should be navigated to the My Info page")
    public void i_should_be_navigated_to_the_my_info_page() {
        MyInfoPage myinfopage = new MyInfoPage(driver);
        System.out.println("drv="+driver);
        myinfopage.isDisplayed();
        System.out.println("Successfully login to the MyInfo page");
//        WebElement pageHeader = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(
//                        By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
//                ));
//        Assert.assertTrue(pageHeader.isDisplayed(), "My Info page is not displayed!");
    }





//    @Then("the page title should be {string}")
//    public void the_page_title_should_be(String expectedTitle) {
//        String actualTitle = DriverManager.getDriver()
//                .findElement(By.xpath("//h6[contains(text(),'" + expectedTitle + "')]")).getText();
//        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
//    }
}
