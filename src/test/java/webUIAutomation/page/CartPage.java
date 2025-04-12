package webUIAutomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPage {
    WebDriver driver;

    By cartLink = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    By checkoutButton = By.id("checkout");
    By continueButton = By.cssSelector("#continue");
    By checkoutDetails = By.xpath("//div[@data-test='secondary-header']/span[@data-test='title']");
    By firstNameInputText = By.id("first-name");
    By lastNameInputText = By.id("last-name");
    By postalCodeInputText = By.id("postal-code");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigatesToTheCart() {
        driver.findElement(cartLink).click();
    }

    public void clicksCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void validateFormCheckoutInformation() {
        WebElement title = driver.findElement(checkoutDetails);
        assertTrue(title.isDisplayed());
        assertEquals("Checkout: Your Information", title.getText());
    }

    public void inputsFirstName(String firstName) {
        driver.findElement(firstNameInputText).sendKeys(firstName);
    }

    public void inputsLastName(String lastName) {
        driver.findElement(lastNameInputText).sendKeys(lastName);
    }

    public void inputsPostalCode(String postalCode) {
        driver.findElement(postalCodeInputText).sendKeys(postalCode);
    }

    public void clicksContinueButton() {
        driver.findElement(continueButton).click();
    }
}
