package com.equerest.pages.common.header;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.registration.EntrepreneurContactsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg Nesterov on 10/7/16;
 */
public class EntrepreneurInfoPage extends HomePage {

    private By startEntrepreneurButton = By.xpath("//*[@id='banner']/div/div[2]//*[text()[contains(.,'Подать проект')]]");

    public EntrepreneurInfoPage(WebDriver driver){super(BASE_URL + "info/entrepreneur", driver);}

    public EntrepreneurContactsPage startEntrepreneurRegistration(){
        driver.findElement(startEntrepreneurButton).click();
        return new EntrepreneurContactsPage(driver);
    }

}
