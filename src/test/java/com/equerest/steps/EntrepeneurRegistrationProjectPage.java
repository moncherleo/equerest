package com.equerest.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by onesterov on 10/7/16.
 */
public class EntrepeneurRegistrationProjectPage extends DriverFactory{
   // protected WebDriver driver;

    private final By fieldTitle = By.id("title");
    private final By fieldDescriptionOfProject = By.id("full_description");
    private final By fieldStageOfProject = By.id("radio_0");
    private final By fieldAdvantages = By.id("advantages");
    private final By fieldMonetizationModel = By.id("monetization_model");
    private final By fieldAmount = By.id("required_amount");
    private final By checkBoxAgree = By.id("checkbox_agree");
    private final By buttonComplete = By.cssSelector("#entrepreneur-register-form .button-blue");
    private final By buttonMyProjectThankYou = By.cssSelector("#thankYouMessage .button.button-white");
    private final By thankyouMessage = By.xpath("//*[@id='thankYouMessage']//*[text()[contains(.,'Спасибо!')]]");
    private final By titleOfProject = By.xpath("//*[@id='wrapper']/main//*[text()[contains(.,'')]]");

    @And("^I fill Project name \"([^\"]*)\" into projectName field$")
    public void iFillProjectNameIntoProjectNameField(String projectName) throws Throwable {
        driver.findElement(fieldTitle).clear();
        driver.findElement(fieldTitle).sendKeys(projectName);
        Assert.assertEquals(driver.findElement(fieldTitle).getAttribute("value"), projectName);
    }

    @And("^I fill Description of project \"([^\"]*)\" into description of project field$")
    public void iFillDescriptionOfProjectIntoDescriptionOfProjectField(String projectDescription) throws Throwable {
        driver.findElement(fieldDescriptionOfProject).clear();
        driver.findElement(fieldDescriptionOfProject).sendKeys(projectDescription);
     //   Assert.assertEquals(driver.findElement(fieldTitle).getAttribute("value"), projectDescription);
    }

    @And("^I select stage of project idea or prototip at project stage field$")
    public void iSelectStageOfProjectAtProjectStageField() throws Throwable {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", driver.findElement(fieldStageOfProject));
        Assert.assertTrue(driver.findElement(fieldStageOfProject).isSelected());
    }

    @And("^I fill advantages \"([^\"]*)\" into Competitive advantages field$")
    public void iFillAdvantagesIntoCompetitiveAdvantagesField(String advantages) throws Throwable {
        driver.findElement(fieldAdvantages).clear();
        driver.findElement(fieldAdvantages).sendKeys(advantages);
        Assert.assertEquals(driver.findElement(fieldAdvantages).getAttribute("value"), advantages);
    }

    @And("^I fill monetization Model \"([^\"]*)\" into monetization Model field$")
    public void iFillMonetizationModelIntoMonetizationModelField(String model) throws Throwable {
        driver.findElement(fieldMonetizationModel).clear();
        driver.findElement(fieldMonetizationModel).sendKeys(model);
        Assert.assertEquals(driver.findElement(fieldMonetizationModel).getAttribute("value"), model);
    }

    @And("^i fill Amount of investment \"([^\"]*)\" into Amount of investment field$")
    public void iFillAmountOfInvestmentIntoAmountOfInvestmentField(String amount) throws Throwable {
        driver.findElement(fieldAmount).clear();
        driver.findElement(fieldAmount).sendKeys(amount);
        Assert.assertEquals(driver.findElement(fieldAmount).getAttribute("value"), amount);
    }

    @And("^I set checkbox at I agree with conditions and rules field$")
    public void iSetCheckboxAtIAgreeWithConditionsAndRulesField() throws Throwable {
        if(driver.findElement(checkBoxAgree).isSelected() == false){
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", driver.findElement(checkBoxAgree));
        }
        Assert.assertTrue(driver.findElement(checkBoxAgree).isSelected());
    }

    @And("^I go to finish registration page$")
    public void iGoToFinishRegistrationPage() throws Throwable {
        driver.findElement(buttonComplete).click();
        Assert.assertTrue(driver.findElement(buttonComplete).isDisplayed());
    }

    @Then("^I should see the text \"([^\"]*)\"$")
    public void iShouldSeeTheText(String message) throws Throwable {
        driver.findElement(thankyouMessage).click();
        Assert.assertTrue(driver.findElement(thankyouMessage).isDisplayed());
    }

    @And("^I shuld click to the Мой проект button$")
    public void iShuldClickToTheButton() throws Throwable {
        driver.findElement(buttonMyProjectThankYou).click();
    }

    @Then("^I should see \"([^\"]*)\" project title$")
    public void iShouldSeePtojectTitle(String name) throws Throwable {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='wrapper']/main//*[text()[contains(.,'Тестовый Проект 1')]]")).isDisplayed());
    }
}

