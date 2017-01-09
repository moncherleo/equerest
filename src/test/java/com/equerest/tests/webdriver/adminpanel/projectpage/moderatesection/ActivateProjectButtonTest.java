package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.InActivePage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.InArchivePage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Julia Zubets on 1/9/2017.
 */
@Title("C53: Изменение статуса проекта на 'Активные'")
@Description("- Пользователь [login] должен предварительно войти в систему, используя [password]\n" +
        "- Проект [projectName] должен быть создан и иметь статус 'Модерация'")
@RunWith(JUnitParamsRunner.class)
public class ActivateProjectButtonTest extends BaseTest {

    @Test
    @FileParameters("src/test/resources/login_project_toActivateButton_info.csv")
    public void inActiveProjectPage(String login, String password, String projectName){
        homePage.openLoginPage()
                .loginAs(login, password)
                .navigateToProjectPageViaMenuItem()
                .addedSelectedProjectToActive(projectName)
                .verifyAlertUpdateProjectDisplayed();

        InActivePage page = new InActivePage(driver);
        page.restoreProjectFromActive(projectName);
    }
}
