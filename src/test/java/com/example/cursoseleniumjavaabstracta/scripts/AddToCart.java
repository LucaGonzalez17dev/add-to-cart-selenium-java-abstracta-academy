package com.example.cursoseleniumjavaabstracta.scripts;

import com.example.cursoseleniumjavaabstracta.dataProvider.CombinedData;
import com.example.cursoseleniumjavaabstracta.pages.HomePage;
import com.example.cursoseleniumjavaabstracta.pages.ProductPage;
import com.example.cursoseleniumjavaabstracta.pages.ProductSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class AddToCart {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://opencart.abstracta.us/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(dataProvider = "combinedData", dataProviderClass = CombinedData.class)
    public void testAddToCartAndCurrencyChange(String currencyCode, String currencySymbol, String product, String expectedPrice) throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.selectCurrency(currencyCode);
        String selectedSymbol = homePage.getSelectedCurrency();
        Assert.assertEquals(selectedSymbol, currencySymbol);
        driver.get("http://opencart.abstracta.us/");
        ProductSearchPage productSearchPage = homePage.search(product);
        ProductPage productPage = productSearchPage.clickProduct(product);
        assertEquals(productPage.getPrice(), expectedPrice);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}