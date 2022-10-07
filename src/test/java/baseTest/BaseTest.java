package baseTest;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPopup;

import java.time.Duration;


public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected LoginPopup loginPopup;
    protected HomePage homePage;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Chrome browser was opened");
        loginPopup = new LoginPopup(webDriver);
        homePage = new HomePage(webDriver);

    }

    @After
    public void tearDown(){
        webDriver.quit();
        logger.info("Chrome browser was closed");
    }



}
