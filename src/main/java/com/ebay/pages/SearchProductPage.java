package com.ebay.pages;

import com.ebay.base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchProductPage extends BaseSetup {
    String itemName;
    String itemPrice;
    String condition;
    String itemQty;

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getItemQty() {
        return itemQty;
    }

    public void setItemQty(String itemQty) {
        this.itemQty = itemQty;
    }

    @Test(priority = 1)
    public void selectProductOptions() {

        String currentURL = (String) context.getAttribute("currentUrl"); //Typecasting
        // Open a new window
        driver.navigate().to(currentURL);

        // Select dropdowns
        try {
            WebElement modelDropdown = driver.findElement(By.id("x-msku__select-box-1000"));
            modelDropdown.click();
            WebElement model = driver.findElement(By.xpath("//option[text()='Apple iPhone X']"));
            model.click();
        } catch (Exception e) {
        }
        try {
            WebElement carrierDropdown = driver.findElement(By.id("x-msku__select-box-1001"));
            carrierDropdown.click();
            WebElement carrier = driver.findElement(By.xpath("//option[text()='Unlocked (GSM)']"));
            carrier.click();
        } catch (Exception e) {
        }
        try {
            WebElement storageDropdown = driver.findElement(By.id("x-msku__select-box-1002"));
            storageDropdown.click();
            WebElement storage = driver.findElement(By.xpath("//option[text()='256 GB']"));
            storage.click();
        } catch (Exception e) {
        }
        try {
            WebElement colorDropdown = driver.findElement(By.id("x-msku__select-box-1003"));
            colorDropdown.click();
            WebElement color = driver.findElement(By.xpath("//option[text()='Gray']"));
            color.click();
        } catch (Exception e) {
        }
        try {
            WebElement cosmeticDropdown = driver.findElement(By.id("x-msku__select-box-1004"));
            cosmeticDropdown.click();
            WebElement cosmetic = driver.findElement(By.xpath("//option[text()='Good']"));
            cosmetic.click();
        } catch (Exception e) {
        }

    }

    @Test(priority = 2)
    public void print() {
        WebElement itemName = driver.findElement(By.xpath("//*[@id=\"LeftSummaryPanel\"]/div[1]/div[1]/div/h1/span"));
        setItemName(itemName.getText());
        System.out.println("item Name: " + getItemName());

        WebElement itemPrice = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[1]/div/div[2]/div/span[1]/span"));
        setItemPrice(itemPrice.getText());
        System.out.println("item Price: " + getItemPrice());

        WebElement condition = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[1]/div[1]/div/div[2]/div[1]/div/span/span[1]/span"));
        setCondition(condition.getText());
        System.out.println("item condition: " + getCondition() );

        WebElement quantity = driver.findElement(By.xpath("//*[@id=\"qtyTextBox\"]"));
        setItemQty(quantity.getAttribute("value"));
        System.out.println("item quantity: " + getItemQty());

    }

    @Test(priority = 3)
    public void addToCart() {
        // Find Add To Cart element and click on it
        WebElement AddToCartBtn = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[2]/ul/li[2]/div/a/span/span"));
        AddToCartBtn.click();
    }

}
