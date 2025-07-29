package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterLink {
	private WebDriver driver;
	
	//Constructor
		public FooterLink (WebDriver driver) {
	        this.driver = driver;
	        
	    }
    
 // Locators for footer links
    private By aboutUsLink = By.linkText("About Us");
    private By servicesLink = By.linkText("Services");
    private By solutionsLink = By.linkText("Solutions");
    private By siteMapLink = By.linkText("Site Map");
    
    //Actions
    public void openLinkInNewTab(By locator) {
        WebElement link = driver.findElement(locator);
        String href = link.getAttribute("href");
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0]);", href);
    }
    public void switchToTab(int tabIndex) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }

    public boolean verifyCurrentURLContains(String expectedText) {
        return driver.getCurrentUrl().toLowerCase().contains(expectedText.toLowerCase());
    }

    // Getters for link locators
    public By getAboutUsLink() {
        return aboutUsLink;
    }

    public By getServicesLink() {
        return servicesLink;
    }

    public By getSolutionsLink() {
        return solutionsLink;
    }

    public By getSiteMapLink() {
        return siteMapLink;
    }
    

}
