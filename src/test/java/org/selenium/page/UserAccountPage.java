package org.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WebElementUtility;

public class UserAccountPage {
    WebDriver driver;
    public UserAccountPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//div[@class='header-links']//a[@class='account']")
    WebElement userAccountEmail;

    public String getUserAccountEmail(){
        String email=WebElementUtility.getTextFromElement(userAccountEmail);
        return email;
    }

}
