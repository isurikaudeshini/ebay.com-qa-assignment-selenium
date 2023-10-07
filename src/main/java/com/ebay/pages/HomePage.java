package com.ebay.pages;

import com.ebay.base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class HomePage extends BaseSetup {
    @Test(priority = 1)
    public void verifyURL() {
        String expectedUrl = "https://www.ebay.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Page URL is not matching");
    }

    @Test(priority = 2)
    public void selectDropDown() {
        // Find All categories drop-down element
        WebElement categoriesDropdown = driver.findElement(By.id("gh-cat"));

        // Click on the drop-down to expand it
        categoriesDropdown.click();

        // Find the "Cell Phones & Accessories" option in the drop-down and click on it
        WebElement cellPhonesOption = driver.findElement(By.xpath("//option[contains(text(),'Cell Phones & Accessories')]"));
        cellPhonesOption.click();
    }

    @Test(priority = 3)
    public void searchForMobile() {
        // Find the search box and enter "Mobile Phone"
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Mobile phone");

        //Click on search Button
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();
    }

    @Test(priority = 4)
    public void filterByBrand() {
        // Check the "Apple" checkbox
        WebElement appleBrandCheckbox = driver.findElement(By.xpath("//input[@aria-label='Apple']"));
        appleBrandCheckbox.click();

    }

    @Test(priority = 5)
    public void selectProduct() {
        // Find the first search result item and click on it
        WebElement firstSearchResult = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div/span"));
        firstSearchResult.click();

        //hold for 5 seconds
        holdExecution(5000);

        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }


        String currentUrl = driver.getCurrentUrl();

        context.setAttribute("currentUrl", currentUrl);

    }

}