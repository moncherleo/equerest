package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard.KeyNumbers;
import com.equerest.pages.helpers.adminpanel.EditProjectHelper;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Oleg Nesterov on 28.09.2016;
 */
@Title("Редактирвание поля \"Ключевые цифры\"")
public class KeyNumbersRemoveNumbersTest extends BaseTest{


    @Test
    @Title("Удаление ключевых цифр")
    public void editKeyNumbersRemoveNumbers() {

        String LOGIN = "olegftzi@gmail.com";
        String PASSWORD = "Oleg1234";
        String PROJECT_NAME = "Интернет киоски \"Инетик\"";

        EditProjectHelper editProjectHelper = new EditProjectHelper(driver);
        editProjectHelper.editProject(LOGIN, PASSWORD, PROJECT_NAME);

        KeyNumbers keyNumbers = new KeyNumbers(driver);
        keyNumbers.editFieldsButton()
                .removeNumbers();
    }
}