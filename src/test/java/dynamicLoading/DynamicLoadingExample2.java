package dynamicLoading;

import locators.DynamicLoadingExample2Locators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stringVariables.DynamicLoadingExample2StringVariables;

public class DynamicLoadingExample2 {
    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
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
