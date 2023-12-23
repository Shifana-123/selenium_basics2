package org.selenium.testngcommands;

import org.apache.poi.sl.usermodel.Slide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.automationcore.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Base {
    @Test
    public void verifyHomePageTitle() {
        WebDriver driver = new ChromeDriver();
        WebElement pageTitle=driver.findElement(By.xpath("//img[@alt='Tricentis Demo Web Shop']"));
        String actualTitle= driver.getTitle();
        String expectedTitle="Tricentis Demo Web Shop";
        Assert.assertEquals(actualTitle,expectedTitle,"Invalid Title");
    }
}
