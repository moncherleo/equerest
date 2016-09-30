package com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard;

import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Eduard Aliiev on 9/23/16;
 */
public class UploadVideoSelection extends EditProjectPage implements CommonProjectSectionStructure {
    private EditProjectPage parentPage;

    private final By applyChangesButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[1]/div[2]/div/div[3]/div/div[1]/div[3]/div/div/label/../*[text()[contains(.,'Применить')]]");
    private final By discardChangesButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[1]/div[2]/div/div[3]/div/div[1]/div[3]/div/div/label/../*[text()[contains(.,'Отмена')]]");


    public UploadVideoSelection(WebDriver driver, EditProjectPage editProjectPage) {
        super(driver);
        parentPage = editProjectPage;
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
