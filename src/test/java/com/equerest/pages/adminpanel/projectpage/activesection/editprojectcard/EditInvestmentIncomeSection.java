package com.equerest.pages.adminpanel.projectpage.activesection.editprojectcard;

import com.equerest.pages.adminpanel.projectpage.activesection.EditActiveProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Eduard Aliiev on 9/24/16;
 */
public class EditInvestmentIncomeSection extends EditActiveProjectPage implements CommonProjectActionSectionStructure {
    private EditActiveProjectPage parentPage;
    private final By quickEditorFirstField = By.cssSelector("#roi1");
    private final By quickEditorSecondField = By.cssSelector("#roi2");
    private final By InvestIncomeCheckBoxForCheckIfSelected = By.xpath("//*[@class=\"input-checkbox\"]//input[@type='checkbox']");
    private final By InvestIncomeCheckBoxForClick = By.xpath("//*[@class=\"input-checkbox\"]");

    private final By applyChangesButton = By.xpath(".//*[@id='dashboard']/div[1]/project-edit/div/div/section[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div[3]/div[5]/button[2]");
    private final By discardChangesButton = By.xpath(".//*[@id='dashboard']/div[1]/project-edit/div/div/section[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div[3]/div[5]/button[1]");

    public EditInvestmentIncomeSection(WebDriver driver, EditActiveProjectPage editActiveProjectPage) {
        super(driver);
        parentPage = editActiveProjectPage;
    }

    public EditInvestmentIncomeSection editInvestmentIncome(String firstField, String secondField) {
        if ( driver.findElement(InvestIncomeCheckBoxForCheckIfSelected).isSelected() )
    {
        driver.findElement(InvestIncomeCheckBoxForClick).click();
    }

        driver.findElement(quickEditorFirstField).clear();
        driver.findElement(quickEditorFirstField).sendKeys(firstField);
        driver.findElement(quickEditorFirstField).click();

        driver.findElement(quickEditorSecondField).clear();
        driver.findElement(quickEditorSecondField).sendKeys(secondField);
        driver.findElement(quickEditorSecondField).click();

        return this;
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
