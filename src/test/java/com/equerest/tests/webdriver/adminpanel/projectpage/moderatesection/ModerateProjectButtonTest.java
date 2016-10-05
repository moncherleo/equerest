package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.ToModeratePage;
import com.equerest.pages.common.MainPage;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.concurrent.TimeUnit;

/**
 * Created by Oleg Nesterov on 24.09.2016;
 */
@RunWith(JUnitParamsRunner.class)
public class ModerateProjectButtonTest extends BaseTest {
	private ProjectsPage toModeratePage(String login, String password, String projectName) {
		MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
		ProjectsPage projectsPage = mainPage.openLoginPage()
				.loginAs(login, password);

		return projectsPage.navigateToProjectPageViaMenuItem();
	}

	//added project-card at "На модерацию"
	@Test
	@Description("Изменение статуса проекта на \"Модерация\"")
	@FileParameters("src/test/resources/login_project_toModerateButton_info.csv")
	public void toModerateProgectPage(String login, String password, String projectName) {

		ToModeratePage selectedProject = toModeratePage(login, password, projectName)
				.selectNewFilter()
				.toModerateProject(projectName)
				.projectToModerate()
				.verifyProjectSavedAlertDisplayed();
	}
}