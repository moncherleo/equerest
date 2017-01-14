package com.equerest.pages.common.header;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.registration.EntrepreneurContactsPage;
import com.equerest.pages.common.registration.EntrepreneurRegistrationProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Eduard Aliiev on 10/21/16;
 */
public class EnterPage extends HomePage {
    public By submitProjectButton = By.cssSelector("a.button[href='/register#/entrepreneur']");

    public EnterPage(WebDriver driver) {
        super(driver);
    }

    public EntrepreneurContactsPage clickSubmitProject() {
        driver.findElement(submitProjectButton).click();
        return new EntrepreneurContactsPage(driver);
    }

}
