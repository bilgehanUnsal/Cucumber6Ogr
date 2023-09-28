# Excelden okuduğumuz Citizenship bilgilerini önce hepsini kaydedi
# daha sonrada siliniz.

Feature: ApachePOI Citizen functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenships

  Scenario: Create and Delete Citizenship from Excel
    When User create citizenship with ApachePOI
    Then User delete citizenship with ApachePOI