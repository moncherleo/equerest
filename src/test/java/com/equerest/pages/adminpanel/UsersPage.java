package com.equerest.pages.adminpanel;

import com.equerest.pages.adminpanel.userspage.CreateNewUserPage;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg Nesterov on 07.10.2016;
 */
public class UsersPage extends BaseAdminPanelPage{

    public UsersPage(WebDriver driver) {
        super(driver);
    }
    private By searchUserField = By.id("search");
    private By deleteUserButton = By.cssSelector("#wrapper a[uib-tooltip='Удалить']");//Use for unique user ONLY
    private By removeFilterButton = By.id("removeFilter");
    private By addUserButton = By.id("userAdd");

    public UsersPage searchUser(String userName){
        driver.findElement(searchUserField).sendKeys(userName);
        return this;
    }

    public CreateNewUserPage createUserAccount(){
        driver.findElement(addUserButton).click();
        return new CreateNewUserPage(driver);
    }

    public UsersPage deleteUser(){
        driver.findElement(deleteUserButton).click();
        return this;
    }

    public UsersPage confirmDeletionAlert(){
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.sendKeys("1");
        confirmationAlert.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='toast-container']//*[text()[contains(.,'Пользователь удален')]]")).isEnabled());
        return this;
    }
}
