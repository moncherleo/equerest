package com.equerest.tests.webdriver.common.main;

import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.main.CataloguePage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yuliia Kulyk on 17.01.2017.
 */
public class ProjectsCatalogueFilterTest extends BaseTest {
    CataloguePage cataloguePage;

    @Before
    public void openProjectsCatalogue() {
        HomePage homePage = new HomePage(driver);
        cataloguePage = homePage.moveToProjectsCatalogue(homePage.forProjects);
    }

    @Test
    public void check_SearchingInvestment_Prototype() {
        cataloguePage.setDropdownOption(cataloguePage.filterProjects, "в поиске инвестиций")
                .setDropdownOption(cataloguePage.filterStage, "Идея или прототип");
        if (cataloguePage.getNumberOfPages() > 1) {
            for (int i = 0; i < cataloguePage.getNumberOfPages(); i++) {
                cataloguePage.checkFilteredProjectsOnPage(cataloguePage.projectStatus, "в поиске инвестиций");
            }
        } else {
            cataloguePage.checkFilteredProjectsOnPage(cataloguePage.projectStatus, "в поиске инвестиций");
        }

    }

    @After
    public void resetFilters() {
        cataloguePage.setDropdownOption(cataloguePage.filterProjects, "все");
        cataloguePage.setDropdownOption(cataloguePage.filterStage, "все");
    }

}
