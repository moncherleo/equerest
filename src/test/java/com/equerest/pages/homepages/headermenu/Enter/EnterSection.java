package com.equerest.pages.homepages.headermenu.Enter;

import com.equerest.pages.homepages.headermenu.TheElementsHeaderMenuAreCheckedClickability;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Eduard Aliiev on 10/16/16;
 */
public class EnterSection extends TheElementsHeaderMenuAreCheckedClickability {

    //the general locator of the equerestLogo
    private final By equerestLogo = By.xpath("/html/body/div[1]/header/div/nav/div[1]/div[1]//img[contains(@src, 'header_logo.svg')]");

    public EnterSection(WebDriver driver) {
        super(driver);
    }

    public EnterSection enterSectionButton() {
        driver.findElement(equerestLogo).click();
        Assert.assertTrue(driver.findElement(equerestLogo).isEnabled());
        return this;
    }

}
