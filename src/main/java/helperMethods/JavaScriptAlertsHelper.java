package helperMethods;

import org.openqa.selenium.By;
import setup.Setup;

public class JavaScriptAlertsHelper extends Setup {

    public void javaScript(By button){
        driver.findElement(button).click();
    }
    public void alertAccept(){
        driver.switchTo().alert().accept();
    }
}
