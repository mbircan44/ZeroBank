package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.pages.LoginPage;
import com.zeroBank.pages.MainPage;
import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.ConfigurationReader;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class AccountSummaryStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() throws InterruptedException {

//        Driver.get().get(ConfigurationReader.get("url"));
        new MainPage().signButton.click();
        new LoginPage().login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));

        if (Driver.get().findElement(By.id("details-button")).isDisplayed()) {
//          For pass to security FOR CHROME ( 2 Steps )
            Driver.get().findElement(By.id("details-button")).click();
            Driver.get().findElement(By.id("proceed-link")).click();
        }
    }
    @Then("The user access the Account Summary Page and have the title Zero - Account Summary")
    public void the_user_access_the_Account_Summary_Page_and_have_the_title_Zero_Account_Summary() {

        Assert.assertEquals("Zero - Account Summary",Driver.get().getTitle());

    }

    @Then("Account summary page should have to following account types:")
    public void account_summary_page_should_have_to_following_account_types(List<String> dataTable) {

        List<String> actualTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);

        Assert.assertEquals(dataTable,actualTypes);

    }
    @Then("Credit accounts table must have columns")
    public void credit_accounts_table_must_have_columns(List<String> dataTable) {

        List<String> actualColumnsTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountColumns);

        Assert.assertEquals(dataTable,actualColumnsTypes);

    }



}









