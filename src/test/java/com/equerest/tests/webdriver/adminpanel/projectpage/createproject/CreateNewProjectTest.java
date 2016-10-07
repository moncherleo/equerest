package com.equerest.tests.webdriver.adminpanel.projectpage.createproject;

import com.equerest.pages.common.MainPage;
import com.equerest.pages.createproject.EntrepreneurRegistrationFinishPage;
import com.equerest.pages.createproject.EntrepreneurContactsPage;
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

        EntrepreneurRegistrationFinishPage projectOwnerInfo = new EntrepreneurContactsPage(driver)
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

        EntrepreneurRegistrationFinishPage projectCreateComplete = new EntrepreneurRegistrationFinishPage(driver);
        projectCreateComplete.navigateToProject();
    }

    @Test
    @FileParameters("src/test/resources/create_new_project_via_menu.csv")
    public void createProjectViaTopMenu(String fio, String city, String telephone, String mail, String pass, String title, String description, String advantages, String model, String amount){

        EntrepreneurContactsPage mainPage = new MainPage("https://dev.equerest.com/", driver)
                .navigateToEntrepreneurInfoPage()
                .startEntrepreneurRegistration();

        EntrepreneurRegistrationFinishPage projectOwnerInfo = new EntrepreneurContactsPage(driver)
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

        EntrepreneurRegistrationFinishPage projectCreateComplete = new EntrepreneurRegistrationFinishPage(driver);
        projectCreateComplete.navigateToProject();
    }

}
