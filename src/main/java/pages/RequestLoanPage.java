package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestLoanPage {
    private WebDriver driver;
    public WebDriverWait wait;

    // Constructor
    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By loanAmountField = By.id("amount");
    private By downPaymentField = By.id("downPayment");
    private By fromAccountDropdown = By.id("fromAccountId");
    private By applyNowBtn = By.xpath("//input[@value='Apply Now']");
    private By loanStatusText = By.xpath("//td[@id='loanStatus']");
    public By newAccountId = By.xpath("//b[normalize-space()='Your new account number:']");

    // Actions
    public void enterLoanAmount(String amount) {
        driver.findElement(loanAmountField).clear();
        driver.findElement(loanAmountField).sendKeys(amount);
    }

    public void enterDownPayment(String downPayment) {
        driver.findElement(downPaymentField).clear();
        driver.findElement(downPaymentField).sendKeys(downPayment);
    }

    public void selectFromAccountByIndex(int index) {
        Select select = new Select(driver.findElement(fromAccountDropdown));
        select.selectByIndex(index);
    }

    public void clickApplyNow() {
        driver.findElement(applyNowBtn).click();
    }

    public String getLoanStatus() {
        return driver.findElement(loanStatusText).getText().trim();
    }

    public String getNewAccountId() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newAccountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//td[contains(text(),'New Account')]/following-sibling::td")
        ));
        return newAccountElement.getText();
    }

    public boolean isLoanApproved() {
        try {
            return driver.findElement(By.xpath("//b[contains(text(),'Your new account number')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLoanDenied() {
        try {
            return driver.findElement(By.xpath("//*[contains(text(),'We cannot grant a loan')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}