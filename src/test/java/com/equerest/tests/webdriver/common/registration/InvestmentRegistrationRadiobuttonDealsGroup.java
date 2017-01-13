package com.equerest.tests.webdriver.common.registration;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.pages.common.registration.InvestorRegistrationContactsPage;
import com.equerest.pages.common.registration.InvestorRegistrationInvestmentsPage;
import com.equerest.pages.helpers.adminpanel.DeleteNewUserHelper;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.concurrent.TimeUnit;

/**
 * Created by Vladyslav Vlasov on 11.01.2017.
 */
@Title("C2: Проверка работы радиобаттонов в группе \"Количество сделок в год\".")
public class InvestmentRegistrationRadiobuttonDealsGroup extends BaseTest {
    @Test
    public void testDealsRadiobuttonGroup() {
        HomePage homePage = new HomePage(driver);
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickInvestButton();

        InvestorRegistrationContactsPage contactsPage = new InvestorRegistrationContactsPage(driver);
        contactsPage
                .fillForm("Test Test Test", "+380975678435", "tester@yahoo.com", "Qwerty123")
                .goToInvestments();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        InvestorRegistrationInvestmentsPage investmentsPage = PageFactory.initElements(driver, InvestorRegistrationInvestmentsPage.class);
        investmentsPage
                .selectRadioButton(InvestorRegistrationInvestmentsPage.intermediaryRoleInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.chooseRoleRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled()
                .selectRadioButton(InvestorRegistrationInvestmentsPage.lessThan50InvestmentInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.annualInvestmentSumRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled()
                .selectRadioButton(InvestorRegistrationInvestmentsPage.from1to3DealQtyInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.numberOfDealsPerYearRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled()
                .selectRadioButton(InvestorRegistrationInvestmentsPage.lessThan5DealQtyInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.numberOfDealsPerYearRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled()
                .selectRadioButton(InvestorRegistrationInvestmentsPage.biggerThan5DealQtyInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.numberOfDealsPerYearRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled()
                .selectRadioButton(InvestorRegistrationInvestmentsPage.noneOfAboveDealQtyInput)
                .checkThatOnlyOneElementOfTheGroupIsSelected(InvestorRegistrationInvestmentsPage.numberOfDealsPerYearRadioButtonGroup)
                .checkThatFinishRegistrationButtonIsDisabled()
                .checkboxAgree()
                .checkThatFinishRegistrationButtonIsEnabled()
                .finishRegistration()
                .pressOk();

        ///Delete created user
        DeleteNewUserHelper deleteNewUserHelper = new DeleteNewUserHelper(driver);
        deleteNewUserHelper
                .deleteNewCreatedUserWithParams("tester@yahoo.com");
    }
}
