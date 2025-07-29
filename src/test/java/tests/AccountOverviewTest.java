package tests;



import org.testng.annotations.Test;


import java.util.List;

import org.testng.Assert;


import base.BaseTest;
import pages.AccountOverviewPage;
import pages.LoginPage;

public class AccountOverviewTest extends BaseTest {

    @Test(priority = 1)
    public void TC021_viewAccountsOverviewSuccessfully() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.addusername("pratik09@gmail.com");
        loginPage.addpassword("Pratik09");
        loginPage.ClickLogin();
        Thread.sleep(2000);
        AccountOverviewPage overviewPage = new AccountOverviewPage(driver);
        overviewPage.clickAccountsOverview();
    }

    @Test(priority = 2)
    public void TC022_verifyAccountNumbersDisplayed() throws InterruptedException {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.addusername("pratik09@gmail.com");
        loginPage.addpassword("Pratik09");
        loginPage.ClickLogin();

        AccountOverviewPage overviewPage = new AccountOverviewPage(driver);
        overviewPage.clickAccountsOverview();
        Thread.sleep(2000);
        List<String> accounts = overviewPage.getAllAccountNumbers();
        System.out.println("Accounts Found: " + accounts);
        Assert.assertTrue(accounts.size() > 0, "Account numbers should be visible in the overview table.");
    }

}