package com.zeroBank.pages;

import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayBillsPage extends BasePage{

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "sp_amount")
    public WebElement amountInput;

    @FindBy(id = "sp_date")
    public WebElement dateInput;

    @FindBy(id = "pay_saved_payees")
    public  WebElement payButton;

    @FindBy(xpath = "//span[text()='The payment was successfully submitted.']")
    public WebElement successMessage;

    @FindBy(xpath = "//a[text()='Add New Payee']")
    public WebElement addNewPayeeTab;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameInput;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressInput;

    @FindBy(id = "np_new_payee_account")
    public WebElement accountInput;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsInput;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id = "alert_content")
    public WebElement successMessageofNewPayee;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropDown;

    @FindBy(xpath = "//select[@id='pc_currency']/option")
    public List<WebElement> currencyOptions;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostButton;

    @FindBy(id = "pc_amount")
    public WebElement amountInputofPFC;

}
