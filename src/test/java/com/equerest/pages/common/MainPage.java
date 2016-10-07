package com.equerest.pages.common;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.createproject.EntrepreneurContactsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by cherleo on 9/19/16.
 */
public class MainPage extends AbstractPage {
    private String url;
    private static final String LOGIN_PAGE_URL = "register#/";
    private By forInvestor = By.xpath("//*[@id='header']//*[text()='Инвестору                                ']");
    private By registerProjectButton = By.cssSelector("#main .button-green.bordered");
    private By forEntrepreneur = By.xpath("//*[@id='header']//*[text()[contains(.,'Предпринимателю')]]");

    public MainPage(String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }
    @Step("Open home page")
    public MainPage open(){
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
        open();
        return navigateToLoginPage();
    }

    public InvestorInfoPage navigateToInfoInvestorPage(){
        open();
        driver.findElement(forInvestor).click();
        return new InvestorInfoPage(driver);
    }

    public InvestorInfoPage openInfoInvestorPage() {
        open();
        return navigateToInfoInvestorPage();
    }

    public EntrepreneurContactsPage openRegisterProjectPage(){
        open();
        driver.findElement(registerProjectButton).click();
        return new EntrepreneurContactsPage(driver);
    }

    public EntrepreneurInfoPage navigateToEntrepreneurInfoPage(){
        open();
        driver.findElement(forEntrepreneur).click();
        return new com.equerest.pages.common.EntrepreneurInfoPage(driver);
    }



}
