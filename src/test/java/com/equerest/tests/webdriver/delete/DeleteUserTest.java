package com.equerest.tests.webdriver.delete;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.UsersPage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;


/**
 * Created by Oleg Nesterov on 07.10.2016;
 */
public class DeleteUserTest extends BaseTest {
    private By deleteUserButton = By.xpath("//*[@id='wrapper']/main/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[3]/button[1]");
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
    public void deleteUserTest(){
       UsersPage projectsPage = openProjectsList()
        .searchUser(userName);
    }
}
