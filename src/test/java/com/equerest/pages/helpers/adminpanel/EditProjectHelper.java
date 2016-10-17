package com.equerest.pages.helpers.adminpanel;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.common.HomePage;
import com.equerest.tests.webdriver.BaseTest;
import org.openqa.selenium.WebDriver;

/**
 * Created by cherleo on 9/29/16.
 */
public class EditProjectHelper extends BaseTest{

    public EditProjectHelper(WebDriver driver){
        this.driver = driver;
    }

    public EditProjectHelper(){
    }

    public EditProjectPage editProject(String login, String password, String projectName) {
        ProjectsPage projectsPage = homePage.openLoginPage()
                .loginAs(login, password);

        return projectsPage.navigateToProjectPageViaMenuItem()
                .editProjectByName(projectName);
    }
}
