package tests;

import org.testng.annotations.Test;


import org.testng.Assert;

import base.BaseTest;
import pages.FooterLink;

public class FooterLinkTest extends BaseTest {
	@Test
    public void openAboutUsLinkInNewTab_TC009() throws InterruptedException {
        FooterLink footer = new FooterLink(driver);
        Thread.sleep(2000);
        footer.openLinkInNewTab(footer.getAboutUsLink());
        footer.switchToTab(1);
        Assert.assertTrue(footer.verifyCurrentURLContains("about"), "URL does not contain 'about'");
        footer.switchToTab(0);
}
	
	@Test
    public void openServicesLinkInNewTab_TC010() {
        FooterLink footer = new FooterLink(driver);

        footer.openLinkInNewTab(footer.getServicesLink());
        footer.switchToTab(1);
        Assert.assertTrue(footer.verifyCurrentURLContains("services"), "URL does not contain 'services'");
        footer.switchToTab(0);
    }
	
}

