package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddLogger implements WebDriverListener {

    private static Logger logger = LoggerFactory.getLogger(AddLogger.class);

    public void beforeFindElement(WebDriver driver, By locator){
        logger.info("ищем элемент по лакатору " + locator);
    }

}
