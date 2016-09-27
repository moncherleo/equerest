package com.equerest.tests.webdriver.register;

import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;

import org.junit.Test;

/**
 * Created by Mykhaylo Dmytrenko on 25.09.2016.
 */
public class InvestorRegistrationTest extends BaseTest{


    @Test
    public void ValidContactsTest(){
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        mainPage.navigateToInfoInvestorPage()
                .startInvest()
                .fillForm("sda", "+380", "tatata@tata", "Zaq123456")
                .goToInvestments()
                .fillForm("role_1", "dealSumm_1", "dealQuantity_1")
                .checkboxAgree()
                .finishRegistration();
        }

}

