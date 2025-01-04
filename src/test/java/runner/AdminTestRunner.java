package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//@CucumberOptions(
//        features = "src/test/resources/Feature/Admin.feature",
//        glue = "StepDefinition",
//        plugin = {"pretty","html:target/cucumber-reports.html"},
//        monochrome = true
//)
//
//public class AdminTestRunner extends AbstractTestNGCucumberTests {
//}
@CucumberOptions(
        features = "src/test/resources/Feature/Admin.feature",
        glue = "StepDefinition",
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true,
        tags = "@Scenario"
)
public class AdminTestRunner extends AbstractTestNGCucumberTests {
}
