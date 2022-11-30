package swag_labs_pages;

import config.BasePage;
import config.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {
    private By inventoryPageLabel = new By.ByXPath("//div[@class='header_secondary_container']/span");
    private By firstItem = new By.ByXPath("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]");
    private By numberOfItemsLabel = new By.ByXPath("//span[@class='shopping_cart_badge']");
    private By menuTab = new By.ByXPath("react-burger-menu-btn");
    private By menuItem = new By.ByXPath("//a[@class='bm-item menu-item']");


    @Override
    public boolean isOpened() {
        return DRVIER.findElement(inventoryPageLabel).isDisplayed();
    }

    public void openWindow(){
        DRVIER.get(PropertiesReader.getValue("inventoryPageUrl"));
    }

    public void AddItemToCart(){
        DRVIER.findElement(firstItem).click();
    }

    public void DeleteItemFromCart(){
        DRVIER.findElement(firstItem).click();
    }

    public LogInPage LogOut(){
        DRVIER.findElement(menuTab).click();

        List<WebElement> listOfMenuTabEelemnts = new ArrayList<>();
        listOfMenuTabEelemnts =  DRVIER.findElements(menuItem);

        for(int pos = 0; pos != listOfMenuTabEelemnts.size(); pos++)
        {
            if(listOfMenuTabEelemnts.get(pos).getText() == "Logout")
            {
                listOfMenuTabEelemnts.get(pos).click();
                return new LogInPage();
            }
        }

        return null;
    }

    public void SortNameZtoA(){

    }


    public String getNumberOfAddedItems(){
        return DRVIER.findElement(numberOfItemsLabel).getText();
    }

    public boolean isItemDisplayed(){
        return DRVIER.findElement(numberOfItemsLabel).isDisplayed();
    }

}
