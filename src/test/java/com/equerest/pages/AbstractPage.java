package com.equerest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by cherleo on 9/19/16.
 */
public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void clickJS(By locator){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public void fillField(By locator, String data){
        driver.findElement(locator).sendKeys(data);
    }

    public void scrollTo(WebElement element) {

        String scrollElementIntoMiddle =
                "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                        + "var elementTop = arguments[0].getBoundingClientRect().top;"
                        + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);

    }
}
