package com.equerest.pages.homepages.headermenu;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.homepages.headermenu.Enter.EnterSection;
import com.equerest.pages.homepages.headermenu.Entrepreneur.EntrepreneurSection;
import com.equerest.pages.homepages.headermenu.Investor.InvestorSection;
import com.equerest.pages.homepages.headermenu.Mission.MissionSection;
import com.equerest.pages.homepages.headermenu.Projects.ProjectsSection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Eduard Aliiev on 10/16/16;
 */
public class HeaderMenu extends AbstractPage {

    //The locators of the 'Header' menu
    private final By missionButton = By.xpath("/html/body/div[1]/header//*[text()[contains(.,'Миссия')]]");
    private final By entrepreneurButton =By.xpath("/html/body/div[1]/header//*[text()[contains(.,'Предпринимателю')]]");
    private final By investorButton =By.xpath("/html/body/div[1]/header//*[text()[contains(.,'Инвестору')]]");
    private final By projectsButton =By.xpath("/html/body/div[1]/header//*[text()[contains(.,'Проекты')]]");
    private final By enterButton =By.xpath("/html/body/div[1]/header//*[text()[contains(.,'Войти')]]");

    public HeaderMenu(WebDriver driver){
        super(driver);
    }

    //'Mission' button "Миссия"
    public MissionSection missionSection(){
        driver.findElement(missionButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='mission']//h1[text()[contains(.,'Миссия Equerest')]]")).isEnabled());
        return new MissionSection(driver);
    }
    //'Entrepreneur' button "Предпринимателю"
    public EntrepreneurSection entrepreneurSection(){
        driver.findElement(entrepreneurButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='banner']//h1[text()[contains(.,'Найдем инвестора для вашего бизнеса')]]")).isEnabled());
        return new EntrepreneurSection(driver);
    }
    //'Investor' button "Инвестору"
    public InvestorSection investorSection(){
        driver.findElement(investorButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='banner']//h1[text()[contains(.,'Инвестируйте в перспективные проекты')]]")).isEnabled());
        return new InvestorSection(driver);
    }
    //'Projects' button "Проекты"
    public ProjectsSection projectsSection(){
        driver.findElement(projectsButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='catalog']//h1[text()[contains(.,'Проекты')]]")).isEnabled());
        return new ProjectsSection(driver);
    }
    //'Enter' button "Войти"
    public EnterSection enterSection(){
        driver.findElement(enterButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='login-block']//h3[text()[contains(.,'Войти')]]")).isEnabled());
        return new EnterSection(driver);
    }

}
