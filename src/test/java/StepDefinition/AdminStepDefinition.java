package StepDefinition;

import Pages.AdminPage;
import Pages.MyInfoPage;
import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static Utilities.DriverManager.driver;

public class AdminStepDefinition extends DriverManager {
    //WebDriver driver;
//    LoginPage loginPage;
    AdminPage adminPage;

    @When("I am on the My Info page")
    public void i_am_on_the_my_info_page() {

        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
        String actual = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(actual, expected, "Failed to navigate to MyInfo.");
        System.out.println("Navigated to Home Page: " + actual);


    }

//    @When("I am on the MyInfo page")
//    public void i_am_on_the_my_info_page() {
////
//        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7";
//        String actual = DriverManager.getDriver().getCurrentUrl();
//        Assert.assertEquals(actual, expected, "Failed to navigate to MyInfo.");
//        System.out.println("Navigated to Home Page: " + actual);
//
//    }

    @When("I click on the {string} menu on the Admin Page")
    public void i_click_on_the_menu(String menuName) {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.adminButtonClick();
        System.out.println("Clicked on Admin Menu Button");
    }


    @Then("I should be navigated to the Admin page")
    public void i_should_be_navigated_to_the_admin_page() {
        AdminPage adminPage = new AdminPage(driver);
        System.out.println("drv="+driver);
        adminPage.isDisplayed();
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