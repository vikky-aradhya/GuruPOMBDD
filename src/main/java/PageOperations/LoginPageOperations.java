package PageOperations;

import com.aventstack.extentreports.Status;
import org.testng.Assert;

import pagesLocators.LoginPageLocators;
import utils.ExtentReportGeneration;

public class LoginPageOperations extends LoginPageLocators {

    public LoginPageLocators loginPageLocators = new LoginPageLocators();

    @SuppressWarnings("finally")
    public boolean verifyLoginPageTitle() {

        boolean success = false;
        try {
            String expectedTitle = "Guru99 Bank Home Page";
            Assert.assertEquals(getDriver().getTitle(), expectedTitle);
            success = true;
            ExtentReportGeneration.extentTest.log(Status.PASS, "Title matched");

        } catch (AssertionError error) {
            ExtentReportGeneration.extentTest.log(Status.ERROR, error.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            ExtentReportGeneration.extentTest.log(Status.FAIL, "Title Not matched");

        } finally {
            return success;
        }
    }

    @SuppressWarnings("finally")
    public boolean LoginInToApplication() {

        boolean success = false;

        try {
            EnterText(getUserNameTextBox(), property.getProperty("username"));
            EnterText(getPasswordTextBox(), property.getProperty("password"));
            ClickOnElement(getLoginButton());
            ExplicitWait(loginPageLocators.getNewCustomer());
            success = true;
            ExtentReportGeneration.extentTest.log(Status.PASS, "Login sucessfully");
        } catch (Exception e) {
            ExtentReportGeneration.extentTest.log(Status.FAIL, e.getMessage());
        } finally {
            return success;
        }
    }

    @SuppressWarnings("finally")
    public boolean HomePageValidation() {
        boolean success = false;
        try {
            verifyElementIsDisplayed(getNewCustomer());
            ExtentReportGeneration.extentTest.log(Status.PASS, "Home Page is displayed");
            success = true;
            getScreenshot("Login sucessfully");
        } catch (Exception e) {
            e.printStackTrace();
            ExtentReportGeneration.extentTest.log(Status.FAIL, "Home Page is Not displayed" + e.getMessage());
        } finally {
            return success;
        }
    }

    @SuppressWarnings("finally")
    public boolean LoginInToApplicationOutline(String userName, String password) {

        boolean success = false;

        try {
            EnterText(getUserNameTextBox(), userName);
            EnterText(getPasswordTextBox(), password);
            ClickOnElement(getLoginButton());
            ExplicitWait(loginPageLocators.getNewCustomer());
            success = true;
            ExtentReportGeneration.extentTest.log(Status.PASS, "Login sucessfully");
        } catch (Exception e) {
            e.printStackTrace();
            ExtentReportGeneration.extentTest.log(Status.FAIL, e.getMessage());
        } finally {
            return success;
        }
    }

}
