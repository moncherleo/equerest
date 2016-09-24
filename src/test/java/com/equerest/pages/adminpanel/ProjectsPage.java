package com.equerest.pages.adminpanel;

import com.equerest.pages.adminpanel.projectpage.EditProjectPage;
import com.equerest.pages.adminpanel.projectpage.InArchivePage;
import com.equerest.pages.adminpanel.projectpage.activesection.EditActiveProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by cherleo on 9/19/16.
 */
public class ProjectsPage extends BaseAdminPanelPage {
    //'Moderation' section "Модерация"
    private By projectFilterModerationButton = By.xpath("//*[@class='projects-list container ng-isolate-scope']//div[1]//*[text()='Модерация']");
    private By projectSearchField = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[2]/div[1]/div[2]/label/../*[@id='searchModerate']");

    //"Редактировать" button on 'Moderation' section
    private By editProjectButton = By.cssSelector(".btn.btn-primary");

    //added project-card at "В архив" button on 'Moderation' section
    private final By projectInArchiveButton = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[3]//*[text()[contains(.,'В архив')]]");


    //'Active' section "Активные"
    private final By projectFilterActiveButton = By.xpath("//*[@class='projects-list container ng-isolate-scope']//div[1]//*[text()='Активные']");
    private final By projectActiveSearchField = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[3]/div[1]/div[2]/label/../*[@id='searchActive']");

    //"Редактировать" button on 'Active' section
    private By editActiveProjectButton = By.cssSelector(".btn.btn-primary");


    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    //'Moderation' section "Модерация"
    public ProjectsPage selectModerationFilter(){
        driver.findElement(projectFilterModerationButton).click();
        return this;
    }

    public ProjectsPage searchProjectByName(String projectName){
        driver.findElement(projectSearchField).sendKeys(projectName);
        return this;
    }

    public EditProjectPage editSelectedProject(){
        driver.findElement(editProjectButton).click();
        return new EditProjectPage(driver);
    }

    //'Active' section "Активные"
    public ProjectsPage selectActiveFilter() {
        driver.findElement(projectFilterActiveButton).click();
        return this;
    }
    public ProjectsPage searchActiveProjectByName(String projectName){
        driver.findElement(projectActiveSearchField).sendKeys(projectName);
        return this;
    }
    public EditActiveProjectPage editSelectedActiveProject(){
        driver.findElement(editActiveProjectButton).click();
        return new EditActiveProjectPage(driver);
    }

    //'Moderation' section "Модерация"
    /** Method consolidate actions needed for typical flow of editing a project
     * @param projectName name of project that should be edited*/
    public EditProjectPage editProjectByName(String projectName){
        selectModerationFilter();
        searchProjectByName(projectName);
        return editSelectedProject();
    }
    //added project-card at "В архив" button on 'Moderation' section
    public InArchivePage addedSelectedProject(String projectName){
        selectModerationFilter();
        searchProjectByName(projectName);
        driver.findElement(projectInArchiveButton).click();
        return new InArchivePage(driver);
    }

    //'Active' section "Активные"
    //in the "Инвестиционный доход" section is edited values.
    public EditActiveProjectPage editActiveProjectByName(String projectName){
        selectActiveFilter();
        searchActiveProjectByName(projectName);
        return editSelectedActiveProject();
    }


}
