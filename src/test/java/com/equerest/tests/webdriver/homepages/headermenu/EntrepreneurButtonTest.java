package com.equerest.tests.webdriver.homepages.headermenu;

import com.equerest.pages.homepage.HomePage;
import com.equerest.pages.homepage.headermenu.EntrepreneurButton;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 10/17/16;
 */
@Title("C126 Проверка контролов Хедер меню")
@Description("Проверка кликабельности кнопок 'Хедер' меню на главной странице сайта")
public class EntrepreneurButtonTest extends BaseTest{
    @Test
    @Title("Проверка кликабельности кнопки 'Предпринимателю'")
    public void entrepreneurSectionButton() {
        HomePage clickButton = new EntrepreneurButton(driver);
        clickButton
                .entrepreneurButton()
                .equerestLogoButton();
    }

}
