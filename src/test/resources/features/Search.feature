Feature: Web Search

  In order to find some information
  As a searcher
  I want to be able to search and have relevant information returned

  Background:
    Given I am on the google homepage

  Scenario: Search for Hello world
    When I search for "hello world"
    Then I should see a link containing "HelloWorld" on Results page

  Scenario: Search for Cucumber
    When I search for "Cucumber"
    Then I should see a link containing "Cucuumber" on Results page
