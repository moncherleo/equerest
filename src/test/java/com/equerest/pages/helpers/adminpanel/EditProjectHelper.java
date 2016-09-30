package com.equerest.pages.helpers.adminpanel;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.common.MainPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by cherleo on 9/29/16.
 */
public class EditProjectHelper {
    private WebDriver driver;

    public EditProjectHelper(WebDriver driver){
        this.driver = driver;
    }

    public EditProjectPage editProject(String login, String password, String projectName) {
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.openLoginPage()
                .loginAs(login, password);

        return projectsPage.navigateToProjectPageViaMenuItem()
                .editProjectByName(projectName);
    }
}
