package com.equerest.pages.homepage;

/**
 * Created by Eduard Aliiev on 10/21/16;
 */
/*public class HomePage extends AbstractPage {
    //######################_locator for the Equerest Logo_######################
    private final By equerestLogo = By.xpath("/html/body/div[1]/header/div/nav/div[1]/div[1]//img[contains(@src, 'header_logo.svg')]");
    //######################_locators for the 'Header' menu_######################
    private final By missionButton = By.xpath("/html/body/div[1]/header/*//*[text()[contains(.,'Миссия')]]");
    private final By entrepreneurButton = By.xpath("/html/body/div[1]/header/*//*[text()[contains(.,'Предпринимателю')]]");
    private final By investorButton = By.xpath("/html/body/div[1]/header/*//*[text()[contains(.,'Инвестору')]]");
    private final By projectsButton = By.xpath("/html/body/div[1]/header/*//*[text()[contains(.,'Проекты')]]");
    private final By enterButton = By.xpath("/html/body/div[1]/header/*//*[text()[contains(.,'Войти')]]");
    //######################_locotors for the ('Подать проект' и 'Как мы работаем?')_######################
    private final By PostProjectButton = By.xpath("/*//*[@id='banner']//a[text()[contains(.,'Подать проект')]]");
    private final By HowWeAreWorkingContactsPage = By.xpath("./*//*[@id='banner']//a[text()[contains(.,'Как мы работаем?')]]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    //######################_Equerest Logo_######################
    public EquerestLogoButton equerestLogoButton() {
        driver.findElement(equerestLogo).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#banner .h1[class='h1']")).isEnabled());
        return new EquerestLogoButton(driver);
    }
    //######################_'Header' menu_######################
    //'MissionInfoPage' button "Миссия"
    public MissionInfoPage missionButton() {
        driver.findElement(missionButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("/*//*[@id='mission']//h1[text()[contains(.,'Миссия Equerest')]]")).isEnabled());
        return new MissionInfoPage(driver);
    }
    //'EntrepreneurButton' button "Предпринимателю"
    public EntrepreneurButton entrepreneurButton() {
        driver.findElement(entrepreneurButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("/*//*[@id='banner']//h1[text()[contains(.,'Найдем инвестора для вашего бизнеса')]]")).isEnabled());
        return new EntrepreneurButton(driver);
    }
    //'InvestorButton' button "Инвестору"
    public InvestorButton investorButton() {
        driver.findElement(investorButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("/*//*[@id='banner']//h1[text()[contains(.,'Инвестируйте в перспективные проекты')]]")).isEnabled());
        return new InvestorButton(driver);
    }
    //'ProjectInfoPage' button "Проекты"
    public ProjectInfoPage projectsButton() {
        driver.findElement(projectsButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("/*//*[@id='catalog']//h1[text()[contains(.,'Проекты')]]")).isEnabled());
        return new ProjectInfoPage(driver);
    }
    //'EnterButton' button "Войти"
    public EnterButton enterButton() {
        driver.findElement(enterButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("/*//*[@id='login-block']//h3[text()[contains(.,'Войти')]]")).isEnabled());
        return new EnterButton(driver);
    }
    //######################_'Подать проект' и 'Как мы работаем?'_######################
    public PostProjectButton postProjectButton() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#banner .h1[class='h1']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.cssSelector("#banner .h3[class='h3']")).isEnabled());
        driver.findElement(PostProjectButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("/*//*[@id='entrepreneur-registration-form']//h1[text()[contains(.,'Регистрация вашего бизнес-проекта')]]")).isEnabled());
        return new PostProjectButton(driver);
    }
    public HowWeAreWorkingContactsPage howWeAreWorkingButton() {
        driver.findElement(HowWeAreWorkingContactsPage).click();
        Assert.assertTrue(driver.findElement(By.xpath("/*//*[@id='banner']//h1[text()[contains(.,'Найдем инвестора для вашего бизнеса')]]")).isEnabled());
        return new HowWeAreWorkingContactsPage(driver);
    }


}*/
