package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard.KeyNumbers;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Oleg Nesterov on 28.09.2016;
 */

public class KeyNumbersRemoveNumbersTest extends BaseTest{


    @Test
    public void editKeyNumbersRemoveNumbers() {

        String LOGIN = "olegftzi@gmail.com";
        String PASSWORD = "Oleg1234";
        String PROJECT_NAME = "Интернет киоски \"Инетик\"";

        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.openLoginPage()
                .loginAs(LOGIN, PASSWORD);

        projectsPage.navigateToProjectPageViaMenuItem()
                .editProjectByName(PROJECT_NAME);

        KeyNumbers keyNumbers = new KeyNumbers(driver);
        keyNumbers.editFieldsButton()
                .removeNumbers();
    }
}