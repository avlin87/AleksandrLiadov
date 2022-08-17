Feature: Exercise 3
  In order to get log message
  As a user Roman
  I want to change value of VIP checkbox in Description column of User Table for Sergey Ivan user

  Scenario: Log message test for checkbox in Description column of User Table
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    When I select 'vip' checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section
