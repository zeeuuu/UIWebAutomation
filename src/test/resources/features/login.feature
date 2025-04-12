@login
Feature: Login

  @valid-login
  Scenario: Login using valid username and password
    Given user is on login page
    And user inputs username "standard_user"
    And user inputs password "secret_sauce"
    When user clicks the login button
    Then user is redirected to the homepage

  @invalid-login
  Scenario: Login using invalid username and password
    Given user is on login page
    And user inputs username "locked_out_user"
    And user inputs password "secret_sauce"
    When user clicks the login button
    Then user is able to see error message "Epic sadface: Sorry, this user has been locked out."

  @boundary-login
  Scenario: Login with 1 character username and password
    Given user is on login page
    And user inputs username "a"
    And user inputs password "A"
    When user clicks the login button
    Then user is able to see error message "Epic sadface: Username and password do not match any user in this service"