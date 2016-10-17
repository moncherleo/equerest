package com.equerest.tests.webdriver.delete;

import com.equerest.pages.adminpanel.UsersPage;
import com.equerest.pages.common.HomePage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by Oleg Nesterov on 07.10.2016;
 */
@RunWith(JUnitParamsRunner.class)
public class DeleteUserTest extends BaseTest {

    public UsersPage openProjectsList() {
        String login = "olegftzi@gmail.com";
        String password = "Oleg1234";
        String userName = "Тестовый пользователь";
        HomePage homePage = new HomePage(driver);
        UsersPage usersPage = homePage.openLoginPage()
                .loginAs(login, password)
                .navigateToUserMenuPageViaMenuItem();
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
