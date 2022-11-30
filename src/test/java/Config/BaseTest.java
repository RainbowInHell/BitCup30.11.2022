package Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import webdriver.WebDriverSingleton;

public abstract class BaseTest {

    @BeforeClass
    public void setupTest(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.getInstance().getWebDriver().manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        WebDriverSingleton.getInstance().closeDriver();
    }

}
