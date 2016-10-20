package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard.TeamMembersPage;
import com.equerest.pages.helpers.adminpanel.EditProjectHelper;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Oleg Nesterov on 9/26/16;
 */

@RunWith(JUnitParamsRunner.class)
@Title("Редактирование проекта")
public class EditFieldTeamProjectAddPeopleTest extends BaseTest {

    @Test
    @Title("Добавление человека в команду")
    @FileParameters("src/test/resources/team_member_info.csv")
    public void teamProjectAddPeople(String name, String position, String experience) {

        String LOGIN = "olegftzi@gmail.com";
        String PASSWORD = "Oleg1234";
        String PROJECT_NAME = "Интернет киоски \"Инетик\"";

        EditProjectHelper editProjectHelper = new EditProjectHelper(homePage);
        editProjectHelper.editProject(LOGIN, PASSWORD, PROJECT_NAME);

        TeamMembersPage teamMembers = new TeamMembersPage(driver);
        teamMembers.teamMemberAdd()
                .teamMemberEdit()
                .fillteamMemberName(name)
                .fillPosition(position)
                .fillExperience(experience)
                .applyChanges()
                .assertTeamMemberAppears(name,position,experience);
    }
}