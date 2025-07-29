package tests;

import org.testng.annotations.Test;


import base.BaseTest;
import utils.ConfigReader;

public class DemoTest extends BaseTest {
	
	
	@Test
    public void verifyLaunch() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Launched URL: " + currentUrl);

        // Check if it matches the config URL
        if(currentUrl.equals(ConfigReader.getProperty("url"))) {
            System.out.println("Framework is working correctly.");
        } else {
            System.out.println("URL mismatch. Check config or driver launch.");
        }
    }
}