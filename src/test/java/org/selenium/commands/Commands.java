package org.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Commands extends Base {
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
        submitButton.click();
    }
}
