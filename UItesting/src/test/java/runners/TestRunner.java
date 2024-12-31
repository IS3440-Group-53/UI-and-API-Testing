package UItesting.src.test.java.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "UItesting/src/test/resources/features/login.feature",
        glue = "step-definitions",
        plugin = {"pretty","html:target/cucumber-reports.html"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
