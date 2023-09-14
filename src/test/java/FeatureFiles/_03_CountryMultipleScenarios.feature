Feature: Country Multi Scenario

  Background: #before senaryo
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to country

    Scenario: Create Country
      When Create a country
      Then Success message should be displayed

    Scenario: Create country 2
      When Create a country name as "Kom23" code as "K23"
      Then Success message should be displayed