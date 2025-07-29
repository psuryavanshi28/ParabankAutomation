package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.testng.Assert;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeMethod;


import base.BaseTest;
import pages.BillPayPage;
import pages.LoginPage;

public class BillPayTest extends BaseTest {
	private BillPayPage billPayPage;
    private LoginPage loginPage;
    
   
        @BeforeMethod
        public void setUpTest() {
            loginPage = new LoginPage(driver);
            loginPage.login("pratik091@gmail.com", "pratik09");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Pay")));

            driver.findElement(By.linkText("Bill Pay")).click();

            billPayPage = new BillPayPage(driver);
    }
    
    @Test(priority = 1)
    public void TC026_verifyBillPayPageLoads() {
    	System.out.println("Actual Page Title: " + driver.getTitle());
    	Assert.assertTrue(driver.getTitle().contains("Bill Pay"), "Bill Pay page did not load.");
    }
 // TC027: Submit bill payment with valid data
    @Test(priority = 2)
    public void TC027_submitValidBillPayment() {
        billPayPage.enterPayeeDetails("Electric Co", "123 Main St", "Mumbai", "MH", "400001",
                "9876543210", "123456", "123456", "250");

        billPayPage.clickSendPayment();

        String confirmation = billPayPage.getConfirmationMessage();
        System.out.println("Bill Payment Confirmation: " + confirmation);
        AssertJUnit.assertEquals(confirmation, "Bill Payment Service");
    }

    // TC028: Submit with mismatched account numbers
    @Test(priority = 3)
    public void TC028_submitWithMismatchedAccountNumbers() {
        billPayPage.enterPayeeDetails("Electric Co", "123 Main St", "Mumbai", "MH", "400001",
                "9876543210", "123456", "999999", "250");

        billPayPage.clickSendPayment();

        // Expecting to remain on same page or error message
        Assert.assertTrue(driver.getPageSource().contains("do not match"), "Validation message not shown.");
    }

 
}

