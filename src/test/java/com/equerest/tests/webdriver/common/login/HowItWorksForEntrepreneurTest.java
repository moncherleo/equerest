package com.equerest.tests.webdriver.common.login;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.pages.common.header.EntrepreneurInfoPage;
import com.equerest.pages.common.registration.InvestorRegistrationContactsPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Julia Zubets on 1/8/2017.
 */
@Title("C34: Check link \"Как это работает?\" for \"Предприниматель\"")
public class HowItWorksForEntrepreneurTest extends BaseTest {
    @Test
    public void checkHowItWorksForEntrepreneurLink() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.navigateToLoginPage();

        EntrepreneurInfoPage entrepreneurInfoPage = loginPage.clickHowItWorksForEntrepreneurLink();
        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, entrepreneurInfoPage.url);
    }
}
