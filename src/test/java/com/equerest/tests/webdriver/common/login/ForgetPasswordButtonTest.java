package com.equerest.tests.webdriver.common.login;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.pages.common.registration.regainpassword.RegainPasswordPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 19.01.2017.
 */
@Title("C30:Check button \"Забыли пароль?\" ")
public class ForgetPasswordButtonTest extends BaseTest {
    @Test
    public void testForgetButton() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .clickForgotPasswordLink();

        RegainPasswordPage regainPasswordPage = new RegainPasswordPage(driver);
        regainPasswordPage.checkUrl();
    }
}
