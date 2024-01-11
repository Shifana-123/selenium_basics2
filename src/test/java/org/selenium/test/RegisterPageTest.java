package org.selenium.test;

import org.selenium.automationcore.Base;
import org.selenium.page.HomePage;
import org.selenium.page.RegisterPage;
import org.selenium.utilities.RandomDataUtility;

public class RegisterPageTest extends Base {
public void verifyRegistrationWithValidCredentials()  {
    String firstName = RandomDataUtility.getFirstName();
    String lastName = RandomDataUtility.getLastName();
    String emailID = firstName + "." + lastName + "123@yahoo.com";
    String password = firstName + "." + lastName;
    HomePage home=new HomePage(driver);
    RegisterPage register= home.clickOnRegisterMenu();
    register.clickOnElement();
    register.enterFirstName(firstName);
    register.enterLastName(lastName);
    register.enterEmail(emailID);
    register.enterPassword(password);
    register.enterConfirmPassword(password);
    register.clickOnRegisterButton();
}
}
