package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginInfoPage {
	
	private WebDriver driver;
	
	
	//Locator
	public By FirstnameField= By.id("firstName");
	public By LastnameField= By.id("lastName");
	public By AddressField = By.id("address.street");
	public By CityField = By.id("address.city");
	public By StateField = By.id("address.state");
	public By ZipcodeField = By.id("address.zipCode");
	public By SSNField = By.id("ssn");
	public  By Loginbutton= By.className("button");
	
	//Constructor
	public LoginInfoPage(WebDriver driver) {
	this.driver = driver;
	}
	
	//Actions
	public void addFirstName (String Firstname) {
		driver.findElement(FirstnameField).sendKeys(Firstname);
	}
	public void addLastName (String Lastname) {
		driver.findElement(LastnameField).sendKeys(Lastname);
	}
	public void addAddress (String Address) {
		driver.findElement(AddressField).sendKeys(Address);
	}
	public void addCity (String City) {
		driver.findElement(CityField).sendKeys(City);
	}
	public void addState (String State) {
		driver.findElement(StateField).sendKeys(State);
	}
	public void addZipcode (String Zipcode) {
		driver.findElement(ZipcodeField).sendKeys(Zipcode);
	}
	public void addSSN (String SSN) {
		driver.findElement(SSNField).sendKeys(SSN);
	}
	public void clickLoginButton() {
		driver.findElement(Loginbutton).click();
	}
}
