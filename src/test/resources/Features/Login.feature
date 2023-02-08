Feature: Login functionality

  @regression @login
  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enter valid credentials <userName> and <password>
    And User clicks on login button
    Then User successfully logged in

    Examples: 
      | userName | password |
      | Admin    | admin123 |
