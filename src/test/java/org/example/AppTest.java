package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class AppTest {
    WebDriver driver;

    private final static String SITE_BASE = "https://www.cifrus.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new EventFiringDecorator(new AddLogger()).decorate(new ChromeDriver());
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Добавление товара в корзину через PageObject")
    void cartTest() {
        driver.get(SITE_BASE);
        MainPage page = new MainPage(driver);
        WebElement product = page.GetFirstProduct();
        String name = page.GetProductName(product);
        page.AddToCart(product);
        driver.get("https://www.cifrus.ru/basket.php");
        String cartProductName = new CartPage(driver).getFirstProductName();
        Assertions.assertEquals(cartProductName, name);
    }

    @Test
    @DisplayName("Авторизация через PageObject")
    void loginTest() {
        driver.get(SITE_BASE);
        new MainPage(driver)
                .ShowAuth()
                .ClickLogin();
        new LoginPage(driver)
                .InputEmail("vexeae@mailto.plus")
                .InputPassword("8520go")
                .ClickLogin();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assertions.assertEquals(url, "https://www.cifrus.ru/account/profile");
    }

    @Test
    @DisplayName("Поиск конкретного товара через PageObject")
    void searchIphone() {
        driver.get(SITE_BASE);
        new MainPage(driver)
                .InputSearchQuery("iphone 13")
                .Search();

        String foundName = new SearchPage(driver).GetFirstProductName();
        Assertions.assertTrue(foundName.toLowerCase().contains("iphone 13"));
    }

    @AfterEach
    void quitBrowser() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log : logEntries)
            Allure.addAttachment("Элемент лога браузера ", log.getMessage());
        driver.quit();
    }
}
