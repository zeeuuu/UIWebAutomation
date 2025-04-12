@checkout
Feature: Checkout Process

  @checkout-success
  Scenario: User successfully checks out with items in the cart
    Given user is login with username "standard_user" and password "secret_sauce"
    When user "Zeeu" "Kay" with the zip code "12345", is on the checkout overview page
    And user clicks on the finish button
    Then user should see the confirmation message "Thank you for your order!"