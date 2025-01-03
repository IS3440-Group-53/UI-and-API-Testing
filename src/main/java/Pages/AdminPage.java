

package Pages;

import org.openqa.selenium.By;import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {
    WebDriver driver;
    WebDriverWait wait;
    By admin_button = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]");
    By pageHeader = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span");

    By userManagementChip = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span");
//    By add_button = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");

    By selectRole = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
    By employeeNameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");

    By searchUsernameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    By searchButton = By.xpath("//button[@type='submit']");
    By resetButton = By.xpath("//button[normalize-space()='Reset']");
    By UserInput = By.xpath("//input[@class='oxd-input oxd-input--focus']");


    public AdminPage(WebDriver driver) {

        this.driver = driver;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }


    //testcase1
    public void adminButtonClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(admin_button)).click();}

    public String getPageHeader(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
        String headerText = driver.findElement(pageHeader).getText();
//        assert headerText.equals("Admin") : "Expected header to be 'Admin', but found: " + headerText;
        return headerText;

    }

    public void searchUserByUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchUsernameInput));
        driver.findElement(searchUsernameInput).sendKeys("John Deo");
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void resetSearchFields() {
        wait.until(ExpectedConditions.elementToBeClickable(resetButton)).click();

    }
    public void clearfeilds(){
        wait.until(ExpectedConditions.elementToBeClickable(UserInput)).clear();
    }

    public String getSearchFieldValue() {
        return driver.findElement(searchUsernameInput).getAttribute("value");
    }

    //Testcase2
    public void clickAddUserButton() {
        By addUserButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
        wait.until(ExpectedConditions.elementToBeClickable(addUserButton)).click();
    }

    public void selectUserRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(selectRole)).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(role).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
    }

    public void enterEmployeeName(String employeeName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput)).sendKeys(employeeName);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
    }

    public void selectStatus(String status) {
        By statusDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(statusDropdown)).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(status).sendKeys(Keys.ENTER).perform();
    }

    public void enterUsername(String username) {
        By usernameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(username);
    }

    public void enterPassword(String password) {
        By passwordInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
    }

    public void confirmPassword(String confirmPassword) {
        By confirmPasswordInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordInput)).sendKeys(confirmPassword);
    }

    public void clickSaveButton() {
        By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }


//Testcase3

    public void editUser(String role, String employeeName, String status, String username) {
        // Locate and click the edit button for the specific user
        By editButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div[1]/div[2]/div/div/button[2]");
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();

        // Edit fields
        selectUserRole(role);
        enterEmployeeName(employeeName);
        selectStatus(status);

        // Save changes
        clickSaveButton();
    }






    public void adminMenuClick() {
    }

    public void enterUserRole(String johndoe) {
    }
}