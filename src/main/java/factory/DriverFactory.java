package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	//Declare WebDriver variable
	
	private static WebDriver driver;
	
	//Method to initialize driver
	public static WebDriver initDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else {
            System.out.println("Invalid browser: " + browser);
		}
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
	}
     // Getter to fetch current driver
        public static WebDriver getDriver() {
            return driver;
        }

}
