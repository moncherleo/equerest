package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard.KeyNumbersPage;
import com.equerest.pages.helpers.adminpanel.EditProjectHelper;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Oleg Nesterov on 28.09.2016;
 */
@RunWith(JUnitParamsRunner.class)
@Title("Редактирвание поля \"Ключевые цифры\"")
public class KeyNumbersAddNumbersTest extends BaseTest{

    @Test
    @Title("Добавление ключевых цифр")
    @FileParameters("src/test/resources/key_numbers_info.csv")
    public void editKeyNumbersAddNumbers(String number, String symbol, String description) {

        String LOGIN = "olegftzi@gmail.com";
        String PASSWORD = "Oleg1234";
        String PROJECT_NAME = "Интернет киоски \"Инетик\"";

        EditProjectHelper editProjectHelper = new EditProjectHelper(homePage);
        editProjectHelper.editProject(LOGIN, PASSWORD, PROJECT_NAME);

        KeyNumbersPage keyNumbers = new KeyNumbersPage(driver);
        keyNumbers.addNumbersButton()
                .editFieldsButton()
                .fillNumber(number)
                .fillSybmol(symbol)
                .fillDescription(description)
                .applyChenges()
                .alertResultMessage()
                .assertKeyNumbersAppears(symbol);
    }
}