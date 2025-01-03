package StepDefinition;

import Pages.MyInfoPage;
import Pages.LoginPage;
import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;


public class MyInfoStepDefinition extends DriverManager {
    MyInfoPage myinfopage;

    //Login
    @When("I am on the Dashboard page")
    public void i_am_on_the_dashboard_page() {

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

        myinfopage.isDisplayed();
        System.out.println("Successfully login to the MyInfo page");

    }


    //FillFullName
    @When("clear and enter the full name field")
    public void clear_and_enter_the_full_name_field() {
        MyInfoPage myinfopage = new MyInfoPage(driver);
        myinfopage.fillFullName();
    }

    @Then("clicks the {string} button")
    public void clicks_the_button(String string) throws InterruptedException {
        Thread.sleep(3000);
        MyInfoPage myinfopage = new MyInfoPage(driver);
        myinfopage.clickSaveBtn();
    }

    //MetirialStatus

//    @When("the user selects {string} from the marital status dropdown")
//    public void the_user_selects_from_the_marital_status_dropdown(String string) throws InterruptedException{
//        MyInfoPage myinfopage = new MyInfoPage(driver);
//        Thread.sleep(2000);
//        myinfopage.fillMaritalStatus();
//    }
//    @Then("the marital status should be saved")
//    public void the_marital_status_should_be_saved() throws InterruptedException {
//        Thread.sleep(2000);
//        MyInfoPage myinfopage = new MyInfoPage(driver);
//        myinfopage.clickSaveBtn();
//    }

    //Gender Selection
    @When("the user selects {string} in the gender radio button")
    public void the_user_selects_in_the_gender_radio_button(String string) {
        MyInfoPage myinfopage = new MyInfoPage(driver);
        myinfopage.selectGender("Male");
        myinfopage.ScrollDown();

    }

    @Then("the gender selection should be saved")
    public void the_gender_selection_should_be_saved() throws InterruptedException {
        Thread.sleep(2000);
        MyInfoPage myinfopage = new MyInfoPage(driver);
        myinfopage.clickSaveBtn();
        myinfopage.ScrollDown();

    }


    //Delete Attachment
    @When("the user clicks delete icon for the attachment")
    public void the_user_clicks_delete_icon_for_the_attachment() {
        MyInfoPage myinfopage = new MyInfoPage(driver);
        myinfopage.ClickDeleteFile();
    }

    @When("confirms deletion in the popup")
    public void confirms_deletion_in_the_popup() throws InterruptedException {
        MyInfoPage myinfopage = new MyInfoPage(driver);
        myinfopage.DeletePopup();
        Thread.sleep(2000);
    }

    @Then("delete the Attachment")
    public void delete_the_attachment() throws InterruptedException {
        MyInfoPage myinfopage = new MyInfoPage(driver);
        myinfopage.ConfirmDelete();
        Thread.sleep(2000);
    }


    //add file
    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
        MyInfoPage myinfopage = new MyInfoPage(driver);
        myinfopage.addFile();
    }

    @When("the user selects an image file {string} from their computer")
    public void the_user_selects_an_image_file_from_their_computer(String string) throws AWTException, InterruptedException {
        MyInfoPage myinfopage = new MyInfoPage(driver);
        myinfopage.BrowserFile();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
        String filePath = "C:\\Users\\ASUS\\Desktop\\Test_image.png";
        StringSelection filePathSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
        Thread.sleep(2000);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }

    @When("the user enters {string} in the comment field")
    public void the_user_enters_in_the_comment_field(String string) throws InterruptedException {
        MyInfoPage myinfopage = new MyInfoPage(driver);
        Thread.sleep(2000);
        myinfopage.addComment();
        myinfopage.ScrollDown();

    }

    @Then("the user clicks the Save button")
    public void the_user_clicks_the_save_button() {
        MyInfoPage myinfopage = new MyInfoPage(driver);
        myinfopage.AddSaveBtn();
        myinfopage.AddCancel();

    }


}
