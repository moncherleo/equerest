package com.equerest.tests.webdriver.register;

import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;

import junitparams.FileParameters;
import org.junit.Test;

/**
 * Created by Mykhaylo Dmytrenko on 25.09.2016.
 */
public class InvestorRegistrationTest extends BaseTest{


    @Test
    /*@FileParameters("src/test/resources/")*/
    public void ValidContactsTest(String fio, String telephone, String email, String password){
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        mainPage.navigateToInfoInvestorPage()
                .startInvest()
                .fillForm(fio, telephone, email, password)
                .goToInvestments();
    }

    @Test
    /*@FileParameters("src/test/resources/")*/
    public void ValidInvestmentsTest(String fio, String telephone, String email, String password, String investorRoleID, String investplanID, String dealquanttityID){
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        mainPage.navigateToInfoInvestorPage()
                .startInvest()
                .fillForm(fio, telephone, email, password)
                .goToInvestments()
                .fillForm(investorRoleID, investplanID, dealquanttityID)
                .checkboxAgree()
                .finishRegistration();
        }

}

