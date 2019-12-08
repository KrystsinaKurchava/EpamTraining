package framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/feature",
        glue = "bdd.yandex.product.steps",
        tags = {"@buttonsCheck"},
        plugin = {"json:target/cucumber-report.json",
                "html:target/cucumber-report"
        }
)
public class CucumberTestNgRunner extends AbstractTestNGCucumberTests {

}
