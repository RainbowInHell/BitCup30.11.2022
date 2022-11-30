package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverSingleton {
    private WebDriver driver;

    private static ThreadLocal<WebDriverSingleton> instance = new ThreadLocal<>();

    public WebDriverSingleton(){ driver = new ChromeDriver(); }

    public static synchronized WebDriverSingleton getInstance(){
        if(instance.get() == null){
            instance.set(new WebDriverSingleton());
        }
        return instance.get();
    }

    public WebDriver getDriver() { return driver; }

    public void closeDriver() {
        try{
            driver.quit();
        }finally {
            instance.remove();
        }
    }
}
