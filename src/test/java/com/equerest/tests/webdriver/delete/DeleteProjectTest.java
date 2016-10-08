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

    private ProjectsPage openProjectsList() {
        String login = "olegftzi@gmail.com";
        String password = "Oleg1234";
        String projectName = "Тестовый проект Удаление";
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.openLoginPage()
                .loginAs(login, password);

        return projectsPage.navigateToProjectPageViaMenuItem();
    }

    @Test
    @Description("Удаление проекта из фильтра Модерация")
    @FileParameters("src/test/resources/delete_project.csv")
    public void deleteProject(String project) {

        ProjectsPage selectedProject = openProjectsList()
                .selectNewFilter()
                .searchProjectByNameForNewStatus(project)
                //.selectModerationFilter()
                //.searchProjectByName(project);
                .deleteProject()
                .confirmDeletionAlert();
    }
}
