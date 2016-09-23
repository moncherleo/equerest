package com.equerest.pages.adminpanel.projectpage.projectsections;

import com.equerest.pages.adminpanel.projectpage.EditProjectPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Eduard Aliiev on 9/23/16;
 */
public class UploadVideoSelection extends EditProjectPage {
//        implements CommonProjectSectionStructure{
    private EditProjectPage parentPage;

   /* private final By applyChangesButton = By.xpath("");
    private final By discardChangesButton = By.xpath("");*/


    public UploadVideoSelection(WebDriver driver, EditProjectPage editProjectPage) {
        super(driver);
        parentPage = editProjectPage;
    }


   /* @Override
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
    }*/
}
