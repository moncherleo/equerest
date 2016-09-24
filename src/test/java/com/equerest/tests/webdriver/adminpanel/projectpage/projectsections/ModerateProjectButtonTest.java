package com.equerest.tests.webdriver.adminpanel.projectpage.projectsections;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.ToModeratePage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Oleg Nesterov on 24.09.2016;
 */
@RunWith(JUnitParamsRunner.class)
public class ModerateProjectButtonTest extends BaseTest {
	private ToModeratePage toModeratePage(String login, String password, String projectName) {
		MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
		ProjectsPage projectsPage = mainPage.openLoginPage()
				.loginAs(login, password);

		return projectsPage.navigateToProjectPageViaMenuItem()
				.toModerateProject(projectName);
	}

	//added project-card at "На модерацию"
	@Test
	@FileParameters("src/test/resources/login_project_toModerateButton_info.csv")
	public void toModerateProgectPage(String login, String password, String projectName) {
		ToModeratePage selectedProject = toModeratePage(login, password, projectName);

		selectedProject.projectToModerate()
				.verifyProjectSavedAlertDisplayed();
	}
}