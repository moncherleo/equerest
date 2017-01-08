package com.equerest.tests.webdriver.common.main;

import com.equerest.pages.common.HomePage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 08.01.2017.
 */
@Title("C6: Проверка контролов и контекста в разделе \"Область успешных проектов\"")
public class ControlAndContextInSuccessfulProjectsArea extends BaseTest {
    @Test
    public void testControlAndContextInSuccessfulProjectsArea() {
        HomePage homePage = new HomePage(driver);
        homePage
                .open()
                .assertCurrentUrlIsEquerestHomepage()
                .checkSuccessfulProjectsAreaPresence()
                .checkSuccessfulProjectsLabelPresence()
                .checkMoreSuccessfulProjectsButtonPresence();
    }
}
