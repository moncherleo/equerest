package com.equerest.tests.webdriver.common.login;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 05.01.2017.
 */
@Title("C17: Log in with valid data, user does not exist in system")
public class LoginNotExistingUser extends BaseTest{
    @Test
    public void testLoginNotExistingUser(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("eq-notexist@mail.ru", "Qwer12");
        loginPage.checkWrongEmailOrPasswordErrorMessage();
    }
}
