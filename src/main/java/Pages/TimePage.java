
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TimePage {
    WebDriver driver;
    WebDriverWait wait;

    // Previous locators remain the same
    By timeTab = By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a");
    By timesheetsDropdown = By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span");
    By myTimesheets = By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li[1]");
    By pageHeader = By.xpath("//h6[contains(text(),'Time / Timesheets')]");
    By editButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button[1]");
    By typeField = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/form/div[2]/table/tbody/tr[1]/td[1]/div/div[2]/div/div/input");
    By saveButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button[3]");
    By attendanceDropdown = By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span");
    By punchInOutButton = By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[2]/a");
    By noteTextField = By.xpath("//textarea[@placeholder='Type here']");

    // Updated XPath for the In/Out button
    By inOutButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/form/div[3]/button");

    public TimePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Previous methods remain the same
    public void clickTimeTab() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(timeTab)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickTimesheetsTab() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(timesheetsDropdown)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickMyTimesheets() {
        wait.until(ExpectedConditions.elementToBeClickable(myTimesheets)).click();
    }

    public void clickEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }

    public void enterTestInTypeField() {
        wait.until(ExpectedConditions.elementToBeClickable(typeField)).sendKeys("Test");
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public void clickAttendanceDropdown() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(attendanceDropdown)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickPunchInOut() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(punchInOutButton)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterNoteText() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(noteTextField)).sendKeys("Test");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Updated method for clicking In/Out button
    public void clickInOutButton() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(inOutButton)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}