package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.common.HomePage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by aBulgakoff on 9/21/16.
 */
public class EditFinanceModelTest extends BaseTest {

    private final static String LOGIN = "olegftzi@gmail.com";
    private final static String PASSWORD = "Oleg1234";
    private final static String PROJECT_NAME = "Интернет киоски \"Инетик\"";

    @Ignore
    @Test
    public void EditProjectOnDashboard() {
        HomePage homePage = new HomePage(driver);
        ProjectsPage projectsPage = homePage.openLoginPage()
                .loginAs(LOGIN, PASSWORD);

        EditProjectPage selectedProject = projectsPage.navigateToProjectPageViaMenuItem()
                .editProjectByName(PROJECT_NAME);

        selectedProject.editFinanceModel()
                .uploadFinancePlan("")
                .applyChanges();
    }
}
