@cart
Feature: Cart Information

  @inputs-information-valid
  Scenario: User successfully inputs valid information
    Given user is login with username "standard_user" and password "secret_sauce"
    When user is on the form checkout information
    And user inputs first name "Zeeu"
    And user inputs last name "Kay"
    And user inputs postal code "12345"
    And user clicks on the continue button
    Then user is redirected to the checkout overview

  @inputs-information-invalid
  Scenario: User inputs an empty last name
    Given user is login with username "standard_user" and password "secret_sauce"
    When user is on the form checkout information
    And user inputs first name "Zeeu"
    And user inputs last name ""
    And user inputs postal code "12345"
    And user clicks on the continue button
    Then user able to see error message "Error: Last Name is required"

  @inputs-information-boundary
  Scenario: User inputs a valid postal code at the boundary of valid formats
    Given user is login with username "standard_user" and password "secret_sauce"
    When user is on the form checkout information
    And user inputs first name "Zeeu"
    And user inputs last name "Kay"
    And user inputs postal code "W1A-0AX-ABCD-EFGH-1234567"
    And user clicks on the continue button
    Then user is redirected to the checkout overview
