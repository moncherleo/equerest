package com.equerest.tests.webdriver.common.main;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.main.CataloguePage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Yuliia Kulyk on 17.01.2017.
 */
@Description("Test suit checks project status for each filter combination")
public class ProjectsCatalogueFilterTest extends BaseTest {
    CataloguePage cataloguePage;

    @Before
    public void openProjectsCatalogue() {
        HomePage homePage = new HomePage(driver);
        cataloguePage = homePage.moveToProjectsCatalogue(homePage.forProjects);
    }

    @Title("Проекты - В поиске инвестиций, Стадия - Идея или прототип")
    @Test
    public void check_SearchingInvestment_Prototype() {
        cataloguePage.setDropdownOption(cataloguePage.filterProjects, "в поиске инвестиций")
                .setDropdownOption(cataloguePage.filterStage, "Идея или прототип")
                .checkFilteredProjects(cataloguePage.projectStatus, "в поиске инвестиций");
    }

    @Title("Проекты - В поиске инвестиций, Стадия - Работающий бизнес")
    @Test
    public void check_SearchingInvestment_WorkingBusiness() {
        cataloguePage.setDropdownOption(cataloguePage.filterProjects, "в поиске инвестиций")
                .setDropdownOption(cataloguePage.filterStage, "Работающий бизнес")
                .checkFilteredProjects(cataloguePage.projectStatus, "в поиске инвестиций");
    }

    @Title("Проекты - В поиске инвестиций, Стадия - Бизнес на продажу")
    @Test
    public void check_SearchingInvestment_ForSale() {
        cataloguePage.setDropdownOption(cataloguePage.filterProjects, "в поиске инвестиций")
                .setDropdownOption(cataloguePage.filterStage, "Бизнес на продажу")
                .checkFilteredProjects(cataloguePage.projectStatus, "в поиске инвестиций");
    }

    @Title("Проекты - В поиске инвестиций, Стадия - Продажа доли")
    @Test
    public void check_SearchingInvestment_SaleShare() {
        cataloguePage.setDropdownOption(cataloguePage.filterProjects, "в поиске инвестиций")
                .setDropdownOption(cataloguePage.filterStage, "Продажа доли в бизнесе")
                .checkFilteredProjects(cataloguePage.projectStatus, "в поиске инвестиций");
    }

    @Title("Проекты - Проинвестированные, Стадия - Идея или прототип")
    @Test
    public void check_Invested_Prototype() {
        cataloguePage.setDropdownOption(cataloguePage.filterProjects, "проинвестирован")
                .setDropdownOption(cataloguePage.filterStage, "Идея или прототип")
                .checkFilteredProjects(cataloguePage.projectStatus, "проинвестирован");
    }

    @Title("Проекты - Проинвестированные, Стадия - Работающий бизнес")
    @Test
    public void check_Invested_WorkingBusiness() {
        cataloguePage.setDropdownOption(cataloguePage.filterProjects, "проинвестирован")
                .setDropdownOption(cataloguePage.filterStage, "Работающий бизнес")
                .checkFilteredProjects(cataloguePage.projectStatus, "проинвестирован");
    }

    @Title("Проекты - Проинвестированные, Стадия - Бизнес на продажу")
    @Test
    public void check_Invested_ForSale() {
        cataloguePage.setDropdownOption(cataloguePage.filterProjects, "проинвестирован")
                .setDropdownOption(cataloguePage.filterStage, "Бизнес на продажу")
                .checkFilteredProjects(cataloguePage.projectStatus, "проинвестирован");
    }

    @Title("Проекты - Проинвестированные, Стадия - Продажа доли")
    @Test
    public void check_Invested_SaleShare() {
        cataloguePage.setDropdownOption(cataloguePage.filterProjects, "проинвестирован")
                .setDropdownOption(cataloguePage.filterStage, "Продажа доли в бизнесе")
                .checkFilteredProjects(cataloguePage.projectStatus, "проинвестирован");
    }

    @After
    public void resetFilters() {
        cataloguePage.setDropdownOption(cataloguePage.filterProjects, "все");
        cataloguePage.setDropdownOption(cataloguePage.filterStage, "все");
    }

}
