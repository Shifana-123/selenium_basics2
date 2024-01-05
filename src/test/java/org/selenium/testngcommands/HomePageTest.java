package org.selenium.testngcommands;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.automationcore.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.listeners.ExtentListener;
import org.selenium.retryanalyzer.RetryAnalyzer;
import org.selenium.utilities.AppUtility;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomePageTest extends Base {
    ThreadLocal<ExtentTest> extentTest = ExtentListener.getTestInstance();

    @Test(priority = 1, enabled = true, groups = {"Smoke", "Regression"}, retryAnalyzer = RetryAnalyzer.class)

    public void verifyHomePageTitle() {
        extentTest.get().assignCategory("Smoke");
        extentTest.get().log(Status.PASS, "URL loaded successfully");
        String actualResult = driver.getTitle();
        extentTest.get().log(Status.PASS, "Home page title recieved successfully");
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.HOME_PAGE);
        extentTest.get().log(Status.PASS, "Expected title recieved from Excel");
        String expectedResult = data.get(1);
        Assert.assertEquals(actualResult, expectedResult, Messages.TITLE_MISMATCH);
    }

    @Test(priority = 2, groups = "Sanity")
    public void verifyCommunityPollSelection() {
        List<WebElement> pollTexts = driver.findElements(By.xpath("//li[@class='answer']//label[starts-with(@for,'pollanswers')]"));
        boolean isButtonSelected = AppUtility.selectValueFromRadioButton(pollTexts, Constants.POOR);
        Assert.assertFalse(isButtonSelected, "Value  selected");
        Assert.assertFalse(isButtonSelected, Messages.VALUE_SELECTED);

    }
}



