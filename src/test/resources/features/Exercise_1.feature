Feature: Exercise 1
#  In order to get log messages
#  As a user Roman
#  I want to change value of checkboxes, radiobutton, dropdown fields

  Background:
    Given I open JDI GitHub site

  Scenario: Different Elements Page
    Given I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    And I select "Water" checkbox
    And I select "Wind" checkbox
    And I select "Selen" radiobutton
    And I select "Yellow" in dropdown
    Then "Different Elements" page should be opened
    And Log should contain 4 displayed rows
    And Log should contain message that checkbox "Water" status changed to "true"
    And Log should contain message that checkbox "Wind" status changed to "true"
    And value of "Colors" field changed to "Yellow"
    And value of "metal" field changed to "Selen"