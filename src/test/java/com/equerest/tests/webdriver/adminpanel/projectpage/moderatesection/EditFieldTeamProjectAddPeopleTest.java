package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard.TeamMembers;
import com.equerest.pages.common.MainPage;
import com.equerest.pages.helpers.adminpanel.EditProjectHelper;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Oleg Nesterov on 9/26/16;
 */

@RunWith(JUnitParamsRunner.class)
public class EditFieldTeamProjectAddPeopleTest extends BaseTest {

    @Test
    @FileParameters("src/test/resources/team_member_info.csv")
    public void teamProjectAddPeople(String name, String position, String experience) {

        String LOGIN = "olegftzi@gmail.com";
        String PASSWORD = "Oleg1234";
        String PROJECT_NAME = "Интернет киоски \"Инетик\"";

        EditProjectHelper editProjectHelper = new EditProjectHelper(driver);
        editProjectHelper.editProject(LOGIN, PASSWORD, PROJECT_NAME);

        TeamMembers teamMembers = new TeamMembers(driver);
        teamMembers.teamMemberAdd()
                .teamMemberEdit()
                .fillteamMemberName(name)
                .fillPosition(position)
                .fillExperience(experience)
                .applyChanges();
    }
}