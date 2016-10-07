package com.equerest.tests.webdriver.delete;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Description;

import static com.sun.deploy.ui.CacheUpdateProgressDialog.dismiss;

/**
 * Created by Oleg Nesterov on 07.10.2016;
 */
@RunWith(JUnitParamsRunner.class)
public class DeleteProjectTest extends BaseTest {

    private By deleteProjectButton = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[3]/button[1]");
    private ProjectsPage openProjectsList(String login, String password, String projectName) {
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.openLoginPage()
                .loginAs(login, password);

        return projectsPage.navigateToProjectPageViaMenuItem();
    }

    //added project-card at "На модерацию"
    @Test
    @Description("Изменение статуса проекта на \"Модерация\"")
    @FileParameters("src/test/resources/login_project_toModerateButton_info.csv")
    public void deleteProject(String login, String password, String projectName) {

        ProjectsPage selectedProject = openProjectsList(login, password, projectName)
                .selectNewFilter()
                .searchProjectByNameForNewStatus(projectName);
        driver.findElement(deleteProjectButton).click();

        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.sendKeys("1");
        confirmationAlert.dismiss();
    }
}
