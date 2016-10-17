package com.equerest.tests.webdriver.delete;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.common.HomePage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.yandex.qatools.allure.annotations.Description;


/**
 * Created by Oleg Nesterov on 07.10.2016;
 */
@RunWith(JUnitParamsRunner.class)
public class DeleteProjectTest extends BaseTest {

    public ProjectsPage openProjectsList() {
        String login = "olegftzi@gmail.com";
        String password = "Oleg1234";
        String projectName = "Тестовый проект Удаление";
        HomePage homePage = new HomePage(driver);
        ProjectsPage projectsPage = homePage.openLoginPage()
                .loginAs(login, password);

        return projectsPage.navigateToProjectPageViaMenuItem();
    }

    @Test
    @Description("Удаление проекта из фильтра Модерация")
    @FileParameters("src/test/resources/delete_project.csv")
    public void deleteProjectTest(String project) {

        ProjectsPage selectedProject = openProjectsList()
                .selectNewFilter()
                .searchProjectByNameForNewStatus(project)
                //.selectModerationFilter()
                //.searchProjectByName(project);
                .deleteProject()
                .confirmDeletionAlert();
    }
}
