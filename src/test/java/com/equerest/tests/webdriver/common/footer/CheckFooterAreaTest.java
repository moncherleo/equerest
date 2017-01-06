package com.equerest.tests.webdriver.common.footer;

import com.equerest.pages.common.HomePage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Пользователь on 06.01.2017.
 */
public class CheckFooterAreaTest extends BaseTest {
    @Test
    @Title("Кейс С-10, Шаг 1:проверить наличие лого")
    public void checkIfLogoPresent(){
        HomePage logo = new HomePage(driver);
        logo.assertLogoPresent();
    }

    @Test
    @Title("Кейс С-10, Шаг 1:\"Сайт открыт в окне браузера\"")
    public void assertCurrentUrl(){
        HomePage url = new HomePage(driver);
        url.assertCurrentUrlIsEquerestHomepage();
    }
}
