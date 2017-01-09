package com.equerest.tests.webdriver.common.main;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.main.CataloguePage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 08.01.2017.
 */
@Title("C7: Проверка работы кнопки \"Больше успешных проектов\"")
public class MoreSuccessfulProjectsButtonTest extends BaseTest {
    @Test
    public void testMoreSuccessfullProjectsButton() {
        HomePage homePage = new HomePage(driver);
        homePage
                .open()
                .assertCurrentUrlIsEquerestHomepage()
                .checkMoreSuccessfulProjectsButtonIsPresentAndActive()
                .checkMoreSuccessfulProjectsButton();
        CataloguePage cataloguePage = new CataloguePage(driver);
        cataloguePage.checkNumberofProjectsShown(6);
    }
}
