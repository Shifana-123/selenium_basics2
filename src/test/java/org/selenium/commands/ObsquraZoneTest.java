package org.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertEquals(actualResult, expectedResult, "Invalid message ");
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
        String expectedResult="Total A + B : 50";
        Assert.assertEquals(actualResult, expectedResult, "Invalid Message");

    }

    @Test
    public void verifySingleCheckBoxDemo() {
        boolean isBoxSelected;
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement singleCheckBox = driver.findElement(By.xpath("input[@id='gridCheck']"));
        isBoxSelected = singleCheckBox.isSelected();
        singleCheckBox.click();
        isBoxSelected = singleCheckBox.isSelected();
        Assert.assertTrue(isBoxSelected, "Check box is not selected");
        //System.out.println(isBoxSelected);
    }

    @Test
    public void verifyRadioButtonDemo() {
        boolean isMaleSelected;
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        WebElement maleElementField = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
        isMaleSelected = maleElementField.isSelected();
        Assert.assertFalse(isMaleSelected, "Male radio button not selected");
        maleElementField.click();
        isMaleSelected = maleElementField.isSelected();
        Assert.assertTrue(isMaleSelected, "Male radio button is not selected");
        WebElement showSelectedValueField = driver.findElement(By.xpath("//button[@id='button-one']"));
        showSelectedValueField.click();
        WebElement showSelectedMessage = driver.findElement(By.xpath("///div[@id='message-one']"));
        String actualResult = showSelectedMessage.getText();
        String expectedResult = "Radio button 'Male' is checked";
        Assert.assertEquals(actualResult, expectedResult, " Radio button Male is not checked");

        boolean isFemaleSelected;
        WebElement femaleElementField = driver.findElement(By.xpath("//input[@id='inlineRadio2]"));
        isFemaleSelected = femaleElementField.isSelected();
        Assert.assertFalse(isFemaleSelected, "Female radio button not selected");
        femaleElementField.click();
        isFemaleSelected = femaleElementField.isSelected();
        Assert.assertTrue(isFemaleSelected, "Female radio button is not selected");
        showSelectedValueField.click();
        String actualResultOne = showSelectedMessage.getText();
        String expectedResultOne = "Radio button 'Female' is checked";
        Assert.assertEquals(actualResult, expectedResult, " Radio button Female is not checked");

    }

    @Test
    public void verifyForm() {
        driver.get("https://selenium.obsqurazone.com/form-submit.php");
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
        firstNameField.sendKeys("Shifana");
        Assert.assertNotNull(firstNameField);
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
        lastNameField.sendKeys("S");
        Assert.assertNotNull(lastNameField);
        WebElement userNameField = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
        userNameField.sendKeys("Form@123");
        Assert.assertNotNull(userNameField);
        WebElement cityField = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
        cityField.sendKeys("Tvm");
        Assert.assertNotNull(cityField);
        WebElement stateField = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
        stateField.sendKeys("Kerala");
        Assert.assertNotNull(stateField);
        WebElement zipField = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
        zipField.sendKeys("123");
        Assert.assertNotNull(zipField);

        boolean isBoxSelected;
        WebElement agreeTermsCheckBox = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
        isBoxSelected = agreeTermsCheckBox.isSelected();
        Assert.assertFalse(isBoxSelected, "Check box selected");
        agreeTermsCheckBox.click();
        isBoxSelected = agreeTermsCheckBox.isSelected();
        Assert.assertTrue(isBoxSelected, "Check box not selected");
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        WebElement actualResultIs= driver.findElement(By.xpath("//div[@id='message-one']"));
        String actualResult = actualResultIs.getText();
        String expectedResult = "Form has been submitted successfully!";
        Assert.assertEquals(actualResult,expectedResult, "Form submission failed");


    }
}
