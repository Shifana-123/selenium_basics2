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
    public void verifyDemoWebShopUserLogin()
    {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login= driver.findElement(By.className("ico-login"));
        login.click();
        WebElement emailField=driver.findElement(By.id("Email"));
        emailField.sendKeys("sshifana959@gmail.com");
        WebElement passwordField=driver.findElement(By.id("Password"));
        passwordField.sendKeys("Shifana@123");
        WebElement loginButton=driver.findElement(By.className("login-button"));
        loginButton.click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://demowebshop.tricentis.com/";
        Assert.assertEquals(actualUrl,expectedUrl,"Invalid URL found");
    }
}
