package ui.tests;


import org.testng.annotations.Test;



import org.testng.Assert;


import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test(priority = 1)
    public void TC013_registerWithValidDetails() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickRegister();

        RegisterPage register = new RegisterPage(driver);
        register.enterFirstName("Praveen");
        register.enterLastName("Suryavanshi");
        register.enterAddress("Pune");
        register.enterCity("Pune");
        register.enterState("Maharashtra");
        register.enterZipCode("411027");
        register.enterPhone("8369061350");
        register.enterSSN("91");
        register.enterUsername("rwstest12324@gmail.com");
        register.enterPassword("Praveen@09");
        register.enterConfirmPassword("Praveen@09");
        register.clickRegister();
        Thread.sleep(2000);

        Assert.assertTrue(register.getSuccessMessage().contains("Welcome"),
                "Registration failed or message not found.");
    }
    
    @Test
    public void TC014_registerWithMissingFields() {
        HomePage home = new HomePage(driver);
        home.clickRegister();

        RegisterPage register = new RegisterPage(driver);
        // Only entering first name, leaving all others blank
        register.enterFirstName("TestOnly");

        register.clickRegister();

        // Basic verification - page should not redirect or success message should not appear
        Assert.assertFalse(driver.getPageSource().contains("Welcome"), 
            "Unexpected success on incomplete registration.");
    }

    @Test(priority = 3)
    public void TC015_registerWithPasswordMismatch() {
        HomePage home = new HomePage(driver);
        home.clickRegister();

        RegisterPage register = new RegisterPage(driver);
        register.enterFirstName("Mismatch");
        register.enterLastName("Test");
        register.enterAddress("456 Elm Street");
        register.enterCity("Los Angeles");
        register.enterState("CA");
        register.enterZipCode("90001");
        register.enterPhone("9876543210");
        register.enterSSN("999-99-9999");
        register.enterUsername("passwordmismatchuser");
        register.enterPassword("Test@1234");
        register.enterConfirmPassword("Wrong@123");

        register.clickRegister();

        // There is no direct error message, so fallback to success message absence
        Assert.assertFalse(driver.getPageSource().contains("Welcome"),
            "Registration should fail with password mismatch.");
    }

    

}
