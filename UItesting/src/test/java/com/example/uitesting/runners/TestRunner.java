package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "D:/Selenium/UI-and-API-Testing/UItesting/src/test/resources/features",
        glue = "stepdefinitions",
        plugin = {"pretty","html:target/cucumber-reports.html"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
