package com.equerest.tests.webdriver.common.registration.recoverpassword;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import com.equerest.pages.common.registration.regainpassword.EntranceToTheEmailAccountPage;
import com.equerest.pages.common.registration.regainpassword.PersonalCabinetPage;
import com.equerest.pages.common.registration.regainpassword.RegainPasswordPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Dmitry Vanzhula on 1/7/17.
 */
public class CheckOfSendingNoticesToRecoverPasswordTest extends BaseTest {
    protected By fieldEmail = By.xpath(".//*[@id='email']");
    protected By assertTitle = By.xpath(".//*[@id='checkMail']/h3");
    protected By fieldEmailGmail = By.xpath(".//*[@id='Email']");
    protected By fieldPasswordGmail = By.xpath(".//*[@id='Passwd']");
    protected By buttonNext = By.xpath(".//*[@id='next']");
    protected By buttonSignIn = By.xpath(".//*[@id='signIn']");
    protected By newMessage = By.xpath(".//*[@id=':3i']/span");
    protected By assertMessage = By.xpath(".//*/div[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/p");
    protected String expTitleNewMessage = "Equerest";
    protected String email = "tester1equerest@gmail.com";
    protected String expAssertMessage = "Здравствуйте, Dima.\n" + "\n" + "Перейдите по ссылке для восстановления пароля: https://dev.equerest.com/index/regainPassword/";
    protected String password = "Dima1234";
    protected String expTitle = "Перейдите по ссылке, которую мы отправили вам на почту.";
    protected String expUrlRecoverPage = "https://dev.equerest.com/index/regainPassword";
    protected String expUrlMail = "https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier";

    @Title("C39 Проверка отправки уведомления для восстановления пароля входа в систему")
    @Test
    public void checkSendingNoticesTest() {

        HomePage homePage = new HomePage(driver);
        homePage
                .navigateToLoginPage()
                .clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .clickForgotPasswordLink();
        RegainPasswordPage regainPasswordPage = new RegainPasswordPage(driver);
        regainPasswordPage
                .visibilityOf(fieldEmail);
        regainPasswordPage
                .fillField(fieldEmail, email);
        Assert.assertEquals(email, driver.findElement(fieldEmail).getAttribute("value"));
        Assert.assertEquals(expUrlRecoverPage, driver.getCurrentUrl());
        regainPasswordPage
                .clickSubmitButton()
                .visibilityOf(assertTitle);
        Assert.assertEquals(expTitle, driver.findElement(assertTitle).getText());
        Assert.assertEquals(expUrlRecoverPage, driver.getCurrentUrl());
        regainPasswordPage
                .checkGoToMailButtonExist()
                .clickGoToMailButton();
        regainPasswordPage
                .manageMultipleWindows(1);
        EntranceToTheEmailAccountPage emailAccountPage = new EntranceToTheEmailAccountPage(driver);
        emailAccountPage
                .visibilityOf(fieldEmailGmail);
        Assert.assertEquals(expUrlMail, driver.getCurrentUrl());
        emailAccountPage
                .fillField(fieldEmailGmail, email);
        Assert.assertEquals(email, driver.findElement(fieldEmailGmail).getAttribute("value"));
        emailAccountPage
                .click(buttonNext);
        emailAccountPage
                .visibilityOf(fieldPasswordGmail);
        emailAccountPage
                .fillField(fieldPasswordGmail, password);
        Assert.assertEquals(password, driver.findElement(fieldPasswordGmail).getAttribute("value"));
        emailAccountPage
                .click(buttonSignIn);
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage
                .visibilityOf(newMessage);
        Assert.assertEquals(expTitleNewMessage, driver.findElement(newMessage).getText());
        personalCabinetPage
                .click(newMessage);
        personalCabinetPage
                .checkRecoverPasswordButtonExist();
        personalCabinetPage
                .visibilityOf(assertMessage);
        Assert.assertEquals(expAssertMessage, driver.findElement(assertMessage).getText().substring(0, 114));
    }
}
