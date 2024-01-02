package org.selenium.testngcommands;

import org.apache.poi.sl.usermodel.Slide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.Message;
import org.selenium.automationcore.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.remote.http.Message.*;

public class HomePageTest extends Base {
    @Test

    public void verifyHomePageTitle()  {
            String actualResult = driver.getTitle();
            ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH,Constants.HOME_PAGE);
            String expectedResult = data.get(1);
            Assert.assertEquals(actualResult, expectedResult, Messages.TITLE_MISMATCH);

    }
    @Test
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

