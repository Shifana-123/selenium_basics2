package org.selenium.testngcommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.automationcore.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.dataprovider.DataProviders;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class LoginPageTest extends Base {
    @Test
    public void verifyLoginPageTitle()  {

        WebElement loginField = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginField.click();
        String actualpageTitle = driver.getTitle();
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String expectedResult = data.get(1);
        Assert.assertEquals(actualpageTitle, expectedResult, Messages.TITLE_MISMATCH);
    }

    @Test
    public void verifyUserLogin() {
        WebElement loginField = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginField.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("sshifana959@gmail.com");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Shifana@123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        WebElement loggedAccount = driver.findElement(By.xpath("//a[@class='account']"));
        String actualResult = loggedAccount.getText();
        String expectedResult = "sshifana959@gmail.com";
        Assert.assertEquals(actualResult, expectedResult, "Login failed");
        Assert.assertEquals(actualResult, expectedResult, Messages.LOGIN_FAILED);
    }


    @Test(priority = 1,dataProvider = "InvalidUserCredentials", dataProviderClass = DataProviders.class)
    public void verifyUserLoginWithInvalidValidation(String username,String  password)  {
        WebElement loginField = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginField.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        emailField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        WebElement actualMessage = driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        String actualMessageText = actualMessage.getText();
        String expectedMessageText = data.get(6);
        Assert.assertEquals(actualMessageText, expectedMessageText, Messages.LOGIN_FAILED_WARNINGMESSAGE_NOTFOUND);
    }

}
