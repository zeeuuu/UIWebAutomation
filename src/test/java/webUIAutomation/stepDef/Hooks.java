package webUIAutomation.stepDef;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import webUIAutomation.BaseTest;

public class Hooks extends BaseTest {
    @BeforeAll
    public static void beforeTest() {
        // Initialize the WebDriver before all tests
        getDriver();
    }

    @AfterAll
    public static void afterTest() {
        // Quit the WebDriver after all tests
        if (driver != null) {
            driver.quit();
        }
    }
}