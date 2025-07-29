package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By username = By.id("customer.username");
    private By password = By.id("customer.password");
    private By confirmPassword = By.id("repeatedPassword");
    private By registerBtn = By.xpath("//input[@value='Register']");

    private By successMessage = By.cssSelector(".title");

    // Actions
    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterAddress(String addr) {
        driver.findElement(address).sendKeys(addr);
    }

    public void enterCity(String c) {
        driver.findElement(city).sendKeys(c);
    }

    public void enterState(String s) {
        driver.findElement(state).sendKeys(s);
    }

    public void enterZipCode(String zip) {
        driver.findElement(zipCode).sendKeys(zip);
    }

    public void enterPhone(String ph) {
        driver.findElement(phone).sendKeys(ph);
    }

    public void enterSSN(String s) {
        driver.findElement(ssn).sendKeys(s);
    }

    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void enterConfirmPassword(String pass) {
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void clickRegister() {
        driver.findElement(registerBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
