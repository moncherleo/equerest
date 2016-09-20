package com.equerest.pages.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by aBulgakoff on 9/20/16.
 */
public class SelectedProjectPage extends ProjectsPage {
    Actions actions;

    private final By achievementsEdit = By.xpath("//*[@id='anchor-achievements']//button[@class='edit-btn']");
    private final By financeModelEdit = By.xpath("//*[@id='anchor-fmodel']//button[@class='edit-btn']");
    private final By financeModelEditThruLeftBar = By.xpath("//ul[contains(concat(' ', @class, ' '), ' left-nav ')]//a[normalize-space(.)='Финансовая модель']");

    public SelectedProjectPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    private SelectedProjectPage editFinanceModel(){
        /*move to the higher element for correct displaying of needed one*/
        actions.moveToElement(driver.findElement(achievementsEdit)).perform();
        driver.findElement(financeModelEdit).click();
        return this;
    }


}