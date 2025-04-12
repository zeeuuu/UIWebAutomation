@home
Feature: Homepage

  @add-to-cart-home
  Scenario: User successfully adds product to cart
    Given user is login with username "standard_user" and password "secret_sauce"
    When user clicks "Add to cart" on the item "Sauce Labs Backpack"
    And the cart displays a total of 1 item
    Then user navigates to the cart

  @remove-from-cart-home
  Scenario: User successfully removes item from the cart
    Given user is login with username "standard_user" and password "secret_sauce"
    When user clicks "Remove" on the item "Sauce Labs Backpack"
    And the cart displays a total of 0 item
    Then user navigates to the cart

  @negative-add-unavailable
  Scenario: User tries to add an item that does not exist
    Given user is login with username "standard_user" and password "secret_sauce"
    When user clicks "Add to cart" on the item "Sauce Labs Red T-Shirt"
    And the cart displays a total of 0 item
    Then user navigates to the cart

  @boundary-add-cart-home
  Scenario: User adds maximum allowed items to cart
    Given user is login with username "standard_user" and password "secret_sauce"
    When user clicks "Add to cart" on the item "Sauce Labs Backpack"
    And user clicks "Add to cart" on the item "Sauce Labs Bike Light"
    And user clicks "Add to cart" on the item "Sauce Labs Bolt T-Shirt"
    And user clicks "Add to cart" on the item "Sauce Labs Fleece Jacket"
    And user clicks "Add to cart" on the item "Sauce Labs Onesie"
    And user clicks "Add to cart" on the item "Test.allTheThings() T-Shirt (Red)"
    And the cart displays a total of 6 item
    Then user navigates to the cart


