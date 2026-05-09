Feature: API and UI Integration Test

@Task1
  Scenario: Validate API setup and UI login flow

    Given User creates a new lead using POST API
    Then User verifies GET API response is successful

    When User launches the demo login page
    And User enters valid username and password
    And User clicks on login button
    Then User should navigate to secure area successfully