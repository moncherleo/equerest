package com.equerest.pages.common.registration;

import com.equerest.pages.AbstractPage;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Mykhaylo Dmytrenko on 26.09.2016.
 */
public class InvestorRegistrationInvestmentsPage extends AbstractPage {

    private By checkboxTerms = By.xpath("//*[@type='checkbox']");
    private By finishReg = By.xpath("//*[text()='Завершить регистрацию']");
    private By disabledFinishReg = By.xpath(".//div[@class='form-controls']/button[@class[contains(.,'is-disabled')]]");
    private String radiobuttonPath = "//*[@class='input-radio-group']//*[@for='";
    private String radiobuttonPath2 = "']";
    @FindBy(how = How.XPATH, using = ".//div[@class='form-controls']/button[@class[contains(.,'is-disabled')]]")
    public static WebElement finishRegDisabled;
    //######################_locators for Radiobutton Groups_######################
    @FindBy(how = How.XPATH, using = "//label[contains(., 'Выберите роль')]/following-sibling::div[@class='radio-group']")
    public static WebElement chooseRoleRadioButtonGroup;
    @FindBy(how = How.XPATH, using = "//label[contains(., 'Сумма инвестиций в год')]/following-sibling::div[@class='radio-group']")
    public static WebElement annualInvestmentSumRadioButtonGroup;
    @FindBy(how = How.XPATH, using = "//label[contains(., 'Количество сделок в год')]/following-sibling::div[@class='radio-group']")
    public static WebElement numberOfDealsPerYearRadioButtonGroup;
    //######################_locators for each Radiobutton label_######################
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'Посредник')]")
    public static WebElement intermediaryRole;
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'Частный инвестор')]")
    public static WebElement privateInvestorRole;
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'Венчурный фонд')]")
    public static WebElement ventureFundRole;
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'До $50 тыс.')]")
    public static WebElement lessThan50Investment;
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'$50-100 тыс.')]")
    public static WebElement from50to100Investment;
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'$100-500 тыс.')]")
    public static WebElement from100to500Investment;
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'Более $500 тыс.')]")
    public static WebElement biggerThan500Investment;
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'Ни один из ответов')]")
    public static WebElement noneOfAboveInvestment;
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'1-3')]")
    public static WebElement from1to3DealQty;
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'До 5')]")
    public static WebElement lessThan5DealQty;
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'Более 5')]")
    public static WebElement biggerThan5DealQty;
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Ни один из ответов') and @for ='dealQuantity_4']")
    public static WebElement noneOfAboveDealQty;
    //######################_locators for each Radiobutton inputField_######################
    @FindBy(how = How.ID, using = "role_1")
    public static WebElement intermediaryRoleInput;
    @FindBy(how = How.ID, using = "role_2")
    public static WebElement privateInvestorRoleInput;
    @FindBy(how = How.ID, using = "role_3")
    public static WebElement ventureFundRoleInput;
    @FindBy(how = How.ID, using = "dealSumm_1")
    public static WebElement lessThan50InvestmentInput;
    @FindBy(how = How.ID, using = "dealSumm_2")
    public static WebElement from50to100InvestmentInput;
    @FindBy(how = How.ID, using = "dealSumm_3")
    public static WebElement from100to500InvestmentInput;
    @FindBy(how = How.ID, using = "dealSumm_4")
    public static WebElement biggerThan500InvestmentInput;
    @FindBy(how = How.ID, using = "dealSumm_5")
    public static WebElement noneOfAboveInvestmentInput;
    @FindBy(how = How.ID, using = "dealQuantity_1")
    public static WebElement from1to3DealQtyInput;
    @FindBy(how = How.ID, using = "dealQuantity_2")
    public static WebElement lessThan5DealQtyInput;
    @FindBy(how = How.ID, using = "dealQuantity_3")
    public static WebElement biggerThan5DealQtyInput;
    @FindBy(how = How.ID, using = "dealQuantity_4")
    public static WebElement noneOfAboveDealQtyInput;


    public InvestorRegistrationInvestmentsPage(WebDriver driver) {
        super(driver);
    }

    public InvestorRegistrationInvestmentsPage fillForm(String investorRoleID, String investplanID, String dealquanttityID) {
        click(By.xpath(radiobuttonPath + investorRoleID + radiobuttonPath2));
        click(By.xpath(radiobuttonPath + investplanID + radiobuttonPath2));
        click(By.xpath(radiobuttonPath + dealquanttityID + radiobuttonPath2));
        return this;
    }

    public InvestorRegistrationInvestmentsPage checkboxAgree() {
        clickJS(checkboxTerms);
        return this;
    }

    public InvestorRegistrationFinishPage finishRegistration() {
        driver.findElement(finishReg).click();
        return new InvestorRegistrationFinishPage(driver);
    }

    public InvestorRegistrationInvestmentsPage selectRadioButton(WebElement radioButtonInput) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", radioButtonInput);
        Assert.assertTrue(radioButtonInput.isSelected());
        return this;
    }

    public InvestorRegistrationInvestmentsPage checkThatFinishRegistrationButtonIsDisabled() {
        Assert.assertTrue(finishRegDisabled.isDisplayed());
        return this;
    }

    public InvestorRegistrationInvestmentsPage checkThatFinishRegistrationButtonIsEnabled() {
        WebElement regButton = driver.findElement(finishReg);
        Assert.assertTrue(regButton.isDisplayed());
        Assert.assertTrue(driver.findElements(disabledFinishReg).size() < 1);
        return this;
    }

    public InvestorRegistrationInvestmentsPage checkThatOnlyOneElementOfTheGroupIsSelected(WebElement radioButtonGroup) {
        if (radioButtonGroup.equals(chooseRoleRadioButtonGroup)) {
            System.out.println("Checking role radiobutton group");
            if (privateInvestorRoleInput.isSelected()) {
                Assert.assertFalse(intermediaryRoleInput.isSelected());
                Assert.assertFalse(ventureFundRoleInput.isSelected());
            } else if (intermediaryRoleInput.isSelected()) {
                Assert.assertFalse(privateInvestorRoleInput.isSelected());
                Assert.assertFalse(ventureFundRoleInput.isSelected());
            } else if (ventureFundRoleInput.isSelected()) {
                Assert.assertFalse(privateInvestorRoleInput.isSelected());
                Assert.assertFalse(intermediaryRoleInput.isSelected());
            } else
                System.out.println("No radiobutton is selected");
        } else if (radioButtonGroup.equals(annualInvestmentSumRadioButtonGroup)) {
            System.out.println("Checking annual investments group");
            if (lessThan50InvestmentInput.isSelected()) {
                Assert.assertFalse(from50to100InvestmentInput.isSelected());
                Assert.assertFalse(from100to500InvestmentInput.isSelected());
                Assert.assertFalse(biggerThan500InvestmentInput.isSelected());
                Assert.assertFalse(noneOfAboveInvestmentInput.isSelected());
            } else if (from50to100InvestmentInput.isSelected()) {
                Assert.assertFalse(lessThan50Investment.isSelected());
                Assert.assertFalse(from100to500InvestmentInput.isSelected());
                Assert.assertFalse(biggerThan500InvestmentInput.isSelected());
                Assert.assertFalse(noneOfAboveInvestmentInput.isSelected());
            } else if (from100to500InvestmentInput.isSelected()) {
                Assert.assertFalse(lessThan50Investment.isSelected());
                Assert.assertFalse(from50to100InvestmentInput.isSelected());
                Assert.assertFalse(biggerThan500InvestmentInput.isSelected());
                Assert.assertFalse(noneOfAboveInvestmentInput.isSelected());
            } else if (biggerThan500InvestmentInput.isSelected()) {
                Assert.assertFalse(lessThan50Investment.isSelected());
                Assert.assertFalse(from50to100InvestmentInput.isSelected());
                Assert.assertFalse(from100to500InvestmentInput.isSelected());
                Assert.assertFalse(noneOfAboveInvestmentInput.isSelected());
            } else if (noneOfAboveInvestmentInput.isSelected()) {
                Assert.assertFalse(lessThan50Investment.isSelected());
                Assert.assertFalse(from50to100InvestmentInput.isSelected());
                Assert.assertFalse(from100to500InvestmentInput.isSelected());
                Assert.assertFalse(biggerThan500InvestmentInput.isSelected());
            } else
                System.out.println("No radiobutton is selected in this group");

        } else if (radioButtonGroup.equals(numberOfDealsPerYearRadioButtonGroup)) {
            System.out.println("Checking deals per year radiobutton group");
            if (from1to3DealQtyInput.isSelected()) {
                Assert.assertFalse(lessThan5DealQtyInput.isSelected());
                Assert.assertFalse(biggerThan5DealQtyInput.isSelected());
                Assert.assertFalse(noneOfAboveDealQtyInput.isSelected());
            } else if (lessThan5DealQtyInput.isSelected()) {
                Assert.assertFalse(from1to3DealQtyInput.isSelected());
                Assert.assertFalse(biggerThan5DealQtyInput.isSelected());
                Assert.assertFalse(noneOfAboveDealQtyInput.isSelected());
            } else if (biggerThan5DealQtyInput.isSelected()) {
                Assert.assertFalse(from1to3DealQtyInput.isSelected());
                Assert.assertFalse(lessThan5DealQtyInput.isSelected());
                Assert.assertFalse(noneOfAboveDealQtyInput.isSelected());
            } else if (noneOfAboveDealQtyInput.isSelected()) {
                Assert.assertFalse(from1to3DealQtyInput.isSelected());
                Assert.assertFalse(lessThan5DealQtyInput.isSelected());
                Assert.assertFalse(biggerThan5DealQtyInput.isSelected());
            } else
                System.out.println("No radiobutton is selected in this group");
        } else {
            System.out.println("Wrong radiobutton group entered");
        }
        return this;
    }
}
