package com.equerest.pages.homepages.headermenu.Mission;

import com.equerest.pages.homepages.headermenu.HeaderMenu;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Eduard Aliiev on 10/16/16;
 */
public class MissionSection extends HeaderMenu {

    //the general locator of the equerestLogo
    private final By equerestLogo = By.xpath("/html/body/div[1]/header/div/nav/div[1]/div[1]//img[contains(@src, 'header_logo.svg')]");

    public MissionSection(WebDriver driver) {
        super(driver);
    }

    public MissionSection missionSectionButton() {
        driver.findElement(equerestLogo).click();
        Assert.assertTrue(driver.findElement(equerestLogo).isEnabled());
        return this;
    }

}
