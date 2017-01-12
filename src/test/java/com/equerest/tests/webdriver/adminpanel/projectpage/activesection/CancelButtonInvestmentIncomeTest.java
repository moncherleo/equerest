package com.equerest.tests.webdriver.adminpanel.projectpage.activesection;

import com.equerest.pages.adminpanel.projectpage.activesection.EditActiveProjectPage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Julia Zubets on 1/11/2017.
 */
@Title("C57: Корректность работы кнопки [Отмена]")
@Description("Пользователь[login]должен предварительно войти в систему, используя[password]")
@RunWith(JUnitParamsRunner.class)
public class CancelButtonInvestmentIncomeTest extends BaseTest{

    @Test
    @FileParameters("src/test/resources/investment_income_cansel_button.csv")
    public void checkCancelButtonInvestmentIncome(String login, String password) throws InterruptedException {
    homePage.openLoginPage()
            .loginAs(login, password);
        EditActiveProjectPage selectedProject = new EditActiveProjectPage(driver);
        selectedProject.clickOnInvestmentIncome()
                .editInvestmentIncome("30", "200")
                .applyChanges()
                .verifyProjectSavedAlertDisplayedActiveSection();
        Thread.sleep(6000);

        selectedProject.clickOnInvestmentIncome()
                .editInvestmentIncome("40", "96")
                .discardChanges()
                .chekDataAfterDiscard();
        Assert.assertFalse(selectedProject.isAlertPresent());
    }
}
