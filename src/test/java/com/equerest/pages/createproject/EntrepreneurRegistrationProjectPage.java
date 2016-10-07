package com.equerest.pages.createproject;

import com.equerest.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg Nesterov on 04.10.2016;
 */
public class EntrepreneurRegistrationProjectPage extends AbstractPage {
    public EntrepreneurRegistrationProjectPage(WebDriver driver) {
        super(driver);
    }

    protected final By fieldTitle = By.id("title");
    protected final By fieldDescriptionOfProject = By.id("full_description");
    protected final By fieldStageOfProject = By.id("radio_0");
    protected final By fieldAdvantages = By.id("advantages");
    protected final By fieldMonetizationModel = By.id("monetization_model");
    protected final By fieldAmount = By.id("required_amount");
    protected final By fieldCheckBoxAgree = By.id("checkbox_agree");
    protected final By buttonComplete = By.cssSelector("#entrepreneur-register-form .button-blue");

    public EntrepreneurRegistrationProjectPage fillTitle(String title){
        driver.findElement(fieldTitle).sendKeys(title);
        return this;
    }

    public EntrepreneurRegistrationProjectPage fillDescription(String description){
        driver.findElement(fieldDescriptionOfProject).sendKeys(description);
        return this;
    }

    public EntrepreneurRegistrationProjectPage fillStage(){
        clickJS(fieldStageOfProject);
        return this;
    }

    public EntrepreneurRegistrationProjectPage fillAdvantages(String advantages){
        scrollTo(driver.findElement(fieldAdvantages));
        driver.findElement(fieldAdvantages).sendKeys(advantages);
        return this;
    }

    public EntrepreneurRegistrationProjectPage fillMonetization(String model){
        scrollTo(driver.findElement(fieldMonetizationModel));
        driver.findElement(fieldMonetizationModel).sendKeys(model);
        return this;
    }

    public EntrepreneurRegistrationProjectPage fillAmount(String amount){
        scrollTo(driver.findElement(fieldAmount));
        driver.findElement(fieldAmount).sendKeys(amount);
        return this;
    }

    public EntrepreneurRegistrationProjectPage setCheckBoxAgree(){
        scrollTo(driver.findElement(fieldCheckBoxAgree));
        clickJS(fieldCheckBoxAgree);
        return this;
    }

    public EntrepreneurRegistrationFinishPage pressCompleteButton(){
        click(buttonComplete);
        return new EntrepreneurRegistrationFinishPage(driver);
    }
}
