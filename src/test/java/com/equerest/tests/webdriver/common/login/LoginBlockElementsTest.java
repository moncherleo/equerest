package com.equerest.tests.webdriver.common.login;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 03.01.2017.
 */
@Title("C13 Check that block \"Войти\" exists and contains elements")
@Description("All elements exist and all buttons and links are clickable, all text field can be filled with relevant data")
public class LoginBlockElementsTest extends BaseTest {
    @Test
    public void checkThatLoginBlockExists() {
        HomePage homePage = new HomePage(driver);
        homePage
                .navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .checkThatLoginBlockElementsExist()
                .checkThatLoginBlockElementsHaveRightTextValue()
                .checkThatLoginBlockElementsClickable()
                .checkThatTextCanBeEnteredInInputFields();
    }
}
