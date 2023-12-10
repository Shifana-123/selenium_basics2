package org.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ObsquraZoneTest extends Base {
    @Test
    public void verifySingleInputField() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement messageField = driver.findElement(By.xpath("//input[@id='single-input-field']"));
        messageField.sendKeys("Hello Shifana");
        WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
        showMessageButton.click();
        WebElement yourMessageField = driver.findElement(By.xpath("//div[@id='message-one']"));
        String expectedResult = yourMessageField.getText();
        String actualResult = "Your Message : Hello Shifana";
        assertEquals(actualResult, expectedResult, "Invalid message ");
    }

    @Test
    public void verifyTwoInputField() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement enterValueAField = driver.findElement(By.xpath("//input[@id='value-a']"));
        enterValueAField.sendKeys("10");
        WebElement enterValueBField = driver.findElement(By.xpath("//input[@id='value-b']"));
        enterValueBField.sendKeys("40");
        WebElement getTotalButton = driver.findElement(By.xpath("//button[@id='button-two']"));
        getTotalButton.click();
        WebElement totalField = driver.findElement(By.xpath("//div[@id='message-two']"));
        String actualResult = totalField.getText();
        String expectedResult = "Total A + B : 50";
        assertEquals(actualResult, expectedResult, "Invalid Message");

    }

    @Test
    public void verifySingleCheckBoxDemo() {
        boolean isBoxSelected;
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement singleCheckBox = driver.findElement((By.xpath("//input[@id='gridCheck']")));
        isBoxSelected= singleCheckBox.isSelected();
        Assert.assertFalse(isBoxSelected,"Check box is selected");
        singleCheckBox.click();
        isBoxSelected = singleCheckBox.isSelected();
        Assert.assertTrue(isBoxSelected, "Check box is not selected");
    }
    @Test
    public void verifyRadioButtonDemo() {
        boolean isButtonSelected;
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
        isButtonSelected = femaleRadioButton.isSelected();
        Assert.assertFalse(isButtonSelected, "Radio Button is Selected");
        femaleRadioButton.click();
        isButtonSelected = femaleRadioButton.isSelected();
        Assert.assertTrue(isButtonSelected, "Female radio button is not selected");
        WebElement showSelectedValue = driver.findElement(By.xpath("//button[@id='button-one']"));
        showSelectedValue.click();
        WebElement showSelectedMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
        String actualResult = showSelectedMessage.getText();
        String expectedResult = "Radio button 'Female' is checked";
        assertEquals(actualResult, expectedResult, "Radio button female is not checked");

    }

    @Test
    public void verifyForm() {
        driver.get("https://selenium.obsqurazone.com/form-submit.php");
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
        firstNameField.sendKeys("Shifana");
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
        lastNameField.sendKeys("S");
        WebElement userNameField = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
        userNameField.sendKeys("Form@123");
        WebElement cityField = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
        cityField.sendKeys("Tvm");
        WebElement stateField = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
        stateField.sendKeys("Kerala");
        WebElement zipField = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
        zipField.sendKeys("123");

        boolean isBoxSelected;
        WebElement agreeTermsCheckBox = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
        isBoxSelected = agreeTermsCheckBox.isSelected();
        Assert.assertFalse(isBoxSelected, "Check box selected");
        agreeTermsCheckBox.click();
        isBoxSelected = agreeTermsCheckBox.isSelected();
        Assert.assertTrue(isBoxSelected, "Check box not selected");
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        WebElement actualResultIs = driver.findElement(By.xpath("//div[@id='message-one']"));
        String actualResult = actualResultIs.getText();
        String expectedResult = "Form has been submitted successfully!";
        assertEquals(actualResult, expectedResult, "Form submission failed");


    }
    @Test
    public void verifyColorSelectFromDropDown() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement colourDropDown= driver.findElement(By.xpath("//select[@class='form-control']"));
        Select select=new Select(colourDropDown);
        select.selectByIndex(3);
        WebElement colorSelected= select.getFirstSelectedOption();
        WebElement messageField=driver.findElement(By.xpath("//div[@id='message-one']"));
        String actualResult=messageField.getText();
        String expectedResult="Selected Color : Green";
        assertEquals(actualResult,expectedResult,"No color selected");
    }
    @Test
    public void verifyTotalNumberOfValuesInDropDown() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement colourDropDown= driver.findElement(By.xpath("//select[@class='form-control']"));
        Select select=new Select(colourDropDown);
        List<WebElement> dropDownSize=select.getOptions();
        int actualResult= dropDownSize.size();
        int expectedResult=4;
        assertEquals(actualResult,expectedResult,"Invalid size");
    }
    @Test
    public void verifyValuesInColorSelectDropDown() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement colourDropDown= driver.findElement(By.xpath("//select[@class='form-control']"));
        Select select=new Select(colourDropDown);
        List<WebElement> element=select.getOptions();
        List<String> actual=new ArrayList<>();
        for(WebElement e:element)
        {
            String colors=e.getText();
            actual.add(colors);
        }
        List<String> expected=new ArrayList<>();
        expected.add("-- Select --");
        expected.add("Red");
        expected.add("Yellow");
        expected.add("Green");
        assertEquals(actual,expected,"Invalid selection");

    }

}
