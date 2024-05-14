package com.example.cursoseleniumjavaabstracta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static WebDriver driver;

    public HomePage(WebDriver driver){
        HomePage.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "search")
    private WebElement searchBar;

    @FindBy(id = "cart-total")
    private WebElement cartTotal;

    public ProductSearchPage search(String product){
        searchBar.sendKeys(product);
        searchBar.sendKeys(Keys.ENTER);
        return new ProductSearchPage(driver);
    }

    public void selectCurrency(String currency){
        driver.findElement(By.xpath("//strong")).click();
        driver.findElement(By.name(currency)).click();
    }

    public String getSelectedCurrency() {
        return driver.findElement(By.xpath("//strong")).getText();
    }

    public boolean isProductInCart(String productName){
        cartTotal.click();
        return driver.findElement(By.linkText(productName)).isDisplayed();
    }

}