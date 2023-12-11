Feature: My Location Setup

  Scenario: User should be able to setup their location
    Given the user has created an account as a show creator
    And the user is on the my location page in the connect dashboard
    When the user enter valid address
    And hits the submit button
    Then the user's location should be setup successfully
