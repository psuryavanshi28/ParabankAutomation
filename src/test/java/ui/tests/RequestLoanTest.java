package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;

import base.BaseTest;
import pages.LoginPage;
import pages.RequestLoanPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestLoanTest extends BaseTest {
    private RequestLoanPage requestLoanPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("pratik092@gmail.com", "Pratik@09");

        // Wait until dashboard loads
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Request Loan")));

        // Navigate to Request Loan
        driver.findElement(By.linkText("Request Loan")).click();

        requestLoanPage = new RequestLoanPage(driver);
    }

    @Test(priority = 1)
    public void TC030_submitValidLoanRequest() {
        requestLoanPage.enterLoanAmount("1000");
        requestLoanPage.enterDownPayment("200");
        requestLoanPage.selectFromAccountByIndex(1);;
        requestLoanPage.clickApplyNow();

        Assert.assertTrue(requestLoanPage.isLoanApproved(), "Loan was not approved as expected.");
        
    }
    @Test(priority = 2)
    public void TC031_submitLoanWithHighDownPayment() {
        requestLoanPage.enterLoanAmount("5000");
        requestLoanPage.enterDownPayment("10000");
        requestLoanPage.clickApplyNow();

        Assert.assertFalse(requestLoanPage.isLoanDenied(), "Loan was not denied as expected.");
    }

    }
