package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.AccountActivityPage;
import com.zeroBank.pages.AccountSummaryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FindTransactionsStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() throws InterruptedException {

        new AccountSummaryPage().accountActivityTab.click();
        new AccountActivityPage().findTransactionsTab.click();
        Thread.sleep(1000);
    }

    @When("the user enters date range from “{int}-{int}-{int}” to “{int}-{int}-{int}” and clicks search")
    public void the_user_enters_date_range_from_to_and_clicks_search(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {

        new AccountActivityPage().fromDate.clear();
        new AccountActivityPage().fromDate.sendKeys("2012-09-01");
        new AccountActivityPage().toDate.clear();
        new AccountActivityPage().toDate.sendKeys("2012-09-06");

        new AccountActivityPage().findButton.click();

    }


























}
