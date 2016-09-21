package com.equerest.pages.adminpanel;

import com.equerest.pages.adminpanel.projectsections.DescriptionSection;
import com.equerest.pages.adminpanel.projectsections.FinanceModelSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by aBulgakoff on 9/20/16.
 */
public class SelectedProjectPage extends ProjectsPage {
    protected Actions actions;

    private final String commonSmallEditButton = "//button[@class='edit-btn']";

    /*project's editing finalization buttons*/
    protected final By saveProjectButton = By.cssSelector(".btn.btn-success");
    protected final By cancelProjectEditButton = By.cssSelector(".btn.btn-primary");
    protected final By moveProjectToArchive = By.cssSelector(".btn.btn-warning");

    /*project sections (access level needed for page scroll)*/
    protected final By addNumbersLink = By.xpath("html/body/div[1]/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/h3/span/a");
    protected final By descriptionEditButton = By.xpath("//*[@id='anchor-full_description']" + commonSmallEditButton);
    protected final By achievementsEditButton = By.xpath("//*[@id='anchor-achievements']" + commonSmallEditButton);
    protected final By financeModelEditButton = By.xpath("//*[@id='anchor-fmodel']" + commonSmallEditButton);

    /*left bar's buttons*/
    private final By financeModelEditThruLeftBar = By.xpath("//ul[contains(concat(' ', @class, ' '), ' left-nav ')]//a[normalize-space(.)='Финансовая модель']");

    public SelectedProjectPage(WebDriver driver) {
        super(driver);
        if (actions == null){
            actions = new Actions(driver);
        }
    }

    public DescriptionSection editProjectDescription() {
        driver.findElement(descriptionEditButton).click();
        return new DescriptionSection(driver, this);
    }

    public FinanceModelSection editFinanceModel(){
        /*move to the higher element for correct displaying of needed one*/
        actions.moveToElement(driver.findElement(achievementsEditButton)).perform();
        driver.findElement(financeModelEditButton).click();
        return new FinanceModelSection(driver, this);
    }





}