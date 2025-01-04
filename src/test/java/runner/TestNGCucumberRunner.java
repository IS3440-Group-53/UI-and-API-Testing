package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Feature/Login.feature",
        glue = "StepDefinition",
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
)

public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
}
