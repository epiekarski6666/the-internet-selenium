package javaScriptAlerts;

import helperMethods.JavaScriptAlertsHelper;
import locators.JavaScriptAlertsLocators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import setup.Setup;
import stringVariables.JavaScriptAlertsStringVariables;

public class JavaScriptAlerts extends Setup{

    JavaScriptAlertsHelper javaScriptAlertsHelper = new JavaScriptAlertsHelper();

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
        driver.findElement(JavaScriptAlertsLocators.javaScriptAlertsLink).click();
    }
    @AfterEach
    public void closeAndQuit() {
        driver.quit();
    }

    @Test
    public void clickForJSConfirmConfirmMessage() {
        javaScriptAlertsHelper.buttonClick(JavaScriptAlertsLocators.clickForJsConfirmButton);
        javaScriptAlertsHelper.alertAccept();
        Assertions.assertEquals(JavaScriptAlertsStringVariables.expected, driver.findElement(JavaScriptAlertsLocators.finishMessageId).getText());
    }
    @Test
    public void javaScriptAlertJsAlertPromptText() {
        javaScriptAlertsHelper.buttonClick(JavaScriptAlertsLocators.clickForJsAlertButton);
        Assertions.assertEquals(JavaScriptAlertsStringVariables.iAmJsAlert, driver.switchTo().alert().getText());
        javaScriptAlertsHelper.alertAccept();
    }
    @Test
    public void javaScriptAlertJsConfirmPromptText() {
        javaScriptAlertsHelper.buttonClick(JavaScriptAlertsLocators.clickForJsConfirmButton);
        Assertions.assertEquals(JavaScriptAlertsStringVariables.iAmJsConfirm, driver.switchTo().alert().getText());
        javaScriptAlertsHelper.alertAccept();
    }    @Test
    public void javaScriptAlertJsPromptPromptText() {
        javaScriptAlertsHelper.buttonClick(JavaScriptAlertsLocators.clickForJsPromptButton);
        Assertions.assertEquals(JavaScriptAlertsStringVariables.iAmJsPrompt, driver.switchTo().alert().getText());
        javaScriptAlertsHelper.alertAccept();
    }
    @Test
    public void javaScriptAlertJsPromptTextEntered() {
        javaScriptAlertsHelper.buttonClick(JavaScriptAlertsLocators.clickForJsPromptButton);
        driver.switchTo().alert().sendKeys(JavaScriptAlertsStringVariables.hireMePlease);
        javaScriptAlertsHelper.alertAccept();
        Assertions.assertEquals(JavaScriptAlertsStringVariables.jsPromptEnteredText, driver.findElement(JavaScriptAlertsLocators.finishMessageId).getText());
    }
}
