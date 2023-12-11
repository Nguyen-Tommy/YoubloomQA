Feature: Show Setup

  Scenario: User should be able to setup a show
    Given the user is logged into the connect dashboard
    And the user is on the show setup page in the connect dashboard
    When the user inputs only required fields
    And hits the publish show button
    Then the user's show should be setup successfully
