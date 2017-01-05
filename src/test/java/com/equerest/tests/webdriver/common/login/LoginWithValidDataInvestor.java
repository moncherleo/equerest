package com.equerest.tests.webdriver.common.login;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.pages.common.entrepreneurpage.EntrepreneurProjectPage;
import com.equerest.pages.common.investorpage.InvestorProjectsCataloguePage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 05.01.2017.
 */
@Title("C15: Log in with valid data as \"Инвестор\"")
public class LoginWithValidDataInvestor extends BaseTest {
    @Test
    public void testLoginWithValidDataInvestor() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("eq-inv@mail.ru", "Qwer1234");
        loginPage.assertSuccessfulLoginPopUpMsg();

        InvestorProjectsCataloguePage investorPage = new InvestorProjectsCataloguePage(driver);
        investorPage.assertPageURL();
    }
}
