

Feature: Login

  Background:
    Given User goes to login page

  Scenario: Login with wrong username
    When User login with wrong username
    Then User tries to login with invalid information, error message Login and or password are wrong. should be displayed

  Scenario: Login with wrong password
    When User login with wrong password
    Then User tries to login with invalid information, error message Login and or password are wrong. should be displayed

  Scenario: Login with blank username
    When User login with blank username
    Then User tries to login with invalid information, error message Login and or password are wrong. should be displayed

  Scenario: Login with blank password
    When User login with blank password
    Then User tries to login with invalid information, error message Login and or password are wrong. should be displayed

  Scenario: Login with valid credentials
    When User login with valid credentials
    Then User logs in with valid credentials, Account summary page should be displayed

