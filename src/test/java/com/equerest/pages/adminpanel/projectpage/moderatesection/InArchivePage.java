package com.equerest.pages.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Eduard Aliiev on 9/23/16;
 */

public class InArchivePage extends ProjectsPage {

    //added project-card at "В архив" button
    protected final By projectInArchiveButton = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[3]//*[text()[contains(.,'В архив')]]");
    protected final By projectSavedAlert = By.xpath("//*[@id='toast-container']//*[text()[contains(.,'Проект обновлен.')]]");

    public InArchivePage(WebDriver driver) {
        super(driver);
    }

    // Alert massage "Проект сохранен"
    public InArchivePage verifyProjectSavedAlertDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(projectSavedAlert)));
        return this;
    }

    //added project-card at "В архив" button
    public InArchivePage addedProjectInArchive(){
        driver.findElement(projectInArchiveButton).click();
        return this;

    }
}

