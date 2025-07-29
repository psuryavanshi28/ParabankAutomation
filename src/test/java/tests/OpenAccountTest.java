package tests;

import org.testng.annotations.Test;

import org.testng.Assert;


import base.BaseTest;
import pages.LoginPage;
import pages.OpenAccountPage;

public class OpenAccountTest extends BaseTest {

    @Test(priority = 1)
    public void TC017_openSavingsAccount() throws InterruptedException {
    	// Login first (without relying on external login flow)
        LoginPage loginPage = new LoginPage(driver);
        loginPage.addusername("pratik091@gmail.com");
        loginPage.addpassword("pratik09");
        loginPage.ClickLogin();

        OpenAccountPage openAccount = new OpenAccountPage(driver);
        openAccount.clickOpenNewAccountLink();
        openAccount.selectAccountType("SAVINGS");
        Thread.sleep(2000);
        openAccount.selectFromAccount("19893"); // Replace with actual account number if needed
        openAccount.clickOpenNewAccount();

        Assert.assertTrue(openAccount.isAccountOpened(), "❌ Savings account creation failed!");
        System.out.println("✅ New Savings Account Number: " + openAccount.getNewAccountNumber());
    }


    @Test(priority = 2)
    public void TC018_openCheckingAccount() throws InterruptedException {
    	LoginPage loginPage = new LoginPage(driver);
        loginPage.addusername("pratik091@gmail.com");
        loginPage.addpassword("pratik09");
        loginPage.ClickLogin();
        OpenAccountPage openAccount = new OpenAccountPage(driver);
        openAccount.clickOpenNewAccountLink();
        openAccount.selectAccountType("CHECKING");
        Thread.sleep(2000);
        openAccount.selectFromAccount("19893"); // Replace with valid existing account
        openAccount.clickOpenNewAccount();

        Assert.assertTrue(openAccount.isAccountOpened(), "Checking account creation failed!");
        System.out.println("New Checking Account Number: " + openAccount.getNewAccountNumber());
    }

    @Test(priority = 3)
    public void TC019_verifyAccountNumberDisplayed() throws InterruptedException {
    	LoginPage loginPage = new LoginPage(driver);
        loginPage.addusername("pratik091@gmail.com");
        loginPage.addpassword("pratik09");
        loginPage.ClickLogin();
        OpenAccountPage openAccount = new OpenAccountPage(driver);
        openAccount.clickOpenNewAccountLink();
        openAccount.selectAccountType("SAVINGS");
        Thread.sleep(2000);
        openAccount.selectFromAccount("19893");
        openAccount.clickOpenNewAccount();

        String newAccountNo = openAccount.getNewAccountNumber();
        Assert.assertNotNull(newAccountNo, "New account number is not displayed!");
    }

    @Test(priority = 4)
    public void TC020_negativeOpenAccountWithoutFromAccount() {
    	LoginPage loginPage = new LoginPage(driver);
        loginPage.addusername("pratik091@gmail.com");
        loginPage.addpassword("pratik09");
        loginPage.ClickLogin();
        OpenAccountPage openAccount = new OpenAccountPage(driver);
        openAccount.clickOpenNewAccountLink();
        openAccount.selectAccountType("SAVINGS");
        // Do not select fromAccount
        openAccount.clickOpenNewAccount();

        Assert.assertFalse(openAccount.isAccountOpened(),
                "Account should not be created without selecting From Account!");
    }
}
