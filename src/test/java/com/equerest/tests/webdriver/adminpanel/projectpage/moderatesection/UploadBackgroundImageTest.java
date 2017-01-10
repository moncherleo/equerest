package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.helpers.adminpanel.EditProjectHelper;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.awt.*;
import java.io.File;

/**
 * Created by Eduard Aliiev on 10/1/16;
 */
@Title("TC-06 'Загрузка фонового изображения страницы проекта'")
@Description("- Пользователь [login] должен предварительно войти в систему, используя [password]")
@RunWith(JUnitParamsRunner.class)
public class UploadBackgroundImageTest extends BaseTest {

    //Upload background image

    @Test
    @FileParameters("src/test/resources/login_project_info.csv")
    public void uploadBackgroundImageInProject(String login, String password, String projectName) throws AWTException, InterruptedException {
        EditProjectPage selectedProject = new EditProjectHelper(homePage).editProject(login, password, projectName);
        File file = new File("src/test/resources/IMG702.jpg");
        selectedProject.uploadImage(file.getAbsolutePath());
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='file']//span[contains(.,'IMG702.jpg')]")).isEnabled());
    }
}
