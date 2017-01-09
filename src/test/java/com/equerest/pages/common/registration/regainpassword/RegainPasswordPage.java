package com.equerest.pages.common.registration.regainpassword;

import com.equerest.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Dmitry Vanzhula on 1/8/17.
 */
public class RegainPasswordPage extends AbstractPage {

    private By submitButtonFirstStep = By.xpath(".//*[@id='submit-block']/button");
    private By goToMailButton = By.xpath(".//*[@id='goToMailLink']");
    private By submitButtonLastStep = By.xpath(".//*[@id='submit-block']");

    public RegainPasswordPage(WebDriver driver){
        super(driver);
    }

    public RegainPasswordPage clickSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonFirstStep));
        WebElement button = driver.findElement(submitButtonFirstStep);
        button.click();
        return new RegainPasswordPage(driver);
    }

    public RegainPasswordPage clickGoToMailButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(goToMailButton));
        WebElement button = driver.findElement(goToMailButton);
        button.click();
        return new RegainPasswordPage(driver);
    }

    public RegainPasswordPage checkGoToMailButtonExist() {
        Assert.assertTrue(driver.findElement(goToMailButton).isEnabled());
        return new RegainPasswordPage(driver);
    }

    public RegainPasswordPage checkSubmitButtonExist() {
        Assert.assertTrue(driver.findElement(submitButtonLastStep).isEnabled());
        return new RegainPasswordPage(driver);
    }
}
