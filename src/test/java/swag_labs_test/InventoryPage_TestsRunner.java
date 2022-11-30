package swag_labs_test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import swag_labs_pages.InventoryPage;
import swag_labs_pages.LogInPage;

public class InventoryPage_TestsRunner {
    InventoryPage inventoryPage;

    @BeforeClass
    public void openSwagLabs(){
        inventoryPage = new InventoryPage();
    }

    @Test
    public void IsItemAddedToCart(){
        inventoryPage.openWindow();
        Assert.assertTrue(inventoryPage.isOpened());

        inventoryPage.AddItemToCart();
        Assert.assertEquals("1", inventoryPage.getNumberOfAddedItems());
    }

    @Test
    public void IsItemDeletedFromCart(){
        inventoryPage.openWindow();
        Assert.assertTrue(inventoryPage.isOpened());

        inventoryPage.AddItemToCart();
        Assert.assertEquals("1", inventoryPage.getNumberOfAddedItems());

        inventoryPage.DeleteItemFromCart();
        Assert.assertFalse(inventoryPage.isItemDisplayed());

    }

    @Test
    public void IsLogOut(){
        inventoryPage.openWindow();
        Assert.assertTrue(inventoryPage.isOpened());

        LogInPage logInPage = inventoryPage.LogOut();
        Assert.assertTrue(logInPage.isOpened());
    }

}
