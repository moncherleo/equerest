package com.equerest.tests.webdriver.homepages.bannermenu;

import com.equerest.pages.homepage.HomePage;
import com.equerest.pages.homepage.bannermenu.PostProjectButton;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 10/20/16;
 */
@Title("C129 Проверка контролов на Главной странице сайта в \"Область ключевых цифр\"")
@Description("Проверка кликабельности кнопок на Главной странице сайта в \"Область ключевых цифр\"")
public class PostProjectButtonTest extends BaseTest {

    @Test
    @Title("Проверка кликабельности кнопки 'Подать проект'")
    public void postProjectClickButton(){
        HomePage clickButton = new PostProjectButton(driver);
        clickButton
                    .postProjectButton()
                    .equerestLogoButton();
    }

}
