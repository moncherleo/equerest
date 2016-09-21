package com.equerest.tests.webdriver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by cherleo on 9/19/16.
 */
public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        this.driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() { driver.close(); }


}
