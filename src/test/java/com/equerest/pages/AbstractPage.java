package com.equerest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by cherleo on 9/19/16.
 */
public class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void visibilityOf(By locator){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public void clickableOf(By locator){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }

    public void click(By locator){
        visibilityOf(locator);
        clickableOf(locator);
        scrollTo(driver.findElement(locator));
        driver.findElement(locator).click();
    }

    public void clickJS(By locator){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", driver.findElement(locator));
    }
    
    public void selectCheckbox(By locator){
        if(driver.findElement(locator).isSelected() == false){
            clickJS(locator);
        }
        Assert.assertTrue(driver.findElement(locator).isSelected());
    }

    public void fillField(By locator, String data){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(data);
    }

    public void scrollTo(WebElement element) {

        String scrollElementIntoMiddle =
                "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                        + "var elementTop = arguments[0].getBoundingClientRect().top;"
                        + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
    }
    public void navigateBack(){
        driver.navigate().back();
    }
}
