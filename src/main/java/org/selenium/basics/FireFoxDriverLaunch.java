package org.selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverLaunch {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        String handleId = driver.getWindowHandle();
        System.out.println(handleId);
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        driver.close();
    }
}
