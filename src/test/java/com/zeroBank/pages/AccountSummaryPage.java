package com.zeroBank.pages;

import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage{
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//tr[1]//a[text()='Savings']")
    public WebElement savings1;

    @FindBy(xpath = "//tr[2]//a[text()='Savings']")
    public WebElement savings2;

    @FindBy(xpath = "//tr[1]//a[text()='Brokerage']")
    public WebElement brokerage;

    @FindBy(xpath = "//tr[1]//a[text()='Checking']")
    public WebElement checking;

    @FindBy(xpath = "//tr[2]//a[text()='Credit Card']")
    public WebElement creditCard;

    @FindBy(xpath = "//tr[1]//a[text()='Loan']")
    public WebElement loan;

    @FindBy(xpath = "//a[text()='Account Activity']")
    public WebElement accountActivity;

    @FindBy(css = "#pay_bills_tab")
    public WebElement payBills;

    @FindBy(xpath = "//div[3]/div/table/thead/tr/th")
    public List<WebElement> headersCreditAcc;

    @FindBy(xpath = "//h2")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//div[3]/div/table/thead/tr/th")
    public List<WebElement> accountColumns;
}