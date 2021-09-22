package locators;

import org.openqa.selenium.By;

public class FormAuthenticationLocators {
    public static final By
    username = By.id("username"),
    password = By.id("password"),
    logout = By.className("icon-2x"),
    formAuthenticationLink = By.xpath("//a[@href='/login']"),
    prompt = By.id("flash");
}
