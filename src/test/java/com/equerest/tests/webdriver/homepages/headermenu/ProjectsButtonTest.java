package com.equerest.tests.webdriver.homepages.headermenu;

import com.equerest.pages.homepage.HomePage;
import com.equerest.pages.homepage.headermenu.ProjectsButton;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 10/17/16;
 */
@Title("C126 Проверка контролов Хедер меню")
@Description("Проверка кликабельности кнопок 'Хедер' меню на главной странице сайта")
public class ProjectsButtonTest extends BaseTest{
    @Test
    @Title("Проверка кликабельности кнопки 'Проекты'")
    public void projectsSectionButton() {
        HomePage clickButton = new ProjectsButton(driver);
        clickButton
                .projectsButton()
                .equerestLogoButton();
    }

}
