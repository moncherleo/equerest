package com.equerest.tests.webdriver.delete;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.UsersPage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;


/**
 * Created by Oleg Nesterov on 07.10.2016;
 */
@RunWith(JUnitParamsRunner.class)
public class DeleteUserTest extends BaseTest {
    //private By deleteUserButton = By.xpath("//*[@id='wrapper']/main//a[@uib-tooltip='Удалить']");
    String login = "olegftzi@gmail.com";
    String password = "Oleg1234";
    String userName = "Тестовый пользователь";

    private UsersPage openProjectsList() {

        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        ProjectsPage usersPage = mainPage.openLoginPage()
                .loginAs(login, password);
        return usersPage.navigateToUserMenuPageViaMenuItem();
    }

    @Test
    @FileParameters("src/test/resources/delete_user.csv")
    public void deleteUserTest(String userMail){
       UsersPage projectsPage = openProjectsList()
               .searchUser(userMail)
               .deleteUser()
               .confirmDeletionAlert();
    }
}
