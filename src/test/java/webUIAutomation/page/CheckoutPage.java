package webUIAutomation.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutPage {
    WebDriver driver;

    By checkoutOverview = By.xpath("//div[@data-test='secondary-header']/span[@data-test='title']");
    By finishButton = By.cssSelector("#finish");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateCheckoutOverview() {
        WebElement title = driver.findElement(checkoutOverview);
        assertTrue(title.isDisplayed());
        assertEquals("Checkout: Overview", title.getText());
    }

    public void clicksFinishButton() {
        driver.findElement(finishButton).click();
    }

    public void validateASuccessfulOrder(String confirmationMessage) {
        Assertions.assertTrue(driver.getPageSource().contains(confirmationMessage));
    }
}
