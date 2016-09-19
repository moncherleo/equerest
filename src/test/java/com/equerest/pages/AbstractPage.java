package com.equerest.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by cherleo on 9/19/16.
 */
public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }


}
