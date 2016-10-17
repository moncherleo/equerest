package com.equerest.pages.common.registration;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.common.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mykhaylo Dmytrenko on 26.09.2016.
 */
public class InvestorRegistrationFinishPage extends AbstractPage {
    private By okButton = By.cssSelector(".button.button-white");
    private String thanksText = "Мы обязательно свяжемся с вами в течение 1 рабочего дня";

    public InvestorRegistrationFinishPage(WebDriver driver){super(driver);}

    public HomePage pressOk(){
        driver.findElement(okButton).click();
        return new HomePage(driver);
    }
}
