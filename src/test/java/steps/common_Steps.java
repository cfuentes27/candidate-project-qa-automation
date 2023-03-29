package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class common_Steps {

     private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webDriver.chrome.driver", "webDrivers/chromedriver_mac64/chromedriver");
        //System.setProperty("webDriver.gecko.driver", "webDrivers/gekoDriver/geckodriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        Thread.sleep(1000);
    }

    public WebDriver getDriver(){
        return driver;
    }
}
