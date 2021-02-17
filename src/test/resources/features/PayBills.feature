Feature: Pay Bills Functionality

  Background:
    Given the user is logged in
    Given The user access the Pay Bills Page

  Scenario: Account Activity Page Title
    Then Account activity page should have the title Zero - Pay Bills

  Scenario: Successful Pay Operation
    When The user enters the amount and date and click on pay
    Then The payment was successfully submitted. should be displayed
    When The user tries to make a payment without entering the amount or date
    Then Please fill out this field. message should be displayed

  Scenario: Special Characters
    When The user enters alphabetical or special characters to amount field
    Then The amount field should not accept
    When The user enters alphabetical characters to date field
    Then The date field should not accept