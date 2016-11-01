package com.equerest.pages.common.header;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.registration.InvestorRegistrationContactsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mykhaylo Dmytrenko on 25.09.2016.
 */
public class InvestorInfoPage extends HomePage {
    private By startInvestButton = By.xpath("//*[@id='banner']//*[@href='/registration#/investor']");

    public InvestorInfoPage(WebDriver driver) {
        super(driver);
    }

    public InvestorRegistrationContactsPage startInvest(){
        driver.findElement(startInvestButton).click();
        return new InvestorRegistrationContactsPage(driver);
    }
}
