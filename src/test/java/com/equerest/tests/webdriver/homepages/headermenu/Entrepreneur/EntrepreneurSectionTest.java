package com.equerest.tests.webdriver.homepages.headermenu.Entrepreneur;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.homepages.headermenu.Entrepreneur.EntrepreneurSection;
import com.equerest.pages.homepages.headermenu.HeaderMenu;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 10/17/16;
 */
@Title("C126 Проверка контролов Хедер меню")
@Description("Проверка кликабельности кнопок 'Хедер' меню на главной странице сайта")
public class EntrepreneurSectionTest extends BaseTest{
    @Test
    @Title("Проверка кликабельности кнопки 'Предпринимателю'")
    public void entrepreneurSectionButton() {
        HeaderMenu clickButton = new EntrepreneurSection(driver);
        clickButton
                .entrepreneurSection()
                .entrepreneurSectionButton();
    }

}
