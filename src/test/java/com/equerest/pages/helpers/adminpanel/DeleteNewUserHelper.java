package com.equerest.pages.helpers.adminpanel;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.common.HomePage;
import com.equerest.pages.common.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Eduard Aliiev on 11/7/16;
 */
public class DeleteNewUserHelper extends AbstractPage {

    private final By forExit = By.xpath("/html/body/div[1]/header//*[text()[contains(.,'Выйти')]]");

    public DeleteNewUserHelper(WebDriver driver) {
        super(driver);
    }

    public DeleteNewUserHelper deleteNewCreatedUser(){

        driver.findElement(forExit).click();

        String login = "olegftzi@gmail.com";
        String password = "Oleg1234";
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openLoginPage();
        ProjectsPage usersPage = loginPage.loginAs(login, password);

        //ProjectsPage usersPage = homePage.openLoginPage().loginAs(login, password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        usersPage.navigateToUserMenuPageViaMenuItem()
                .searchUser("equeresttest1@gmail.com")
                .deleteUser()
                .confirmDeletionAlert();
        return this;
    }
    public DeleteNewUserHelper deleteNewCreatedUserWithParams(String userEmail){

        driver.findElement(forExit).click();

        String login = "olegftzi@gmail.com";
        String password = "Oleg1234";
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openLoginPage();
        ProjectsPage usersPage = loginPage.loginAs(login, password);

        //ProjectsPage usersPage = homePage.openLoginPage().loginAs(login, password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        usersPage.navigateToUserMenuPageViaMenuItem()
                .searchUser(userEmail)
                .deleteUser()
                .confirmDeletionAlert();
        return this;
    }
}
