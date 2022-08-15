package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private WebDriver driver;
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public String GetFirstProductName() {
        WebElement el = this.driver
                .findElement(By.className("product-thumb"))
                .findElement(By.className("caption"))
                .findElement(By.className("name"));
        return el.getText();
    }
}
