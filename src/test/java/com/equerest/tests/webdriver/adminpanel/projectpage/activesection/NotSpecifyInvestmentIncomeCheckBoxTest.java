package com.equerest.tests.webdriver.adminpanel.projectpage.activesection;

/**
 * Created by Julia Zubets on 1/13/2017.
 */

import com.equerest.pages.adminpanel.projectpage.activesection.EditActiveProjectPage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import static com.equerest.pages.adminpanel.projectpage.activesection.editprojectcard.EditInvestmentIncomeSection.investmentIncomeFourYearsDisabled;
import static com.equerest.pages.adminpanel.projectpage.activesection.editprojectcard.EditInvestmentIncomeSection.investmentIncomeTwoYearsDisabled;


@Title("C58: Корректность работы чек бокса \"Не указывать инвестиционный доход\"")
@Description("Пользователь[login]должен предварительно войти в систему, используя[password]")
@RunWith(JUnitParamsRunner.class)
public class NotSpecifyInvestmentIncomeCheckBoxTest extends BaseTest {

    @Test
    @FileParameters("src/test/resources/investment_income_cancel_button.csv")
    public void notSpecifyInvestmentIncomeCheckBoxTest(String login, String password) {
        homePage.openLoginPage()
                .loginAs(login, password);
        EditActiveProjectPage selectedProject = new EditActiveProjectPage(driver);
        selectedProject.clickOnInvestmentIncome()
                .editInvestmentIncome("40", "96")
                .setNotSpecifyInvestmentIncomeCheckBox()
                .checkFieldDisabled(investmentIncomeTwoYearsDisabled)
                .checkFieldDisabled(investmentIncomeFourYearsDisabled)
                .applyChangesForCheckedCheckBox()
                .verifyProjectSavedAlertDisplayedActiveSection()
                .checkElementAbsent(selectedProject.investmentIncomeTwoYears)
                .checkElementAbsent(selectedProject.investmentIncomeFourYears);
    }
}
