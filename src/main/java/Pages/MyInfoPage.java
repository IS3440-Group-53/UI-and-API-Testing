package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class MyInfoPage {
    WebDriver driver;
    WebDriverWait wait;
    By myInfo_button = By.xpath("//span[normalize-space()='My Info']");

    By pageHeader = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    By Emp_FirstName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[1]/div[2]/input");
    By Emp_MiddleName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[2]/div[2]/input");
    By Emp_LastName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[3]/div[2]/input");

    By MaritalStatus = By.xpath("//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']");

    By SvButton = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']");
    By maleRadioButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/label/span");
    By femaleRadioButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/label/span");
    By addButton = By.xpath("//button[normalize-space()='Add']");

    By uploadBtn = By.xpath("//div[@class='oxd-file-button']");


    By commentInput = By.xpath("//textarea[@placeholder='Type comment here']");
    By AddSaveBtn = By.xpath("//div[@class='orangehrm-attachment']//button[@type='submit'][normalize-space()='Save']");
    By AddCancelBtn = By.xpath("//button[normalize-space()='Cancel']");
    By DeleteBtn = By.xpath("//i[@class='oxd-icon bi-trash']");
    By DeletePopUp = By.xpath("//div[@class='orangehrm-modal-header']");
    By YesDeleteBtn = By.xpath("//button[normalize-space()='Yes, Delete']");

    public MyInfoPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void myInfoButtonClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myInfo_button)).click();
    }

    public void isDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
        String headerText = driver.findElement(pageHeader).getText();
        assert headerText.equals("My Info") : "Expected header to be 'My Info', but found: " + headerText;
    }

    public void fillFullName() {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Emp_FirstName));
        firstNameElement.click();
        firstNameElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        firstNameElement.sendKeys("Anoja");

        WebElement middleNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Emp_MiddleName));
        middleNameElement.click();
        middleNameElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        middleNameElement.sendKeys("Dayas");

        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Emp_LastName));
        lastNameElement.click();
        lastNameElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        lastNameElement.sendKeys("Sliva");

    }

    public void fillMaritalStatus() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MaritalStatus)).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();

    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            wait.until(ExpectedConditions.elementToBeClickable(maleRadioButton)).click();
        } else if (gender.equalsIgnoreCase("Female")) {
            wait.until(ExpectedConditions.elementToBeClickable(femaleRadioButton)).click();
        } else {
            throw new IllegalArgumentException("Invalid gender provided: " + gender);
        }
    }

    public void clickSaveBtn() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(SvButton)).click();
    }

    public void addFile() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton)).click();
    }

    public void BrowserFile() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadBtn)).click();

    }

    public void addComment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentInput)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentInput)).sendKeys("Profile picture added");

    }

    public void AddSaveBtn() {

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(AddSaveBtn));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", saveButton);
    }

    public void AddCancel() {

        WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(AddCancelBtn));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", cancelButton);
    }

    public void ClickDeleteFile() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteBtn)).click();
    }

    public void DeletePopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DeletePopUp));
    }

    public void ConfirmDelete() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(YesDeleteBtn)).click();
    }

    public void ScrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

}
