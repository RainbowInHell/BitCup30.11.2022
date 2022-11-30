package swag_labs_test;

import Config.BaseTest;
import config.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import swag_labs_pages.InventoryPage;
import swag_labs_pages.LogInPage;

public class LoginPage_TestsRunner extends BaseTest {
    LogInPage loginPage;

    @BeforeClass
    public void openSwagLabs(){
        loginPage = new LogInPage();
    }

    @Test
    public void IsLoginPageOpened(){
        loginPage.openWindow();
        Assert.assertTrue(loginPage.isOpened());
    }

    @Test
    public void IsLoginInputFilled(){
        loginPage.openWindow();
        Assert.assertTrue(loginPage.isOpened());

        loginPage.fillUserNameField();
        Assert.assertEquals(PropertiesReader.getValue("userName"), loginPage.getWrittenUserName());
    }

    @Test
    public void IsPasswordFilled(){
        loginPage.openWindow();
        Assert.assertTrue(loginPage.isOpened());


        loginPage.fillUserPasswordField();
        Assert.assertEquals(PropertiesReader.getValue("userPassword"), loginPage.getWrittenPassword());
    }

    @Test
    public void IsAuthorized(){
        loginPage.openWindow();
        Assert.assertTrue(loginPage.isOpened());

        loginPage.fillUserNameField();
        Assert.assertEquals(PropertiesReader.getValue("userName"), loginPage.getWrittenUserName());

        loginPage.fillUserPasswordField();
        Assert.assertEquals(PropertiesReader.getValue("userPassword"), loginPage.getWrittenPassword());

        InventoryPage inventoryPage = loginPage.pressLoginButton();
        Assert.assertTrue(inventoryPage.isOpened());
    }

}
