package com.equerest.tests.webdriver.adminpanel.projectpage.projectsections;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.EditProjectPage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by cherleo on 9/19/16.
 */
@RunWith(JUnitParamsRunner.class)
public class EditProjectDescriptionTest extends BaseTest {

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

        Date date= new java.util.Date();
        String currentDate = new Timestamp(date.getTime()).toString();

        selectedProject.editProjectDescription()
                .editText(currentDate)
                .applyChanges()
                .verifyEditWindowNotPresent()
                .verifyProjectSavedAlertDisplayed()
                .assertProjectDescriptionUpdate(currentDate);

    }

    @Test
    @FileParameters("src/test/resources/login_project_info.csv")
    public void editProjectDescriptionDeclineChanges(String login, String password, String projectName) {
        EditProjectPage selectedProject = editProject(login, password, projectName);

        selectedProject.editProjectDescription()
                .editText("Временное описание")
                .discardChanges();
    }

    //upload "Видео" into the project-card
    @Test
    @FileParameters("src/test/java/com/eduardaliiev/app/equerest/resources/login_project_info.csv")
    public void uploadVideoInProject(String login, String password, String projectName) {
        EditProjectPage selectedProject = editProject(login, password, projectName);

        Date date = new Date();
        String currentDate = new Timestamp(date.getTime()).toString();

        selectedProject.uploadVideo()
                //.applyChanges()
                .verifyEditWindowNotPresent()
                .verifyProjectSavedAlertDisplayed();
    }


}
