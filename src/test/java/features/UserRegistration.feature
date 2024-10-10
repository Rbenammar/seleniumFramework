Feature: User Registration
  I want to check that the user can register in our e-commerce website.

  Scenario: User Registration
    Given the user in the home page
    When I click on the register link
    And I enter the user data
    Then the registration page is displayed successfully