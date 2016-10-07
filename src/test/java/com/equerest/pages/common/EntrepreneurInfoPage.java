package com.equerest.pages.common;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.createproject.EntrepreneurContactsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg Nesterov on 10/7/16;
 */
public class EntrepreneurInfoPage extends AbstractPage {

    private By startEntrepreneurButton = By.xpath("//*[@id='banner']/div/div[2]//*[text()[contains(.,'Подать проект')]]");

    public EntrepreneurInfoPage(WebDriver driver) {
        super(driver);
    }

    public EntrepreneurContactsPage startEntrepreneurRegistration(){
        driver.findElement(startEntrepreneurButton).click();
        return new EntrepreneurContactsPage(driver);
    }

}
