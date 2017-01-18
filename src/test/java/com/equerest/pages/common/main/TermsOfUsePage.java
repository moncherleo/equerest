package com.equerest.pages.common.main;

import com.equerest.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vladyslav Vlasov on 18.01.2017.
 */
public class TermsOfUsePage extends AbstractPage {
    public TermsOfUsePage(WebDriver driver) {
        super(driver);
    }

    public static final String pageURL = "https://dev.equerest.com/info/terms";

    public TermsOfUsePage checkThatURLisCorrect() {
        try {
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);

            }
        } catch (Exception e) {
            System.out.println("fail");
        }
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe(pageURL));
        Assert.assertEquals(pageURL, driver.getCurrentUrl());
        return this;
    }
}
