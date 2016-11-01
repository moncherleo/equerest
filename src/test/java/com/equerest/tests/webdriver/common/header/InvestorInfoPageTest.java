package com.equerest.tests.webdriver.common;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.header.InvestorInfoPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 10/17/16;
 */
@Title("C126 Проверка контролов Хедер меню")
@Description("Проверка кликабельности кнопок 'Хедер' меню на главной странице сайта")
public class InvestorInfoPageTest extends BaseTest{
    @Test
    @Title("Проверка кликабельности кнопки 'Инвестору'")
    public void investorSectionButton() {
        HomePage clickButton = new InvestorInfoPage(driver);
        clickButton
                .navigateToInfoInvestorPage()
                .equerestLogoButton();
    }

}
