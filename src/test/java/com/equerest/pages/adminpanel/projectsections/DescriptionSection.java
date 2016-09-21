package com.equerest.pages.adminpanel.projectsections;

import com.equerest.pages.adminpanel.SelectedProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by aBulgakoff on 9/21/16.
 */
public class DescriptionSection extends SelectedProjectPage {
    private SelectedProjectPage parentPage;

    private final By textField = By.id("tmpFull_description");
    private final By applyChangesButton = By.xpath("html/body/div[1]/main/div/div/div/section[2]/div[2]/div[2]/div/div[2]/h3/div/button[2]");
    private final By discardChangesButton = By.xpath("html/body/div[1]/main/div/div/div/section[2]/div[2]/div[2]/div/div[2]/h3/div/button[1]");

    public DescriptionSection(WebDriver driver, SelectedProjectPage selectedProjectPage) {
        super(driver);
        parentPage = selectedProjectPage;
    }

    public DescriptionSection editText(String description) {
        driver.findElement(textField).click();
        driver.findElement(textField).clear();
        driver.findElement(textField).sendKeys(description);
        return this;
    }

    public SelectedProjectPage applyChanges() {
        scrollPage();
        driver.findElement(applyChangesButton).click();
        return parentPage;
    }

    public SelectedProjectPage discardChanges() {
        scrollPage();
        driver.findElement(discardChangesButton).click();
        return parentPage;
    }

    private void scrollPage() {
        actions.moveToElement(driver.findElement(saveProjectButton)).perform();
        actions.moveToElement(driver.findElement(addNumbersLink)).perform();

    }
}
