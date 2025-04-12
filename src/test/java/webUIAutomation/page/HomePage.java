package webUIAutomation.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePage {
    WebDriver driver;

    By productBackpack = By.xpath("//div[@data-test='inventory-item-name' and normalize-space()='Sauce Labs Backpack']");
    By cartBadge = By.xpath("//span[@data-test='shopping-cart-badge']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By addButton(String item) {
        return By.xpath("//div[contains(@data-test, 'inventory-item-name') and contains(text(),'" + item + "')]"
                + "/ancestor::div[contains(@class,'inventory_item')]//button[contains(@data-test, 'add-to-cart')]");
    }

    private By removeButton(String item) {
        return By.xpath(String.format("//button[contains(@data-test, 'remove-%s')]", item.toLowerCase().replace(" ", "-")));
    }

    public void validateHomePage() {
        try {
            WebElement product = driver.findElement(productBackpack);
            assertTrue(product.isDisplayed());
            assertEquals("Sauce Labs Backpack", product.getText());
        } catch (NoSuchElementException e) {
            throw new AssertionError("Sauce Labs Backpack not found on the homepage.");
        }
    }

    public void clickAddItemToCart(String item) {
        try {
            WebElement addButtonElement = driver.findElement(addButton(item));
            addButtonElement.click();
        } catch (NoSuchElementException e) {
            System.out.println("Add button not found for item " + item);
        }
    }

    public void clickRemoveItemToCart(String item) {
        try {
            WebElement removeButtonElement = driver.findElement(removeButton(item));
            removeButtonElement.click();
        } catch (NoSuchElementException e) {
            System.out.println("Remove button not found for item " + item);
        }
    }

    public int getCartBadgeCount() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
            List<WebElement> badgeElements = driver.findElements(cartBadge);
            return badgeElements.isEmpty() ? 0 : Integer.parseInt(badgeElements.get(0).getText());
        } catch (TimeoutException e) {
            System.out.println("Cart badge not found");
            return 0;
        }
    }

    public void validateTotalItemInCart(int totalItem) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            if (totalItem > 0) {
                wait.until(ExpectedConditions.presenceOfElementLocated(cartBadge));
            }
            int actualCount = getCartBadgeCount();
            assertEquals("Cart badge count mismatch!", totalItem, actualCount);
        } catch (TimeoutException e) {
            assertEquals("Expected cart count but badge not found!", totalItem, 0);
        }
    }
}
