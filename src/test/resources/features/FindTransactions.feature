
Feature: Find Transactions in Account Activity
  Background:
    Given the user is logged in
    Given the user accesses the Find Transactions tab

  Scenario: Search date range
    When the user enters date range from “2012-9-1” to “2012-9-6” and clicks search
    Then results table should only show transactions dates between “2012-9-1” to “2012-9-6”
    And the results should be sorted by most recent date
    When the user enters date range from “2012-9-2” to “2012-9-6” and clicks search
    Then results table should only show transactions dates between “2012-9-2” to “2012-9-6”
    And the results table should only not contain transactions dated “2012-9-1”

  Scenario: Search description
    When the user enters description "ONLINE" and clicks search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE" and clicks search
    Then results table should only show descriptions containing "OFFICE"
    Then results table should not show descriptions containing "ONLINE"

  Scenario: Search description case insensitive
    When the user enters description "ONLINE" and clicks search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "online" and clicks search
    Then results table should only show descriptions containing "ONLINE"

  Scenario: Type
    And clicks search
    Then results table should show at least one result under Deposit
    Then results table should show at least one result under Withdrawal
    When user selects type "Deposit"
    Then results table should show at least one result under Deposit
    But results table should show no result under Withdrawal
    When user selects type "Withdrawal"
    Then results table should show at least one result under Withdrawal
    But results table should show no result under Deposit