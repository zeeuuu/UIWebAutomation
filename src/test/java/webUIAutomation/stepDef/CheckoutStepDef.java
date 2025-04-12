package webUIAutomation.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webUIAutomation.BaseTest;
import webUIAutomation.page.CartPage;
import webUIAutomation.page.CheckoutPage;

public class CheckoutStepDef extends BaseTest {
    CheckoutPage checkout;
    CartPage cart;

    @Then("user is redirected to the checkout overview")
    public void userIsRedirectedToTheCheckoutOverview() {
        checkout = new CheckoutPage(driver);
        checkout.validateCheckoutOverview();
    }

    @When("user {string} {string} with the zip code {string}, is on the checkout overview page")
    public void userWithTheZipCodeIsOnTheCheckoutOverviewPage(String firstName, String lastName, String postalCode) {
        cart = new CartPage(driver);
        cart.navigatesToTheCart();
        cart.clicksCheckoutButton();
        cart.validateFormCheckoutInformation();
        cart.inputsFirstName(firstName);
        cart.inputsLastName(lastName);
        cart.inputsPostalCode(postalCode);
        cart.clicksContinueButton();
        checkout = new CheckoutPage(driver);
        checkout.validateCheckoutOverview();
    }

    @And("user clicks on the finish button")
    public void userClicksOnTheFinishButton() {
        checkout.clicksFinishButton();
    }

    @Then("user should see the confirmation message {string}")
    public void userShouldSeeTheConfirmationMessage(String confirmationMessage) {
        checkout.validateASuccessfulOrder(confirmationMessage);
    }
}
