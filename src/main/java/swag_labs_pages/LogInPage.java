package swag_labs_pages;

import config.BasePage;
import config.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogInPage extends BasePage {

    private By loginPageLogo = new By.ByXPath("//div[@class='bot_column']");
    private By userNameInput = new By.ById("user-name");
    private By userPasswordInput = new By.ById("password");
    private By loginButton = new By.ById("login-button");

    @Override
    public boolean isOpened() {
        return DRVIER.findElement(loginPageLogo).isDisplayed();
    }

    @Override
    public void openWindow(){
        DRVIER.get(PropertiesReader.getValue("loginPageUrl"));
    }

    public void fillUserNameField(){
        WebElement usernameInput = DRVIER.findElement(userNameInput);

        usernameInput.click();
        usernameInput.sendKeys(PropertiesReader.getValue("userName"));

        wait(5);
    }

    public void fillUserPasswordField(){
        WebElement userpasswordInput = DRVIER.findElement(userPasswordInput);

        userpasswordInput.click();
        userpasswordInput.sendKeys(PropertiesReader.getValue("userPassword"));

        wait(5);
    }

    public InventoryPage pressLoginButton(){
        DRVIER.findElement(loginButton).click();
        return new InventoryPage();
    }

    public String getWrittenUserName(){
        return DRVIER.findElement(userNameInput).getAttribute("value");
    }

    public String getWrittenPassword(){
        return DRVIER.findElement(userPasswordInput).getAttribute("value");
    }
}
