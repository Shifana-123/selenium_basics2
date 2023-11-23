package org.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement userNameField=driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        WebElement passWordField=driver.findElement(By.id("password"));
        passWordField.sendKeys("secret_sauce");
        WebElement loginButton=driver.findElement(By.id("login-button"));
        loginButton.click();
        //driver.close();

    }
}
