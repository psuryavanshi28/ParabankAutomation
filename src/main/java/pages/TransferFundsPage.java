package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferFundsPage {

    private WebDriver driver;

    private By fromAccountDropdown = By.id("fromAccountId");
    private By toAccountDropdown = By.id("toAccountId");
    private By amountInput = By.id("amount");
    private By transferButton = By.xpath("//input[@value='Transfer']");
    private By confirmationMessage = By.cssSelector(".title");

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstFromAccount() {
        WebElement dropdownElement = waitUntilVisible(fromAccountDropdown);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until at least 1 option is present
        wait.until(driver -> ((Select) new Select(dropdownElement)).getOptions().size() > 0);

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(0);
    }

    public void selectFirstToAccount() {
        WebElement dropdownElement = waitUntilVisible(toAccountDropdown);
        Select dropdown = new Select(dropdownElement);
        int count = dropdown.getOptions().size();
        if (count > 1) {
            dropdown.selectByIndex(1);
        } else {
            System.out.println("Warning: Only one account available for transfer.");
            dropdown.selectByIndex(0);
        }
    }

    public void enterAmount(String amount) {
        WebElement amountField = waitUntilVisible(amountInput);
        amountField.clear();
        amountField.sendKeys(amount);
    }

    public void clickTransfer() {
        waitUntilVisible(transferButton).click();
    }

    public String getConfirmationMessage() {
        return waitUntilVisible(confirmationMessage).getText().trim();
    }

    private WebElement waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}