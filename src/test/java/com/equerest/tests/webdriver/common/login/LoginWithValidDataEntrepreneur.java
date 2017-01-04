package com.equerest.tests.webdriver.common.login;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.pages.common.entrepreneurpage.EntrepreneurProjectPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.concurrent.TimeUnit;

/**
 * Created by Vladyslav Vlasov on 04.01.2017.
 */
@Title("C14. Log in with valid data as \"Предприниматель\"")
public class LoginWithValidDataEntrepreneur extends BaseTest {
    @Test
    public void testLoginWithValidDataEntrepreneur() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("eq-pred@mail.ru", "Qwer1234");
        loginPage.assertSuccessfulLoginPopUpMsg();

        EntrepreneurProjectPage projectPage = new EntrepreneurProjectPage(driver);
        projectPage
                .assertPageURL()
                .assertNameTitle("Предприниматель");
    }
}
