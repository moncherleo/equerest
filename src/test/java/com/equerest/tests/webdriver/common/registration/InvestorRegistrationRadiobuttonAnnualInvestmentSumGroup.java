package com.equerest.tests.webdriver.common.registration;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.pages.common.registration.InvestorRegistrationInvestmentsPage;
import com.equerest.pages.common.registration.InvestorRegistrationContactsPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 10.01.2017.
 */

@Title("C1: Проверка работы радиобаттонов в группе \"Сумма инвестиций в год\".")
public class InvestorRegistrationRadiobuttonAnnualInvestmentSumGroup extends BaseTest {
    @Test
    public void testAnnualInvestmentSumGroupRadiobuttons() {
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
                .selectRadioButton(InvestorRegistrationInvestmentsPage.lessThan50InvestmentInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.annualInvestmentSumRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled()
                .selectRadioButton(InvestorRegistrationInvestmentsPage.from50to100InvestmentInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.annualInvestmentSumRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled()
                .selectRadioButton(InvestorRegistrationInvestmentsPage.from100to500InvestmentInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.annualInvestmentSumRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled()
                .selectRadioButton(InvestorRegistrationInvestmentsPage.biggerThan500InvestmentInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.annualInvestmentSumRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled()
                .selectRadioButton(InvestorRegistrationInvestmentsPage.noneOfAboveInvestmentInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.annualInvestmentSumRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled();
    }
}
