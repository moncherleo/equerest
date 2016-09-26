package com.equerest.tests.webdriver.createproject;

import junitparams.FileParameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Oleg Nesterov on 25.09.2016;
 */
public class CreateProjectTest {
    FirefoxDriver driver;
    String baseUrl = "https://dev.equerest.com/";

    private By newProjectButton = By.cssSelector("#banner .button.button-green.bordered");
    private By filedFio = By.id("fio");
    private By filedCity = By.id("city");
    private By filedTelephone = By.id("tel");
    private By filedMail = By.id("mail");
    private By fieldPassword = By.cssSelector("#pass");
    private By fieldCheckbox = By.id("checkbox_1");
    private By buttonNextStep = By.cssSelector("#entrepreneur-register-form .button.button-blue.button-next");
    private By projectName = By.id("title");
    private By projectDescription = By.id("full_description");
    private By projectStage = By.id("radio_0");
    private By projectAdvantages = By.id("advantages");
    private By projectMonetizationModel = By.id("monetization_model");
    private By projectRequiredAmount = By.id("required_amount");
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
    public void editAndSaveStandardProjectField(){
        driver.findElement(newProjectButton).click();
        driver.findElement(filedFio).sendKeys("Олег Нестеров");
        driver.findElement(filedCity).sendKeys("Киев");
        driver.findElement(filedTelephone).sendKeys("631234567");
        driver.findElement(filedMail).sendKeys("olegvn88@gmail.com");
        new Actions(driver).moveToElement(driver.findElement(fieldPassword)).sendKeys("Oleg1234");
        new Actions(driver).moveToElement(driver.findElement(fieldCheckbox)).perform();
        new Actions(driver).moveToElement(driver.findElement(buttonNextStep)).perform();
        driver.findElement(projectName).sendKeys("Тестовый проект Модерация");
        driver.findElement(projectDescription).sendKeys("Описание проекта");
        driver.findElement(projectStage).sendKeys("Идея или прототип");
        new Actions(driver).moveToElement(driver.findElement(projectAdvantages)).sendKeys("Преймущества");
        new Actions(driver).moveToElement(driver.findElement(projectMonetizationModel)).sendKeys("Модель монетизации");
        new Actions(driver).moveToElement(driver.findElement(projectRequiredAmount)).sendKeys("20000");
        new Actions(driver).moveToElement(driver.findElement(projectCheckboxAgree)).click();
        new Actions(driver).moveToElement(driver.findElement(buttonCompleteRegistration)).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
