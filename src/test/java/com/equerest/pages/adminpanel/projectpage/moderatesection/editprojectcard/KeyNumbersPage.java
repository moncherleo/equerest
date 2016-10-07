package com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard;

import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Oleg Nesterov on 28.09.2016;
 */
public class KeyNumbersPage extends EditProjectPage {

    private By addNumbersElement = By.xpath("//*[@id='wrapper']/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/h3/span/a");
    private By editFieldsElement = By.xpath("//*[@id='wrapper']/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/div/div/div/button");
    private By fieldNumber = By.id("digit_key_$index");
    private By fieldSymbol = By.id("digit_sup_$index");
    private By fieldDescription = By.id("digit_descr_$index");
    private By applyButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/button[2]");
    private By discardButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/button[1]");
    private By removeButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/a");
    private By resultVerificationMessage = By.xpath("//*[@id='toast-container']//*[text()[contains(.,'Цифра добавлена')]]");
    private By keyNumbersSection = By.xpath("//*[@id='wrapper']/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]");


    public KeyNumbersPage(WebDriver driver){
        super(driver);
    }

    public KeyNumbersPage addNumbersButton(){
        scrollTo(driver.findElement(addNumbersElement));
        click(addNumbersElement);
        return this;
    }

    public KeyNumbersPage editFieldsButton(){
        click(editFieldsElement);
        return this;
    }

    public KeyNumbersPage fillNumber(String dataNumber){
        fillField(fieldNumber, dataNumber);
        return this;
    }

    public KeyNumbersPage fillSybmol(String dataSymbol){
        fillField(fieldSymbol, dataSymbol);
        return this;
    }

    public KeyNumbersPage fillDescription(String dataDescription){
        fillField(fieldDescription, dataDescription);
        return this;
    }
    public KeyNumbersPage applyChenges(){
        click(applyButton);
        return this;
    }

    public KeyNumbersPage DiscardChanges(){
        click(discardButton);
        return this;
    }

    public KeyNumbersPage removeNumbers(){
        click(removeButton);
        return this;
    }

    public KeyNumbersPage alertResultMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(resultVerificationMessage)));
        return this;
    }

    public KeyNumbersPage assertKeyNumbersAppears(String symbol){
        Assert.assertTrue(driver.findElement(keyNumbersSection).getText().contains(symbol));
        return this;
    }
}
