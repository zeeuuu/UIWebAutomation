package webUIAutomation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:reports/cucumber.html",
                "json:reports/cucumber.json"
        },
        glue = {"webUIAutomation.stepDef"},
        features = {"src/test/resources/features"}
)

public class RunnerTest {

}
