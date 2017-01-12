package com.equerest.pages.adminpanel.projectpage.activesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.activesection.editprojectcard.EditInvestmentIncomeSection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Eduard Aliiev on 9/24/16;
 */

public class EditActiveProjectPage extends ProjectsPage {

    //locator: for the "Инвестиционный доход" section on EditProjectPage.
    private final By investmentIncomeTwoYears = By.xpath(".//*[@ng-bind-html=\"$ctrl.post.projects.roi.r1\"]");
    private final By investmentIncomeFourYears = By.xpath(".//*[@ng-bind-html=\"$ctrl.post.projects.roi.r2\"]");

    //locator: in the "Инвестиционный доход" section is edited values.
    private final By infoInvestmentIncomeEditButton = By.cssSelector(".project-roi>div>button.edit-btn");

    //locator: Alert massage "Проект сохранен" locator
    protected final By projectSavedAlert = By.xpath("//*[@id='toast-container']//*[text()[contains(.,'Проект сохранен')]]");


    public EditActiveProjectPage(WebDriver driver) {
        super(driver);
    }

    //Alert massage "Проект сохранен"
    public EditActiveProjectPage verifyProjectSavedAlertDisplayedActiveSection(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(projectSavedAlert)));
        return this;
    }

    public boolean isAlertPresent() {
        try {
            new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOf(driver.findElement(projectSavedAlert)));
            return true;
        } catch (NoSuchElementException e) {
        return false;
        }
    }

    public EditInvestmentIncomeSection clickOnInvestmentIncome() {
        driver.findElement(infoInvestmentIncomeEditButton).click();
        return new EditInvestmentIncomeSection(driver, this);
    }


    public void chekDataAfterDiscard() {
        Assert.assertEquals(driver.findElement(investmentIncomeTwoYears).getText(), "30");
        Assert.assertEquals(driver.findElement(investmentIncomeFourYears).getText(), "200");
    }
}
