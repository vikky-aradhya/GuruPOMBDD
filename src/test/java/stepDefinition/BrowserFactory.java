package stepDefinition;

import com.aventstack.extentreports.Status;

import base.BasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utils.ExtentReportGeneration;

public class BrowserFactory extends BasePage {

    @When("^User opens browser$")
    public void user_opens_browser() throws Throwable {
        try {
            init_properties();
            openBrowser(property.getProperty("browser"));

        } catch (Exception e) {
            e.getMessage();
        }
        try {
            navigateToUrl();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Given("^test data is read from excel \"([^\"]*)\" under \"([^\"]*)\"$")
    public void test_data_is_read_from_excel_under(String scenarioName, String sheetName) throws Throwable {

        System.out.println(scenarioName);
        System.out.println(sheetName);
        readexceldata(scenarioName, sheetName);
        Thread.sleep(3000);
        ExtentReportGeneration.extentTest.log(Status.INFO, "Test Data read successfully");
    }

}
