package com.equerest.pages.common.main;

import com.equerest.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vladyslav Vlasov on 07.01.2017.
 */
public class CataloguePage extends AbstractPage {
    public CataloguePage(WebDriver driver) {
        super(driver);
    }

    public static final String pageURL = "https://dev.equerest.com/catalog#/";
    private By projectHeader = By.xpath("//*[@id='catalog']//h1[text()[contains(.,'Проекты')]]");

}
