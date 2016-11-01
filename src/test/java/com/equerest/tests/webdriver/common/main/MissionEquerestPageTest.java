package com.equerest.tests.webdriver.common;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.main.MissionEquerestPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 11/1/16;
 */
@Title("Проверка контролов на Главной странице сайта в \"Мы убеждены, что за бизнесом должно стоять желание помогать людям и улучшать качество жизни.\"")
@Description("Проверка кликабельности кнопок на Главной странице сайта в \"Мы убеждены, что за бизнесом должно стоять желание помогать людям и улучшать качество жизни.\"")
public class MissionEquerestPageTest extends BaseTest {
    @Test
    @Title("Проверка кликабельности кнопок \"Миссия Equerest\"")
    public void missionEquerestClickButton(){
        HomePage clickButton = new MissionEquerestPage(driver);
        clickButton
                .missionEquerestButton()
                .equerestLogoButton();
    }
}
