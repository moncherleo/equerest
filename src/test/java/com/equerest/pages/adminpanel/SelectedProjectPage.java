package com.equerest.pages.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by aBulgakoff on 9/20/16.
 */
public class SelectedProjectPage extends ProjectsPage {
    private Actions actions;

    private final String commonSmallEditButton = "//button[@class='edit-btn']";

    /*final edition buttons*/
    private final By saveProjectButton = By.cssSelector(".btn.btn-success");
    private final By cancelProjectEditButton = By.cssSelector(".btn.btn-primary");
    private final By moveProjectToArchive = By.cssSelector(".btn.btn-warning");

    private final By addNumbersButton = By.xpath("html/body/div[1]/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/h3/span/a");
    private final By descriptionEdit = By.xpath("//*[@id='anchor-full_description']" + commonSmallEditButton);
    private final By textField = By.id("tmpFull_description");
    private final By achievementsEdit = By.xpath("//*[@id='anchor-achievements']" + commonSmallEditButton);
    private final By financeModelEdit = By.xpath("//*[@id='anchor-fmodel']" + commonSmallEditButton);

    /*left bar's buttons*/
    private final By financeModelEditThruLeftBar = By.xpath("//ul[contains(concat(' ', @class, ' '), ' left-nav ')]//a[normalize-space(.)='Финансовая модель']");
    
    private final By applyChangesButton = By.xpath("html/body/div[1]/main/div/div/div/section[2]/div[2]/div[2]/div/div[2]/h3/div/button[2]");
    private final By discardChangesButton = By.xpath("html/body/div[1]/main/div/div/div/section[2]/div[2]/div[2]/div/div[2]/h3/div/button[1]");

    public SelectedProjectPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    public SelectedProjectPage applyChanges() {
        /*scroll page for correct displaying of the needed element*/
        actions.moveToElement(driver.findElement(saveProjectButton)).perform();
        actions.moveToElement(driver.findElement(addNumbersButton)).perform();
        driver.findElement(applyChangesButton).click();
        return this;
    }

    public SelectedProjectPage discardChanges() {
        /*scroll page for correct displaying of the needed element*/
        actions.moveToElement(driver.findElement(saveProjectButton)).perform();
        actions.moveToElement(driver.findElement(addNumbersButton)).perform();
        driver.findElement(discardChangesButton).click();
        return this;
    }

    public SelectedProjectPage editProjectDescription(String description) {
        driver.findElement(descriptionEdit).click();
        driver.findElement(textField).click();
        driver.findElement(textField).clear();
        driver.findElement(textField).sendKeys(description);
        return this;
    }


    public SelectedProjectPage editFinanceModel() {
        /*move to the higher element for correct displaying of needed one*/
        actions.moveToElement(driver.findElement(achievementsEdit)).perform();
        driver.findElement(financeModelEdit).click();
        return this;
    }

    public SelectedProjectPage uploadFinancePlan(String path) {
        //TODO: implement upload functionality

        return this;
    }


}