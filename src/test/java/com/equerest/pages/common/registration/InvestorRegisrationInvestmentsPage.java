package com.equerest.pages.common.registration;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.common.FinishPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Михаїл on 26.09.2016.
 */
public class InvestorRegisrationInvestmentsPage extends AbstractPage {
    private By checkbox_agree = By.xpath("//*[@for='checkbox_agree']");
    private By finishReg = By.cssSelector("");
    private String radiobuttonPath = "//*[@class='input-radio-group']//*[@for='";
    private String radiobuttonPath2 = "']";

    public InvestorRegisrationInvestmentsPage(WebDriver driver){super(driver);}

    public FinishPage chooseInvestments(String investorRoleID, String investplanID, String dealquanttityID){
        driver.findElement(By.xpath(radiobuttonPath + investorRoleID + radiobuttonPath2)).click();
        driver.findElement(By.xpath(radiobuttonPath + investplanID + radiobuttonPath2)).click();
        driver.findElement(By.xpath(radiobuttonPath + dealquanttityID + radiobuttonPath2)).click();
        driver.findElement(checkbox_agree).click();
        driver.findElement(checkbox_agree).isSelected();
        return new FinishPage(driver);
    }
}
