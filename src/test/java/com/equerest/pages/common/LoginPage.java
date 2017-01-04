package com.equerest.pages.common;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.adminpanel.ProjectsPage;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by cherleo on 9/19/16.
 */
public class LoginPage extends AbstractPage {

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#submit-block .button.button-blue");
    private By loginGButton = By.cssSelector(".button.is-danger");
    private By loginBlock = By.cssSelector("#login-block");
    private By loginLabel = By.cssSelector("#login-block>h3");
    private By emailFieldLabel = By.cssSelector(".input-text-group>label[for = 'email']");
    private By passwordFieldlabel = By.cssSelector(".input-text-group>label[for = 'password']");
    private By loginConfirmationMsg = By.xpath("//div[contains(.,'Вы успешно вошли')]");


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

    public LoginPage checkThatLoginBlockElementsExist() {
        WebElement block = driver.findElement(loginBlock);
        Assert.assertTrue(block.isEnabled());
        Assert.assertTrue(driver.findElement(emailField).isEnabled());
        Assert.assertTrue(driver.findElement(passwordField).isEnabled());
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        Assert.assertTrue(driver.findElement(loginGButton).isEnabled());
        return new LoginPage(driver);
    }

    public LoginPage checkThatLoginBlockElementsHaveRightTextValue() {
        WebElement label = driver.findElement(loginLabel);
        Assert.assertEquals(label.getText(), "Войти");
        WebElement emailLabel = driver.findElement(emailFieldLabel);
        Assert.assertEquals(emailLabel.getText(), "E-mail");
        WebElement emField = driver.findElement(emailField);
        Assert.assertEquals(emField.getAttribute("placeholder"), "введите эл. почту");
        WebElement passLabel = driver.findElement(passwordFieldlabel);
        Assert.assertEquals(passLabel.getText(), "Пароль");
        WebElement passField = driver.findElement(passwordField);
        Assert.assertEquals(passField.getAttribute("placeholder"), "введите пароль");
        WebElement blueButton = driver.findElement(loginButton);
        WebElement gButton = driver.findElement(loginGButton);
        Assert.assertEquals(blueButton.getText(), "Войти");
        Assert.assertEquals(gButton.getText(), "Войти");
        return new LoginPage(driver);
    }

    public LoginPage checkThatLoginBlockElementsClickable() {
        WebElement blueButton = driver.findElement(loginButton);
        WebElement gButton = driver.findElement(loginGButton);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Assert.assertEquals(blueButton, wait.until(ExpectedConditions.elementToBeClickable(loginButton)));
        Assert.assertEquals(gButton, wait.until(ExpectedConditions.elementToBeClickable(loginGButton)));
        return new LoginPage(driver);
    }

    public LoginPage checkThatTextCanBeEnteredInInputFields() {
        WebElement emField = driver.findElement(emailField);
        WebElement passField = driver.findElement(passwordField);
        String testEmailMsg = "test@mail.ru";
        String testPwMsg = "Dev12345";
        emField.clear();
        emField.sendKeys(testEmailMsg);
        passField.clear();
        passField.sendKeys(testPwMsg);
        Assert.assertEquals(emField.getAttribute("value"), testEmailMsg);
        Assert.assertEquals(passField.getAttribute("value"), testPwMsg);
        return new LoginPage(driver);
    }

    public LoginPage assertSuccessfulLoginPopUpMsg() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginConfirmationMsg));
        return new LoginPage(driver);
    }
}
