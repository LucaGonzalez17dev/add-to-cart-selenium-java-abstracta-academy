package com.example.cursoseleniumjavaabstracta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {
    private WebDriver driver;

    @FindBy(css = "li h2")
    private WebElement price;

    @FindBy(id = "button-cart")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        return price.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }
}