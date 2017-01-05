package com.equerest.pages.common.investorpage;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.common.entrepreneurpage.EntrepreneurProjectPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vladyslav Vlasov on 05.01.2017.
 */
public class InvestorProjectsCataloguePage extends AbstractPage {
    public InvestorProjectsCataloguePage(WebDriver driver) {
        super(driver);
    }

    public static final String INVPROJCATALOGUEURL = "https://dev.equerest.com/catalog/index#/";

    public InvestorProjectsCataloguePage assertPageURL() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(wait.until(ExpectedConditions.urlMatches(INVPROJCATALOGUEURL)));
        return new InvestorProjectsCataloguePage(driver);
    }
}
