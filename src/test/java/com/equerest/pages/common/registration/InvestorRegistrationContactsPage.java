package com.equerest.pages.common.registration;

import com.equerest.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mykhaylo Dmytrenko on 26.09.2016.
 */
public class InvestorRegistrationContactsPage extends AbstractPage{
    private static final By FIO_FIELD = By.xpath("//*[@id='fio']");
    private static final By TELEPHONE_FIELD = By.xpath("//*[@id='tel']");
    private static final By EMAIL_FIELD = By.xpath("//*[@id='mail']");
    private static final By PASSWORD_FIELD = By.xpath("//*[@id='pass']");
    private By goToInvestmentsButton = By.cssSelector(".button.button-blue.button-next");

    public InvestorRegistrationContactsPage(WebDriver driver){super(BASE_URL + "register#/investor", driver);}

    public InvestorRegistrationContactsPage fillForm(String fio, String telephone, String email, String password){
        fillField(FIO_FIELD, fio);
        fillField(TELEPHONE_FIELD, telephone);
        fillField(EMAIL_FIELD, email);
        fillField(PASSWORD_FIELD, password);
        return this;
    }

    public InvestorRegistrationInvestmentsPage goToInvestments(){
        click(goToInvestmentsButton);
        return new InvestorRegistrationInvestmentsPage(driver);
    }
}
