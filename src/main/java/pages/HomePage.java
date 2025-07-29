package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By registerLink = By.linkText("Register");
    private By forgotLoginLink = By.linkText("Forgot login info?");
    private By aboutUsLink = By.linkText("About Us");
    private By siteMapLink = By.linkText("Site Map");
    private By solutionsLink = By.linkText("Solutions");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void clickForgotLoginInfo() {
        driver.findElement(forgotLoginLink).click();
    }

    public void clickAboutUs() {
        driver.findElement(aboutUsLink).click();
    }

    public void clickSiteMap() {
        driver.findElement(siteMapLink).click();
    }

    public void clickSolutions() {
        driver.findElement(solutionsLink).click();
    }

    public void clickCustomerCare() {
        driver.findElement(By.xpath("//a[normalize-space()='contact']")).click();
    }
}
