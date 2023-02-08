Feature: Add  new employee details

  Background: 
    Given User navigates to login page
    When User enter valid credentials Admin and admin123
    And User clicks on login button
    Then User successfully logged in

  @regression @employee
  Scenario: Verify user able to add new employee
    When User clicks on PIM link
    And User clicks on add employee button
    And User enters employee details
      | firstName | middleName | lastName |
      | Dipali    | B          | Bhagat   |
    Then User succefully save employee details
