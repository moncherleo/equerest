package com.equerest.pages.adminpanel.projectpage.activesection.editprojectcard;

import com.equerest.pages.adminpanel.projectpage.activesection.EditActiveProjectPage;
import com.equerest.pages.common.registration.InvestorRegistrationInvestmentsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
    private final By applyChangesButtonWhenCheckBoxChecked = By.xpath(".//*[@id='dashboard']/div[1]/project-edit/div/div/section[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div/div[5]/button[2]");
    private final By discardChangesButton = By.xpath(".//*[@id='dashboard']/div[1]/project-edit/div/div/section[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div[3]/div[5]/button[1]");

    //locators for disabled fields when notSpecifyInvestmentIncome CheckBox checked
    public static By investmentIncomeTwoYearsDisabled = By.xpath(".//div[@class='input-text-group']//*[@id='roi1'][@class[contains(.,'disabled')]]");
    public static By investmentIncomeFourYearsDisabled = By.xpath(".//div[@class='input-text-group']//*[@id='roi2'][@class[contains(.,'disabled')]]");

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

    public EditInvestmentIncomeSection setNotSpecifyInvestmentIncomeCheckBox() {
        if ( !driver.findElement(InvestIncomeCheckBoxForCheckIfSelected).isSelected() )
        {
            driver.findElement(InvestIncomeCheckBoxForClick).click();
        }
        return this;
    }

    @Override
    public EditActiveProjectPage applyChanges() {
        scrollPage();
        driver.findElement(applyChangesButton).click();
        return parentPage;
    }

     public EditActiveProjectPage applyChangesForCheckedCheckBox() {
        scrollPage();
        driver.findElement(applyChangesButtonWhenCheckBoxChecked).click();
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

    public EditInvestmentIncomeSection checkFieldDisabled(By fieldName) {
        Assert.assertTrue(driver.findElement(fieldName).isDisplayed());
            return this;
        }
    }

