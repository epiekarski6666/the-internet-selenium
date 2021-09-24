package dynamicLoading;

import locators.DynamicLoadingExample2Locators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Setup;
import stringVariables.DynamicLoadingExample2StringVariables;

public class DynamicLoadingExample2 extends Setup{

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
    public void dynamicLoadingExample2() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(DynamicLoadingExample2Locators.dynamicLoadingLink).click();
        driver.findElement(DynamicLoadingExample2Locators.dynamicLink2).click();
        driver.findElement(DynamicLoadingExample2Locators.startButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(DynamicLoadingExample2Locators.finishDivId));
        Assertions.assertEquals(DynamicLoadingExample2StringVariables.expected, driver.findElement(DynamicLoadingExample2Locators.finishDivId).getText());
    }
}
