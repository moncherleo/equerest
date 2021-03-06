package com.equerest.tests.webdriver.common.registration;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.pages.common.registration.InvestorRegistrationContactsPage;
import com.equerest.pages.common.registration.InvestorRegistrationInvestmentsPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 11.01.2017.
 */
@Title("C122: Проверка работы радиобаттонов в группе \"Выберите роль\"")
public class InvestorRegistrationRadiobuttonRoleGroup extends BaseTest {
    @Test
    public void testRoleGroupRadiobuttons() {
        HomePage homePage = new HomePage(driver);
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickInvestButton();

        InvestorRegistrationContactsPage contactsPage = new InvestorRegistrationContactsPage(driver);
        contactsPage
                .fillForm("Test Test Test", "+380975678435", "tester@yahoo.com", "Qwerty123")
                .goToInvestments();

        InvestorRegistrationInvestmentsPage investmentsPage = PageFactory.initElements(driver, InvestorRegistrationInvestmentsPage.class);
        investmentsPage
                .selectRadioButton(InvestorRegistrationInvestmentsPage.intermediaryRoleInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.chooseRoleRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled()
                .selectRadioButton(InvestorRegistrationInvestmentsPage.privateInvestorRoleInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.chooseRoleRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled()
                .selectRadioButton(InvestorRegistrationInvestmentsPage.ventureFundRoleInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.chooseRoleRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled();
    }
}
