package com.equerest.tests.webdriver.common.footer;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.footer.*;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 11/4/16;
 */
@Title("Проверка контролов на Главной странице сайта в \"Нижний колонтитул\"")
@Description("Проверка кликабельности кнопок на Главной странице сайта в \"Нижний колонтитул\"")
public class FooterClickableElementsTest extends BaseTest {

    @Test
    @Title("Проверка кликабельности кнопки 'Инвестору'")
    public void InvestorInfoFooterClickButton(){
        HomePage clickButton = new InvestInfoFooterPage(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='footer']//*[text()[contains(.,'©')]]")).isEnabled());
        clickButton
                .investorInfoFooterButton()
                .worthItFooterLogoButton();
    }
    @Test
    @Title("Проверка кликабельности кнопки 'Пропекты'")
    public void ProjectsInfoFooterClickButton(){
        HomePage clickButton = new PostProjectInfoFooterPage(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='footer']//*[text()[contains(.,'©')]]")).isEnabled());
    clickButton
            .projectsInfoFooterButton()
            .worthItFooterLogoButton();
    }
    @Test
    @Title("Проверка кликабельности кнопки 'Инвестировать'")
    public void InvestInfoFooterClickButton(){
        HomePage clickButton = new InvestInfoFooterPage(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='footer']//*[text()[contains(.,'©')]]")).isEnabled());
        clickButton
                .investInfoFooterButton()
                .worthItFooterLogoButton();
    }
    @Test
    @Title("Проверка кликабельности кнопки 'Предпринимателю'")
    public void IentrepreneurInfoFooterClickButton(){
        HomePage clickButton = new IentrepreneurInfoFooterPage(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='footer']//*[text()[contains(.,'©')]]")).isEnabled());
        clickButton
                .ientrepreneurInfoFooterButton()
                .worthItFooterLogoButton();
    }
    @Test
    @Title("Проверка кликабельности кнопки 'Миссия'")
    public void PostProjectInfoFooterClickButton(){
        HomePage clickButton = new PostProjectInfoFooterPage(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='footer']//*[text()[contains(.,'©')]]")).isEnabled());
        clickButton
                .postProjectInfoFooterButton()
                .worthItFooterLogoButton();
    }
    @Test
    @Title("Проверка кликабельности кнопки 'Подать проект'")
    public void MissionInfoFooterClickButton(){
        HomePage clickButton = new MissionInfoFooterPage(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='footer']//*[text()[contains(.,'©')]]")).isEnabled());
        clickButton
                .missionInfoFooterButton()
                .worthItFooterLogoButton();
    }
    @Test
    @Title("Проверка кликабельности кнопки 'Контакты'")
    public void ContactsInfoFooterClickButton(){
        HomePage clickButton = new ContactsInfoFooterPage(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='footer']//*[text()[contains(.,'©')]]")).isEnabled());
        clickButton
                .contactsInfoFooterButton()
                .worthItFooterLogoButton();
    }
    @Test
    @Title("Проверка кликабельности кнопки 'Правила пользования'")
    public void TermsOfUseInfoFooterClickButton(){
        HomePage clickButton = new TermsOfUseInfoFooterPage(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='footer']//*[text()[contains(.,'©')]]")).isEnabled());
        clickButton
                .termsOfUseInfoFooterButton()
                .worthItFooterLogoButton();
    }
    @Test
    @Title("Проверка кликабельности кнопки 'Политика конфиденциальности'")
    public void PrivacyPolicyInfoFooterClickButton(){
        HomePage clickButton = new PrivacyPolicyInfoFooterPage(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='footer']//*[text()[contains(.,'©')]]")).isEnabled());
        clickButton
                .privacyPolicyInfoFooterButton()
                .worthItFooterLogoButton();
    }
    @Test
    @Title("Проверка кликабельности кнопки 'Политика обработки cookies'")
    public void CookiesProcessingPolicyInfoFooterClickButton(){
        HomePage clickButton = new PrivacyPolicyInfoFooterPage(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='footer']//*[text()[contains(.,'©')]]")).isEnabled());
        clickButton
                .cookiesProcessingPolicyInfoFooterButton()
                .worthItFooterLogoButton();
    }
}
