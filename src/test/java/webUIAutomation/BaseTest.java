package webUIAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected static WebDriver driver;

    protected static void getDriver() {
        // Setup WebDriver using WebDriverManager
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        // Run tests in headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
}
