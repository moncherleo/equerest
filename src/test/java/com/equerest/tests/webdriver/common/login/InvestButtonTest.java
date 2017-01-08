package com.equerest.tests.webdriver.common.login;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.pages.common.registration.InvestorRegistrationContactsPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Julia Zubets on 1/8/2017.
 */
@Title("C33: Check button \"Инвестировать\"")
public class InvestButtonTest extends BaseTest {
    @Test
    public void checkInvestButton(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.navigateToLoginPage();

        InvestorRegistrationContactsPage investorContactPage = loginPage.clickInvestButton();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, investorContactPage.url);
    }
}
