package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//table[contains(@class, 'simplecheckout-cart')]/tbody/tr")
    private WebElement firstProduct;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("локализация продукта по имени на CartPage")
    public String getFirstProductName() {
        return firstProduct.findElement(By.className("name")).getText();
    }
}
