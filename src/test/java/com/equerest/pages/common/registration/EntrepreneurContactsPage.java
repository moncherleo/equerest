package com.equerest.pages.common.registration;

import com.equerest.pages.common.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Oleg Nesterov on 10/4/16;
 */
public class EntrepreneurContactsPage extends HomePage {

    public EntrepreneurContactsPage(WebDriver driver) {
        super(BASE_URL + "register#/entrepreneur", driver);
    }

    protected final By fieldFio = By.id("fio");
    protected final By fieldCity = By.id("city");
    protected final By fieldTelephone = By.id("tel");
    protected final By fieldMail = By.id("mail");
    protected final By fieldPass = By.id("pass");
    protected final By fieldCheckBox = By.id("checkbox_1");
    protected final By buttonNextStep = By.cssSelector(".entrepreneur-reg-form .button.button-blue.button-next");
    protected final By fieldFioError = By.cssSelector("input#fio~div[ng-messages='e_r_s_one.fio.$error']>div");


    public EntrepreneurContactsPage fillFio(String fio){
        driver.findElement(fieldFio).clear();
        driver.findElement(fieldFio).sendKeys(fio);
        Assert.assertEquals(fio, driver.findElement(fieldFio).getAttribute("value"));
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

    public EntrepreneurContactsPage assertFioError(boolean isError) {
        List<WebElement> errorMessages = driver.findElements(fieldFioError);
        Assert.assertEquals(isError, errorMessages.size()>0);
        return this;
    }

}
