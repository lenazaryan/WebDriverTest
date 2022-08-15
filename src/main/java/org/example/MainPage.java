package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[contains(text(), 'Личный')]")
    private WebElement auth_menu;
    @FindBy(xpath = "//*[contains(text(), 'Авторизация')]")
    private WebElement login_button;
    @FindBy(id = "search_box")
    private WebElement search_box;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement search_button;

    @FindBy(className = "product-thumb")
    private WebElement product;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage ShowAuth() {
        this.auth_menu.click();
        return this;
    }

    public MainPage ClickLogin() {
        this.login_button.click();
        return this;
    }

    public MainPage InputSearchQuery(String query) {
        this.search_box.sendKeys(query);
        return this;
    }

    public MainPage Search() {
        this.search_button.click();
        return this;
    }

    public WebElement GetFirstProduct() {
        return this.product;
    }

    public String GetProductName(WebElement product) {
        return product.findElement(By.className("caption")).findElement(By.className("name")).getText();
    }

    public MainPage AddToCart(WebElement product) {
        product.findElement(By.xpath("//button[contains(text(), 'В корзину')]")).click();
        return this;
    }


}
