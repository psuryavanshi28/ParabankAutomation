package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillPayPage {

    private WebDriver driver;

    // Locators
    private By payeeNameField = By.name("payee.name");
    private By addressField = By.name("payee.address.street");
    private By cityField = By.name("payee.address.city");
    private By stateField = By.name("payee.address.state");
    private By zipCodeField = By.name("payee.address.zipCode");
    private By phoneNumberField = By.name("payee.phoneNumber");
    private By accountNumberField = By.name("payee.accountNumber");
    private By verifyAccountField = By.name("verifyAccount");
    private By amountField = By.name("amount");
    
    private By sendPaymentButton = By.xpath("//input[@value='Send Payment']");

    private By confirmationMessage = By.cssSelector("#rightPanel > div > div > h1");

    // Constructor
    public BillPayPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterPayeeDetails(String name, String address, String city, String state, String zip,
                                  String phone, String account, String verifyAccount, String amount) {
        driver.findElement(payeeNameField).sendKeys(name);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipCodeField).sendKeys(zip);
        driver.findElement(phoneNumberField).sendKeys(phone);
        driver.findElement(accountNumberField).sendKeys(account);
        driver.findElement(verifyAccountField).sendKeys(verifyAccount);
        driver.findElement(amountField).sendKeys(amount);
    }

    public void clickSendPayment() {
        driver.findElement(sendPaymentButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}
