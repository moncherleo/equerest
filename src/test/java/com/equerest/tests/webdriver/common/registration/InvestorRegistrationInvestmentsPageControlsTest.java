package com.equerest.tests.webdriver.common.registration;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.pages.common.main.TermsOfUsePage;
import com.equerest.pages.common.registration.InvestorRegistrationContactsPage;
import com.equerest.pages.common.registration.InvestorRegistrationInvestmentsPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 17.01.2017.
 */
@Title("C121: Проверка контролов на странице Регистрация инвестора/Инвестиции")
public class InvestorRegistrationInvestmentsPageControlsTest extends BaseTest {
    @Test
    public void testInvestmetsPageControls() {
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
                .checkThatRegistrationHeaderIsPresent()
                .checkThatContactsAndInvestmentsLabelsArePResent()
                .checkThatInvestmentsLabelIsActive()
                .checkExplanationText()
                .checkRadioButtonGroupLabelPresence(InvestorRegistrationInvestmentsPage.chooseRoleRadioButtonGroup)
                .checkThatChooseRoleGroupHasAllRadioButtons()
                .checkRadioButtonGroupLabelPresence(InvestorRegistrationInvestmentsPage.annualInvestmentSumRadioButtonGroup)
                .checkThatInvestmentSumGroupHasAllRadioButtons()
                .checkRadioButtonGroupLabelPresence(InvestorRegistrationInvestmentsPage.numberOfDealsPerYearRadioButtonGroup)
                .checkThatDealsGroupHasAllRadioButtons()
                .checkCheckBoxPresence()
                .checkRegistrationButtonPresence()
                .clickOnRulesAndConditions();
        TermsOfUsePage termsOfUsePage = new TermsOfUsePage(driver);
        termsOfUsePage
                .checkThatURLisCorrect();

    }
}
