package com.equerest.pages.common.registration;

import com.equerest.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Mykhaylo Dmytrenko on 26.09.2016.
 */
public class InvestorRegisrationInvestmentsPage extends AbstractPage {
    private By checkbox_agree = By.xpath("//*[@type='checkbox']");
    private By finishReg = By.xpath("//*[text()='Завершить регистрацию']");
    private String radiobuttonPath = "//*[@class='input-radio-group']//*[@for='";
    private String radiobuttonPath2 = "']";

    public InvestorRegisrationInvestmentsPage(WebDriver driver){super(driver);}

    public InvestorRegisrationInvestmentsPage fillForm(String investorRoleID, String investplanID, String dealquanttityID){
        click(By.xpath(radiobuttonPath + investorRoleID + radiobuttonPath2));
        click(By.xpath(radiobuttonPath + investplanID + radiobuttonPath2));
        click(By.xpath(radiobuttonPath + dealquanttityID + radiobuttonPath2));
        return this;
    }

    public InvestorRegisrationInvestmentsPage checkboxAgree(){
        clickJS(checkbox_agree);
        return this;
    }

    public FinishPage finishRegistration(){
        driver.findElement(finishReg).click();
        return new FinishPage(driver);
    }

}
