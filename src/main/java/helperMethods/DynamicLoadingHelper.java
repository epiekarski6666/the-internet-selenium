package helperMethods;

import locators.DynamicLoadingLocators;
import org.openqa.selenium.By;
import setup.Setup;

public class DynamicLoadingHelper extends Setup{

    public void startExample2(By locators){
        driver.findElement(locators).click();
        driver.findElement(DynamicLoadingLocators.startButton).click();
    }

}
