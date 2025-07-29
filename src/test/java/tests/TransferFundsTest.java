package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeMethod;


import base.BaseTest;
import pages.LoginPage;
import pages.TransferFundsPage;

public class TransferFundsTest extends BaseTest {

    private LoginPage loginPage;
    private TransferFundsPage transferFundsPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("pratik091@gmail.com", "pratik09");

        // Wait until dashboard loads
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Transfer Funds")));

        // Navigate to Transfer Funds
        driver.findElement(By.linkText("Transfer Funds")).click();

        transferFundsPage = new TransferFundsPage(driver);
    }

    @Test(priority = 1)
    public void TC024_verifyTransferFundsPageLoads() {
        Assert.assertTrue(driver.getTitle().contains("Transfer Funds"), "Transfer Funds page did not load.");
    }

    @Test(priority = 2)
    public void TC025_verifySuccessfulFundTransfer() {
        transferFundsPage.selectFirstFromAccount();
        transferFundsPage.selectFirstToAccount();
        transferFundsPage.enterAmount("500");
        transferFundsPage.clickTransfer();

        String message = transferFundsPage.getConfirmationMessage();
        System.out.println("Transfer Confirmation Message: " + message);
        Assert.assertTrue(message.contains("Transfer Complete!"), "Transfer failed or confirmation message incorrect.");
    }

    
	
	@AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
