package com.equerest.pages.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Julia Zubets on 1/9/2017.
 */
public class InActivePage extends ProjectsPage {

    protected final By projectActiveButton = By.xpath("//*[@id='wrapper']/main//*[text()[contains(.,'Активные')]]");
    private final By projectSearchFieldActiveStatus = By.xpath(".//*[@id='searchActive']");
    private final By projectArchiveToModerationButton = By.xpath("//*[@id='wrapper']/main//*[text()[contains(.,'На модерацию')]]");

    public InActivePage(WebDriver driver) {super(driver);}

    public InActivePage restoreProjectFromActive(String projectName) {
        driver.findElement(projectActiveButton).click();
        driver.findElement(projectSearchFieldActiveStatus).sendKeys(projectName);
        driver.findElement(projectArchiveToModerationButton).click();
        return this;
    }
}
