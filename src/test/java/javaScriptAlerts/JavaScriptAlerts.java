package javaScriptAlerts;

import helperMethods.JavaScriptAlertsHelper;
import locators.JavaScriptAlertsLocators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Setup;
import stringVariables.JavaScriptAlertsStringVariables;

public class JavaScriptAlerts extends Setup{

    JavaScriptAlertsHelper jaHelper = new JavaScriptAlertsHelper();

    @BeforeEach
    public void driverSetup() throws Exception{
        Setup setupBrowser = new Setup();
        setupBrowser.setup(
                "chrome"
//                "firefox"
//                "edge"
//                "opera"
        );
        driver.get(BASIC_URL);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(JavaScriptAlertsLocators.javaScriptAlertsLink));
        driver.findElement(JavaScriptAlertsLocators.javaScriptAlertsLink).click();
    }
    @AfterEach
    public void closeAndQuit() {
        driver.quit();
    }
    @Test
    public void clickForJSConfirm() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        jaHelper.javaScript(JavaScriptAlertsLocators.clickForJsConfirmButton);
        wait.until(ExpectedConditions.alertIsPresent());
        jaHelper.alertAccept();
        Assertions.assertEquals(JavaScriptAlertsStringVariables.expected, driver.findElement(JavaScriptAlertsLocators.finishMessageId).getText());
    }
    @Test
    public void javaScriptAlertJsAlertPromptText() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        jaHelper.javaScript(JavaScriptAlertsLocators.clickForJsAlertButton);
        wait.until(ExpectedConditions.alertIsPresent());
        Assertions.assertEquals(JavaScriptAlertsStringVariables.iAmJsAlert, driver.switchTo().alert().getText());
        jaHelper.alertAccept();
    }
    @Test
    public void javaScriptAlertJsConfirmPromptText() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        jaHelper.javaScript(JavaScriptAlertsLocators.clickForJsConfirmButton);
        wait.until(ExpectedConditions.alertIsPresent());
        Assertions.assertEquals(JavaScriptAlertsStringVariables.iAmJsConfirm, driver.switchTo().alert().getText());
        jaHelper.alertAccept();
    }    @Test
    public void javaScriptAlert3() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        jaHelper.javaScript(JavaScriptAlertsLocators.clickForJsPromptButton);
        wait.until(ExpectedConditions.alertIsPresent());
        Assertions.assertEquals(JavaScriptAlertsStringVariables.iAmJsPrompt, driver.switchTo().alert().getText());
        jaHelper.alertAccept();
    }
    @Test
    public void javaScriptAlert4() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        jaHelper.javaScript(JavaScriptAlertsLocators.clickForJsPromptButton);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(JavaScriptAlertsStringVariables.hireMePlease);
        jaHelper.alertAccept();
        Assertions.assertEquals(JavaScriptAlertsStringVariables.jsPromptEnteredText, driver.findElement(JavaScriptAlertsLocators.finishMessageId).getText());
    }
}
