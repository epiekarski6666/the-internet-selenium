package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class Setup {
    public static WebDriver driver;
    public String BASIC_URL = "https://the-internet.herokuapp.com/";

    @Parameters("browserType")
    public void setup(String browserType) throws Exception{

        if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browserType.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else if (browserType.equalsIgnoreCase("opera")) {
            System.setProperty("webdriver.opera.driver","src/main/resources/operadriver.exe");
            driver = new OperaDriver();
        }
        else{
            throw new Exception("This browser is not valid for this test");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
