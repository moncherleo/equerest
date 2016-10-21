package com.equerest.tests.webdriver.common;


import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.registration.EntrepreneurContactsPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 10/20/16;
 */
@Title("C129 Проверка контролов на Главной странице сайта в \"Область ключевых цифр\"")
@Description("Проверка кликабельности кнопок на Главной странице сайта в \"Область ключевых цифр\"")
public class EntrepreneurContactsPageTest extends BaseTest {

    @Test
    @Title("Проверка кликабельности кнопки 'Подать проект'")
    public void entrepreneurContactsClickButton(){
        HomePage clickButton = new EntrepreneurContactsPage(driver);
        clickButton
                    .openRegisterProjectPage()
                    .equerestLogoButton();
    }



}
