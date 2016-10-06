package com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard;

import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg Nesterov on 28.09.2016;
 */
public class TeamMembersPage extends EditProjectPage{

    protected final By teamMemberAddPeople = By.cssSelector("#anchor-team .addTeamMember>a");
    protected final By teamMemberEditButton = By.xpath("//*[@id='anchor-team']/div/div/div/button");
    protected final By teamMemberName = By.id("member_name_$index");
    protected final By teamMemberPosition = By.id("member_q_$index");
    protected final By teamMemberExperience = By.id("member_descr_$index");
    protected final By teamMemberDiscardChengesButton = By.xpath("//*[@id='anchor-team']/div/div/div/div[2]/button[1]");
    protected final By teamMemberApplyChangesButton = By.xpath("//*[@id='anchor-team']/div/div/div/div[2]/button[2]");
    protected final By teamMemberRemovePeople = By.cssSelector("#anchor-team .quick-editor>a");
    protected final By teamMemberSection = By.id("anchor-team");

    public TeamMembersPage(WebDriver driver){
        super(driver);
    }

    public TeamMembersPage teamMemberAdd() {
        scrollTo(driver.findElement(teamMemberAddPeople));
        click(teamMemberAddPeople);
        return this;
    }

    public TeamMembersPage teamMemberEdit() {
        scrollTo(driver.findElement(teamMemberEditButton));
        click(teamMemberEditButton);
        return this;
    }

    public TeamMembersPage fillteamMemberName(String name) {
        fillField(teamMemberName, name);
        return this;
    }

    public TeamMembersPage fillPosition(String position) {
        fillField(teamMemberPosition,position);
        return this;
    }

    public TeamMembersPage fillExperience(String experience) {
        fillField(teamMemberExperience,experience);
        return this;
    }

    public TeamMembersPage applyChanges() {
        click(teamMemberApplyChangesButton);
        return this;
    }

    //Remove people from team
    public TeamMembersPage teamMemberRemove() {
        scrollToElement(teamMemberEditButton);
        click(teamMemberRemovePeople);
        return this;
    }

    public TeamMembersPage assertTeamMemberAppears(String name, String position, String experience){
        scrollTo(driver.findElement(teamMemberSection));
        Assert.assertTrue(driver.findElement(teamMemberSection).getText().contains(name));
        Assert.assertTrue(driver.findElement(teamMemberSection).getText().contains(position));
        Assert.assertTrue(driver.findElement(teamMemberSection).getText().contains(experience));
        return this;
    }

}
