package com.equerest.tests.webdriver.register;

import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Mykhaylo Dmytrenko on 25.09.2016.
 */
public class InvestorRegistration extends BaseTest{


    @Test
    public void ValidContactsTest(){
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        mainPage.navigateToInfoInvestorPage()
                .startInvest()
                .enterFields("sda", "+380", "tatata@tata", "Zaq123456")
                .chooseInvestments("role_1", "dealSumm_1", "dealQuantity_1");

        }

}

