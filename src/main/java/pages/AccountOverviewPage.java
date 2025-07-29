package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountOverviewPage {

    private WebDriver driver;

    // Constructor
    public AccountOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By accountsOverviewLink = By.linkText("Accounts Overview");
    private By accountRows = By.cssSelector("table#accountTable tbody tr");

    public void clickAccountsOverview() {
        driver.findElement(accountsOverviewLink).click();
    }

    public int getNumberOfAccountsDisplayed() {
        return driver.findElements(accountRows).size();
    }

    public List<String> getAllAccountNumbers() {
        List<String> accountNumbers = new ArrayList<>();
        List<WebElement> accountElements = driver.findElements(By.xpath("//table[@id='accountTable']//tr/td[1]/a"));

        for (WebElement account : accountElements) {
            accountNumbers.add(account.getText().trim());
        }

        return accountNumbers;
    }

    public String getAccountBalance(String accountNumber) {
        List<WebElement> rows = driver.findElements(accountRows);

        for (WebElement row : rows) {
            String accNum = row.findElement(By.xpath("td[1]/a")).getText();
            if (accNum.equals(accountNumber)) {
                return row.findElement(By.xpath("td[2]")).getText(); // Assuming 2nd column is balance
            }
        }
        return null;
    }

    public void clickOnAccount(String accountNumber) {
        List<WebElement> rows = driver.findElements(accountRows);

        for (WebElement row : rows) {
            String accNum = row.findElement(By.xpath("td[1]/a")).getText();
            if (accNum.equals(accountNumber)) {
                row.findElement(By.xpath("td[1]/a")).click();
                break;
            }
        }
    }

	public boolean areAccountNumbersVisible() {
		// TODO Auto-generated method stub
		return false;
	}
}
