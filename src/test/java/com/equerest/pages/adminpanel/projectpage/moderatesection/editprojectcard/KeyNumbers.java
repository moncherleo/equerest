package com.equerest.pages.adminpanel.projectpage.moderatesection.editprojectcard;

import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg Nesterov on 28.09.2016;
 */
public class KeyNumbers extends EditProjectPage {

    private By addNumbersElement = By.xpath("//*[@id='wrapper']/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/h3/span/a");
    private By editFieldsElement = By.xpath("//*[@id='wrapper']/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/div/div/div/button");
    private By fieldNumber = By.id("digit_key_$index");
    private By fieldSymbol = By.id("digit_sup_$index");
    private By fieldDescription = By.id("digit_descr_$index");
    private By applyButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/button[2]");
    private By discardButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/button[1]");
    private By removeButton = By.xpath("//*[@id='wrapper']/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/a");


    public KeyNumbers(WebDriver driver){
        super(driver);
    }

    @Override
    public void click(By locator) {
        super.click(locator);
    }

    @Override
    public void fillField(By locator, String data){
        super.fillField(locator, data);
    }


    public KeyNumbers addNumbersButton(){
        scrollTo(driver.findElement(addNumbersElement));
        click(addNumbersElement);
        return this;
    }

    public KeyNumbers editFieldsButton(){
        click(editFieldsElement);
        return this;
    }

    public KeyNumbers fillNumber(String dataNumber){
        driver.findElement(fieldNumber).clear();
        fillField(fieldNumber, dataNumber);
        return this;
    }

    public KeyNumbers fillSybmol(String dataSymbol){
        driver.findElement(fieldSymbol).clear();
        fillField(fieldSymbol, dataSymbol);
        return this;
    }

    public KeyNumbers fillDescription(String dataDescription){
        driver.findElement(fieldDescription).clear();
        fillField(fieldDescription, dataDescription);
        return this;
    }
    public KeyNumbers applyChenges(){
        click(applyButton);
        return this;
    }

    public KeyNumbers DiscardChanges(){
        click(discardButton);
        return this;
    }

    public KeyNumbers removeNumbers(){
        click(removeButton);
        return this;
    }




}
