package com.equerest.pages.common.registration;

import com.equerest.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg Nesterov on 10/4/16;
 */
public class EntrepreneurContactsPage extends AbstractPage {

    public EntrepreneurContactsPage(WebDriver driver) {
        super(driver);
    }

    protected final By fieldFio = By.id("fio");
    protected final By fieldCity = By.id("city");
    protected final By fieldTelephone = By.id("tel");
    protected final By fieldMail = By.id("mail");
    protected final By fieldPass = By.id("pass");
    protected final By fieldCheckBox = By.id("checkbox_1");
    protected final By buttonNextStep = By.cssSelector("#entrepreneur-register-form .button.button-blue.button-next");


    public EntrepreneurContactsPage fillFio(String fio){
        driver.findElement(fieldFio).sendKeys(fio);
        return this;
    }

    public EntrepreneurContactsPage fillCity(String city){
        driver.findElement(fieldCity).sendKeys(city);
        return this;
    }

    public EntrepreneurContactsPage fillTelephone(String telephone){
        driver.findElement(fieldTelephone).sendKeys(telephone);
        return this;
    }

    public EntrepreneurContactsPage fillMail(String mail){
        driver.findElement(fieldMail).sendKeys(mail);
        return this;
    }

    public EntrepreneurContactsPage setCheckBox(){
        scrollTo(driver.findElement(fieldCheckBox));
        clickJS(fieldCheckBox);
        return this;
    }

    public EntrepreneurContactsPage fillPass(String password){
        scrollTo(driver.findElement(fieldPass));
        driver.findElement(fieldPass).sendKeys(password);
        return this;
    }

    public EntrepreneurRegistrationProjectPage pressNextButton(){
        click(buttonNextStep);
        return new EntrepreneurRegistrationProjectPage(driver);
    }

}
