package com.equerest.tests.webdriver.adminpanel.projectpage.createproject;

import com.equerest.pages.common.MainPage;
import com.equerest.pages.createproject.ProjectCreateComplete;
import com.equerest.pages.createproject.ProjectInfo;
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
    @FileParameters("src/test/resources/create_new_project_owner_info.csv")
    public void createProject(String fio, String city, String telephone, String mail, String pass, String title, String description, String advantages, String model, String amount){

        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);

        mainPage.openRegisterProjectPage();

        ProjectCreateComplete projectOwnerInfo = new ProjectOwnerInfo(driver)
                .fillFio(fio)
                .fillCity(city)
                .fillTelephone(telephone)
                .fillMail(mail)
                .fillPass(pass)
                .setCheckBox()
                .pressNextButton()
                .fillTitle(title)
                .fillDescription(description)
                .fillStage()
                .fillAdvantages(advantages)
                .fillMonetization(model)
                .fillAmount(amount)
                .setCheckBoxAgree()
                .pressCompleteButton();

        ProjectCreateComplete projectCreateComplete = new ProjectCreateComplete(driver);
        projectCreateComplete.navigateToProject();
    }


}
