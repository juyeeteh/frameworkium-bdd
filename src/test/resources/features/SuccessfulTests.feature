@pass
Feature: Basic login and navigation tests to demonstrate use of multiple page object and step definition classes

  @login @single
  Scenario: successfully login with correct login details
    Given I am on the login page
    When I submit login with correct details
    Then I will be logged in

  @login @negative
  Scenario: fail to login when using incorrect login details
    Given I am on the login page
    When I submit login with incorrect details
    Then I will not be logged in

  Scenario: login and navigate to the My first course
    Given I have successfully logged in
    When I click the My First Course link
    Then I will be on the Course page
    And the title 'My first course' will be present


  Scenario: successfully change page title
    Given I have successfully logged in
    And I have navigated to the Settings page
    When I change the page title and submit
    Then the new page title will be displayed



