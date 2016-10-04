package com.equerest.pages.createproject;

import com.equerest.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Oleg Nesterov on 10/4/16;
 */
public class ProjectOwnerInfo extends AbstractPage {

    public ProjectOwnerInfo(WebDriver driver) {
        super(driver);
    }

    protected final By fieldFio = By.id("fio");
    protected final By fieldCity = By.id("city");
    protected final By fieldTelephone = By.id("tel");
    protected final By fieldMail = By.id("mail");
    protected final By fieldPass = By.id("pass");
    protected final By fieldCheckBox = By.id("checkbox_1");
    protected final By buttonNextStep = By.cssSelector("#entrepreneur-register-form .button.button-blue.button-next");


    public void fillFio(String fio){
        driver.findElement(fieldFio).sendKeys(fio);
    }

    public void fillCity(String city){
        driver.findElement(fieldCity).sendKeys(city);
    }

    public void fillTelephone(String telephone){
        driver.findElement(fieldTelephone).sendKeys(telephone);
    }

    public void fillMail(String mail){
        driver.findElement(fieldMail).sendKeys(mail);
    }

    public void setCheckBox(){
        driver.findElement(fieldCheckBox).click();
    }

    public void fillPass(String password){
        driver.findElement(fieldPass).sendKeys(password);
    }

    public void pressNextButton(){
        scrollTo(driver.findElement(buttonNextStep));
        driver.findElement(buttonNextStep).click();
    }

}
