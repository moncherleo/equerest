package com.equerest.tests.webdriver.adminpanel.projectpage.projectsections;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.SelectedProjectPage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;

/**
 * Created by aBulgakoff on 9/21/16.
 */
public class EditProjectDescriptionDeclineChanges extends BaseTest {

    private final static String LOGIN = "olegftzi@gmail.com";
    private final static String PASSWORD = "Oleg1234";
    private final static String PROJECT_NAME = "Интернет киоски \"Инетик\"";

    @Test
    public void EditProjectOnDashboard() {
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.openLoginPage()
                .loginAs(LOGIN, PASSWORD);

        SelectedProjectPage selectedProject = projectsPage.navigateToProjectPageViaMenuItem()
                .editProjectByName(PROJECT_NAME);

        selectedProject.editProjectDescription()
                .editText("Временное описание")
                .discardChanges();
    }
}
