package com.equerest.pages.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by aBulgakoff on 9/20/16.
 */
public class EditProjectPage extends ProjectsPage {
    private final static String UPLOADVIDEO = "https://www.youtube.com/watch?v=TWiKdFqnIzw";

    protected Actions actions;

    private final String commonSmallEditButton = "//button[@class='edit-btn']";

    /*project's editing finalization buttons*/
    protected final By saveProjectButton = By.cssSelector(".btn.btn-success");
    protected final By cancelProjectEditButton = By.cssSelector(".btn.btn-primary");
    protected final By moveProjectToArchive = By.cssSelector(".btn.btn-warning");

    /*project sections (access level needed for page scroll)*/
    protected final By addNumbersLink = By.xpath("html/body/div[1]/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/h3/span/a");
    protected final By descriptionEditButton = By.xpath("//*[@id='anchor-full_description']" + commonSmallEditButton);
    protected final By achievementsEditButton = By.xpath("//*[@id='anchor-achievements']" + commonSmallEditButton);
    protected final By financeModelEditButton = By.xpath("//*[@id='anchor-fmodel']" + commonSmallEditButton);
    protected final By editorInputAreaWindows = By.cssSelector(".quick-editor.input-textarea-group");
    protected final By projectSavedAlert = By.xpath("//*[@id='toast-container']//*[text()[contains(.,'Проект сохранен')]]");
    protected final By fileUploadedAlert = By.xpath("//*[@id='toast-container']//*[text()[contains(.,'Файл загружен')]]");
    protected final By projectDescriptionTextArea = By.id("anchor-full_description");

    /*left bar's buttons*/
    private final By financeModelEditThruLeftBar = By.xpath("//ul[contains(concat(' ', @class, ' '), ' left-nav ')]//a[normalize-space(.)='Финансовая модель']");

    //added link at "Видео"
    protected final By editUploadVideoButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[1]/div[2]/div/div[3]/div/div[1]/div[3]//*[@class='edit-btn']");
    protected final By pasteVideoLinksField = By.xpath("//*[@id='wrapper']/main/div/div/div/section[1]/div[2]/div/div[3]/div/div[1]/div[3]/div/div/label/../*[@id='yt_link']");
    protected final By videoButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[1]/div[2]/div/div[3]/div/div[1]/div[3]//*[text()[contains(.,'Видео')]]");
    //[Background image] button
    private final By backgroundImageButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[1]/div[2]/div/div[2]/div/..//*[@id='file']");
    //"Загрузить изображения" button
    private final By galleryImageButton = By.cssSelector("#anchor-gallery>.mediafiles>button");


    public EditProjectPage(WebDriver driver) {
        super(driver);
        if (actions == null) {
            actions = new Actions(driver);
        }
    }

    protected void scrollToElement(By element) {
        actions.moveToElement(driver.findElement(element)).perform();
    }

    public DescriptionSection editProjectDescription() {
        /*move to the element in the end of page, move to the higher element for correct displaying of needed one*/
        scrollToElement(saveProjectButton);
        scrollToElement(addNumbersLink);
        driver.findElement(descriptionEditButton).click();
        return new DescriptionSection(driver, this);
    }

    public FinanceModelSection editFinanceModel() {
        /*move to the higher element for correct displaying of needed one*/
        scrollToElement(achievementsEditButton);
        driver.findElement(financeModelEditButton).click();
        return new FinanceModelSection(driver, this);
    }

    // "Применить" button
    public EditProjectPage verifyEditWindowNotPresent() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(editorInputAreaWindows)));
        return this;
    }

    // Alert massage "Проект сохранен"
    public EditProjectPage verifyProjectSavedAlertDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(projectSavedAlert)));
        return this;
    }


    public EditProjectPage assertProjectDescriptionUpdate(String s) {
        Assert.assertTrue(driver.findElement(projectDescriptionTextArea).getText().contains(s));
        return this;
    }

    //edit fild at "Видео"
    public UploadVideoSelection editVideoLink() {
        driver.findElement(editUploadVideoButton).click();
        return new UploadVideoSelection(driver, this);
    }

    //added link at "Видео"
    public UploadVideoSelection uploadVideo() {
        driver.findElement(pasteVideoLinksField).clear();
        driver.findElement(pasteVideoLinksField).sendKeys(UPLOADVIDEO);
        //валидация
        Assert.assertEquals(UPLOADVIDEO, UPLOADVIDEO);
        driver.findElement(videoButton).click();
        //driver.close();
        return new UploadVideoSelection(driver, this);
    }

    //delete link at "Видео"
    public UploadVideoSelection deleteVideo() {
        driver.findElement(pasteVideoLinksField).clear();
        //валидация
        Assert.assertEquals("", "");
        return new UploadVideoSelection(driver, this);
    }

    //Upload background image
    public UploadBackgroundImage uploadImage(String path) throws InterruptedException, AWTException {
        WebElement fileInput = driver.findElement(backgroundImageButton);
        fileInput.click();
        Thread.sleep(5000);
        StringSelection ss = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
        Assert.assertTrue(driver.findElement(projectSavedAlert).isEnabled());
        Assert.assertTrue(driver.findElement(fileUploadedAlert).isEnabled());
        return new UploadBackgroundImage(driver, this);
    }

    //Upload image to "Глерея"
    public UploadImagesToGallery uploadImagesToGallery() {
        driver.findElement(galleryImageButton).click();



        return new UploadImagesToGallery(driver, this);
    }

}