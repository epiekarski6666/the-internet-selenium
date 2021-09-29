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

    FormAuthenticationHelper faHelper = new FormAuthenticationHelper();

    @BeforeEach
    public void driverSetup() throws Exception {
        Setup setupBrowser = new Setup();
        setupBrowser.setup(
                "chrome"
//                "firefox"
//                "edge"
//                "opera"
        );
        driver.get(BASIC_URL);
        driver.findElement(FormAuthenticationLocators.formAuthenticationLink).click();
    }
    @AfterEach
    public void closeAndQuit() {
        driver.quit();
    }
    @Test
    public void formAuthentication(){
        faHelper.login(FormAuthenticationLocators.username, FormAuthenticationLocators.password,
                FormAuthenticationStringVariables.usernamePhrase, FormAuthenticationStringVariables.passwordPhrase);
//        driver.findElement(FormAuthenticationLocators.logout).click();
        faHelper.logout(FormAuthenticationLocators.logout);
        Assertions.assertEquals(FormAuthenticationStringVariables.expected, driver.findElement(FormAuthenticationLocators.prompt).getText());
    }
}
