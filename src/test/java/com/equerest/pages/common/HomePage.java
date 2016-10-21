package com.equerest.pages.common;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.common.registration.EntrepreneurContactsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by cherleo on 9/19/16.
 */
public class HomePage extends AbstractPage {
    private String url;
    private static final String LOGIN_PAGE_URL = "registration#/";
    private final By equerestLogo = By.xpath("/html/body/div[1]/header/div/nav/div[1]/div[1]//img[contains(@src, 'header_logo.svg')]");
    //######################_locators for the 'Header' menu_######################
    private final By forMission = By.xpath("/html/body/div[1]/header//*[text()[contains(.,'Миссия')]]");
    private By forEntrepreneur = By.xpath("//*[@id='header']//*[text()[contains(.,'Предпринимателю')]]");
    private By forInvestor = By.xpath("//*[@id='header']//*[text()='Инвестору                                ']");
    private final By forProjects = By.xpath("/html/body/div[1]/header//*[text()[contains(.,'Проекты')]]");
    private final By forEnter = By.xpath("/html/body/div[1]/header//*[text()[contains(.,'Войти')]]");
    //######################_locotors for the ('Подать проект' и 'Как мы работаем?')_######################
    private By registerProjectButton = By.cssSelector("#main .button-green.bordered");
    private final By howWeAreWorkingButton = By.xpath("//*[@id='banner']//a[text()[contains(.,'Как мы работаем?')]]");


    public HomePage(String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }

    public HomePage(WebDriver driver) {
        super(driver);
        this.url = "https://dev.equerest.com/";
    }

    @Step("Open home page")
    public HomePage open(){
        driver.navigate().to(url);
        return this;
    }
    @Step("Navigate to login page")
    public LoginPage navigateToLoginPage(){
        driver.navigate().to(url+LOGIN_PAGE_URL);
        return new LoginPage(driver);
    }

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
    public EntrepreneurInfoPage navigateToEntrepreneurInfoPage(){
        driver.findElement(forEntrepreneur).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='banner']//h1[text()[contains(.,'Найдем инвестора для вашего бизнеса')]]")).isEnabled());
        return new EntrepreneurInfoPage(driver);
    }
    //'InvestorInfoPage' button "Инвестору"
    /** Method consolidate actions needed for typical flow of opening login page*/
    public LoginPage openLoginPage(){
        return navigateToLoginPage();
    }

    public InvestorInfoPage navigateToInfoInvestorPage(){
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
    //######################_'Подать проект' и 'Как мы работаем?'_######################
    public EntrepreneurContactsPage openRegisterProjectPage(){
        Assert.assertTrue(driver.findElement(By.cssSelector("#banner .h1[class='h1']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.cssSelector("#banner .h3[class='h3']")).isEnabled());
        driver.findElement(registerProjectButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='entrepreneur-register-form']//h1[text()[contains(.,'Регистрация вашего бизнес-проекта')]]")).isEnabled());
        return new EntrepreneurContactsPage(driver);
    }
    public HowWeAreWorkingContactsPage howWeAreWorkingButton() {
        driver.findElement(howWeAreWorkingButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='banner']//h1[text()[contains(.,'Найдем инвестора для вашего бизнеса')]]")).isEnabled());
        return new HowWeAreWorkingContactsPage(driver);
    }



}
