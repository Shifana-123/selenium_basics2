package org.selenium.testngcommands;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.automationcore.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.listeners.ExtentListener;
import org.selenium.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RegisterPageTest extends Base {
    ThreadLocal<ExtentTest> extentTest = ExtentListener.getTestInstance();

    @Test(priority = 3,groups = "Smoke")
    public void verifyRegisterPageTitle() {
        extentTest.get().assignCategory("Smoke");
        extentTest.get().log(Status.PASS,"URL loaded successfully");
        WebElement registerField = driver.findElement(By.xpath("//a[@class='ico-register']"));
        WebElementUtility.clickOnElement(registerField);
        String actualPageTitle = driver.getTitle();
        extentTest.get().log(Status.PASS,"Register page title recieved succcessfully");
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.REGISTRATION_PAGE);
        extentTest.get().log(Status.PASS,"Expected title recieved successfully");
        String expectedResult = data.get(1);
        extentTest.get().log(Status.PASS,"Data in row 0, column 1 recieved from excel");
        Assert.assertEquals(actualPageTitle, expectedResult, Messages.TITLE_MISMATCH);
    }

    @Test(priority = 4, groups = "Regression")
    public void verifyUserRegistration() {
        String firstName = RandomDataUtility.getFirstName();
        String lastName = RandomDataUtility.getLastName();
        String emailID = firstName + "." + lastName + "123@yahoo.com";
        String password = firstName + "." + lastName;
        WebElement registerField = driver.findElement(By.xpath("//a[@class='ico-register']"));
        WebElementUtility.clickOnElement(registerField);
        List<WebElement> genderselection = driver.findElements(By.xpath("//div[@class='gender']//label"));
        boolean isButtonSelected= AppUtility.selectGender(genderselection,Constants.FEMALE);
        WebElement firstNameField = driver.findElement(By.id("FirstName"));
        WebElementUtility.enterValue(firstNameField, firstName);
        WebElement lastNameField = driver.findElement(By.id("LastName"));
        WebElementUtility.enterValue(lastNameField, lastName);
        WebElement emailField = driver.findElement(By.id("Email"));
        WebElementUtility.enterValue(emailField, emailID);
        WebElement passwordField = driver.findElement(By.id("Password"));
        WebElementUtility.enterValue(passwordField, password);
        WebElement confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        WebElementUtility.enterValue(confirmPasswordField, password);
        WebElement registerButton = driver.findElement(By.id("register-button"));
        WebElementUtility.clickOnElement(registerButton);
        WebElement actualUserLoginElement = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actualId = WebElementUtility.getTextFromElement(actualUserLoginElement);
        Assert.assertEquals(actualId, emailID, Messages.USER_REGISTRATION_FAILED);
    }
}





