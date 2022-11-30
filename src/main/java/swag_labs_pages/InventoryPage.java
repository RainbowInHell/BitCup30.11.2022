package swag_labs_pages;

import config.BasePage;
import org.openqa.selenium.By;

public class InventoryPage extends BasePage {
    private By inventoryPageLabel = new By.ByXPath("//div[@class='header_secondary_container']/span");
    private By firstItem = new By.ByXPath("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]");
    private By numberOfItemsLabel = new By.ByXPath("//span[@class='shopping_cart_badge']");

    @Override
    public boolean isOpened() {
        return DRVIER.findElement(inventoryPageLabel).isDisplayed();
    }

    public void AddItemToCart(){
        DRVIER.findElement(firstItem).click();
    }

    public void DeleteItemFromCart(){
        DRVIER.findElement(firstItem).click();
    }

    public String getNumberOfAddedItems(){
        return DRVIER.findElement(numberOfItemsLabel).getText();
    }

    public boolean isItemDisplayed(){
        return DRVIER.findElement(numberOfItemsLabel).isDisplayed();
    }

}
