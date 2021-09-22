package locators;

import org.openqa.selenium.By;

public class FormAuthenticationLocators {
    public static final By
    formAuthenticationLink = By.xpath("//a[@href='/login']"),
    username = By.id("username"),
    password = By.id("password"),
    logout = By.className("icon-2x"),
    prompt = By.id("flash");
}
