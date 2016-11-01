package com.equerest.tests.webdriver.common.main;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.main.NewProjectsPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 11/1/16;
 */
@Title("Проверка контролов на Главной странице сайта в \"Новые проекты\"")
@Description("Проверка кликабельности кнопок на Главной странице сайта в \"Новые проекты\"")
public class NewProjectsPageTest extends BaseTest {
    @Test
    @Title("Проверка кликабельности кнопок \"Больше новых проектов\"")
    public void moreNewProjectsClickButton(){
        HomePage clickButton = new NewProjectsPage(driver);
        clickButton
                .moreNewProjectsButton()
                .equerestLogoButton();
    }
}
