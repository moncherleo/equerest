package com.equerest.tests.webdriver.common.main;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.main.HowWeAreWorkingContactsPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 10/20/16;
 */
@Title("C129 Проверка контролов на Главной странице сайта в \"Область ключевых цифр\"")
@Description("Проверка кликабельности кнопок на Главной странице сайта в \"Область ключевых цифр\"")
public class HowWeAreWorkingContactsPageTest extends BaseTest {

    @Test
    @Title("Проверка кликабельности кнопки 'Как мы работаем?'")
    public void HowWeAreWorkingClickButton() {
        HomePage clickButton = new HowWeAreWorkingContactsPage(driver);
        clickButton
                .howWeAreWorkingButton()
                .equerestLogoButton();
    }
}
