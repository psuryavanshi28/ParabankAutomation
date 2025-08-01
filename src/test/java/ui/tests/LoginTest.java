package ui.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(priority = 1)
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.addusername("pratik092@gmail.com");     // Replace with valid username
        loginPage.addpassword("Pratik@09");     // Replace with valid password
        loginPage.ClickLogin();

        // Assert Page Title or URL after login
        String actualTitle = driver.getTitle();
        AssertJUnit.assertEquals(actualTitle, "ParaBank | Accounts Overview");
    }
	
	@Test(priority = 2)
	public void InvalidLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.addusername("Shsaa");
		loginPage.addpassword("null");
		loginPage.ClickLogin();
		
		//Assert PageTitle
		WebElement errorMsg = driver.findElement(By.xpath("//p[@class='error']"));
	    AssertJUnit.assertEquals(errorMsg.getText(), "");
	}
	
	@Test(priority = 3)
    public void invalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.addusername("john");
        loginPage.addpassword("wrongpass");
        loginPage.ClickLogin();

        WebElement errorMsg = driver.findElement(By.xpath("//p[@class='error']"));
	    AssertJUnit.assertEquals(errorMsg.getText(), "");
    }

    @Test(priority = 4)
    public void blankCredentialsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.addusername("");
        loginPage.addpassword("");
        loginPage.ClickLogin();

        WebElement errorMsg = driver.findElement(By.xpath("//p[@class='error']"));
	    AssertJUnit.assertEquals(errorMsg.getText(), "Please enter a username and password.");
    }
}
	


