package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;


import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.InArchivePage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 9/23/16;
 */
@Title("'Изменение статуса проекта на 'Архив'")
@Description("- Пользователь [login] должен предварительно войти в систему, используя [password]\n" +
        "- Проект [projectName] должен быть создан и иметь статус 'Модерация'")
@RunWith(JUnitParamsRunner.class)
public class ArchiveProjectButtonTest extends BaseTest {
    private InArchivePage inArchivePage(String login, String password, String projectName) {
        ProjectsPage projectsPage = homePage.openLoginPage()
                .loginAs(login, password);

        return projectsPage.navigateToProjectPageViaMenuItem()
                .addedSelectedProject(projectName);
    }

    //added project-card at "В архив"
    @Test
    @FileParameters("src/test/resources/login_project_inArchiveButton_info.csv")
    public void inArchiveProjectPage(String login, String password, String projectName) {
        InArchivePage selectedProject = inArchivePage(login, password, projectName);
        selectedProject
                .addedProjectInArchive()
                .verifyProjectSavedAlertDisplayed()
                .restoreProjectFromArchive(projectName);
    }
}
