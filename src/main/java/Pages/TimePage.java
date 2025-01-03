
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TimePage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By timeTab = By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a");
    By timesheetsDropdown = By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span");
    By myTimesheetOption = By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li[1]/a");
    By projectInfoDropdown = By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span");
    By customersOption = By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[4]/ul/li[1]");
    By previousButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/form/div[1]/div[2]/div/button[1]/i");
    By createTimesheetButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button");
    By submitButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button[2]");
    By editButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button[1]");
    By typeField = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/form/div[2]/table/tbody/tr[1]/td[1]/div/div[2]/div/div/input");
    By saveButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button[3]");
    By addCustomerButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[1]/div/button");
    By customerNameField = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");
    By customerDescriptionField = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea");
    By customerSaveButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    By firstCustomerEditButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[2]/i");

    public TimePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickTime() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(timeTab)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickTimesheetsDropdown() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(timesheetsDropdown)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectMyTimesheetOption() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(myTimesheetOption)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickPreviousButton(int times) {
        try {
            for (int i = 0; i < times; i++) {
                Thread.sleep(1000);
                wait.until(ExpectedConditions.elementToBeClickable(previousButton)).click();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickCreateTimesheet() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(createTimesheetButton)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickSubmit() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void editTimesheet() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
            wait.until(ExpectedConditions.elementToBeClickable(typeField)).sendKeys("Test");
            wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickProjectInfo() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(projectInfoDropdown)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectCustomers() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(customersOption)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createCustomer(String name, String description) {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(addCustomerButton)).click();
            wait.until(ExpectedConditions.elementToBeClickable(customerNameField)).sendKeys(name);
            wait.until(ExpectedConditions.elementToBeClickable(customerDescriptionField)).sendKeys(description);
            wait.until(ExpectedConditions.elementToBeClickable(customerSaveButton)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void editFirstCustomer() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(firstCustomerEditButton)).click();
            WebElement descField = wait.until(ExpectedConditions.elementToBeClickable(customerDescriptionField));
            descField.clear();
            wait.until(ExpectedConditions.elementToBeClickable(customerSaveButton)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}