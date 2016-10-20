package com.equerest.pages.helpers.adminpanel;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.common.HomePage;
import com.equerest.tests.webdriver.BaseTest;

/**
 * Created by cherleo on 9/29/16.
 */
public class EditProjectHelper extends BaseTest{

//    public EditProjectHelper(WebDriver driver){
//        this.driver = driver;
//    }

    protected HomePage homePage1;
    public EditProjectHelper(HomePage homePage){
        this.homePage1 = homePage;
    }

    public EditProjectPage editProject(String login, String password, String projectName) {
        ProjectsPage projectsPage = homePage1.openLoginPage()
                .loginAs(login, password);

        return projectsPage.navigateToProjectPageViaMenuItem()
                .editProjectByName(projectName);
    }
}
