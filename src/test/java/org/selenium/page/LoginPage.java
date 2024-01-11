package org.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WebElementUtility;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(id="Password")
    WebElement passwordField;

    @FindBy(xpath="//input[@class='button-1 login-button']")
    WebElement loginButton;

    public void enterUserName(String username) {
        WebElementUtility.enterValue(emailField,username);
    }
    public void enterPassword(String password) {
        WebElementUtility.enterValue(passwordField,password);
    }
    public UserAccountPage clickOnLogin() {
        WebElementUtility.clickOnElement(loginButton);
        return new UserAccountPage(driver);
    }

}
