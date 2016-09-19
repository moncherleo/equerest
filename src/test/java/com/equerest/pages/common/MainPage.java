package com.equerest.pages.common;

import com.equerest.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import sun.applet.Main;

/**
 * Created by cherleo on 9/19/16.
 */
public class MainPage extends AbstractPage {
    private String url;
    private static final String LOGIN_PAGE_URL = "register#/";

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
}
