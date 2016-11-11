package com.equerest.pages.adminpanel.projectpage.activesection.editprojectcard;

import com.equerest.pages.adminpanel.projectpage.activesection.EditActiveProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Eduard Aliiev on 9/24/16;
 */
public class EditInvestmentIncomeSection extends EditActiveProjectPage implements CommonProjectActionSectionStructure {
    private EditActiveProjectPage parentPage;

    private final By applyChangesButton = By.xpath("//*[@id='wrapper']/main//*[text()[contains(.,'Применить')]]");
    private final By discardChangesButton = By.xpath("//*[@id='wrapper']/main//*[text()[contains(.,'Отмена')]]");

    public EditInvestmentIncomeSection(WebDriver driver, EditActiveProjectPage editActiveProjectPage) {
        super(driver);
        parentPage = editActiveProjectPage;

    }

    @Override
    public EditActiveProjectPage applyChanges() {
        scrollPage();
        driver.findElement(applyChangesButton).click();
        return parentPage;
    }

    @Override
    public EditActiveProjectPage discardChanges() {
        scrollPage();
        driver.findElement(discardChangesButton).click();
        return parentPage;
    }

    private void scrollPage() {
    }
}
