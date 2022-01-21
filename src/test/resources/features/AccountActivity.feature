Feature: Account Activity

  Background:
    Given the user is logged in
    Given The user access the Account Activity Page

  Scenario: Account Activity Page functionality
    Then Account activity page should have the title Zero - Account Activity
    Then In the Account drop down default option should be Savings

  Scenario: Dropdown Options
    Then Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transactions Tables
    Then Transactions table should have columns names
      |Date        |
      |Description |
      |Deposit     |
      |Withdrawal  |