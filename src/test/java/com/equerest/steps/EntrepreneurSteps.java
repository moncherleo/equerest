package com.equerest.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by moncher on 06.10.2016.
 */
public class EntrepreneurSteps {
    protected WebDriver driver;
    protected final By fieldFio = By.id("fio");
    protected final By fieldCity = By.id("city");
    protected final By fieldTelephoneNumber = By.id("tel");
    protected final By fieldMail = By.id("mail");
    protected final By fieldPass = By.id("pass");
    protected final By buttonNextStep = By.cssSelector("#entrepreneur-register-form .button.button-blue.button-next");
    protected final By fieldMonetizationModel = By.id("monetization_model");
    protected final By fieldTitle = By.id("title");
    protected final By fieldCheckBox = By.id("checkbox_1");
    protected final By fieldCheckBoxAgree = By.id("checkbox_agree");

    @Given("^I am on new project registration page$")
    public void setup() throws Throwable {

        this.driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://dev.equerest.com/register#/entrepreneur");
    }

    @When("^I fill my First Name \"([^\"]*)\" and Last Name \"([^\"]*)\" into Full Name field$")
    public void iFillMyFirstNameAndLastNameIntoFullNameField(String arg0, String arg1) throws Throwable {
        String fullName = arg0 + " " + arg1;
        driver.findElement(fieldFio).clear();
        driver.findElement(fieldFio).sendKeys(fullName);
        Assert.assertEquals(driver.findElement(fieldFio).getAttribute("value"), fullName);
    }

    @And("^I fill my City \"([^\"]*)\" into City field$")
    public void iFillMyCityIntoCityField(String city) throws Throwable {
        driver.findElement(fieldCity).clear();
        driver.findElement(fieldCity).sendKeys(city);
        Assert.assertEquals(driver.findElement(fieldCity).getAttribute("value"), city);
    }

    @And("^I fill my phone number \"([^\"]*)\" into Phone field$")
    public void iFillMyPhoneNumberIntoPhoneField(String phone) throws Throwable {
        driver.findElement(fieldTelephoneNumber).clear();
        driver.findElement(fieldTelephoneNumber).sendKeys(phone);
        Assert.assertEquals(driver.findElement(fieldTelephoneNumber).getAttribute("value"), phone);
    }

    @And("^I fill my email address \"([^\"]*)\" into Email field$")
    public void iFillMyEmailAddressIntoEmailField(String arg0) throws Throwable {
        String mail = arg0;
        driver.findElement(fieldMail).click();
        driver.findElement(fieldMail).sendKeys(mail);
        Assert.assertEquals(driver.findElement(fieldMail).getAttribute("value"), mail);
    }

    @And("^I fill my desired password \"([^\"]*)\" into Password field$")
    public void iFillMyDesiredPasswordIntoPasswordField(String arg0) throws Throwable {
        String password = arg0;
        driver.findElement(fieldPass).click();
        driver.findElement(fieldPass).sendKeys(password);
        Assert.assertEquals(driver.findElement(fieldPass).getAttribute("value"), password);
    }

    @And("^I go next to second project registration page$")
    public void iGoNextToSecondProjectRegistrationPage() throws Throwable {
        driver.findElement(buttonNextStep).click();
        Assert.assertTrue(driver.findElement(fieldMonetizationModel).isDisplayed());
    }

    @Then("^I should see form field with \"([^\"]*)\" title$")
    public void iShouldSeeFormFieldWithTitle(String title) throws Throwable {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@for='title' and text()[contains(.,'" + title + "')]]")).isDisplayed());
    }

    @And("^I set checkbox to show my password$")
    public void iSetCheckboxToShowMyPassword() throws Throwable {
        if(driver.findElement(fieldCheckBox).isSelected() == false){
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", driver.findElement(fieldCheckBox));
        }
        Assert.assertTrue(driver.findElement(fieldCheckBox).isSelected());
    }
}
