package com.equerest.pages.createproject;

import com.equerest.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg Nesterov on 04.10.2016;
 */
public class ProjectInfo extends AbstractPage {
    public ProjectInfo(WebDriver driver) {
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

    public ProjectInfo fillTitle(String title){
        driver.findElement(fieldTitle).sendKeys(title);
        return this;
    }

    public ProjectInfo fillDescription(String description){
        driver.findElement(fieldDescriptionOfProject).sendKeys(description);
        return this;
    }

    public ProjectInfo fillStage(){
        clickJS(fieldStageOfProject);
        return this;
    }

    public ProjectInfo fillAdvantages(String advantages){
        scrollTo(driver.findElement(fieldAdvantages));
        driver.findElement(fieldAdvantages).sendKeys(advantages);
        return this;
    }

    public ProjectInfo fillMonetization(String model){
        scrollTo(driver.findElement(fieldMonetizationModel));
        driver.findElement(fieldMonetizationModel).sendKeys(model);
        return this;
    }

    public ProjectInfo fillAmount(String amount){
        scrollTo(driver.findElement(fieldAmount));
        driver.findElement(fieldAmount).sendKeys(amount);
        return this;
    }

    public ProjectInfo setCheckBoxAgree(){
        scrollTo(driver.findElement(fieldCheckBoxAgree));
        clickJS(fieldCheckBoxAgree);
        return this;
    }

    public ProjectCreateComplete pressCompleteButton(){
        click(buttonComplete);
        return new ProjectCreateComplete(driver);
    }
}
