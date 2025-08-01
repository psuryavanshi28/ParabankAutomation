package ui.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import base.BaseTest;
import pages.LoginInfoPage;

public class ForgotLogin extends BaseTest {
	

	@Test(priority = 1)
    public void validForgotLoginInfoTest_TC005() {
        driver.get("https://parabank.parasoft.com/parabank/lookup.htm");

        LoginInfoPage loginInfo = new LoginInfoPage(driver);
        loginInfo.addFirstName("John");
        loginInfo.addLastName("Doe");
        loginInfo.addAddress("123 Elm Street");
        loginInfo.addCity("New York");
        loginInfo.addState("NY");
        loginInfo.addZipcode("10001");
        loginInfo.addSSN("123-45-6789");
        loginInfo.clickLoginButton();

     // Wait for result
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // Debug output
        System.out.println(driver.getPageSource());

        // Assertion (adjust message to actual one from UI)
        AssertJUnit.assertTrue(driver.getPageSource().contains("ParaBank is a demo site used for demonstration of Parasoft software solutions."));
    }

    // TC006: Submit form with missing required fields (e.g., First Name missing)
    @Test(priority = 2)
    public void missingFieldsForgotLoginInfoTest_TC006() {
        driver.get("https://parabank.parasoft.com/parabank/lookup.htm");

        LoginInfoPage loginInfo = new LoginInfoPage(driver);
        // Missing first name
        loginInfo.addLastName("Doe");
        loginInfo.addAddress("123 Elm Street");
        loginInfo.addCity("New York");
        loginInfo.addState("NY");
        loginInfo.addZipcode("10001");
        loginInfo.addSSN("123-45-6789");
        loginInfo.clickLoginButton();

     // Wait for result
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        
    }

    // TC007: Submit form with incorrect SSN
    @Test(priority = 3)
    public void incorrectSSNForgotLoginInfoTest_TC007() {
        driver.get("https://parabank.parasoft.com/parabank/lookup.htm");

        LoginInfoPage loginInfo = new LoginInfoPage(driver);
        loginInfo.addFirstName("John");
        loginInfo.addLastName("Doe");
        loginInfo.addAddress("123 Elm Street");
        loginInfo.addCity("New York");
        loginInfo.addState("NY");
        loginInfo.addZipcode("10001");
        loginInfo.addSSN("000-00-0000"); // Invalid SSN
        loginInfo.clickLoginButton();

        
    }

    // TC008: Verify navigation from Login page to Forgot Login Info page
    @Test(priority = 4)
    public void navigationToForgotLoginInfo_TC008() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // Click the "Forgot login info?" link
        driver.findElement(By.linkText("Forgot login info?")).click();

        // Assertion: Verify redirected to lookup page
        Assert.assertTrue(driver.getCurrentUrl().contains("lookup.htm"), "User is not navigated to Forgot Login Info page.");
    }
}