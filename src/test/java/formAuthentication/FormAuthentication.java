package formAuthentication;

import helperMethods.FormAuthenticationHelper;
import locators.FormAuthenticationLocators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import setup.Setup;
import stringVariables.FormAuthenticationStringVariables;

public class FormAuthentication extends Setup {

    FormAuthenticationHelper dynamicLoadingHelper1 = new FormAuthenticationHelper();

    @BeforeEach
    public void driverSetup() throws Exception {
        Setup setupBrowser = new Setup();
        setupBrowser.setup("chrome");
//        setupBrowser.setup("firefox");
//        setupBrowser.setup("edge");
//        setupBrowser.setup("opera");
        driver.get(BASIC_URL);
        driver.findElement(FormAuthenticationLocators.formAuthenticationLink).click();
    }
    @AfterEach
    public void closeAndQuit() {
        driver.quit();
    }
    @Test
    public void formAuthentication(){
        dynamicLoadingHelper1.login(FormAuthenticationLocators.username, FormAuthenticationLocators.password,
                FormAuthenticationStringVariables.usernamePhrase, FormAuthenticationStringVariables.passwordPhrase);
        driver.findElement(FormAuthenticationLocators.logout).click();
        Assertions.assertEquals(FormAuthenticationStringVariables.expected, driver.findElement(FormAuthenticationLocators.prompt).getText());
    }
}
