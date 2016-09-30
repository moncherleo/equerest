package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.helpers.adminpanel.EditProjectHelper;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Eduard Aliiev on 10/1/16;
 */
@RunWith(JUnitParamsRunner.class)
public class UploadImagesToGalleryTest extends BaseTest {

    //Upload image to "Глерея"
    // TODO: implement upload functionality

    @Ignore
    @Test
    @FileParameters("src/test/resources/login_project_info.csv")
    public void uploadImagesToGalleryImageInProject(String login, String password, String projectName) {
        EditProjectPage selectedProject = new EditProjectHelper(driver).editProject(login, password, projectName);

        selectedProject.uploadImagesToGallery();
    }
}
