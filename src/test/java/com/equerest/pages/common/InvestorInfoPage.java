package com.equerest.pages.common;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.common.registration.InvestorRegistrationContactsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mykhaylo Dmytrenko on 25.09.2016.
 */
public class InvestorInfoPage extends AbstractPage{
    private By startInvestButton = By.xpath("//*[@id='banner']//*[@href='/register#/investor']");

    public InvestorInfoPage(WebDriver driver) {
        super(driver);
    }

    public InvestorRegistrationContactsPage startInvest(){
        driver.findElement(startInvestButton).click();
        return new InvestorRegistrationContactsPage(driver);
    }
}
