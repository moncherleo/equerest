package com.equerest.pages.adminpanel.projectpage.activesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Eduard Aliiev on 9/24/16;
 */

public class EditActiveProjectPage extends ProjectsPage {

    //locator: in the "Инвестиционный доход" section is edited values.
    private final By infoInvestmentIncomeEditButton = By.cssSelector(".project-roi>div>button.edit-btn");
    private final By quickEditorFirstField = By.cssSelector("#roi1");
    private final By quickEditorSecondField = By.cssSelector("#roi2");

    //locator: "Применить" button
    protected final By editorInputAreaWindows = By.xpath("//*[@id='wrapper']/main/div/div/div/section[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div[3]//*[text()[contains(.,'Применить')]]");
    //locator: Alert massage "Проект сохранен" locator
    protected final By projectSavedAlert = By.xpath("//*[@id='toast-container']//*[text()[contains(.,'Проект сохранен')]]");


    public EditActiveProjectPage(WebDriver driver) {
        super(driver);
    }

    //"Применить" button
   /* public EditActiveProjectPage verifyEditWindowNotPresentActiveSection(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(editorInputAreaWindows)));
        return this;
    }*/

    //Alert massage "Проект сохранен"
    public EditActiveProjectPage verifyProjectSavedAlertDisplayedActiveSection(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(projectSavedAlert)));
        return this;
    }

    public EditActiveProjectPage investmentIncomeInProject(){
        driver.findElement(infoInvestmentIncomeEditButton).click();

        driver.findElement(quickEditorFirstField).clear();
        driver.findElement(quickEditorFirstField).sendKeys("30");
        driver.findElement(quickEditorFirstField).click();

        driver.findElement(quickEditorSecondField).clear();
        driver.findElement(quickEditorSecondField).sendKeys("200");
        driver.findElement(quickEditorSecondField).click();
        driver.findElement(editorInputAreaWindows).click();
        return new EditActiveProjectPage(driver);
    }

}
