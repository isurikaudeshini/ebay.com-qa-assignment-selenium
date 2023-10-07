package com.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPage extends SearchProductPage {
    @Test(priority = 4)
    public void assertShoppingCart() {

        WebElement actualName = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[3]/div[1]/div/ul/li/div[1]/div/div/div[1]/div/div[2]/div/h3/span/a/span/span/label"));
        Assert.assertEquals(actualName.getText(), getItemName(), "Name is not matching");
        System.out.println(actualName.getText());

        WebElement actualPrice = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[3]/div[1]/div/ul/li/div[1]/div/div/div[1]/div/div[3]/div/div[1]/div[2]/div/div/span/span/span"));
        Assert.assertEquals(actualPrice.getText(), getItemPrice(), "Price is not matching");
        System.out.println(actualPrice.getText());
    }

    /*

        * This assertion used to work perfectly fine before ebay.com updated their website.
         But now, the quantity of items is displayed as a drop-down menu instead of a label.
         Unfortunately, the ID of the drop-down is not working.

    @Test(priority = 5)
    public void assertQuantity() {
        WebElement actualQuantity = driver.findElement(By.xpath("//*[@id=\"dropdown-1034663958-f8bfe6a4-b423-4738-8796-5779b2dc81b3\"]"));
        Assert.assertEquals(actualQuantity.getText(), getItemQty(), "Quantity is not matching");
        assert !actualQuantity.getText().equals("Qty 0") : "Quantity should not be empty";
        System.out.println(actualQuantity.getText());
    }

    */

    @Test(priority = 6)
    public void assertSubtotal() {

        WebElement subTotal = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[4]/div[2]/span/span/span"));
        Assert.assertEquals(subTotal.getText(), getItemPrice(), "subtotal and item price are not matching");
    }

    @Test(priority = 7)
    public void assertShippingValue() {

        WebElement shippingValue = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[2]/div[2]/span/span/span"));
        System.out.println("shippingValue :" + shippingValue.getText());

    }
}
