package com.zeroBank.pages;

import com.zeroBank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage{
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//h2")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//div[3]/div/table/thead/tr/th")
    public List<WebElement> accountColumns;

    @FindBy(xpath = "//a[text()='Account Activity']")
    public WebElement accountActivityTab;

    @FindBy(xpath = "//a[text()='Pay Bills']")
    public WebElement payBillsTab;

    @FindBy(xpath = "//tr[1]//a[text()='Savings']")
    public WebElement savings1;

    @FindBy(xpath = "//a[text()='Brokerage']")
    public  WebElement brokerage;

    @FindBy(xpath = "//a[text()='Checking']")
    public WebElement checking;

    @FindBy(xpath = "//a[text()='Credit Card']")
    public WebElement creditCard;

    @FindBy(xpath = "//a[text()='Loan']")
    public WebElement loan;

}