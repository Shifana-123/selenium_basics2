package org.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WaitUtility;
import org.selenium.utilities.WebElementUtility;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
   @FindBy(id="gender-female")
    WebElement genderFemale;

    @FindBy(id="FirstName")
    WebElement firstNameField;

    @FindBy(id="LastName")
    WebElement lastNameField;

    @FindBy(id="Email")
    WebElement emailField;

    @FindBy(id="Password")
    WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    WebElement registerButton;

    public void clickOnElement() {
        WebElementUtility.clickOnElement(genderFemale);
    }
    public void enterFirstName(String firstname) {
        WebElementUtility.enterValue(firstNameField,firstname );
    }
    public void enterLastName(String lastname) {
        WebElementUtility.enterValue(lastNameField,lastname);
    }
    public void enterEmail(String email) {
        WebElementUtility.enterValue(emailField,email);
    }
    public void enterPassword(String password) {
        WebElementUtility.enterValue(passwordField,password);
    }
    public void enterConfirmPassword(String password) {
        WebElementUtility.enterValue(confirmPasswordField,password);
    }
    public void clickOnRegisterButton() {
        WebElementUtility.clickOnElement(registerButton);
    }

}
