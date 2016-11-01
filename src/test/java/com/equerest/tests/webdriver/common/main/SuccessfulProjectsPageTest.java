package com.equerest.tests.webdriver.common.main;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.main.SuccessfulProjectsPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 11/1/16;
 */
@Title("Проверка контролов на Главной странице сайта в \"Успешные проекты\"")
@Description("Проверка кликабельности кнопок на Главной странице сайта в \"Успешные проекты\"")
public class SuccessfulProjectsPageTest extends BaseTest {
    @Test
    @Title("Проверка кликабельности кнопок \"Больше успешных проектов\"")
    public void moreSuccessfulProjectsClickButton(){
        HomePage clickButton = new SuccessfulProjectsPage(driver);
        clickButton
                .moreSuccessfulProjectsButton()
                .equerestLogoButton();
    }
}
