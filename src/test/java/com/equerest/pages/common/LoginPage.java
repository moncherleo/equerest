package com.equerest.pages.common;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.common.registration.EntrepreneurContactsPage;
import com.google.common.base.Verify;
import org.jboss.netty.util.Version;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    private By wrongEmailOrPasswordMsg = By.xpath("//div[contains(.,'Неверный логин или пароль')]");
    private By invalidInput = By.cssSelector("input:invalid");
    //######################_locotors for the Registration block_######################
    private By registrationBlock = By.id("registerBlock");
    private By registrationLabel = By.cssSelector("#registerBlock>h3");
    private By entrepreneurLabel = By.xpath(".//*[@id='registerBlock']//div[1]/label");
    private By presentProjectText = By.cssSelector(".flex-block>div>div>span");
    private By submitProjectButton = By.xpath(".//*[@class='flex-block']/div[1]/div/div/a");
    private By howItWorksForEntrepreneur = By.xpath(".//*[@id='registerBlock']//span[1]/a");
    private By howItWorksForInvestor = By.xpath(".//*[@id='registerBlock']//span[2]/a");
    private By investorLabel = By.xpath(".//*[@id='registerBlock']//div[2]/label");
    private By getAccessText = By.xpath(".//*[@id='registerBlock']//div[2]/span[1]");
    private By investButton = By.xpath("//*[@href = \"/register#/investor\"]");



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

    public LoginPage checkSuccessfulLoginPopUpMsg() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginConfirmationMsg));
        return new LoginPage(driver);
    }

    public LoginPage checkWrongEmailOrPasswordErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(wrongEmailOrPasswordMsg));
        return new LoginPage(driver);
    }

    public LoginPage clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        WebElement button = driver.findElement(loginButton);
        button.click();
        return new LoginPage(driver);
    }

    public LoginPage checkEmptyInput() {
        WebElement emailF = driver.findElement(emailField);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(invalidInput));
        emailF.sendKeys("eq-notexist@mail.ru");
        wait.until(ExpectedConditions.presenceOfElementLocated(invalidInput));
        return new LoginPage(driver);
    }

    //######################_Registration block_######################
    public LoginPage checkRegistrationBlockExist() {
        Assert.assertTrue(driver.findElement(registrationBlock).isEnabled());
        Assert.assertTrue(driver.findElement(registrationLabel).isEnabled());
        Assert.assertTrue(driver.findElement(entrepreneurLabel).isEnabled());
        Assert.assertTrue(driver.findElement(presentProjectText).isEnabled());
        Assert.assertTrue(driver.findElement(submitProjectButton).isEnabled());
        Assert.assertTrue(driver.findElement(howItWorksForEntrepreneur).isEnabled());
        Assert.assertTrue(driver.findElement(howItWorksForInvestor).isEnabled());
        Assert.assertTrue(driver.findElement(investorLabel).isEnabled());
        Assert.assertTrue(driver.findElement(getAccessText).isEnabled());
        Assert.assertTrue(driver.findElement(investButton).isEnabled());
        return new LoginPage(driver);
    }

    public LoginPage checkRegistrationBlockTextValues() {
        Assert.assertEquals(driver.findElement(registrationLabel).getText(), "Регистрация");
        Assert.assertEquals(driver.findElement(entrepreneurLabel).getText(), "Предпринимателю");
        Assert.assertTrue(driver.findElement(presentProjectText).getText().contains("Представьте свой"));
        Assert.assertTrue(driver.findElement(presentProjectText).getText().contains("проект потенциальным"));
        Assert.assertTrue(driver.findElement(presentProjectText).getText().contains("инвесторам"));
        Assert.assertEquals(driver.findElement(submitProjectButton).getText(), "Подать проект");
        Assert.assertEquals(driver.findElement(howItWorksForEntrepreneur).getText(), "Как это работает?");
        Assert.assertEquals(driver.findElement(howItWorksForInvestor).getText(), "Как это работает?");
        Assert.assertEquals(driver.findElement(investorLabel).getText(), "Инвестору");
        Assert.assertEquals(driver.findElement(investButton).getText(), "Инвестировать");
        Assert.assertTrue(driver.findElement(getAccessText).getText().contains("Получите доступ"));
        Assert.assertTrue(driver.findElement(getAccessText).getText().contains("к перспективным"));
        Assert.assertTrue(driver.findElement(getAccessText).getText().contains("и доходным проектам"));
        return new LoginPage(driver);
    }

    public LoginPage checkRegistrationBlockClickable() {
        WebElement submitProjectButton = driver.findElement(this.submitProjectButton);
        WebElement investButton = driver.findElement(this.investButton);
        WebElement howItWorksForEntrepreneur = driver.findElement(this.howItWorksForEntrepreneur);
        WebElement howItWorksForInvestor = driver.findElement(this.howItWorksForInvestor);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Assert.assertEquals(submitProjectButton, wait.until(ExpectedConditions.elementToBeClickable(this.submitProjectButton)));
        Assert.assertEquals(investButton, wait.until(ExpectedConditions.elementToBeClickable(this.investButton)));
        Assert.assertEquals(howItWorksForEntrepreneur, wait.until(ExpectedConditions.elementToBeClickable(this.howItWorksForEntrepreneur)));
        Assert.assertEquals(howItWorksForInvestor, wait.until(ExpectedConditions.elementToBeClickable(this.howItWorksForInvestor)));
        return new LoginPage(driver);
    }

    public EntrepreneurContactsPage clickSubmitProjectButton() {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.elementToBeClickable(submitProjectButton));
        WebElement button = driver.findElement(submitProjectButton);
        button.click();
        return new EntrepreneurContactsPage(driver);
    }


}
