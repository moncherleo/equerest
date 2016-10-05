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
@Title("TC-06 'Загрузка фонового изображения страницы проекта'")
@Description("- Пользователь [login] должен предварительно войти в систему, используя [password]")
@RunWith(JUnitParamsRunner.class)
public class UploadBackgroundImageTest extends BaseTest {

    //Upload background image
    // TODO: implement upload functionality

    @Ignore
    @Test
    @FileParameters("src/test/resources/login_project_info.csv")
    public void uploadBackgroundImageInProject(String login, String password, String projectName) {
        EditProjectPage selectedProject = new EditProjectHelper(driver).editProject(login, password, projectName);

        selectedProject.uploadImage();
    }
}
