package com.equerest.tests.webdriver.createproject;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Oleg Nesterov on 25.09.2016;
 */
@RunWith(JUnitParamsRunner.class)
public class CreateProjectTest {
    FirefoxDriver driver;
    String baseUrl = "https://dev.equerest.com/";

    private By newProjectButton = By.cssSelector("#banner .button.button-green.bordered");
    private By filedFio = By.id("fio");
    private By filedCity = By.id("city");
    private By filedTelephone = By.id("tel");
    private By filedMail = By.id("mail");
    private By fieldPassword = By.cssSelector("#pass");
    private By buttonNextStep = By.cssSelector("#entrepreneur-register-form .button.button-blue.button-next");
    private By projectName = By.id("title");
    private By projectDescription = By.id("full_description");
    private By projectStage = By.id("radio_0");
    private By projectAdvantages = By.id("advantages");
    private By projectMonetizationModel = By.id("monetization_model");
    private By projectRequiredAmount = By.id("required_amount");
    //private By projectCheckboxAgree = By.id("checkbox_agree");
    private By projectCheckboxAgree = By.id("checkbox_agree");
    private By buttonCompleteRegistration = By.cssSelector("header .button.button-blue.button-next");


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }

    @Test
    @FileParameters("src/test/resources/create_new_project_info.csv")
    public void createProject(String fio, String city, String tel, String mail, String pass, String nameOfPoject, String descriptionOfProect, String ideaOfProject, String advantagesOfProjet, String modelOfProject, String amountOfProject){
        driver.findElement(newProjectButton).click();
        driver.findElement(filedFio).sendKeys(fio);
        driver.findElement(filedCity).sendKeys(city);
        driver.findElement(filedTelephone).sendKeys(tel);
        driver.findElement(filedMail).sendKeys(mail);
        driver.findElement(fieldPassword).sendKeys(pass);
        driver.findElement(buttonNextStep).click();
        driver.findElement(projectName).sendKeys(nameOfPoject);
        driver.findElement(projectDescription).sendKeys(descriptionOfProect);
        driver.findElement(projectStage).sendKeys(ideaOfProject);
        driver.findElement(projectAdvantages).sendKeys(advantagesOfProjet);
        driver.findElement(projectMonetizationModel).sendKeys(modelOfProject);
        driver.findElement(projectRequiredAmount).sendKeys(amountOfProject);
//        new Actions(driver).moveToElement(driver.findElement(projectAdvantages)).sendKeys(avantagesOfProjet);
//        new Actions(driver).moveToElement(driver.findElement(projectMonetizationModel)).sendKeys(modelOfProject);
//        new Actions(driver).moveToElement(driver.findElement(projectRequiredAmount)).sendKeys(amountOfProject);
        new Actions(driver).moveToElement(driver.findElement(projectCheckboxAgree)).click();
        new Actions(driver).moveToElement(driver.findElement(buttonCompleteRegistration)).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
