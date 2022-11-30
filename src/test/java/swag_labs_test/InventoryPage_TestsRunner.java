package swag_labs_test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import swag_labs_pages.InventoryPage;

public class InventoryPage_TestsRunner {
    InventoryPage inventoryPage;

    @BeforeClass
    public void openSwagLabs(){
        inventoryPage = new InventoryPage();
    }

    @Test
    public void IsItemAddedToCart(){
        inventoryPage.AddItemToCart();

        Assert.assertEquals("1", inventoryPage.getNumberOfAddedItems());
    }

    @Test
    public void IsItemDeletedFromCart(){
        inventoryPage.AddItemToCart();
        Assert.assertEquals("1", inventoryPage.getNumberOfAddedItems());

        inventoryPage.DeleteItemFromCart();
        Assert.assertFalse(inventoryPage.isItemDisplayed());

    }
}
