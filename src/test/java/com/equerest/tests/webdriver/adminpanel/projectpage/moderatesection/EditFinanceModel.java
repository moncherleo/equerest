package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by aBulgakoff on 9/21/16.
 */
public class EditFinanceModel extends BaseTest {

    private final static String LOGIN = "olegftzi@gmail.com";
    private final static String PASSWORD = "Oleg1234";
    private final static String PROJECT_NAME = "Интернет киоски \"Инетик\"";

    @Ignore
    @Test
    public void EditProjectOnDashboard() {
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.openLoginPage()
                .loginAs(LOGIN, PASSWORD);

        EditProjectPage selectedProject = projectsPage.navigateToProjectPageViaMenuItem()
                .editProjectByName(PROJECT_NAME);

        selectedProject.editFinanceModel()
                .uploadFinancePlan("")
                .applyChanges();
    }
}
