package webUIAutomation.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webUIAutomation.BaseTest;
import webUIAutomation.page.CartPage;
import webUIAutomation.page.LoginPage;

public class CartStepDef extends BaseTest {
    CartPage cart;
    LoginPage login;

    @Then("user navigates to the cart")
    public void userNavigatesToTheCart() {
        cart = new CartPage(driver);
        cart.navigatesToTheCart();
    }

    @When("user is on the form checkout information")
    public void userIsOnTheFormCheckoutInformation() {
        userNavigatesToTheCart();
        cart.clicksCheckoutButton();
        cart.validateFormCheckoutInformation();
    }

    @And("user inputs first name {string}")
    public void userInputsFirstName(String firstName) {
        cart.inputsFirstName(firstName);
    }

    @And("user inputs last name {string}")
    public void userInputsLastName(String lastName) {
        cart.inputsLastName(lastName);
    }

    @And("user inputs postal code {string}")
    public void userInputsPostalCode(String postalCode) {
        cart.inputsPostalCode(postalCode);
    }

    @And("user clicks on the continue button")
    public void userClicksOnTheContinueButton() {
        cart.clicksContinueButton();
    }

    @Then("user able to see error message {string}")
    public void userAbleToSeeErrorMessage(String errorMessage) {
        login = new LoginPage(driver);
        login.validateErrorAppears(errorMessage);
    }
}
