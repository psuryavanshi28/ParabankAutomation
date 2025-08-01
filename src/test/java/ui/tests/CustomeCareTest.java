package ui.tests;

import org.testng.annotations.Test;


import org.testng.Assert;


import base.BaseTest;
import pages.CustomeCarePage;
import pages.HomePage;

public class CustomeCareTest extends BaseTest {

    @Test(priority = 1)
    public void TC018_verifyCustomerCareNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCustomerCare(); // you need this method to click on the link

        Assert.assertTrue(driver.getCurrentUrl().contains("contact.htm"), "Navigation to Customer Care failed.");
    }
    
    @Test(priority = 2)
    public void TC019_submitValidCustomerCareForm() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCustomerCare();

        CustomeCarePage ccPage = new CustomeCarePage(driver);
        ccPage.enterName("John Doe");
        ccPage.enterEmail("john@example.com");
        ccPage.enterPhone("9876543210");
        ccPage.enterMessage("I have an issue with my account.");
        ccPage.clickSend();

}
    @Test(priority = 3)
    public void TC020_submitWithoutMandatoryFields() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCustomerCare();

        CustomeCarePage ccPage = new CustomeCarePage(driver);
        ccPage.enterMessage("Test issue without filling name/email");
        ccPage.clickSend();

        // Validate appropriate error message or failure (modify based on actual behavior)
        Assert.assertFalse(ccPage.isMessageSent(), "Message should not be sent without required fields!");
    }
}
