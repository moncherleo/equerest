package com.equerest.pages.helpers.adminpanel;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.common.HomePage;
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
        HomePage homePage = new HomePage(driver);
        ProjectsPage projectsPage = homePage.openLoginPage()
                .loginAs(login, password);

        return projectsPage.navigateToProjectPageViaMenuItem()
                .editProjectByName(projectName);
    }
}
