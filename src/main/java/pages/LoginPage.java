package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	private WebDriver driver;
	
	
	//Locator
	public By usernameField= By.name("username");
	public By passwordField = By.name("password");
	public By login = By.xpath("//input[@value='Log In']");
	
	
	//Constructor
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        
    }
	
	//Actions
	public void addusername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	public void addpassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	public void ClickLogin() {
		driver.findElement(login).click();
	}

	public void login(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        WebElement userField = driver.findElement(usernameField);
        userField.clear();
        userField.sendKeys(username);

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        WebElement passField = driver.findElement(passwordField);
        passField.clear();
        passField.sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(login));
        driver.findElement(login).click();
    }
}

