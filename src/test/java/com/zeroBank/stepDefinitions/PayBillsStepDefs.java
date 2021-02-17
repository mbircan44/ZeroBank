package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.pages.PayBillsPage;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PayBillsStepDefs {

    @Given("The user access the Pay Bills Page")
    public void the_user_access_the_Pay_Bills_Page() {

        new AccountSummaryPage().payBillsTab.click();

    }

    @Then("Account activity page should have the title Zero - Pay Bills")
    public void account_activity_page_should_have_the_title_Zero_Pay_Bills() {

        String currentTitle = Driver.get().getTitle();
        String actualTitle = "Zero - Pay Bills";

        Assert.assertEquals(currentTitle, actualTitle);

    }

    @When("The user enters the amount and date and click on pay")
    public void the_user_enters_the_amount_and_date_and_click_on_pay() {

        new PayBillsPage().amountInput.sendKeys("1000");
        new PayBillsPage().dateInput.sendKeys("2021-02-18");
        new PayBillsPage().payButton.click();

    }
    @Then("The payment was successfully submitted. should be displayed")
    public void the_payment_was_successfully_submitted_should_be_displayed() {

        String expectedMessage= "The payment was successfully submitted.";
        String actualMessage = new PayBillsPage().successMessage.getText();

   Assert.assertEquals(expectedMessage,actualMessage);

    }

    @When("The user tries to make a payment without entering the amount or date")
    public void the_user_tries_to_make_a_payment_without_entering_the_amount_or_date() {

        new PayBillsPage().amountInput.clear();
        new PayBillsPage().dateInput.clear();
        new PayBillsPage().payButton.click();

    }

    @Then("Please fill out this field. message should be displayed")
    public void please_fill_out_this_field_message_should_be_displayed() {

        String actualMessage= new PayBillsPage().amountInput.getAttribute("validationMessage");
        String expectedMessage = "Please fill out this field.";
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("The user enters alphabetical or special characters to amount field")
    public void the_user_enters_alphabetical_or_special_characters_to_amount_field() {

        new PayBillsPage().amountInput.sendKeys("asgh#&/)");
    }

    @Then("The amount field should not accept")
    public void the_amount_field_should_not_accept() {

        String expectedInput= "";
        String actualInput= new PayBillsPage().amountInput.getAttribute("characters");
        Assert.assertTrue(new PayBillsPage().amountInput.getAttribute("characters").isEmpty());
    }
    @When("The user enters alphabetical characters to date field")
    public void the_user_enters_alphabetical_characters_to_date_field() {
       new PayBillsPage().dateInput.sendKeys("asgds");
    }

    @Then("The date field should not accept")
    public void the_date_field_should_not_accept() {

        String expectedInput = "";
        String actualInput = new PayBillsPage().dateInput.getAttribute("characters");
        Assert.assertTrue(new PayBillsPage().dateInput.getAttribute("characters").isEmpty());
    }


}
