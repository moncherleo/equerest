package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;

/**
 * Created by Oleg Nesterov on 28.09.2016;
 */
public class EditFieldKeyNumbersAddNumbersTest extends BaseTest{
    private final static String LOGIN = "olegftzi@gmail.com";
    private final static String PASSWORD = "Oleg1234";
    private final static String PROJECT_NAME = "Интернет киоски \"Инетик\"";

    @Test
    public void editKeyNumbersAddNumbers() {
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.openLoginPage()
                .loginAs(LOGIN, PASSWORD);

        EditProjectPage selectedProject = projectsPage.navigateToProjectPageViaMenuItem()
                .editProjectByName(PROJECT_NAME);
    }
}