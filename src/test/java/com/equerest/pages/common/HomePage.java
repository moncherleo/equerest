package com.equerest.pages.common;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.common.registration.EntrepreneurContactsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by cherleo on 9/19/16.
 */
public class HomePage extends AbstractPage {
    private String url;
    private static final String LOGIN_PAGE_URL = "register#/";
    private By forInvestor = By.xpath("//*[@id='header']//*[text()='Инвестору                                ']");
    private By registerProjectButton = By.cssSelector("#main .button-green.bordered");
    private By forEntrepreneur = By.xpath("//*[@id='header']//*[text()[contains(.,'Предпринимателю')]]");

    public HomePage(String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }

    public HomePage(WebDriver driver) {
        super(driver);
        this.url = "https://dev.equerest.com/";
    }

    @Step("Open home page")
    public HomePage open(){
        driver.navigate().to(url);
        return this;
    }
    @Step("Navigate to login page")
    public LoginPage navigateToLoginPage(){
        driver.navigate().to(url+LOGIN_PAGE_URL);
        return new LoginPage(driver);
    }

    /** Method consolidate actions needed for typical flow of opening login page*/
    public LoginPage openLoginPage(){
        return navigateToLoginPage();
    }

    public InvestorInfoPage navigateToInfoInvestorPage(){
        driver.findElement(forInvestor).click();
        return new InvestorInfoPage(driver);
    }

    public InvestorInfoPage openInfoInvestorPage() {
        return navigateToInfoInvestorPage();
    }

    public EntrepreneurContactsPage openRegisterProjectPage(){
        driver.findElement(registerProjectButton).click();
        return new EntrepreneurContactsPage(driver);
    }

    public EntrepreneurInfoPage navigateToEntrepreneurInfoPage(){
        driver.findElement(forEntrepreneur).click();
        return new com.equerest.pages.common.EntrepreneurInfoPage(driver);
    }



}
