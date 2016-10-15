package com.equerest.tests.webdriver.register;

import com.equerest.pages.common.MainPage;
import com.equerest.pages.common.registration.EntrepreneurRegistrationFinishPage;
import com.equerest.pages.common.registration.EntrepreneurContactsPage;
import com.equerest.tests.webdriver.BaseTest;
import com.equerest.tests.webdriver.delete.DeleteProjectTest;
import com.equerest.tests.webdriver.delete.DeleteUserTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Oleg Nesterov on 10/4/16;
 */
@RunWith(JUnitParamsRunner.class)
public class EntrepreneurRegistrationTest extends BaseTest {

    @Test
    @FileParameters("src/test/resources/create_new_project_owner_info.csv")
    public void createProject(String fio, String city, String telephone, String mail, String pass, String title, String description, String advantages, String model, String amount){
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        mainPage.openRegisterProjectPage();
        //test comment
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
    @Ignore
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

    @After
    public void deleteProjectAndUser(){
 /*       DeleteProjectTest deleteProjectTest = new DeleteProjectTest();
        deleteProjectTest.openProjectsList();
        deleteProjectTest.deleteProjectTest("Тестовый проект Предприниматель 1");

        DeleteUserTest deleteUserTest = new DeleteUserTest();
        deleteUserTest.openProjectsList();
        deleteUserTest.deleteUserTest("equeresttest1@gmail.com");*/
    }


}
