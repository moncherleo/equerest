package com.equerest.pages.common.registration.regainpassword;

import com.equerest.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dmitry Vanzhula on 1/8/17.
 */
public class EntranceToTheEmailAccountPage extends AbstractPage {

    private By email = By.xpath(".//*[@id='Email']");

    public EntranceToTheEmailAccountPage(WebDriver driver){
        super(driver);
    }

    public EntranceToTheEmailAccountPage checkMailExist() {
        Assert.assertTrue(driver.findElement(email).isEnabled());
        return new EntranceToTheEmailAccountPage(driver);
    }
}
