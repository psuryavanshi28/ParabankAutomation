package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By openNewAccountLink= By.xpath("//a[normalize-space()='Open New Account']");
    private By accountTypeDropdown = By.id("type");
    private By fromAccountDropdown = By.id("fromAccountId");
    private By openNewAccountButton = By.xpath("//input[@value='Open New Account']");
    private By successMessage = By.xpath("//h1[text()='Account Opened!']");
    private By newAccountNumber = By.id("newAccountId");

    // Constructor
    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    
    public void clickOpenNewAccountLink() {
        driver.findElement(openNewAccountLink).click();
    }
 
    
    public void selectAccountType(String type) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountTypeDropdown));
        Select accountType = new Select(driver.findElement(accountTypeDropdown));
        accountType.selectByVisibleText(type);
    }

    public void selectFromAccount(String fromAccount) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromAccountDropdown));
        Select fromAcc = new Select(driver.findElement(fromAccountDropdown));
        fromAcc.selectByVisibleText(fromAccount);
    }
    public void clickOpenNewAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(openNewAccountButton)).click();
    }

    public boolean isAccountOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return driver.findElement(successMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getNewAccountNumber() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(newAccountNumber));
            return driver.findElement(newAccountNumber).getText();
        } catch (Exception e) {
            return null;
        }
    }
}
