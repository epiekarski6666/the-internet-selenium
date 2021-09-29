package helperMethods;

import org.openqa.selenium.By;
import setup.Setup;

public class FormAuthenticationHelper extends Setup {

    public void login(By username, By password, String usernamePhrase, String passwordPhrase){
        driver.findElement(username).sendKeys(usernamePhrase);
        driver.findElement(password).sendKeys(passwordPhrase);
        driver.findElement(password).submit();
    }
    public void logout(By logout){
        driver.findElement(logout).click();
    }

}
