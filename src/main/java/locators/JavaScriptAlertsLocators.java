package locators;

import org.openqa.selenium.By;

public class JavaScriptAlertsLocators {
    public static final By
    javaScriptAlertsLink = By.xpath(".//a[@href='/javascript_alerts']"),
    clickForJsConfirmButton = By.xpath("(//button)[text()='Click for JS Confirm']"),
    finishMessageId = By.id("result"),
    clickForJsAlertButton = By.xpath("(//button)[text()='Click for JS Alert']"),
    clickForJsPromptButton = By.xpath("(//button)[text()='Click for JS Prompt']");
}
