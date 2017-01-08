package com.equerest.tests.webdriver.common.main;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.common.HomePage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 06.01.2017.
 */
@Title("C9: Проверка области новых проектов")
public class NewProjectsAreaTest extends BaseTest {
    @Test
    public void testNewProjectsArea() {
        HomePage homePage = new HomePage(driver);
        homePage
                .open()
                .assertCurrentUrlIsEquerestHomepage()
                .assertLogoPresent()
                .checkNewProjectsAreaPresence()
                .checkNumberofNewProjectsShown(3)
                .checkThatNewProjectsSortedByDate()
                .checkMoreNewProjectsLinkIsPresent()
                .checkMoreNewProjectsLinkBehaviourOnMouseHovering()
                .moveToCataloguePageByClickingOnMoreNewProjects()
                .navigateBack();

        homePage.checkNewProjectsAreaVisibility();
    }
    @Test
    public void checkNeProjectAreaProjectDescription(){
        HomePage homePage = new HomePage(driver);
        homePage.
                open().checkThatEachProjectInNewProjectsAreaHasFullInfo();
    }
}
