package com.equerest.pages.adminpanel;

import com.equerest.pages.adminpanel.projectpage.activesection.EditActiveProjectPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.InActivePage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.InArchivePage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.ToModeratePage;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by cherleo on 9/19/16.
 */
public class ProjectsPage extends BaseAdminPanelPage {
    //'Moderation' section "Модерация"
    private By projectFilterModerationButton = By.xpath("//*[@class='projects-list container ng-isolate-scope']//div[1]//*[text()='Модерация']");
    private By projectModerateSearchField = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[2]/div[1]/div[2]/label/../*[@id='searchModerate']");
    private By projectSearchFieldForNewStatus = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[1]/div[1]/div[2]/*[@id='searchModerate']");
    //"Редактировать" button on 'Moderation' section
    private By editProjectButton = By.cssSelector(".btn.btn-primary");
    //"Активировать" button on 'Moderation' section
    private By activateProjectButton = By.cssSelector(".pull-right.activate-button.btn.btn-success");

    //added project-card at "В архив" button on 'Moderation' section
    private final By projectInArchiveButton = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[3]//*[text()[contains(.,'В архив')]]");
    private final By projectToModerationButton = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[3]//*[text()[contains(.,'На модерацию')]]");

    //'Active' section "Активные"
    private final By projectFilterActiveButton = By.xpath("//*[@class='projects-list container ng-isolate-scope']//div[1]//*[text()='Активные']");
    private final By projectActiveSearchField = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[3]/div[1]/div[2]/label/../*[@id='searchActive']");

    //"Редактировать" button on 'Active' section
    private By editActiveProjectButton = By.cssSelector(".btn.btn-primary");

    //New section "Новые"
    private final By projectFilterNewButton = By.xpath("//*[@class='projects-list container ng-isolate-scope']//div[1]//*[text()='Новые']");
    private By deleteProjectButton = By.xpath("//*[@id='wrapper']/main/div/div/div//*[text()[contains(.,'Удалить')]]");

    //'Archive' section "Архив"
    private final By projectArchiveButton = By.xpath("//*[@id='wrapper']/main//*[text()[contains(.,'Архив')]]");
    private final By projectArchiveToModerationButton = By.xpath("//*[@id='wrapper']/main//*[text()[contains(.,'На модерацию')]]");
    private By projectSearchFieldArchiveStatus = By.xpath("//*[@id='searchArchive']");


    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Go to Moderation section")
    //'Moderation' section "Модерация"
    public ProjectsPage selectModerationFilter(){
        driver.findElement(projectFilterModerationButton).click();
        return this;
    }

    @Step("Search project by name")
    public ProjectsPage searchProjectByName(String projectName){
        driver.findElement(projectModerateSearchField).sendKeys(projectName);
        return this;
    }

    public ProjectsPage searchProjectByNameForNewStatus(String projectName) {
        driver.findElement(projectSearchFieldForNewStatus).sendKeys(projectName);
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
    //added project-card at "Активировать" button on 'Moderation' section
    public ToModeratePage addedSelectedProjectToActive(String projectName){
        selectModerationFilter();
        searchProjectByName(projectName);
        driver.findElement(activateProjectButton).click();
        return new ToModeratePage(driver);
    }

    public ToModeratePage toModerateProject(String projectName){
        searchProjectByNameForNewStatus(projectName);
        driver.findElement(projectToModerationButton).click();
        return new ToModeratePage(driver);
    }


    //'Active' section "Активные"
    //in the "Инвестиционный доход" section is edited values.
    public EditActiveProjectPage editActiveProjectByName(String projectName){
        selectActiveFilter();
        searchActiveProjectByName(projectName);
        return editSelectedActiveProject();
    }

    //'New' section "Новые"
    public ToModeratePage selectNewFilter() {
        click(projectFilterNewButton);
        return new ToModeratePage(driver);
    }

    public ProjectsPage confirmDeletionAlert(){
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.sendKeys("1");
        confirmationAlert.accept();
        return this;
    }

    public ProjectsPage deleteProject(){
        driver.findElement(deleteProjectButton).click();
        return this;
    }

    //'Archive' section "Архив"
    public ProjectsPage restoreProjectFromArchive(String projectName){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='wrapper']/main//*[text()[contains(.,'Поиск проекта')]]")).isEnabled());
        driver.findElement(projectArchiveButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='wrapper']/main//*[text()[contains(.,'Архив ')]]")).isEnabled());
        driver.findElement(projectSearchFieldArchiveStatus).sendKeys(projectName);
        driver.findElement(projectArchiveToModerationButton).click();
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@id='toast-container']//*[text()[contains(.,'Проект обновлен.')]]")).isEnabled());
    return this;
    }
}
