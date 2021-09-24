package formAuthentication;

import locators.FormAuthenticationLocators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import setup.Setup;
import stringVariables.FormAuthenticationStringVariables;

public class FormAuthentication extends Setup {

    @BeforeEach
    public void driverSetup() throws Exception {
        Setup setupBrowser = new Setup();
        setupBrowser.setup("chrome");
//        setupBrowser.setup("firefox");
//        setupBrowser.setup("edge");
//        setupBrowser.setup("opera");
        driver.get(BASIC_URL);
    }
    @AfterEach
    public void closeAndQuit() {
        driver.close();
        driver.quit();
    }
    @Test
    public void formAuthentication(){

        driver.findElement(FormAuthenticationLocators.formAuthenticationLink).click();
        driver.findElement(FormAuthenticationLocators.username).sendKeys(FormAuthenticationStringVariables.loginPhrase);
        driver.findElement(FormAuthenticationLocators.password).sendKeys(FormAuthenticationStringVariables.passwordPhrase);
        driver.findElement(FormAuthenticationLocators.password).submit();
        driver.findElement(FormAuthenticationLocators.logout).click();
        Assertions.assertEquals(FormAuthenticationStringVariables.expected, driver.findElement(FormAuthenticationLocators.prompt).getText());
    }
}
