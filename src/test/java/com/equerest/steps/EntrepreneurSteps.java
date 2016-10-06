package com.equerest.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by moncher on 06.10.2016.
 */
public class EntrepreneurSteps {
    protected WebDriver driver;
    protected final By fieldFio = By.id("fio");

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
}
