@fail
Feature: Have a test that fails to demonstrate how failed tests show up in reports

  Scenario: Demonstrating a test that fails by logging in with incorrect details
    Given I have successfully logged in
    Then the home page title will be 'this is not the home page title'


  Scenario: Another successfully changed page title
    Given I have successfully logged in
    And I have navigated to the Settings page
    When I change the page title and submit
    Then the new page title will be displaye