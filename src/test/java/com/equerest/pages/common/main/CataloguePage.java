package com.equerest.pages.common.main;

import com.equerest.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Vladyslav Vlasov on 07.01.2017.
 */
public class CataloguePage extends AbstractPage {
    public CataloguePage(WebDriver driver) {
        super(driver);
    }

    public static final String pageURL = "https://dev.equerest.com/catalog#/";
    private By projectHeader = By.xpath("//*[@id='catalog']//h1[text()[contains(.,'Проекты')]]");
    private By filter =By.className("catalog-filter");
    public By filterProjects = By.id("filter-selector");
    public By filterStage = By.id("filter-stage");
    public By pageNumber = By.cssSelector("a[ng-click='setCurrent(pageNumber)']");
    public By projectStatus = By.cssSelector("div.status>span.ng-binding");

    public CataloguePage checkNumberofProjectsShown(int expectedNumberOfProjects){
        List<WebElement> listOfElements = driver.findElements(By.xpath(".//*[@id='catalog-feed']//project-card"));
        Assert.assertEquals(expectedNumberOfProjects, listOfElements.size());
        return this;
    }
    public CataloguePage checkFilterPresence(){
        WebElement pageFilter = driver.findElement(filter);
        Assert.assertTrue(pageFilter.isDisplayed());
        return this;
    }

    public int getNumberOfPages() {
        List<WebElement> pages = driver.findElements(pageNumber);
        return pages.size();
    }

    public CataloguePage checkFilteredProjectsOnPage(By locatorOfElement, String elementText) {
        List<WebElement> elements = driver.findElements(locatorOfElement);
        boolean isRight = true;
        if (elements.size() > 0) {
            for (int i = 0; i < elements.size(); i++) {
                Assert.assertEquals(elements.get(i).getAttribute("value"), elementText);
            }
        }
        return this;
    }

    public CataloguePage setDropdownOption(By dropdownElement, String visibleText) {
        Select dropdown = new Select(driver.findElement(dropdownElement));
        dropdown.selectByVisibleText(visibleText);
        return this;
    }

}
