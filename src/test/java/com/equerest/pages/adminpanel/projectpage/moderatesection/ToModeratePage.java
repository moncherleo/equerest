package com.equerest.pages.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Oleg Nesterov on 24.09.2016;
 */

public class ToModeratePage extends ProjectsPage {

    //added project-card to "На Модерацию" button
    protected final By ProjectToModerationButton = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[3]/button[2]");
    protected final By projectSavedAlert = By.xpath("//*[@id='toast-container']//*[text()[contains(.,'Проект обновлен.')]]");
    protected final By filterNewButton = By.xpath("//*[@class='projects-list container ng-isolate-scope']//div[1]//*[text()='Новые']");

    public ToModeratePage(WebDriver driver) {
        super(driver);
    }

    // Alert massage "Проект сохранен"
    public ToModeratePage verifyProjectSavedAlertDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(projectSavedAlert)));
        return this;
    }

    //added project-card to "На Модерацию" button
    public ToModeratePage projectToModerate(){
        driver.findElement(ProjectToModerationButton).click();
        return this;

    }
}

