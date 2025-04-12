package webUIAutomation.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webUIAutomation.BaseTest;
import webUIAutomation.page.HomePage;
import webUIAutomation.page.LoginPage;

public class HomeStepDef extends BaseTest {
    HomePage homepage;
    LoginPage login;

    @Then("user is redirected to the homepage")
    public void userIsRedirectedToTheHomepage() {
        homepage = new HomePage(driver);
        homepage.validateHomePage();
    }

    @Given("user is login with username {string} and password {string}")
    public void userIsLoginWithUsernameAndPassword(String username, String password) {
        login = new LoginPage(driver);
        login.goToLoginPage();
        login.inputUsername(username);
        login.inputPassword(password);
        login.clickLoginButton();
        homepage = new HomePage(driver);
        homepage.validateHomePage();
    }

    @When("user clicks {string} on the item {string}")
    public void userClicksOnTheItem(String button, String item) {
        switch (button) {
            case "Add to cart":
                homepage.clickAddItemToCart(item);
                break;
            case "Remove":
                homepage.clickRemoveItemToCart(item);
                break;
            default:
                throw new IllegalArgumentException("Action '" + button + "' is not recognized");
        }
    }

    @And("the cart displays a total of {int} item")
    public void theCartDisplaysATotalOfItem(int totalItem) {
        homepage.validateTotalItemInCart(totalItem);
    }
}

