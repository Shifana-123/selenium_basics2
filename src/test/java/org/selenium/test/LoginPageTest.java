package org.selenium.test;

import org.selenium.automationcore.Base;
import org.selenium.page.HomePage;
import org.selenium.page.LoginPage;
import org.selenium.page.UserAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
    @Test
    public void verifyUserLoginWithValidCredentials() {
        HomePage home=new HomePage(driver);
        LoginPage login=home.clickOnLoginMenu();
        login.enterUserName("sshifana959@gmail.com");
        login.enterPassword("Shifana@123");
        UserAccountPage userAccount=login.clickOnLogin();
        String actualUserAccountEmail=userAccount.getUserAccountEmail();
        Assert.assertEquals(actualUserAccountEmail,"sshifana959@gmail.com","User Login Failed");
    }
}
