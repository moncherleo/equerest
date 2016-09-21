package com.equerest.tests.webdriver.dashboard;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.SelectedProjectPage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.BaseTest;
import org.junit.Test;

/**
 * Created by cherleo on 9/19/16.
 */
public class EditProjectOnDashboard1 extends BaseTest {

    private final static String LOGIN = "olegftzi@gmail.com";
    private final static String PASSWORD = "Oleg1234";
    private final static String PROJECT_NAME = "Интернет киоски \"Инетик\"";

    protected SelectedProjectPage selectedProject;

    @Test
    public void EditProjectOnDashboard() {
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.open()
                .navigateToLoginPage()
                .loginAs(LOGIN, PASSWORD);

        selectedProject = projectsPage.navigateToProjectPageViaMenuItem()
                .selectModerationFilter()
                .searchProjectByName(PROJECT_NAME)
                .editSelectedProject();

        //TODO: move to separate test
        selectedProject.editProjectDescription()
                .editText("Промежуточное описание")
                .discardChanges()
                .editProjectDescription()
                .editText("Новый проект")
                .applyChanges();

    }

}
