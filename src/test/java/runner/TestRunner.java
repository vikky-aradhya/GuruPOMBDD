package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utils.ExtentReportGeneration;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = {"src/test/java/features"},
        glue = {"stepDefinition/"},
        tags = {"@Login_user, @Register_user"},
        monochrome = true,
        dryRun = false
)

public class TestRunner {

    @BeforeClass
    public static void setUp() throws Throwable {
        ExtentReportGeneration.init_extentReport();
    }

    @AfterClass
    public static void tearDown() {
        ExtentReportGeneration.generateExtentReport();
    }


}