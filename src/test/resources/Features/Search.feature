Feature: Search functionality

  @search
  Scenario Outline: Verify user able to search product
    Given User navigates to the home page
    When User clicks on products button
    Then User is navigated to all products page
    When User enter <productName> in search input
    And User clicks on search button
    Then Searched Products is visible
    And All products related to search are visible

    Examples: 
      | productName |
      | Jeans       |
