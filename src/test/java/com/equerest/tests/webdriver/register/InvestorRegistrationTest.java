package com.equerest.tests.webdriver.register;

import com.equerest.pages.common.HomePage;
import com.equerest.tests.webdriver.BaseTest;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Mykhaylo Dmytrenko on 25.09.2016.
 */
@RunWith(JUnitParamsRunner.class)
public class InvestorRegistrationTest extends BaseTest{

    @Test
    @FileParameters("src/test/resources/valid_contacts.csv")
    public void ValidContactsTest(String fio, String telephone, String email, String password){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToInfoInvestorPage()
                .startInvest()
                .fillForm(fio, telephone, email, password)
                .goToInvestments();
    }

    @Test
    @FileParameters("src/test/resources/investment_radiobuttons_pairwise.csv")
    public void ValidInvestmentsTest(String investorRoleID, String investplanID, String dealquanttityID){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToInfoInvestorPage()
                .startInvest()
                .fillForm("Name Surname", "+380123451212", "h194398@mvrht.com", "!QAZ@WSX")
                .goToInvestments()
                .fillForm(investorRoleID, investplanID, dealquanttityID)
                .checkboxAgree()
                .finishRegistration();
        }

}

