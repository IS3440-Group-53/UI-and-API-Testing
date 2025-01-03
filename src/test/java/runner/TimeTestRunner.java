package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Feature/Time.feature",
        glue = "StepDefinition",
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},

        monochrome = true
)
public class TimeTestRunner extends AbstractTestNGCucumberTests {
}