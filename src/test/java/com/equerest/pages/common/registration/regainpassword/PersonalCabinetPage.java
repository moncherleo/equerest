package com.equerest.pages.common.registration.regainpassword;

import com.equerest.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dmitry Vanzhula on 1/8/17.
 */
public class PersonalCabinetPage extends AbstractPage {

    private By recoverPasswordButton = By.xpath(".//*/div[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/a");

    public PersonalCabinetPage(WebDriver driver){
     super(driver);
    }

    public PersonalCabinetPage checkRecoverPasswordButtonExist() {
        Assert.assertTrue(driver.findElement(recoverPasswordButton).isEnabled());
        return new PersonalCabinetPage(driver);
    }
}
