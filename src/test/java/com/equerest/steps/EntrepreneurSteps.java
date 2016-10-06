package com.equerest.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by moncher on 06.10.2016.
 */
public class EntrepreneurSteps {
    protected WebDriver driver;
    protected final By fieldFio = By.id("fio");
    protected final By fieldMail = By.id("mail");
    protected final By fieldPass = By.id("pass");



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
    public void iFillMyCityIntoCityField(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
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
}
