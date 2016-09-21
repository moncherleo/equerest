package com.equerest.tests.webdriver.adminpanel.projectpage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Leonid Chernyshov on 9/15/16.
 */
public class EditProjectOnDashboard {
    FirefoxDriver driver;
    String baseUrl = "https://dev.equerest.com/";

    private final static String LOGIN = "olegftzi@gmail.com";
    private final static String PASSWORD = "Oleg1234";

    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("#submit-block .button.button-blue");
    private final By projectsMenuItem = By.xpath("//*[@id='js-navbar-collapse']//*[text()='Проекты']");
    private final By projectFilterModerationButton = By.xpath("//*[@class='projects-list container ng-isolate-scope']//div[1]//*[text()='Модерация']");
    private final By projectSearchField = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[2]/div[1]/div[2]/label/../*[@id='searchModerate']");

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseUrl + "register#/");
    }

    @Test
    public void editAndSaveStandardProjectField(){
        driver.findElement(emailField).sendKeys(LOGIN);
        driver.findElement(passwordField).sendKeys(PASSWORD);
        driver.findElement(loginButton).click();
        driver.findElement(projectsMenuItem).click();
        driver.findElement(projectFilterModerationButton).click();
        driver.findElement(projectSearchField).sendKeys("Интернет киоски \"Инетик\"");


    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
