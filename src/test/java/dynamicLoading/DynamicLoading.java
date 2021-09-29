package dynamicLoading;

import helperMethods.DynamicLoadingHelper;
import locators.DynamicLoadingLocators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Setup;
import stringVariables.DynamicLoadingStringVariables;

public class DynamicLoading extends Setup{

    DynamicLoadingHelper dynamicLoadingHelper = new DynamicLoadingHelper();

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
        driver.findElement(DynamicLoadingLocators.dynamicLoadingLink).click();
    }
    @AfterEach
    public void closeAndQuit() {
        driver.quit();
    }
    @Test
    public void dynamicLoadingExample2ConfirmMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        dynamicLoadingHelper.startExample2(DynamicLoadingLocators.dynamicLink2);
        wait.until(ExpectedConditions.presenceOfElementLocated(DynamicLoadingLocators.finishDivId));
        Assertions.assertEquals(DynamicLoadingStringVariables.expected, driver.findElement(DynamicLoadingLocators.finishDivId).getText());
    }
}
