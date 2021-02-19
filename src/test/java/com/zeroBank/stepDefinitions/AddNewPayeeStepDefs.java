package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {

        new AccountSummaryPage().payBillsTab.click();
        new PayBillsPage().addNewPayeeTab.click();

    }
    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> dataTable) {

        PayBillsPage addNewPayee = new PayBillsPage();

        addNewPayee.payeeNameInput.sendKeys(dataTable.get("Payee Name"));
        addNewPayee.payeeAddressInput.sendKeys(dataTable.get("Payee Address"));
        addNewPayee.accountInput.sendKeys(dataTable.get("Account"));
        addNewPayee.payeeDetailsInput.sendKeys(dataTable.get("Payee details"));
        addNewPayee.addButton.click();

    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {

        String expectedMessage = "The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        String actualMessage = new PayBillsPage().successMessageofNewPayee.getText();

        Assert.assertEquals(expectedMessage,actualMessage);
    }
}











