package com.equerest.pages.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by aBulgakoff on 9/20/16.
 */
public class EditProjectPage extends ProjectsPage {
    private final static String UPLOADVIDEO = "https://www.youtube.com/watch?v=QH2-TGUlwu4";

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
    protected final By projectDescriptionTextArea = By.id("anchor-full_description");
    protected final By teamMemberAddPeople = By.cssSelector("#anchor-team .addTeamMember>a");
    protected final By teamMemberEditButton = By.xpath("//*[@id='anchor-team']/div/div/div/button");
    protected final By teamMemberName = By.id("member_name_$index");
    protected final By teamMemberPosition = By.id("member_q_$index");
    protected final By teamMemberExperience = By.id("member_descr_$index");
    protected final By teamMemberDiscardChengesButton = By.xpath("//*[@id='anchor-team']/div/div/div/div[2]/button[1]");
    protected final By teamMemberApplyChangesButton = By.xpath("//*[@id='anchor-team']/div/div/div/div[2]/button[2]");
    protected final By teamMemberRemovePeople = By.cssSelector("#anchor-team .quick-editor>a");

    /*left bar's buttons*/
    private final By financeModelEditThruLeftBar = By.xpath("//ul[contains(concat(' ', @class, ' '), ' left-nav ')]//a[normalize-space(.)='Финансовая модель']");

    //added link at "Видео"
    protected final By editUploadVideoButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[1]/div[2]/div/div[3]/div/div[1]/div[3]//*[@class='edit-btn']");
    protected final By pasteVideoLinksField = By.xpath("//*[@id='wrapper']/main/div/div/div/section[1]/div[2]/div/div[3]/div/div[1]/div[3]/div/div/label/../*[@id='yt_link']");
    protected final By applyVideoLinksButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[1]/div[2]/div/div[3]/div/div[1]/div[3]/div/div/label/../*[text()[contains(.,'Применить')]]");
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

    private void scrollToElement(By element) {
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
        driver.findElement(applyVideoLinksButton).click();
        //валидация
        Assert.assertEquals(UPLOADVIDEO, UPLOADVIDEO);
        driver.findElement(videoButton).click();
        return new UploadVideoSelection(driver, this);
    }

    //delete link at "Видео"
    public UploadVideoSelection deleteVideo() {
        driver.findElement(pasteVideoLinksField).clear();
        driver.findElement(applyVideoLinksButton).click();
        //валидация
        Assert.assertEquals("", "");
        return new UploadVideoSelection(driver, this);
    }

    public EditProjectPage teamMemberAdd(String name, String position, String experience) {
        scrollToElement(teamMemberAddPeople);
        scrollToElement(teamMemberEditButton);
        driver.findElement(teamMemberEditButton).click();
        driver.findElement(teamMemberName).clear();
        driver.findElement(teamMemberName).sendKeys(name);
        driver.findElement(teamMemberPosition).clear();
        driver.findElement(teamMemberPosition).sendKeys(position);
        driver.findElement(teamMemberExperience).clear();
        driver.findElement(teamMemberExperience).sendKeys(experience);
        driver.findElement(teamMemberApplyChangesButton).click();
        return this;
    }

    //Upload background image
    public UploadBackgroundImage uploadImage() {
        driver.findElement(backgroundImageButton).click();


        return new UploadBackgroundImage(driver, this);
    }

    //Upload image to "Глерея"
    public UploadImagesToGallery uploadImagesToGallery() {
        driver.findElement(galleryImageButton).click();


        return new UploadImagesToGallery(driver, this);
    }

    //Remove people from team
    public EditProjectPage teamMemberRemove() {
        scrollToElement(teamMemberEditButton);
        driver.findElement(teamMemberAddPeople).click();
        driver.findElement(teamMemberEditButton);
        driver.findElement(teamMemberRemovePeople).click();
        return this;

    }
}