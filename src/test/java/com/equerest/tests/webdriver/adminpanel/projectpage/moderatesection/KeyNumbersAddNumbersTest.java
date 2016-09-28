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
@RunWith(JUnitParamsRunner.class)
public class KeyNumbersAddNumbersTest extends BaseTest{
    private final static String LOGIN = "olegftzi@gmail.com";
    private final static String PASSWORD = "Oleg1234";
    private final static String PROJECT_NAME = "Интернет киоски \"Инетик\"";

    @Test
    @FileParameters("src/test/resources/key_numbers_info.csv")
    public void editKeyNumbersAddNumbers(String number, String symbol, String description) {
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage projectsPage = mainPage.openLoginPage()
                .loginAs(LOGIN, PASSWORD);

        EditProjectPage selectedProject = projectsPage.navigateToProjectPageViaMenuItem()
                .editProjectByName(PROJECT_NAME);

        KeyNumbers keyNumbers = new KeyNumbers(driver);
        keyNumbers.addNumbersButton()
                .editFieldsButton()
                .fillNumber(number)
                .fillSybmol(symbol)
                .fillDescription(description)
                .applyChenges();
    }
}