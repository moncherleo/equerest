package com.equerest.pages.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by cherleo on 9/19/16.
 */
public class ProjectsPage extends BaseAdminPanelPage {

    private By projectFilterModerationButton = By.xpath("//*[@class='projects-list container ng-isolate-scope']//div[1]//*[text()='Модерация']");
    private By projectSearchField = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[2]/div[1]/div[2]/label/../*[@id='searchModerate']");

    private By editProjectButton = By.cssSelector(".btn.btn-primary");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage selectModerationFilter(){
        driver.findElement(projectFilterModerationButton).click();
        return this;
    }

    public ProjectsPage searchProjectByName(String projectName){
        driver.findElement(projectSearchField).sendKeys(projectName);
        return this;
    }

    public SelectedProjectPage editSelectedProject(){
        driver.findElement(editProjectButton).click();
        return new SelectedProjectPage(driver);
    }

}
