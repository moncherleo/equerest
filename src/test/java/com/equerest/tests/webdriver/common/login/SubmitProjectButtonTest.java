package com.equerest.tests.webdriver.common.login;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.pages.common.registration.EntrepreneurContactsPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Julia Zubets on 1/6/2017.
 */
@Title("C32 Check button \"Подать проект\"")
public class SubmitProjectButtonTest extends BaseTest {
    @Test
    public void checkSubmitProjectButton() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.navigateToLoginPage();

        EntrepreneurContactsPage entrepreneurContactsPage = loginPage.clickSubmitProjectButton();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, entrepreneurContactsPage.url);
    }
}
