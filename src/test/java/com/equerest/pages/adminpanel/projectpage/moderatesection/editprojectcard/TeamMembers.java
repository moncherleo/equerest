package com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard;

import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg Nesterov on 28.09.2016;
 */
public class TeamMembers extends EditProjectPage{

    protected final By teamMemberAddPeople = By.cssSelector("#anchor-team .addTeamMember>a");
    protected final By teamMemberEditButton = By.xpath("//*[@id='anchor-team']/div/div/div/button");
    protected final By teamMemberName = By.id("member_name_$index");
    protected final By teamMemberPosition = By.id("member_q_$index");
    protected final By teamMemberExperience = By.id("member_descr_$index");
    protected final By teamMemberDiscardChengesButton = By.xpath("//*[@id='anchor-team']/div/div/div/div[2]/button[1]");
    protected final By teamMemberApplyChangesButton = By.xpath("//*[@id='anchor-team']/div/div/div/div[2]/button[2]");
    protected final By teamMemberRemovePeople = By.cssSelector("#anchor-team .quick-editor>a");

    public TeamMembers(WebDriver driver){
        super(driver);
    }

    @Override
    public void click(By locator) {
        super.click(locator);
    }

    @Override
    public void fillField(By locator, String data){
        super.fillField(locator, data);
    }

    public TeamMembers teamMemberAdd() {
        scrollToElement(teamMemberAddPeople);
        return this;
    }

    public TeamMembers teamMemberEdit() {
        scrollToElement(teamMemberEditButton);
        return this;
    }

    public TeamMembers fillteamMemberName(String name) {
        driver.findElement(teamMemberName).clear();
        fillField(teamMemberName, name);
        return this;
    }

    public TeamMembers fillPosition(String position) {
        driver.findElement(teamMemberPosition).clear();
        fillField(teamMemberPosition,position);
        return this;
    }

    public TeamMembers fillExperience(String experience) {
        driver.findElement(teamMemberExperience).clear();
        fillField(teamMemberExperience,experience);
        return this;
    }

    public TeamMembers applyChanges() {
        click(teamMemberApplyChangesButton);
        return this;
    }

    //Remove people from team
    public TeamMembers teamMemberRemove() {
        scrollToElement(teamMemberEditButton);
        click(teamMemberRemovePeople);
        return this;
    }

}
