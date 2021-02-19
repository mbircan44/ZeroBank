package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.LoginPage;
import com.zeroBank.pages.MainPage;
import com.zeroBank.utilities.ConfigurationReader;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginStepDefs {

    @Given("User goes to login page")
    public void user_goes_to_login_page() {
        new MainPage().signButton.click();
    }
    @When("User login with wrong username")
    public void user_login_with_wrong_username() {
        String wrongUsername = "asdasd";
        String password = "password";
        new LoginPage().login(wrongUsername,password);
    }

    @Then("the user should stay in Login Page")
    public void the_user_should_stay_in_Login_Page() {
        String currentTitle = Driver.get().getTitle();
        String expextedTitle = "Zero - Log in";
        Assert.assertTrue(currentTitle.contains(expextedTitle));
    }
    @When("User login with wrong password")
    public void user_login_with_wrong_password() {
        String username = "username";
        String wrongPassword = "asdasd";
        new LoginPage().login(username,wrongPassword);
    }
    @When("User login with blank username")
    public void user_login_with_blank_username() {
        String blankUsername = "";
        String password = "password";
        new LoginPage().login(blankUsername,password);
    }
    @Then("User tries to login with invalid information, error message Login and or password are wrong. should be displayed")
    public void user_tries_to_login_with_invalid_information_error_message_Login_and_or_password_are_wrong_should_be_displayed() {

        String expextedAlertMsg = "Login and/or password are wrong.";
        String actualAlertMsg = new LoginPage().loginAlert.getText();

        Assert.assertTrue(new LoginPage().loginAlert.isDisplayed());
        Assert.assertEquals(expextedAlertMsg,actualAlertMsg);

    }

    @When("User login with blank password")
    public void user_login_with_blank_password() {
        String username = "username";
        String blankPassword = "";
        new LoginPage().login(username,blankPassword);
    }
    @When("User login with valid credentials")
    public void user_login_with_valid_credentials() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        new LoginPage().login(username,password);
    }
    @Then("User logs in with valid credentials, Account summary page should be displayed")
    public void user_logs_in_with_valid_credentials_Account_summary_page_should_be_displayed() {
        if(Driver.get().findElement(By.id("details-button")).isDisplayed()) {
//          For pass to security FOR CHROME ( 2 Steps )
            Driver.get().findElement(By.id("details-button")).click();
            Driver.get().findElement(By.id("proceed-link")).click();
        }
        String currentTitle = Driver.get().getTitle();
        String expextedTitle = "Account Summary";
        Assert.assertTrue(currentTitle.contains(expextedTitle));
        String currentUrl = Driver.get().getCurrentUrl();
        String expectedUrl = "http://zero.webappsecurity.com/bank/account-summary.html";
        Assert.assertEquals(currentUrl,expectedUrl);
        System.out.println("currentTitle = " + currentTitle);
        System.out.println("currentUrl = " + currentUrl);
    }
}

