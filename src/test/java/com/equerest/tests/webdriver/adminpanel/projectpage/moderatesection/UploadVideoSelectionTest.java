package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.helpers.adminpanel.EditProjectHelper;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Eduard Aliiev on 9/30/16;
 */
@RunWith(JUnitParamsRunner.class)
public class UploadVideoSelectionTest extends BaseTest {

    //upload "Видео" into the project-card
    @Test
    @FileParameters("src/test/resources/login_project_info.csv")
    public void uploadVideoLinkInProject(String login, String password, String projectName) {
        EditProjectPage selectedProject = new EditProjectHelper(driver).editProject(login, password, projectName);

        selectedProject.editVideoLink()
                .uploadVideo()
                .applyChanges()
                .verifyEditWindowNotPresent()
                .verifyProjectSavedAlertDisplayed();
    }
}

