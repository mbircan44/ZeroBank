package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.pages.PayBillsPage;
import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() throws InterruptedException {

        new AccountSummaryPage().payBillsTab.click();
        new PayBillsPage().purchaseForeignCurrencyTab.click();
        Thread.sleep(1000);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedOptions) throws InterruptedException {

        Thread.sleep(1000);
        List<String> actualOptions = BrowserUtils.getElementsText(new PayBillsPage().currencyOptions);

        for (int i = 0; i < expectedOptions.size(); i++) {

            Assert.assertTrue(actualOptions.contains(expectedOptions.get(i)));
        }
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

        new PayBillsPage().amountInputofPFC.sendKeys("3500");
        new PayBillsPage().calculateCostButton.click();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        Alert alert = Driver.get().switchTo().alert();
        boolean check = (alert.getText().length()>0);
        Assert.assertTrue(check);
        alert.accept();
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {

        Select select = new Select(new PayBillsPage().currencyDropDown);
        select.selectByIndex(7);
        new PayBillsPage().calculateCostButton.click();
    }




    }












