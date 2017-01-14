package com.equerest.pages.common.registration;

import com.equerest.pages.common.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Oleg Nesterov on 10/4/16;
 */
public class EntrepreneurContactsPage extends HomePage {

    private By fieldCityError = By.cssSelector("input#city~div[ng-messages='e_r_s_one.city.$error']>div");
    private By telephoneFormatError = By.cssSelector("input#tel~div>div[ng-message='pattern']");
    private By telephoneRequiredError = By.cssSelector("input#city~div>div[ng-message='required']");
    private By telephoneError = By.cssSelector("input#tel~div[ng-messages='e_r_s_one.tel.$error']>div");

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
        WebElement field = driver.findElement(fieldFio);
        field.clear();
        field.sendKeys(fio);
        Assert.assertEquals(fio, field.getAttribute("value"));
        field.sendKeys(Keys.TAB);
        return this;
    }

    public EntrepreneurContactsPage fillCity(String city){
        WebElement field = driver.findElement(fieldCity);
        field.clear();
        field.sendKeys(city);
        Assert.assertEquals(city, field.getAttribute("value"));
        field.sendKeys(Keys.TAB);
        return this;
    }

    public EntrepreneurContactsPage fillTelephone(String telephone){
        WebElement field = driver.findElement(fieldTelephone);
        field.clear();
        field.sendKeys(telephone);
        Assert.assertEquals(telephone, field.getAttribute("value"));
        field.sendKeys(Keys.TAB);
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

    public EntrepreneurContactsPage assertCityError(boolean isError) {
        List<WebElement> errorMessages = driver.findElements(fieldCityError);
        Assert.assertEquals(isError, errorMessages.size()>0);
        return this;
    }

    public EntrepreneurContactsPage assertTelephoneError(PhoneError errorType) {
        List<WebElement> errorMessages;
        switch (errorType) {
            case NONE:
                errorMessages = driver.findElements(telephoneError);
                Assert.assertTrue(errorMessages.size()==0);
                break;
            case FORMAT:
                errorMessages = driver.findElements(telephoneFormatError);
                Assert.assertTrue(errorMessages.size()>0);
                break;
            case REQUIRED:
                errorMessages = driver.findElements(telephoneRequiredError);
                Assert.assertTrue(errorMessages.size()>0);
                break;
        }
        return this;
    }

    public enum PhoneError {NONE, FORMAT, REQUIRED}

}
