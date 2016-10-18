package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.helpers.adminpanel.EditProjectHelper;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 10/1/16;
 */
@Title("TC-07 'Загрузка изображений в 'Галерею проекта'")
@Description("- Пользователь [login] должен предварительно войти в систему, используя [password]")
@RunWith(JUnitParamsRunner.class)
public class UploadImagesToGalleryTest extends BaseTest {

    //Upload image to "Глерея"
    // TODO: implement upload functionality

    @Ignore
    @Test
    @FileParameters("src/test/resources/login_project_info.csv")
    public void uploadImagesToGalleryImageInProject(String login, String password, String projectName) {
        EditProjectPage selectedProject = new EditProjectHelper().editProject(login, password, projectName);

        selectedProject.uploadImagesToGallery();
    }
}
