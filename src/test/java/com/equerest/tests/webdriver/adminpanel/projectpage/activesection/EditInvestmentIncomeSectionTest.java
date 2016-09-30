package com.equerest.tests.webdriver.adminpanel.projectpage.activesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.activesection.EditActiveProjectPage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Eduard Aliiev on 9/24/16;
 */
@RunWith(JUnitParamsRunner.class)
public class EditInvestmentIncomeSectionTest extends BaseTest {

    private EditActiveProjectPage editActiveProject(String login, String password, String projectName) {
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.openLoginPage()
                .loginAs(login, password);

        return projectsPage.navigateToProjectPageViaMenuItem()
                .editActiveProjectByName(projectName);
    }

    //"Инвестиционный доход" section is edited values.
    @Test
    @FileParameters("src/test/resources/login_project_ActiveSection_info.csv")
    public void uploadVideoInProject(String login, String password, String projectName) {
        EditActiveProjectPage selectedProject = editActiveProject(login, password, projectName);

        selectedProject.investmentIncomeInProject()
                .applyChanges()
                .verifyProjectSavedAlertDisplayedActiveSection();
    }


}
