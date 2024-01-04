package org.selenium.testngcommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.automationcore.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.listeners.RetryAnalyzer;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomePageTest extends Base {
    @Test(priority=1,enabled=true,groups ={"Smoke","Regression"},retryAnalyzer = RetryAnalyzer.class)

    public void verifyHomePageTitle() {
        String actualResult = driver.getTitle();
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.HOME_PAGE);
        String expectedResult = data.get(1)+"123";
        Assert.assertEquals(actualResult, expectedResult, Messages.TITLE_MISMATCH);
    }

    @Test(priority=2,groups = "Sanity")
    public void verifyCommunityPollSelection() {
        List<WebElement> pollTexts = driver.findElements(By.xpath("//li[@class='answer']//label[starts-with(@for,'pollanswers')]"));
        for (WebElement values : pollTexts) {
            String pollValuesTexts = values.getText();
            if (pollValuesTexts.equals("Poor")) {
                if (pollValuesTexts.equals(Constants.POOR)) {
                    values.click();
                }
                boolean isButtonSelected = values.isSelected();
                Assert.assertFalse(isButtonSelected, "Value  selected");
                Assert.assertFalse(isButtonSelected, Messages.VALUE_SELECTED);

            }
        }
    }
}

