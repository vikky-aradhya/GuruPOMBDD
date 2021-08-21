package stepDefinition;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.Status;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import base.BasePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import utils.ExtentReportGeneration;

public class Hooks {

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                File sourcePath = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/target/screenshots/" + screenshotName + System.currentTimeMillis() + ".png");

                Files.copy(sourcePath, destinationPath);
                ExtentReportGeneration.extentTest.log(Status.INFO, "Failed Screenshot Captured" + "<a href='" + destinationPath.toString() + "'>Click Here</a>");
            } catch (IOException e) {
            }
        }
        BasePage.getDriver().quit();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentReportGeneration.create_extentTest(scenario.getName());
    }

}
