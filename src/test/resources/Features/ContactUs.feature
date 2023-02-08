Feature: Contact Us functionality

  @smoke @regression
  Scenario Outline: To verfiy contact us functionality
    Given User navigates to the home page
    When User clicks on the contact us button
    Then Contact Us form get opened
    When User enters contact us details <name>, <emailId>, <subject> and <message>
    And User clicks on submit button
    And User clicks on ok button
    Then Details have been submitted successfully

    Examples: 
      | name   | emailId          | subject        | message                  |
      | Dipali | dipali@gmail.com | TestAutomation | This is sample test page |
