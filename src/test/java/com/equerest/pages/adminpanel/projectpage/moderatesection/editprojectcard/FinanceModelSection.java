package com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard;

import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by aBulgakoff on 9/21/16.
 */
public class FinanceModelSection extends EditProjectPage implements CommonProjectSectionStructure{
    private EditProjectPage parentPage;

    private final By applyChangesButton = By.xpath("");
    private final By discardChangesButton = By.xpath("");


    public FinanceModelSection(WebDriver driver, EditProjectPage editProjectPage) {
        super(driver);
        parentPage = editProjectPage;
    }


    public FinanceModelSection uploadFinancePlan(String path) {
        //TODO: implement upload functionality

        return this;
    }

    @Override
    public EditProjectPage applyChanges() {
        scrollPage();
        driver.findElement(applyChangesButton).click();
        return parentPage;
    }

    @Override
    public EditProjectPage discardChanges() {
        scrollPage();
        driver.findElement(discardChangesButton).click();
        return parentPage;
    }

    private void scrollPage() {

    }


}
