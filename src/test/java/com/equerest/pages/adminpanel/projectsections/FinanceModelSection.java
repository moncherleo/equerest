package com.equerest.pages.adminpanel.projectsections;

import com.equerest.pages.adminpanel.SelectedProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by aBulgakoff on 9/21/16.
 */
public class FinanceModelSection extends SelectedProjectPage {
    private SelectedProjectPage parentPage;

    private final By applyChangesButton = By.xpath("");
    private final By discardChangesButton = By.xpath("");


    public FinanceModelSection(WebDriver driver, SelectedProjectPage selectedProjectPage) {
        super(driver);
        parentPage = selectedProjectPage;
    }


    public FinanceModelSection uploadFinancePlan(String path) {
        //TODO: implement upload functionality

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

    }


}
