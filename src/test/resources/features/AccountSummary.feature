
Feature: Account Summary

  Background:
    Given the user is logged in

  Scenario: Account Summary Page functionality
    Then The user access the Account Summary Page and have the title Zero - Account Summary
    Then Account summary page should have to following account types:
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

    Then Credit accounts table must have columns
      | Account     |
      | Credit Card |
      | Balance     |