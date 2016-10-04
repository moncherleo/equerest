package com.equerest.tests.webdriver.adminpanel.projectpage.createproject;

import com.equerest.pages.common.MainPage;
import com.equerest.pages.createproject.ProjectOwnerInfo;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Oleg Nesterov on 10/4/16;
 */
@RunWith(JUnitParamsRunner.class)
public class CreateNewProjectTest extends BaseTest {

    @Test
    @FileParameters("src/test/resources/create_new_project_info.csv")
    public void createProject(String fio, String city, String telephone, String mail, String pass){

        ProjectOwnerInfo projectOwnerInfo = new ProjectOwnerInfo(driver);
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);

        mainPage.openRegisterProjectPage();

        projectOwnerInfo.fillFio(fio);
        projectOwnerInfo.fillCity(city);
        projectOwnerInfo.fillTelephone(telephone);
        projectOwnerInfo.fillPass(pass);
        projectOwnerInfo.setCheckBox();
        projectOwnerInfo.pressNextButton();

    }


}
