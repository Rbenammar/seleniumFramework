package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src/test/java/features",
        glue = {"steps"}, plugin = {"pretty", "html:target/cucumber-ht ml-report"})
public class TestRunner extends TestBase
{




}
