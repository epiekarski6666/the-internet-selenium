package locators;

import org.openqa.selenium.By;

public class DynamicLoadingExample2Locators {
    public static final By
    dynamicLoadingLink = By.xpath("//a[@href='/dynamic_loading']"),
    dynamicLink2 = By.xpath("//a[@href='/dynamic_loading/2']"),
    startButton = By.cssSelector("[id=\"start\"]>button"),
    finishDivId = By.id("finish")
    ;
}
