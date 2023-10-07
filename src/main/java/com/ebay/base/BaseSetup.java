package com.ebay.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseSetup {
    protected WebDriver driver;
    protected ITestContext context;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void setUp(ITestContext context, String browser, String url) {
        //check the browser type
        if (browser.equalsIgnoreCase("chrome")) {
            // Set up the WebDriver instance
            String exePath = System.getProperty("user.dir") +
                    "\\src\\main\\resources\\drivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        } else if (browser.equalsIgnoreCase("edge")) {
            // Set up the WebDriver instance
            String exePath = System.getProperty("user.dir") +
                    "\\src\\main\\resources\\drivers\\msedgedriver.exe";
            System.setProperty("webdriver.msedge.driver", exePath);

            driver = new EdgeDriver();
            driver.manage().window().maximize();

        }
        // Set driver to the context
        context.setAttribute("driver", driver);
        this.context = context;

        driver = (WebDriver) context.getAttribute("driver");
        driver.get(url);

    }

    @AfterTest
    public void tearDown() {
        // Close the WebDriver instance
        driver.quit();
        System.out.println("Test Ran Successfully");
    }

    // custom sleep thread function
    public static void holdExecution(int milSec) {

        try {
            Thread.sleep(milSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
