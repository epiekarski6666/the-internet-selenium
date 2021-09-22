package formAuthentication;

import locators.FormAuthenticationLocators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import setup.Setup;
import stringVariables.StringVariables;

import java.util.concurrent.TimeUnit;

public class FormAuthentication extends Setup {

    @BeforeEach
    public void driverSetup() throws Exception {
        Setup s = new Setup();
        s.setup("chrome");
//        s.setup("firefox");
//        s.setup("edge");
//        s.setup("opera");
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
        driver.findElement(FormAuthenticationLocators.username).sendKeys(StringVariables.loginPhrase);
        driver.findElement(FormAuthenticationLocators.password).sendKeys(StringVariables.passwordPhrase);
        driver.findElement(FormAuthenticationLocators.password).submit();
        driver.findElement(FormAuthenticationLocators.logout).click();
        Assertions.assertEquals(StringVariables.expected, driver.findElement(FormAuthenticationLocators.prompt).getText());
    }
}
