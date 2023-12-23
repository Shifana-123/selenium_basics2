package org.selenium.commands;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;


public class Commands extends BrowserLaunch {
    @Test
    public void verifySwagLabsUserLogin() {
        driver.get("https://www.saucedemo.com/");
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        WebElement passWordField = driver.findElement(By.id("password"));
        passWordField.sendKeys("secret_sauce");
        WebElement loginButtonField = driver.findElement(By.id("login-button"));
        loginButtonField.click();
        WebElement swagLogo = driver.findElement(By.className("app_logo"));
        String actualSwagLogoText = swagLogo.getText();
        String expectedSwagLogoText = "Swag Labs";
        assertEquals(actualSwagLogoText, expectedSwagLogoText, "Invalid Logo found in login page");

    }

    @Test
    public void verifyDemoWebShopUserLogin() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.className("ico-login"));
        login.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("sshifana959@gmail.com");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Shifana@123");
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
        WebElement userLogin = driver.findElement(By.className("account"));
        String actualUserLogin = userLogin.getText();
        String expectedUserLogin = "sshifana959@gmail.com";
        assertEquals(actualUserLogin, expectedUserLogin, "Login Failed");
    }

    @Test
    public void verifyDemoTourRegistration() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement firstNameField = driver.findElement(By.name("firstName"));
        firstNameField.sendKeys("Shifana");
        WebElement lastNameField = driver.findElement(By.name("lastName"));
        lastNameField.sendKeys("S");
        WebElement phoneNumberField = driver.findElement(By.name("phone"));
        phoneNumberField.sendKeys("8156963192");
        WebElement emailField = driver.findElement(By.id("userName"));
        emailField.sendKeys("sshifana959@gmail.com");
        WebElement addressField = driver.findElement(By.name("address1"));
        addressField.sendKeys("Attingal");
        WebElement cityName = driver.findElement(By.name("city"));
        cityName.sendKeys("Thiruvananthapuram");
        WebElement stateName = driver.findElement(By.name("state"));
        stateName.sendKeys("Kerala");
        WebElement postalCodeField = driver.findElement(By.name("postalCode"));
        postalCodeField.sendKeys("695305");
        WebElement userNameField = driver.findElement(By.id("email"));
        userNameField.sendKeys("sshifana959@gmail.com");
        WebElement passWordField = driver.findElement(By.name("password"));
        passWordField.sendKeys("Demo@123");
        WebElement confirmPassWordField = driver.findElement(By.name("confirmPassword"));
        confirmPassWordField.sendKeys("Demo@123");
        WebElement submitButton = driver.findElement(By.name("submit"));
        //submitButton.click();
    }

    @Test
    public void verifyLinkText() {
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.linkText("your destination"));
        element.click();
    }

    @Test
    public void verifyPartialLinkText() {
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.partialLinkText("destination"));
        element.click();
    }

    @Test
    public void verifyDemoWebShopUserLoginUsingXpath() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement loginField = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        loginField.click();
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        emailField.sendKeys("sshifana959@gmail.com");
        WebElement passWordField = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        passWordField.sendKeys("Shifana@123");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
        loginButton.click();
        WebElement actualUserLoginElement = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        String actualLoginId = actualUserLoginElement.getText();
        String expectedLoginId = "sshifana959@gmail.com";
        assertEquals(actualLoginId, expectedLoginId, "User Login Failed");
    }

    @Test
    public void verifyDemoWebShopUserLoginUsingCssSelector() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement userLoginField = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
        userLoginField.click();
        WebElement emailField = driver.findElement(By.cssSelector("#Email"));
        emailField.sendKeys("sshifana959@gmail.com");
        WebElement passWordField = driver.findElement(By.cssSelector("#Password"));
        passWordField.sendKeys("Shifana@123");
        WebElement loginButton = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
        loginButton.click();
        WebElement actualUserLoginElement = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(1) > a"));
        String actualLoginId = actualUserLoginElement.getText();
        String expectedLoginId = "sshifana959@gmail.com";
        assertEquals(actualLoginId, expectedLoginId, " User Login Failed");

    }

    @Test
    public void validateTotalNumberOfTags() {
        driver.get("https://demowebshop.tricentis.com/");
        List<WebElement> inputTagElements = driver.findElements(By.tagName("Input"));
        int tagSize = inputTagElements.size();
        System.out.println(tagSize);
    }

    @Test
    public void verifyNavigationCommands() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement register = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        register.click();
        driver.navigate().back();
        driver.navigate().forward();
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"FirstName\"]"));
        firstName.sendKeys("Shifana");
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"LastName\"]"));
        lastName.sendKeys("S");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        email.sendKeys("sshifana959@gmail.com");
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.co.in/");
    }

    @Test
    public void verifyIsSelected() {
        boolean isMaleSelected;
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement maleRadioButton = driver.findElement(By.xpath("//input[@id='gender-male']"));
        isMaleSelected = maleRadioButton.isSelected(); //Expected result is false
        Assert.assertFalse(isMaleSelected, "Male radio button is selected");
        System.out.println("Gender Male Before Selection " + isMaleSelected);
        maleRadioButton.click();
        isMaleSelected = maleRadioButton.isSelected();
        Assert.assertTrue(isMaleSelected, "Male Radio button is not selected");
        System.out.println("Gender Male After Selection " + isMaleSelected);
    }

    @Test
    public void verifyIsEnabled() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement subscribeButton = driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
        boolean isSubscribeButtonEnabled = subscribeButton.isEnabled();
        Assert.assertTrue(isSubscribeButtonEnabled, "Subscribe button is not enabled");
    }

    @Test
    public void isDisplayed() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement voteButton = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        boolean isButtonDisplayed = voteButton.isDisplayed();
        Assert.assertTrue(isButtonDisplayed, " Vote Button is not displayed");
    }

    @Test
    public void verifyCommunityPoll() {
        driver.get("https://demowebshop.tricentis.com/");
        List<WebElement> communityPollElements = driver.findElements(By.xpath("//li[@class='answer']//label[starts-with(@for,'pollanswers')]"));
        for (WebElement obj : communityPollElements) {
            String poll = obj.getText();
            if (poll.equals("Poor")) {
                obj.click();
            }

        }

    }

    @Test
    public void verifyValueSelectFromDropDown() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countryDropDown);
        //select.selectByVisibleText("INDIA");
        //select.selectByIndex(23);
        select.selectByValue("AUSTRIA");
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println(firstSelectedOption.getText());
    }

    @Test
    public void verifyTotalNumberOfDropDownValues() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countryDropDown);
        List<WebElement> dropDownElements = select.getOptions();
        System.out.println(dropDownElements.size());

    }

    @Test
    public void verifyMultiSelectDropDown() {
        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
        WebElement multiSelect = driver.findElement(By.xpath("//select[@name='selenium_commands']"));
        Select select = new Select(multiSelect);
        boolean selectedValue = select.isMultiple();
        System.out.println(selectedValue);
        select.selectByVisibleText("Browser Commands");
        select.selectByVisibleText("Switch Commands");
        List<WebElement> selectedValues = select.getAllSelectedOptions();
        for (WebElement e : selectedValues) {
            System.out.println(e.getText());
        }
        select.deselectByVisibleText("Switch Commands");
    }

    @Test
    public void verifyFileUpload() {
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFileField = driver.findElement(By.xpath("//input[@type='file']"));
        chooseFileField.sendKeys("C:\\Users\\shifa\\IdeaProjects\\selenium_basics\\src\\main\\resources\\Selenium.docx");
        WebElement acceptField = driver.findElement(By.xpath("//input[@type='checkbox']"));
        acceptField.click();
        WebElement submitField = driver.findElement(By.xpath("//button[@type='button']"));
        submitField.click();
    }

    @Test
    public void verifyDropDownWithoutSelect() {
        driver.get("https://selenium.obsqurazone.com/jquery-select.php");
        WebElement stateDropDown = driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single']//span[@class='select2-selection__arrow']"));
        stateDropDown.click();
        List<WebElement> DropDownWithoutSelect = driver.findElements(By.xpath("//li[contains(@class,'select2-results__option select2-results__option--selectable')]"));
        for (WebElement dropDownValueElements : DropDownWithoutSelect) {
            String selectedState = dropDownValueElements.getText();
            if (selectedState.equals("California")) {
                dropDownValueElements.click();
                break;
            }
        }
    }

    @Test
    public void verifyTextInSubscribeButton() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement subscribeButton = driver.findElement(By.id("newsletter-subscribe-button"));
        String subscribeButtonText = subscribeButton.getAttribute("value");
        String expectedText = "Subscribe";
        Assert.assertEquals(subscribeButtonText, expectedText, "Invalid Text Found in Subscribe Button");
    }

    @Test
    public void validateSimpleAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement clickButton = driver.findElement(By.id("alertButton"));
        clickButton.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
    }

    @Test
    public void validateConfirmationAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement clickMeButton = driver.findElement(By.id("confirmButton"));
        clickMeButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement messageField = driver.findElement(By.id("confirmResult"));
        String actualMessage = messageField.getText();
        String expectedMessage = "You selected Cancel";
        Assert.assertEquals(actualMessage, expectedMessage, "Invalid Text Found");
    }

    @Test
    public void verifyPromptAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement clickButton = driver.findElement(By.id("promtButton"));
        clickButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Shifana");
        alert.accept();
        WebElement messageField = driver.findElement(By.id("promptResult"));
        String actualResult = messageField.getText();
        String expectedResult = "You entered Shifana";
        Assert.assertEquals(actualResult, expectedResult, "Invalid Text Found");
    }

    @Test
    public void verifyMultipleWindowHandling() {
        driver.get("https://demo.guru99.com/popup.php");
        String parentWindowHandleId = driver.getWindowHandle();
        System.out.println(parentWindowHandleId);
        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();
        Set<String> windowHandleIds = driver.getWindowHandles();
        System.out.println(windowHandleIds);
        Iterator<String> values = windowHandleIds.iterator();
        while (values.hasNext()) {
            String handleId = values.next();
            if (handleId.equals(parentWindowHandleId)) {
                System.out.println("Parent window of child window is" + handleId);
                driver.switchTo().window(handleId);
                WebElement emailField = driver.findElement(By.xpath("//input[@name='emailid']"));
                emailField.sendKeys("sshifana959@gmail.com");
                WebElement submitButton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
                submitButton.click();
                driver.close();
            }
        }
        driver.switchTo().window(parentWindowHandleId);
    }

    @Test
    public void verifyframes() {
        driver.get("https://demoqa.com/frames");
        List<WebElement> iframeTags = driver.findElements(By.tagName("iframe"));
        int size = iframeTags.size();
        System.out.println("Total No of iframes in the webpage is " + size);
        //driver.switchTo().frame(3);
        //driver.switchTo().frame("frame1");
        WebElement frame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame);
        WebElement frameText = driver.findElement(By.id("sampleHeading"));
        System.out.println("iframe text = " + frameText.getText());
        driver.switchTo().defaultContent();
    }

    @Test
    public void verifyRightClick() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions action = new Actions(driver);
        action.contextClick(rightClickButton).build().perform();
    }

    @Test
    public void verifyDoubleClick() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClickButton).build().perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
    }
    @Test
    public void verifyDragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement dragButton= driver.findElement(By.id("draggable"));
        WebElement dropButton=driver.findElement(By.id("droppable"));
        Actions action=new Actions(driver);
        action.dragAndDrop(dragButton,dropButton).build().perform();

    }
    @Test
    public void dragAndDropByOffset() {
        driver.get("https://demoqa.com/dragabble");
        WebElement dragBox= driver.findElement(By.id("dragBox"));
        Actions action=new Actions(driver);
        action.dragAndDropBy(dragBox,150,150).build().perform();
    }
    @Test
    public void verifyMouseOver() {
        driver.get("https://demoqa.com/menu/");
        WebElement selectItemButton= driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        Actions action=new Actions(driver);
        action.moveToElement(selectItemButton).build().perform();
        WebElement subListButton= driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        action.moveToElement(subListButton).build().perform();
    }
    @Test
    public void verifyJavaScriptClickAndSendKeys() {
        driver.get("https://demowebshop.tricentis.com/");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.getElementById('newsletter-email').value='test@test.com'");
        js.executeScript("document.getElementById('newsletter-subscribe-button').click()");
    }
    @Test
    public void verifyVerticalScroll() {
        driver.get("https://demowebshop.tricentis.com/");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    @Test
    public void verifyScreenshotAfterTestFail() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.className("ico-login"));
        login.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("sshifana959@gmail.com");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Shifana@123");
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
        WebElement userLogin = driver.findElement(By.className("account"));
        String actualUserLogin = userLogin.getText();
        String expectedUserLogin = "shifana@gmail.com";
        assertEquals(actualUserLogin, expectedUserLogin, "Login Failed");
    }
    @Test
    public void verifyWait() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
        WebElement clickButton=driver.findElement(By.id("timerAlertButton"));
        clickButton.click();
       // Thread.sleep(6000);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    @Test 
    public void verifyFluentWait() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
        WebElement clickButton=driver.findElement(By.id("timerAlertButton"));
        clickButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    @Test
    public void verifyDiffBetweenFindElementandFindElements() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement subscribeButton =driver.findElement(By.id("newsletter-subscribe-button"));
        System.out.println("WebElement on match " +subscribeButton);
        List<WebElement> communityPoll=driver.findElements(By.xpath("//li[@class='answer']//label"));
        int size=communityPoll.size();
        System.out.println("Size of list on match " +size);
        //onZeromatch
        List<WebElement> communityPollonZeroMatch=driver.findElements(By.xpath("//input[@class='answer123']//label"));
        int sizeonzeroMatch=communityPollonZeroMatch.size();
        System.out.println("Size of list on zero match " +sizeonzeroMatch);
        //WebElement subscribeButtononZeromatch =driver.findElement(By.id("newsletter-subscribe-button123"));
        //on Oneplus match
        WebElement communityPollonOnePlusMatch=driver.findElement(By.xpath("//li[@class='answer']//label"));
        communityPollonOnePlusMatch.click();
    }
    @Test
    public void verifyDiffBetweenCloseAndQuit() {
        driver.get("https://demo.guru99.com/popup.php");
        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();
    }


}











