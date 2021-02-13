Feature: Login functionality
  @wip
  Background:
    Given the user is on the login page


  Scenario: Login with valid credentials
    When the user logs in with valid username and password
    Then Account summary page should be displayed
