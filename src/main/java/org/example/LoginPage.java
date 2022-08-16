package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    @FindBy(name = "email")
    private WebElement email_field;
    @FindBy(name = "password")
    private WebElement password_field;
    @FindBy(xpath = "//a[contains(text(), 'Войти')]")
    private WebElement login_button;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("ввод имейла")
    public LoginPage InputEmail(String email) {
        this.email_field.sendKeys(email);
        return this;
    }
    @Step("ввод пароля")
    public LoginPage InputPassword(String password) {
        this.password_field.sendKeys(password);
        return this;
    }
    @Step("клик кнопки логина")
    public LoginPage ClickLogin() {
        this.login_button.click();
        return this;
    }

}
