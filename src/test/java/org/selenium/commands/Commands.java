package org.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class
Commands extends Base {
    @Test
    public void verifySwagLabsUserLogin() {
        driver.get("https://www.saucedemo.com/");
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        WebElement passWordField = driver.findElement(By.id("password"));
        passWordField.sendKeys("secret_sauce");
        WebElement loginButtonField = driver.findElement(By.id("login-button"));
        loginButtonField.click();
        WebElement swagLogo = driver.findElement(By.className("app_logo"));
        String actualSwagLogoText = swagLogo.getText();
        String expectedSwagLogoText = "Swag Labs";
        Assert.assertEquals(actualSwagLogoText, expectedSwagLogoText, "Invalid Logo found in login page");

    }

    @Test
    public void verifyDemoWebShopUserLogin() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.className("ico-login"));
        login.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("sshifana959@gmail.com");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Shifana@123");
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
        WebElement UserLogin = driver.findElement(By.className("account"));
        String actualUserLogin = UserLogin.getText();
        String expectedUserLogin = "sshifana959@gmail.com";


        Assert.assertEquals(actualUserLogin, expectedUserLogin, "Login Failed");
    }

    @Test
    public void verifyDemoTourRegistration() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement firstNameField = driver.findElement(By.name("firstName"));
        firstNameField.sendKeys("Shifana");
        WebElement lastNameField = driver.findElement(By.name("lastName"));
        lastNameField.sendKeys("S");
        WebElement phoneNumberField = driver.findElement(By.name("phone"));
        phoneNumberField.sendKeys("8156963192");
        WebElement emailField = driver.findElement(By.id("userName"));
        emailField.sendKeys("sshifana959@gmail.com");
        WebElement addressField = driver.findElement(By.name("address1"));
        addressField.sendKeys("Attingal");
        WebElement cityName = driver.findElement(By.name("city"));
        cityName.sendKeys("Thiruvananthapuram");
        WebElement stateName = driver.findElement(By.name("state"));
        stateName.sendKeys("Kerala");
        WebElement postalCodeField = driver.findElement(By.name("postalCode"));
        postalCodeField.sendKeys("695305");
        WebElement userNameField = driver.findElement(By.id("email"));
        userNameField.sendKeys("sshifana959@gmail.com");
        WebElement passWordField = driver.findElement(By.name("password"));
        passWordField.sendKeys("Demo@123");
        WebElement confirmPassWordField = driver.findElement(By.name("confirmPassword"));
        confirmPassWordField.sendKeys("Demo@123");
        WebElement submitButton = driver.findElement(By.name("submit"));
        //submitButton.click();
    }

    @Test
    public void verifyLinkText() {
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.linkText("your destination"));
        element.click();
    }

    @Test
    public void verifyPartialLinkText() {
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.partialLinkText("destination"));
        element.click();
    }

    @Test
    public void verifyDemoWebShopUserLoginUsingXpath() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement loginField = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        loginField.click();
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        emailField.sendKeys("sshifana959@gmail.com");
        WebElement passWordField = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        passWordField.sendKeys("Shifana@123");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
        loginButton.click();
        WebElement actualUserLoginElement = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        String actualLoginId = actualUserLoginElement.getText();
        String expectedLoginId = "sshifana959@gmail.com";
        Assert.assertEquals(actualLoginId, expectedLoginId, "User Login Failed");
    }

    @Test
    public void verifyDemoWebShopUserLoginUsingCssSelector() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement userLoginField = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
        userLoginField.click();
        WebElement emailField = driver.findElement(By.cssSelector("#Email"));
        emailField.sendKeys("sshifana959@gmail.com");
        WebElement passWordField = driver.findElement(By.cssSelector("#Password"));
        passWordField.sendKeys("Shifana@123");
        WebElement loginButton = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
        loginButton.click();
        WebElement actualUserLoginElement = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(1) > a"));
        String actualLoginId = actualUserLoginElement.getText();
        String expectedLoginId = "sshifana959@gmail.com";
        Assert.assertEquals(actualLoginId, expectedLoginId, " User Login Failed");

    }

    @Test
    public void validateTotalNumberOfTags() {
        driver.get("https://demowebshop.tricentis.com/");
        List<WebElement> inputTagElements = driver.findElements(By.tagName("Input"));
        int tagSize = inputTagElements.size();
        System.out.println(tagSize);
    }

    @Test
    public void verifyNavigationCommands() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement register = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        register.click();
        driver.navigate().back();
        driver.navigate().forward();
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"FirstName\"]"));
        firstName.sendKeys("Shifana");
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"LastName\"]"));
        lastName.sendKeys("S");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        email.sendKeys("sshifana959@gmail.com");
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.co.in/");
    }

    @Test
    public void verifyIsSelected() {
        boolean isMaleSelected;
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement maleRadioButton = driver.findElement(By.xpath("//input[@id='gender-male']"));
        isMaleSelected = maleRadioButton.isSelected(); //Expected result is false
        Assert.assertFalse(isMaleSelected, "Male radio button is selected");
        System.out.println("Gender Male Before Selection " + isMaleSelected);
        maleRadioButton.click();
        isMaleSelected = maleRadioButton.isSelected();
        Assert.assertTrue(isMaleSelected, "Male Radio button is not selected");
        System.out.println("Gender Male After Selection " + isMaleSelected);
    }
    @Test
    public void verifyIsEnabled() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement subscribeButton=driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));

    }
}
