package com.equerest.pages.common.entrepreneurpage;

import com.equerest.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vladyslav Vlasov on 05.01.2017.
 */
public class EntrepreneurProjectPage extends AbstractPage{
    public EntrepreneurProjectPage (WebDriver driver){
        super(driver);
    }
    private By nameTitle = By.xpath("//*[@id='dashboard']//*[@ng-bind-html='$ctrl.post.projects.title']");

    public final static String ENTPAGEURL = "https://dev.equerest.com/dashboard#/projects/edit";

    public EntrepreneurProjectPage assertNameTitle(String titleToCompare){
        Assert.assertEquals(driver.findElement(nameTitle).getText(),titleToCompare);
        return new EntrepreneurProjectPage(driver);
    }
    public EntrepreneurProjectPage assertPageURL(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertTrue(wait.until(ExpectedConditions.urlMatches(ENTPAGEURL)));
        //Assert.assertEquals(ENTPAGEURL,driver.getCurrentUrl());
        return new EntrepreneurProjectPage(driver);
    }

}
