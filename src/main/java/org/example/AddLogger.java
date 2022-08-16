package org.example;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public class AddLogger implements WebDriverListener {

    private static Logger logger = LoggerFactory.getLogger(AddLogger.class);

    public void beforeFindElement(WebDriver driver, By locator){
        logger.info("ищем элемент по лакатору " + locator);
        Allure.step("ищем элемент по лакатору " + locator);
    }

    public void beforeQuit(WebDriver driver){
        Allure.addAttachment("скриншот перед закрытием браузера", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

}
