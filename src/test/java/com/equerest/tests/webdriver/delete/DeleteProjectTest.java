package com.equerest.tests.webdriver.delete;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
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
public class DeleteProjectTest extends BaseTest {

    private By deleteProjectButton = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[3]/button[1]");
    String login = "olegftzi@gmail.com";
    String password = "Oleg1234";
    String projectName = "Тестовый проект Удаление";

    private ProjectsPage openProjectsList() {

        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.openLoginPage()
                .loginAs(login, password);

        return projectsPage.navigateToProjectPageViaMenuItem();
    }

    @Test
    @Description("Удаление проекта из фильтра Модерация")
    public void deleteProject() {

        ProjectsPage selectedProject = openProjectsList()
                .selectModerationFilter()
                .searchProjectByName(projectName);
        driver.findElement(deleteProjectButton).click();

        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.sendKeys("1");
        confirmationAlert.accept();
    }
}
