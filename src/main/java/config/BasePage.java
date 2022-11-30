package config;

import org.openqa.selenium.WebDriver;
import webdriver.WebDriverSingleton;

public abstract class BasePage {
    public final WebDriver DRVIER = WebDriverSingleton.getInstance().getDriver();

    public abstract boolean isOpened();
    public abstract void openWindow();

//    public boolean waitUntil {
//
//    }

    public void wait(int time){
        try{
            Thread.sleep(time*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
