package com.equerest.tests.webdriver.adminpanel.projectpage.projectsections;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.EditProjectPage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by cherleo on 9/19/16.
 */
@RunWith(JUnitParamsRunner.class)
public class EditProjectDescription extends BaseTest {

    private EditProjectPage editProject(String login, String password, String projectName) {
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.openLoginPage()
                .loginAs(login, password);

        return projectsPage.navigateToProjectPageViaMenuItem()
                .editProjectByName(projectName);
    }

    @Test
    @FileParameters("src/test/resources/login_project_info.csv")
    public void editProjectDescriptionPositive(String login, String password, String projectName) {
        EditProjectPage selectedProject = editProject(login, password, projectName);

        selectedProject.editProjectDescription()
                .editText("Новый проект")
                .applyChanges();

    }

    @Test
    @FileParameters("src/test/resources/login_project_info.csv")
    public void editProjectDescriptionDeclineChanges(String login, String password, String projectName) {
        EditProjectPage selectedProject = editProject(login, password, projectName);

        selectedProject.editProjectDescription()
                .editText("Временное описание")
                .discardChanges();
    }



}
