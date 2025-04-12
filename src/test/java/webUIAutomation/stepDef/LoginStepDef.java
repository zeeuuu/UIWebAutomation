package webUIAutomation.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webUIAutomation.BaseTest;
import webUIAutomation.page.LoginPage;

public class LoginStepDef extends BaseTest {
    LoginPage login;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        login = new LoginPage(driver);
        login.goToLoginPage();
    }

    @And("user inputs username {string}")
    public void userInputsUsername(String username) {
        login.inputUsername(username);
    }

    @And("user inputs password {string}")
    public void userInputsPassword(String password) {
        login.inputPassword(password);
    }

    @When("user clicks the login button")
    public void userClicksTheLoginButton() {
        login.clickLoginButton();
    }

    @Then("user is able to see error message {string}")
    public void userIsAbleToSeeErrorMessage(String errorMessage) {
        login.validateErrorAppears(errorMessage);
    }
}
