package com.equerest.pages.common;

import com.equerest.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by cherleo on 9/19/16.
 */
public class MainPage extends AbstractPage {
    private String url;
    private static final String LOGIN_PAGE_URL = "register#/";
    private By forInvestor = By.xpath("//*[@id='header']//*[text()='Инвестору']");

    public MainPage(String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }

    public MainPage open(){
        driver.navigate().to(url);
        return this;
    }

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
}
