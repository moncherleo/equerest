package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;


import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.InArchivePage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Eduard Aliiev on 9/23/16;
 */

@RunWith(JUnitParamsRunner.class)
public class ArchiveProjectButtonTest extends BaseTest {
    private InArchivePage inArchivePage(String login, String password, String projectName) {
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.openLoginPage()
                .loginAs(login, password);

        return projectsPage.navigateToProjectPageViaMenuItem()
                .addedSelectedProject(projectName);
    }

    //added project-card at "В архив"
    @Test
    @FileParameters("src/test/resources/login_project_inArchiveButton_info.csv")
    public void inArchiveProjectPage(String login, String password, String projectName) {
        InArchivePage selectedProject = inArchivePage(login, password, projectName);

        Date date = new Date();
        String currentDate = new Timestamp(date.getTime()).toString();

        selectedProject.addedProjectInArchive()
                        .verifyProjectSavedAlertDisplayed();

    }
}
