package com.equerest.pages.homepages.bannermenu;

import com.equerest.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Eduard Aliiev on 10/20/16;
 */
public class BannerMenu extends AbstractPage {
    //Локаторы двух элементов ('Подать проект' и 'Как мы работаем?'), которые находятся в данном разделе.
    private final By PostProjectButton = By.xpath("//*[@id='banner']//a[text()[contains(.,'Подать проект')]]");
    private final By HowWeAreWorkingButton = By.xpath(".//*[@id='banner']//a[text()[contains(.,'Как мы работаем?')]]");
    private final By equerestLogo = By.xpath("/html/body/div[1]/header/div/nav/div[1]/div[1]//img[contains(@src, 'header_logo.svg')]");

    public BannerMenu(WebDriver driver) {
        super(driver);
    }
    //the general LOGO of the Equerest
    public EquerestLogoButton equerestLogoButton() {
        driver.findElement(equerestLogo).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#banner .h1[class='h1']")).isEnabled());
        return new EquerestLogoButton(driver);
    }

    public PostProjectButton postProjectButton() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#banner .h1[class='h1']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.cssSelector("#banner .h3[class='h3']")).isEnabled());
        driver.findElement(PostProjectButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='entrepreneur-register-form']//h1[text()[contains(.,'Регистрация вашего бизнес-проекта')]]")).isEnabled());
        return new PostProjectButton(driver);
    }

    public HowWeAreWorkingButton howWeAreWorkingButton() {
        driver.findElement(HowWeAreWorkingButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='banner']//h1[text()[contains(.,'Найдем инвестора для вашего бизнеса')]]")).isEnabled());
        return new HowWeAreWorkingButton(driver);
    }

}
