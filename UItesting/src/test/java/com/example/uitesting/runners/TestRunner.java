package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "D:\\Acadamic Notes\\Lvl 4 Sem 1\\IS 3440 ITQA\\Assignment1\\UItesting\\src\\test\\resources\\features",
        glue = "stepdefinitions",
        plugin = {"pretty","html:target/cucumber-reports.html"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
