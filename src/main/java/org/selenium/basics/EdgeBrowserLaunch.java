package org.selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowserLaunch {
    public static void main(String[] args) {
        WebDriver driver=new EdgeDriver();
        driver.get("https://demo.guru99.com/test/newtours");
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
