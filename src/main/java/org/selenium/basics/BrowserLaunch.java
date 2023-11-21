package org.selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        driver.getCurrentUrl();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        String handleId = driver.getWindowHandle();
        System.out.println(handleId);
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        driver.close();
    }
}
