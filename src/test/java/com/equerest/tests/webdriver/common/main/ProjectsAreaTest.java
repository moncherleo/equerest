package com.equerest.tests.webdriver.common.main;

import com.equerest.pages.common.HomePage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Vladyslav Vlasov on 06.01.2017.
 */
@Title("C9: Проверка области новых проектов")
public class ProjectsAreaTest extends BaseTest {
    @Test
    public void testNewProjectsArea() {
        HomePage homePage = new HomePage(driver);
        homePage
                .open()
                .assertCurrentUrlIsEquerestHomepage()
                .assertLogoPresent()
                .checkAreaPresence(homePage.moreNewProjectsArea)
                .checkNumberOfElementsShown(3, homePage.newProjectsDivs)
                .checkThatProjectsSortedByDate(homePage.newProjectsDivs, homePage.newProjectsDates)
                .checkLinkBehaviourOnMouseHovering(homePage.moreNewProjectsLink)
                .moveToProjectsCatalogue(homePage.moreNewProjectsLink)
                .navigateBack();

        homePage.checkNewProjectsAreaVisibility();
    }

    @Title("C5: Проверка области успешных проектов")
    @Test
    public void testSuccessfulProjectsArea() {
        HomePage homePage = new HomePage(driver);
        homePage
                .open()
                .assertCurrentUrlIsEquerestHomepage()
                .assertLogoPresent()
                .checkAreaPresence(homePage.successfulProjectsArea)
                .checkNumberOfElementsShown(2, homePage.successfulProjectsDivs)
                .checkThatProjectsSortedByDate(homePage.successfulProjectsDivs, homePage.successfulProjectDate)
                .checkLinkBehaviourOnMouseHovering(homePage.moreSuccessfulProjectsLink)
                .moveToProjectsCatalogue(homePage.moreSuccessfulProjectsLink)
                .navigateBack();
        homePage.checkAreaPresence(homePage.successfulProjectsArea);
    }

    @Test
    public void checkNeProjectAreaProjectDescription(){
        HomePage homePage = new HomePage(driver);
        homePage.
                open().checkThatEachProjectInNewProjectsAreaHasFullInfo();
    }
}
