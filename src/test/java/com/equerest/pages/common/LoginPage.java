package com.equerest.pages.common;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.adminpanel.ProjectsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by cherleo on 9/19/16.
 */
public class LoginPage extends AbstractPage {

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#submit-block .button.button-blue");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login as user {0} with password {1}")
    public ProjectsPage loginAs(String userName, String password) {
        driver.findElement(emailField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new ProjectsPage(driver);
    }
}
