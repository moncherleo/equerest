package com.equerest.tests.webdriver.common.registration;

import com.equerest.pages.common.registration.EntrepreneurContactsPage;
import com.equerest.pages.common.registration.EntrepreneurRegistrationFinishPage;
import com.equerest.pages.helpers.adminpanel.DeleteNewUserHelper;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.yandex.qatools.properties.annotations.Resource;

/**
 * Created by Oleg Nesterov on 10/4/16;
 */
@RunWith(JUnitParamsRunner.class)
public class EntrepreneurRegistrationTest extends BaseTest {

    @Test
    @FileParameters("src/test/resources/create_new_project_owner_info.csv")
    public void createProject(String fio, String city, String telephone, String mail, String pass, String title, String description, String advantages, String model, String amount) {
        homePage.openRegisterProjectPage();
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
        projectCreateComplete
                .navigateToProject();

        // Удаление НОВОГО пользователя
        DeleteNewUserHelper deleteNewUserHelper = new DeleteNewUserHelper(driver);
        deleteNewUserHelper
                .deleteNewCreatedUser();
    }

    @Test
    @Ignore
    @FileParameters("src/test/resources/create_new_project_via_menu.csv")
    public void createProjectViaTopMenu(String fio, String city, String telephone, String mail, String pass, String title, String description, String advantages, String model, String amount){

                homePage.navigateToEntrepreneurInfoPage()
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

    @Test
    public void checkValidInputFIO() { //test case # C86
        homePage.openRegisterProjectPage()
                .enterButton()
                .clickSubmitProject()
                .fillFio("Фамилия Имя Отчество").assertFioError(false)
                .fillFio("Иванов-Петров Иван Иванович").assertFioError(false)
                .fillFio("Ivanov Ivan Ivanovich").assertFioError(false);
    }

    @FileParameters("src/test/resources/entrepreneur_registr_invalid_fio.csv")
    @Test
    public void checkInvalidInputFIO(String input) { //C87
        homePage.openRegisterProjectPage()
                .enterButton()
                .clickSubmitProject()
                .fillFio(input).assertFioError(true);
    }

    @Test
    public void checkValidInputCity() { //C88
        homePage.openRegisterProjectPage()
                .enterButton()
                .clickSubmitProject()
                .fillCity("Киев").assertCityError(false)
                .fillCity("Каменец-Подольский").assertCityError(false)
                .fillCity("Lviv").assertCityError(false);
    }

    @FileParameters("src/test/resources/entrepreneur_registr_invalid_city.csv")
    @Test
    public void checkInvalidInputCity(String input) { //C89
        homePage.openRegisterProjectPage()
                .enterButton()
                .clickSubmitProject()
                .fillCity(input).assertCityError(true);
    }

    @Test
    public void checkValidInputTelephone() { //C90
        homePage.openRegisterProjectPage()
                .enterButton()
                .clickSubmitProject()
                .fillTelephone("+380664537897").assertTelephoneError(EntrepreneurContactsPage.PhoneError.NONE)
                .fillTelephone("+380504535566").assertTelephoneError(EntrepreneurContactsPage.PhoneError.NONE);
    }

    @FileParameters("src/test/resources/entrepreneur_registr_invalid_phone.csv")
    @Test
    public void checkInvalidInputTelephone(String input, String errorType) { //C92
        homePage.openRegisterProjectPage()
                .enterButton()
                .clickSubmitProject()
                .fillTelephone(input).assertTelephoneError(EntrepreneurContactsPage.PhoneError.valueOf(errorType));
    }

    /*@After
    public void deleteProjectAndUser(){
        DeleteProjectTest deleteProjectTest = new DeleteProjectTest();
        deleteProjectTest.openProjectsList();
        deleteProjectTest.deleteProjectTest("Тестовый проект Предприниматель 1");

        DeleteUserTest deleteUserTest = new DeleteUserTest();
        deleteUserTest.openProjectsList();
        deleteUserTest.deleteUserTest("equeresttest1@gmail.com");
    }*/


}
