package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;

import utils.ConfigReader;

public class BaseTest {
	
	//Declare WebDriver references
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		//Read Browser value from config
		
		String browser = ConfigReader.getProperty("browser");
		
		// Initialize driver using DriverFactory
        driver = DriverFactory.initDriver(browser);

        // Navigate to the URL (also from config)
        driver.get(ConfigReader.getProperty("url"));
        
	}

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Quit the browser after test
        }
    }
}
