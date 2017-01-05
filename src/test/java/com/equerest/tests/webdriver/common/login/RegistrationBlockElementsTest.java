package com.equerest.tests.webdriver.common.login;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Julia Zubets on 1/5/2017.
 */
@Title("C31 Check that block \"Регистрация\" exists and contains elements")
@Description("All elements exist and all buttons and links are clickable")
public class RegistrationBlockElementsTest extends BaseTest {
    @Test
    public void checkThatRegistrationBlockExist() {
        HomePage homePage = new HomePage(driver);
        homePage
                .navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .checkRegistrationBlockExist()
                .checkRegistrationBlockTextValues()
                .checkRegistrationBlockClickable();

    }
}
