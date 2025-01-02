package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Feature/Time.feature",
        glue = "StepDefinition",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TimeTestRunner extends AbstractTestNGCucumberTests {
}