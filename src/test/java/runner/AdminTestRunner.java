package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/resources/Feature/Admin.feature",
        glue = "StepDefinition",
        plugin = {"pretty","html:target/cucumber-reports.html"},
        monochrome = true
)

public class AdminTestRunner extends AbstractTestNGCucumberTests {
}
