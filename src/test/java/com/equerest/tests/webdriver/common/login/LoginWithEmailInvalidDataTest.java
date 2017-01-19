package com.equerest.tests.webdriver.common.login;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 19.01.2017.
 */
public class LoginWithEmailInvalidDataTest extends BaseTest {
    @Title("C20: Log in with e-mail invalid data \"q@\" ")
    @Test
    public void testLoginUsingInvalidData1() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .fillInEmailField("q@")
                .clickLoginButton()
                .checkPresenceOfInvalidInputNotification();
    }
    @Title("C21: Log in with e-mail invalid data \"q@q\" ")
    @Test
    public void testLoginUsingInvalidData2() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .fillInEmailField("q@q")
                .clickLoginButton()
                .checkPresenceOfInvalidInputNotification();
    }
    @Title("C22: Log in with e-mail invalid data \"@mail.ru\" ")
    @Test
    public void testLoginUsingInvalidData3() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .fillInEmailField("@mail.ru")
                .clickLoginButton()
                .checkPresenceOfInvalidInputNotification();
    }
    @Title("C23: Log in with e-mail invalid data \".mail@mail.ru\" ")
    @Test
    public void testLoginUsingInvalidData4() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .fillInEmailField(".mail@mail.ru")
                .clickLoginButton()
                .checkPresenceOfInvalidInputNotification();
    }

}

