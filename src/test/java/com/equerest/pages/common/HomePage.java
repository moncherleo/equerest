package com.equerest.pages.common;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.common.footer.*;
import com.equerest.pages.common.header.*;
import com.equerest.pages.common.main.*;
import com.equerest.pages.common.registration.EntrepreneurContactsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cherleo on 9/19/16.
 */
public class HomePage extends AbstractPage {
    private static final String LOGIN_PAGE_URL = "register#/";
    private static final String REGAIN_PASSWORD_PAGE_URL = "index/regainPassword";
    private final By equerestLogo = By.xpath("/html/body/div[1]/header/div/nav/div[1]/div[1]//img[contains(@src, 'header_logo.svg')]");
    private final By worthItFooterLogo = By.cssSelector("#footer .link");
    //######################_locators for the 'Header' menu_######################
    private final By forMission = By.xpath("/html/body/div[1]/header//*[text()[contains(.,'Миссия')]]");
    private By forEntrepreneur = By.xpath("//*[@id='header']//*[text()[contains(.,'Предпринимателю')]]");
    private By forInvestor = By.xpath("//*[@id='header']//*[text()='Инвестору                                ']");
    private final By forProjects = By.xpath("/html/body/div[1]/header//*[text()[contains(.,'Проекты')]]");
    private final By forEnter = By.xpath("/html/body/div[1]/header//*[text()[contains(.,'Войти')]]");
    //######################_locotors for the 'Main' menu_######################
    private By registerProjectButton = By.cssSelector("#main .button-green.bordered");
    private final By howWeAreWorkingButton = By.xpath("//*[@id='banner']//a[text()[contains(.,'Как мы работаем?')]]");
    private final By moreSuccessfulProjectsButton = By.xpath("//*[@id='complete']//*[text()[contains(.,'Больше успешных проектов')]]");
    private final By missionEquerestButton = By.xpath("//*[@id='main']//*[text()[contains(.,'Миссия Equerest')]]");
    private final By moreNewProjectsButton = By.xpath("//*[@id='new_projects']//*[text()[contains(.,'Больше новых проектов')]]");
    private final By moreNewProjectsLink = By.xpath("//*[@id='new_projects']//a[contains(.,'Больше новых проектов')]");
    private final By moreNewProjectsArea = By.xpath("//*[@id='new_projects']//*[text()[contains(.,'Новые проекты')]]");
    private By successfulProjectsArea = By.cssSelector("#complete");
    private By successfulProjectsLabel = By.xpath("//*[@id='complete']//h2[contains(.,'Успешные проекты')]");
    //######################_locotors for the 'Footer' menu_######################
    private final By investorFooterButton = By.xpath("//*[@id='footer']//*[text()[contains(.,'Инвестору')]]");
    private final By projectsFooterButton = By.xpath("//*[@id='footer']//*[text()[contains(.,'Проекты')]]");
    private final By investFooterButton = By.xpath("//*[@id='footer']//*[text()[contains(.,'Инвестировать')]]");
    private final By ientrepreneurFooterButton = By.xpath("//*[@id='footer']//*[text()[contains(.,'Предпринимателю')]]");
    private final By missionFooterButton = By.xpath("//*[@id='footer']//*[text()[contains(.,'Миссия')]]");
    private final By postProjectFooterButton = By.xpath("//*[@id='footer']//*[text()[contains(.,'Подать проект')]]");
    private final By contactsFooterButton = By.xpath("//*[@id='footer']//*[text()[contains(.,'Контакты')]]");
    private final By termsOfUseFooterButton = By.xpath("//*[@id='footer']//*[text()[contains(.,'Правила пользования')]]");
    //private final By partnersFooterButton = By.id("partners-link");
    private final By privacyPolicyFooterButton = By.xpath("//*[@id='footer']//*[text()[contains(.,'Политика конфиденциальности')]]");
    private final By cookiesProcessingPolicyFooterButton = By.xpath("//*[@id='footer']//*[text()[contains(.,'Политика обработки cookies')]]");

    public HomePage(String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }

    public HomePage(WebDriver driver) {
        super(driver);
        this.url = BASE_URL;
    }

    @Step("Open home page")
    public HomePage open() {
        driver.navigate().to(url);
        return this;
    }

    @Step("Navigate to login page")
    public LoginPage navigateToLoginPage() {
        driver.navigate().to(url + LOGIN_PAGE_URL);
        return new LoginPage(driver);
    }

    @Step("Navigate to regain password page")
    public LoginPage navigateToRegainPasswordPage() {
        driver.navigate().to(url + REGAIN_PASSWORD_PAGE_URL);
        return new LoginPage(driver);
    }

    //######################_'Header'_######################
    //'Equerest logo'
    public EquerestLogoButton equerestLogoButton() {
        driver.findElement(equerestLogo).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#banner .h1[class='h1']")).isEnabled());
        return new EquerestLogoButton(driver);
    }

    //'MissionInfoPage' button "Миссия"
    public MissionInfoPage missionButton() {
        driver.findElement(forMission).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='mission']//h1[text()[contains(.,'Миссия Equerest')]]")).isEnabled());
        return new MissionInfoPage(driver);
    }

    //'EntrepreneurInfoPage' button "Предпринимателю"
    public EntrepreneurInfoPage navigateToEntrepreneurInfoPage() {
        driver.findElement(forEntrepreneur).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='banner']//h1[text()[contains(.,'Найдем инвестора для вашего бизнеса')]]")).isEnabled());
        return new EntrepreneurInfoPage(driver);
    }
    //'InvestorInfoPage' button "Инвестору"

    /**
     * Method consolidate actions needed for typical flow of opening login page
     */
    public LoginPage openLoginPage() {
        return navigateToLoginPage();
    }

    public InvestorInfoPage navigateToInfoInvestorPage() {
        driver.findElement(forInvestor).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='banner']//h1[text()[contains(.,'Инвестируйте в перспективные проекты')]]")).isEnabled());
        return new InvestorInfoPage(driver);
    }

    public InvestorInfoPage openInfoInvestorPage() {
        return navigateToInfoInvestorPage();
    }

    //'ProjectInfoPage' button "Проекты"
    public ProjectInfoPage projectsButton() {
        driver.findElement(forProjects).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='catalog']//h1[text()[contains(.,'Проекты')]]")).isEnabled());
        return new ProjectInfoPage(driver);
    }

    //'EnterInfoPage' button "Войти"
    public EnterPage enterButton() {
        driver.findElement(forEnter).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='login-block']//h3[text()[contains(.,'Войти')]]")).isEnabled());
        return new EnterPage(driver);
    }

    //######################_'Main'_######################
    //'Подать проект'
    public EntrepreneurContactsPage openRegisterProjectPage() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#banner .h1[class='h1']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.cssSelector("#banner .h3[class='h3']")).isEnabled());
        driver.findElement(registerProjectButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='entrepreneur-register-form']//h1[text()[contains(.,'Регистрация вашего бизнес-проекта')]]")).isEnabled());
        return new EntrepreneurContactsPage(driver);
    }

    //'Как мы работаем?'
    public HowWeAreWorkingContactsPage howWeAreWorkingButton() {
        driver.findElement(howWeAreWorkingButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='banner']//h1[text()[contains(.,'Найдем инвестора для вашего бизнеса')]]")).isEnabled());
        return new HowWeAreWorkingContactsPage(driver);
    }

    //'Успешные проекты'
    public SuccessfulProjectsPage moreSuccessfulProjectsButton() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='complete']//*[text()[contains(.,'Успешные проекты')]]")).isEnabled());
        driver.findElement(moreSuccessfulProjectsButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='catalog']//h1[text()[contains(.,'Проекты')]]")).isEnabled());
        return new SuccessfulProjectsPage(driver);
    }

    //'Миссия Equerest'
    public MissionEquerestPage missionEquerestButton() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='main']//*[text()[contains(.,'Мы убеждены, что за бизнесом должно стоять желание помогать людям')]]")).isEnabled());
        driver.findElement(missionEquerestButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='mission']//h1[text()[contains(.,'Миссия Equerest')]]")).isEnabled());
        return new MissionEquerestPage(driver);
    }

    //'Новые проекты'
    public NewProjectsPage moreNewProjectsButton() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='new_projects']//*[text()[contains(.,'Новые проекты')]]")).isEnabled());
        driver.findElement(moreNewProjectsButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='catalog']//h1[text()[contains(.,'Проекты')]]")).isEnabled());
        return new NewProjectsPage(driver);
    }

    //######################_'Footer'_######################
    //Worth It Logo
    public HomePage worthItFooterLogoButton() {
        driver.findElement(worthItFooterLogo).click();
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='footer']//*[text()[contains(.,'©')]]")).isEnabled());
        return this;
    }

    //'Инвестору' футер
    public InvestorInfoFooterPage investorInfoFooterButton() {
        driver.findElement(investorFooterButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='banner']//h1[text()[contains(.,'Инвестируйте в перспективные проекты')]]")).isEnabled());
        return new InvestorInfoFooterPage(driver);
    }

    //'Пропекты' футер
    public ProjectsInfoFooterPage projectsInfoFooterButton() {
        driver.findElement(projectsFooterButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='catalog']//h1[text()[contains(.,'Проекты')]]")).isEnabled());
        return new ProjectsInfoFooterPage(driver);
    }

    //'Инвестировать' футер
    public InvestInfoFooterPage investInfoFooterButton() {
        driver.findElement(investFooterButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='entrepreneur-register-form']//*[text()[contains(.,'Регистрация инвестора')]]")).isEnabled());
        return new InvestInfoFooterPage(driver);
    }

    //'Предпринимателю' футер
    public IentrepreneurInfoFooterPage ientrepreneurInfoFooterButton() {
        driver.findElement(ientrepreneurFooterButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='banner']//h1[text()[contains(.,'Найдем инвестора для вашего бизнеса')]]")).isEnabled());
        return new IentrepreneurInfoFooterPage(driver);
    }

    //'Миссия' футер
    public MissionInfoFooterPage missionInfoFooterButton() {
        driver.findElement(missionFooterButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='mission']//h1[text()[contains(.,'Миссия Equerest')]]")).isEnabled());
        return new MissionInfoFooterPage(driver);
    }

    //'Подать проект' футер
    public PostProjectInfoFooterPage postProjectInfoFooterButton() {
        driver.findElement(postProjectFooterButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='entrepreneur-register-form']//*[text()[contains(.,'Регистрация вашего бизнес-проекта')]]")).isEnabled());
        return new PostProjectInfoFooterPage(driver);
    }

    //'Контакты' футер
    public ContactsInfoFooterPage contactsInfoFooterButton() {
        driver.findElement(contactsFooterButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contact']//*[text()[contains(.,'Контакты')]]")).isEnabled());
        return new ContactsInfoFooterPage(driver);
    }

    //'Правила пользования' футер
    public TermsOfUseInfoFooterPage termsOfUseInfoFooterButton() {
        driver.findElement(termsOfUseFooterButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='terms']//*[text()[contains(.,'Правила пользования')]]")).isEnabled());
        return new TermsOfUseInfoFooterPage(driver);
    }

    //'Политика конфиденциальности' футер
    public PrivacyPolicyInfoFooterPage privacyPolicyInfoFooterButton() {
        driver.findElement(privacyPolicyFooterButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='terms']/div/div/h1[text()[contains(.,'Политика конфиденциальности')]]")).isEnabled());
        return new PrivacyPolicyInfoFooterPage(driver);
    }

    //'Политика обработки cookies' футер
    public CookiesProcessingPolicyInfoFooterPage cookiesProcessingPolicyInfoFooterButton() {
        driver.findElement(cookiesProcessingPolicyFooterButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='terms']/div/div/h1[text()[contains(.,'Политика обработки “cookies”')]]")).isEnabled());
        return new CookiesProcessingPolicyInfoFooterPage(driver);
    }

    public HomePage checkNewProjectsAreaPresence() {
        Assert.assertTrue(driver.findElement(moreNewProjectsArea).isEnabled());
        return this;
    }

    public HomePage checkNumberofNewProjectsShown(int expectedNumofElements) {
        List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id='new_projects']//div[@class ='flex-row']//div[contains(@class,'new_project')]"));
        Assert.assertEquals(expectedNumofElements, listOfElements.size());
        return this;
    }

    public HomePage checkThatNewProjectsSortedByDate() {
        List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id='new_projects']//div[@class ='flex-row']//div[contains(@class,'new_project')]"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date thisElementDate = new Date();
        Date previousElementDate = new Date(0);
        boolean dateSortisCorrect = false;
        for (int i = 0; i < listOfElements.size(); i++) {
            WebElement thisElement = listOfElements.get(i);
            String dateStr = thisElement.findElement(By.xpath(".//div[preceding-sibling::div[contains(.,'Подача проекта')]]/span")).getText();
            try {
                thisElementDate = sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (i > 0) {
                if (previousElementDate.compareTo(thisElementDate) >= 0) {
                    dateSortisCorrect = true;
                }
            }
            previousElementDate = thisElementDate;
        }
        Assert.assertTrue(dateSortisCorrect);
        return this;
    }

    public HomePage checkMoreNewProjectsLinkIsPresent() {
        WebElement moreProjLink = driver.findElement(moreNewProjectsLink);
        Assert.assertTrue(moreProjLink.isEnabled());
        return this;
    }

    public HomePage checkMoreNewProjectsLinkBehaviourOnMouseHovering() {
        WebElement moreProjLink = driver.findElement(moreNewProjectsLink);
        Actions builder = new Actions(driver);
        builder.moveToElement(moreProjLink);
        builder.build().perform();
        Assert.assertEquals(moreProjLink.getCssValue("text-decoration"), "underline");
        Assert.assertEquals(moreProjLink.getCssValue("cursor"), "pointer");
        return this;
    }

    public CataloguePage moveToCataloguePageByClickingOnMoreNewProjects() {
        driver.findElement(moreNewProjectsLink).click();
        Assert.assertEquals(driver.getCurrentUrl(), CataloguePage.pageURL);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='catalog']//h1[text()[contains(.,'Проекты')]]")).isEnabled());
        return new CataloguePage(driver);
    }

    public HomePage checkNewProjectsAreaVisibility() {
        Assert.assertTrue(driver.findElement(moreNewProjectsArea).isDisplayed());
        return this;
    }

    public HomePage checkThatEachProjectInNewProjectsAreaHasFullInfo() {
        List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id='new_projects']//div[@class ='flex-row']//div[contains(@class,'new_project')]"));
        for (int i = 0; i < listOfElements.size(); i++) {
            WebElement thisElement = listOfElements.get(i);
            Assert.assertTrue(thisElement.findElement(By.className("title")).isDisplayed());
            Assert.assertTrue(thisElement.findElement(By.cssSelector(".new_project>header[style^='background-image']")).isDisplayed());
            Assert.assertTrue(thisElement.findElement(By.className("description")).isDisplayed());
            Assert.assertTrue(thisElement.findElement(By.xpath(".//a[contains(.,'Перейти на страницу проекта')]")).isDisplayed());
            Assert.assertTrue(thisElement.findElement(By.xpath(".//span[contains(.,'Локация')]")).isDisplayed());
            Assert.assertTrue(thisElement.findElement(By.xpath(".//span[contains(.,'Подача проекта')]")).isDisplayed());
            Assert.assertTrue(thisElement.findElement(By.xpath(".//span[contains(.,'Сумма инвестиций') or contains (.,'Стоимость продажи доли')]")).isDisplayed());
            System.out.println("Check for element " + (i + 1) + " is successful");
        }
        return this;
    }
    public HomePage assertLogoPresent(){
        Assert.assertTrue(driver.findElement(equerestLogo)!=null);
        return this;
    }
    public HomePage assertCurrentUrlIsEquerestHomepage(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://dev.equerest.com/", currentUrl);
        return this;
    }
    public HomePage checkSuccessfulProjectsAreaPresence(){
        WebElement successProjArea = driver.findElement(successfulProjectsArea);
        Assert.assertTrue(successProjArea.isDisplayed());
        return this;
    }
    public HomePage checkSuccessfulProjectsLabelPresence(){
        WebElement successProjArea = driver.findElement(successfulProjectsArea);
        Assert.assertTrue(successProjArea.findElement(successfulProjectsLabel).isDisplayed());
        return this;
    }
    public HomePage checkMoreSuccessfulProjectsButtonPresence(){
        WebElement successProjArea = driver.findElement(successfulProjectsArea);
        Assert.assertTrue(successProjArea.findElement(moreSuccessfulProjectsButton).isDisplayed());
        return this;
    }
}
