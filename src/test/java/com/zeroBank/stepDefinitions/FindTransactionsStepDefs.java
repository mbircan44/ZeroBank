package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.AccountActivityPage;
import com.zeroBank.pages.AccountSummaryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class FindTransactionsStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() throws InterruptedException {

        new AccountSummaryPage().accountActivityTab.click();
        new AccountActivityPage().findTransactionsTab.click();
        Thread.sleep(1000);
    }

    @When("the user enters date range from “{int}-{int}-{int}” to “{int}-{int}-{int}” and clicks search")
    public void the_user_enters_date_range_from_to_and_clicks_search(Integer fromYear, Integer fromMonth, Integer fromDay, Integer toYear, Integer toMonth, Integer toDay) {

        new AccountActivityPage().fromDate.clear();
        new AccountActivityPage().fromDate.sendKeys("2012-09-01");
        new AccountActivityPage().toDate.clear();
        new AccountActivityPage().toDate.sendKeys("2012-09-06");

        new AccountActivityPage().findButton.click();
    }

    @Then("results table should only show transactions dates between “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void results_table_should_only_show_transactions_dates_between_to(Integer fromYear, Integer fromMonth, Integer fromDay, Integer toYear, Integer toMonth, Integer toDay) {

        AccountActivityPage accountActivity = new AccountActivityPage();
        List<WebElement> dateResult = accountActivity.dateColumn;

        for (int i = 0; i < dateResult.size(); i++) {
            String date = dateResult.get(i).getText();
            String[] str = date.split("-");

            Integer[] intDate = new Integer[str.length];

            for (int j = 0; j < str.length; j++) {
                intDate[j] = Integer.parseInt(str[j]);
            }
            LocalDate start = LocalDate.of(fromYear, fromMonth, fromDay);
            LocalDate end = LocalDate.of(toYear, toMonth, toDay);
            LocalDate current = LocalDate.of(intDate[0], intDate[1], intDate[2]);

            boolean check = ((current.equals(start) || current.isAfter(start)) && (current.isBefore(end) || current.isEqual(end)));
            Assert.assertTrue(check);
        }
    }
        @Then("the results should be sorted by most recent date")
        public void the_results_should_be_sorted_by_most_recent_date() {

            AccountActivityPage accountActivity = new AccountActivityPage();
            List<WebElement> dateResult= accountActivity.dateColumn;

            LocalDate[] localDate = new LocalDate[dateResult.size()];
            for (int i = 0; i < dateResult.size(); i++) {
                String date = dateResult.get(i).getText();
                String[] str = date.split("-");

                Integer[] intDate = new Integer[str.length];

                for (int j = 0; j < str.length; j++) {
                    intDate[j] = Integer.parseInt(str[j]);
                }
                localDate[i] = LocalDate.of(intDate[0], intDate[1], intDate[2]);
            }
            boolean check;

            for (int i = 0; i < localDate.length - 1; i++) {
                check = (localDate[i].isEqual(localDate[i + 1]) || localDate[i].isAfter(localDate[i + 1]));
                Assert.assertTrue(check);
            }
        }

    @Then("the results table should only not contain transactions dated “{int}-{int}-{int}”")
    public void the_results_table_should_only_not_contain_transactions_dated(Integer year, Integer month, Integer day) {

        AccountActivityPage accountActivity = new AccountActivityPage();
        List<WebElement> dateResult= accountActivity.dateColumn;

        LocalDate[] localDate = new LocalDate[dateResult.size()];
        for (int i = 0; i < dateResult.size(); i++) {
            String date = dateResult.get(i).getText();
            String[] str = date.split("-");

            Integer[] intDate = new Integer[str.length];

            for (int j = 0; j < str.length; j++) {
                intDate[j] = Integer.parseInt(str[j]);
            }
            localDate[i] = LocalDate.of(intDate[0], intDate[1], intDate[2]);
        }
        LocalDate trDate = LocalDate.of(year, month, day);

        boolean check = false;
        for (int i = 0; i < localDate.length; i++) {

            if (trDate.isEqual(localDate[i])) {
                check = false;
            } else {
                check = true;
            }
        }
        Assert.assertTrue(check);
    }

    @When("the user enters description {string} and clicks search")
    public void the_user_enters_description_and_clicks_search(String string) {

        new AccountActivityPage().descriptionInput.clear();
        new AccountActivityPage().descriptionInput.sendKeys(string.toUpperCase(Locale.ENGLISH));
        new AccountActivityPage().findButton.click();

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {

        AccountActivityPage accountActivity = new AccountActivityPage();
        List<WebElement> descriptionResult= accountActivity.descriptionColumn;

        String[] dates = new String[descriptionResult.size()];

        for (int i = 0; i < descriptionResult.size(); i++) {

            dates[i] = descriptionResult.get(i).getText();
        }

        for (int i = 0; i < dates.length; i++) {

            Assert.assertTrue(dates[i].contains(string));

        }

    }
    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {

        AccountActivityPage accountActivity = new AccountActivityPage();
        List<WebElement> descriptionResult= accountActivity.descriptionColumn;

        String[] dates = new String[descriptionResult.size()];

        for (int i = 0; i < descriptionResult.size(); i++) {
            dates[i] = descriptionResult.get(i).getText();
        }

        for (int i = 0; i < dates.length; i++) {

            Assert.assertFalse(dates[i].contains(string));
        }
    }
    @Given("clicks search")
    public void clicks_search() {
        new AccountActivityPage().findButton.click();
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {

        AccountActivityPage accountActivity = new AccountActivityPage();
        List<WebElement> depositResult= accountActivity.depositColumn;

        boolean x = false;

        for (int i = 0; i < depositResult.size(); i++) {
            if(!depositResult.get(i).getText().equals("")){
                x = true;
            }
        }
        Assert.assertTrue(x);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {

        AccountActivityPage accountActivity = new AccountActivityPage();
        List<WebElement> withdrawalResult= accountActivity.withdrawalColumn;

        boolean x = false;

        for (int i = 0; i < withdrawalResult.size(); i++) {
            if(!withdrawalResult.get(i).getText().equals("")){
                x = true;
            }
        }
        Assert.assertTrue(x);
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {




    }








    }























































