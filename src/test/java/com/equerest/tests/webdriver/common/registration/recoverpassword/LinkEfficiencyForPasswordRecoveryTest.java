package com.equerest.tests.webdriver.common.registration.recoverpassword;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.registration.regainpassword.EntranceToTheEmailAccountPage;
import com.equerest.pages.common.registration.regainpassword.PersonalCabinetPage;
import com.equerest.pages.common.registration.regainpassword.RegainPasswordPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Dmitry Vanzhula on 1/8/17.
 */
public class LinkEfficiencyForPasswordRecoveryTest extends BaseTest {
    CheckOfSendingNoticesToRecoverPasswordTest linkTo = new CheckOfSendingNoticesToRecoverPasswordTest();
    private By recoverPasswordButton = By.xpath(".//*/div[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/a");
    private By password = By.xpath(".//*[@id='password']");
    private String expAttribPass = "password";
    private String expAtribAgainPass = "again_password";
    private By againPassword = By.xpath(".//*[@id='again_password']");

    @Title("C40 Проверка работы линки для восстановения пароля входа в систему")
    @Test
  public void checkLinkRecoverPasswordTest(){

        HomePage homePage = new HomePage(driver);
        homePage
                .navigateToRegainPasswordPage();
        RegainPasswordPage regainPasswordPage = new RegainPasswordPage(driver);
        regainPasswordPage
                .visibilityOf(linkTo.fieldEmail);
        regainPasswordPage
                .fillField(linkTo.fieldEmail, linkTo.email);
        Assert.assertEquals(linkTo.email, driver.findElement(linkTo.fieldEmail).getAttribute("value"));
        Assert.assertEquals(linkTo.expUrlRecoverPage, driver.getCurrentUrl());
        regainPasswordPage
                .clickSubmitButton()
                .visibilityOf(linkTo.assertTitle);
        Assert.assertEquals(linkTo.expTitle, driver.findElement(linkTo.assertTitle).getText());
        Assert.assertEquals(linkTo.expUrlRecoverPage, driver.getCurrentUrl());
        regainPasswordPage
                .checkGoToMailButtonExist()
                .clickGoToMailButton();
        regainPasswordPage
                .manageMultipleWindows(1);
        EntranceToTheEmailAccountPage emailAccountPage = new EntranceToTheEmailAccountPage(driver);
        emailAccountPage
                .visibilityOf(linkTo.fieldEmailGmail);
        Assert.assertEquals(linkTo.expUrlMail, driver.getCurrentUrl());
        emailAccountPage
                .fillField(linkTo.fieldEmailGmail, linkTo.email);
        Assert.assertEquals(linkTo.email, driver.findElement(linkTo.fieldEmailGmail).getAttribute("value"));
        emailAccountPage
                .click(linkTo.buttonNext);
        emailAccountPage
                .visibilityOf(linkTo.fieldPasswordGmail);
        emailAccountPage
                .fillField(linkTo.fieldPasswordGmail, linkTo.password);
        Assert.assertEquals(linkTo.password, driver.findElement(linkTo.fieldPasswordGmail).getAttribute("value"));
        emailAccountPage
                .visibilityOf(linkTo.buttonSignIn);
        emailAccountPage
                .click(linkTo.buttonSignIn);
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage
                .visibilityOf(linkTo.newMessage);
        Assert.assertEquals(linkTo.expTitleNewMessage, driver.findElement(linkTo.newMessage).getText());
        personalCabinetPage
                .click(linkTo.newMessage);
        personalCabinetPage
                .checkRecoverPasswordButtonExist()
                .click(recoverPasswordButton);
        personalCabinetPage
                .manageMultipleWindows(2);
        RegainPasswordPage regainPasswordPage2 = new RegainPasswordPage(driver);
        regainPasswordPage2
                .visibilityOfTwo(password,againPassword);
        regainPasswordPage2
                .checkSubmitButtonExist();
        Assert.assertEquals(expAttribPass, driver.findElement(password).getAttribute("id"));
        Assert.assertEquals(expAtribAgainPass, driver.findElement(againPassword).getAttribute("id"));
  }
}
