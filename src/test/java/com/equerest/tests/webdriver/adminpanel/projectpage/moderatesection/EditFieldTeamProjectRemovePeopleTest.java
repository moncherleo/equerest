package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard.TeamMembersPage;
import com.equerest.pages.helpers.adminpanel.EditProjectHelper;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Oleg Nesterov on 27.09.2016;
 */
@Title("Редактирование проекта")
public class EditFieldTeamProjectRemovePeopleTest extends BaseTest {

    @Test
    @Title("Удаление человека из команды")
    public void teamProjectRemovePeople() {

        String LOGIN = "olegftzi@gmail.com";
        String PASSWORD = "Oleg1234";
        String PROJECT_NAME = "Интернет киоски \"Инетик\"";

        EditProjectHelper editProjectHelper = new EditProjectHelper(homePage);
        editProjectHelper.editProject(LOGIN, PASSWORD, PROJECT_NAME);

        TeamMembersPage teamMembers = new TeamMembersPage(driver);
        teamMembers.teamMemberEdit().teamMemberRemove();
    }
}
