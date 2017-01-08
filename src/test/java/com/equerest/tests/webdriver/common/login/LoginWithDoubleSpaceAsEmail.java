package com.equerest.tests.webdriver.common.login;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 08.01.2017.
 */
@Title("C19: Log in with e-mail invalid data \"double space\"")
public class LoginWithDoubleSpaceAsEmail extends BaseTest{
    @Test
    public void testLoginUsingDoubleSpaceAsEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .fillInEmailField("  ")
                .clickLoginButton()
                .checkPresenceOfInvalidInputNotification();
    }
}
