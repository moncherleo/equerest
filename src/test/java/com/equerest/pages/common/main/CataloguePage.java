package com.equerest.pages.common.main;

import com.equerest.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public CataloguePage checkNumberofProjectsShown(int expectedNumberOfProjects){
        List<WebElement> listOfElements = driver.findElements(By.xpath(".//*[@id='catalog-feed']//project-card"));
        Assert.assertEquals(expectedNumberOfProjects, listOfElements.size());
        return this;
    }
}
