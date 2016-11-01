package com.equerest.tests.webdriver.common.header;


import com.equerest.pages.common.header.EnterPage;
import com.equerest.pages.common.HomePage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 10/16/16;
 */
@Title("C126 Проверка контролов Хедер меню")
@Description("Проверка кликабельности кнопок 'Хедер' меню на главной странице сайта")
public class EnterPageTest extends BaseTest {
    @Test
    @Title("Проверка кликабельности кнопки 'Войти'")
    public void enterSectionButton() {
        HomePage clickButton = new EnterPage(driver);
        clickButton
                .enterButton()
                .equerestLogoButton();
    }

}
