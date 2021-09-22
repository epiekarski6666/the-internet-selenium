package formAthencication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import setup.Setup;

public class FormAuthentication extends Setup {
    WebDriver driver;

    private final String
    formAuthHref = "//a[@href='/login']",
    loginPhrase = "tomsmith",
    passwordPhrase = "SuperSecretPassword!",
    expected = "You logged out of the secure area!\n×";

    private final By
    username = By.id("username");


    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(BASIC_URL);
    }
    @AfterEach
    public void closeAndQuit() {
        driver.close();
        driver.quit();
    }
    @Test
    public void formAuthentication(){

        driver.findElement(new By.ByXPath(formAuthHref)).click();
        driver.findElement(username).sendKeys(loginPhrase);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(passwordPhrase);
        password.submit();
        WebElement logout = driver.findElement(By.className("icon-2x"));
        logout.click();
        Assertions.assertEquals(expected, driver.findElement(By.id("flash")).getText());
    }
}
