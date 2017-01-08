package com.equerest.tests.webdriver.common.login;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.pages.common.header.EntrepreneurInfoPage;
import com.equerest.pages.common.header.InvestorInfoPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Julia Zubets on 1/8/2017.
 */
@Title("Check link \"Как это работает?\" for \"Инвестор\"")
public class HowItWorksForInvestorTest extends BaseTest {
    @Test
    public void checkHowItWorksForInvestorLink() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.navigateToLoginPage();

        InvestorInfoPage investorInfoPage = loginPage.clickHowItWorksForInvestorLink();
        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, investorInfoPage.url);
    }
}
