package com.equerest.pages.common.registration;

import com.equerest.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Михаїл on 26.09.2016.
 */
public class InvestorRegistrationContactsPage extends AbstractPage{
    private static final By FIO_FIELD = By.xpath("//*[@id='fio']");
    private static final By TELEPHONE_FIELD = By.xpath("//*[@id='tel']");
    private static final By EMAIL_FIELD = By.xpath("//*[@id='mail']");
    private static final By PASSWORD_FIELD = By.xpath("//*[@id='pass']");
    private By goToInvestmentsButton = By.cssSelector(".button.button-blue.button-next");

    public InvestorRegistrationContactsPage(WebDriver driver){super(driver);}

    public InvestorRegisrationInvestmentsPage enterFields(String fio, String telephone, String email, String password){
        driver.findElement(FIO_FIELD).sendKeys(fio);
        driver.findElement(TELEPHONE_FIELD).sendKeys(telephone);
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(goToInvestmentsButton).click();
        return new InvestorRegisrationInvestmentsPage(driver);
    }
}
