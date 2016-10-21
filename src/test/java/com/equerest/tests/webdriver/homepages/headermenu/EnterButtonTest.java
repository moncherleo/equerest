package com.equerest.tests.webdriver.homepages.headermenu;


import com.equerest.pages.homepage.HomePage;
import com.equerest.pages.homepage.headermenu.EnterButton;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 10/16/16;
 */
@Title("C126 Проверка контролов Хедер меню")
@Description("Проверка кликабельности кнопок 'Хедер' меню на главной странице сайта")
public class EnterButtonTest extends BaseTest {

    @Test
    @Title("Проверка кликабельности кнопки 'Войти'")
    public void enterSectionButton() {
        HomePage clickButton = new EnterButton(driver);
        clickButton
                .enterButton()
                .equerestLogoButton();

    }

}
