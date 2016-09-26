package com.equerest.pages.common.registration;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.common.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mykhaylo Dmytrenko on 26.09.2016.
 */
public class FinishPage extends AbstractPage {
    private By okButton = By.cssSelector(".button.button-white");
    private String thanksText = "Мы обязательно свяжемся с вами в течение 1 рабочего дня";

    public FinishPage(WebDriver driver){super(driver);}

    public MainPage pressOk(){
        driver.findElement(okButton).click();
        return new MainPage("https://dev.equerest.com/", driver);
    }
}
